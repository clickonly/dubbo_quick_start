package org.dubbo.api.imp;

import com.alibaba.druid.util.StringUtils;
import org.apache.log4j.Logger;
import org.dubbo.api.dao.ActivityMainDao;
import org.dubbo.api.dao.ActivityPrizeDao;
import org.dubbo.api.dao.NewActivityAwardDao;
import org.dubbo.api.dao.VoucherBaseDao;
import org.dubbo.api.service.CouponService;
import org.dubbo.api.service.MessageService;
import org.dubbo.api.service.UserService;
import org.dubbo.pojo.bean.activity.*;
import org.dubbo.pojo.bean.user.UserInfo;
import org.dubbo.pojo.dto.activity.SendVouCouponDto;
import org.dubbo.pojo.dto.wx.SendVouCouponMessageDto;
import org.dubbo.pojo.enums.ActivityprizeType;
import org.dubbo.pojo.enums.IsSendMessageFlag;
import org.dubbo.pojo.redis.RedisUtil;
import org.dubbo.pojo.utils.CommonRedisKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fanglei on 2018/5/24.
 */
@Service("couponService")
public class CouponServiceImpl implements CouponService {


    private static final Logger logger = Logger.getLogger(CouponService.class);



    private static String MESSAGE="恭喜您获得1 张 ×{couponName}的优惠券，您的券号{linkNo},请点击查看券详情";


    @Autowired(required = false)
    private NewActivityAwardDao newActivityAwardDao;

    @Autowired(required = false)
    private RedisUtil redisUtil;

    @Autowired(required = false)
    private ActivityMainDao activityMainDao;

    @Autowired(required = false)
    private VoucherBaseDao voucherBaseDao;

    @Autowired(required = false)
    private UserService userService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private ActivityPrizeDao activityPrizeDao;


    @Override
    public boolean sendCouponTorRedis(SendVouCouponDto sendVouCouponDto) {
        logger.info("into CouponServiceImp sendCouponTorRedis");
        boolean flag;
        try{
            redisUtil.lSet(CommonRedisKey.acticity.COUPON_KEY,sendVouCouponDto);
            flag=true;
        }catch (Exception e){
            flag=false;
            logger.error("CouponServiceImp sendCouponTorRedis error",e);
        }
        return flag;
    }


    /**
     * 發送優惠券
     * @param sendVouCouponDto
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean sendVouCoupon(SendVouCouponDto sendVouCouponDto) {
        logger.info("into sendVouCoupon method");
        boolean flag = false;
        //判断当前用户是否存在
        UserInfo userInfo=new UserInfo();
        userInfo.setUnionId(sendVouCouponDto.getUnionid());
        userInfo.setOpenId(sendVouCouponDto.getOpenid());
         userInfo=userService.getClientVipInfo(userInfo);
        if (null == userInfo) {
            logger.info("当前用户openId" + sendVouCouponDto.getOpenid() + "main表不存在");
        } else {
            //获取当前优惠券
            NewActivityAward newActivityAward = newActivityAwardDao.getNewActivityAwardBy(Integer.valueOf(sendVouCouponDto.getCouponId()));
            if (newActivityAward != null) {
                ActivityMain activityMain = activityMainDao.getActivityInfo(Long.valueOf(sendVouCouponDto.getActivityId()));
                ViewWxscgift viewWxscgift = newActivityAwardDao.getViewWxscgiftBy(Integer.valueOf(sendVouCouponDto.getCouponId()));
                SimpleDateFormat s = new SimpleDateFormat("yyyyMMdd");
                Calendar c = Calendar.getInstance();
                c.add(Calendar.DATE, 30);//计算30天后的时间
                Map<String, Object> map = new HashMap<String, Object>();
                map = callWxscInsertVoucher(map, activityMain, userInfo, viewWxscgift, newActivityAward, sendVouCouponDto, s, c);
                //保存优惠券信息
                if (!map.isEmpty() && map.containsKey("amt") && map.containsKey("linkNo")) {
                    saveVoucherBase(map, s, c, viewWxscgift, sendVouCouponDto);
                    flag = true;
                }
                if (null!=activityMain.getActivityConfigJson()&&flag){
                    if (!StringUtils.isEmpty(activityMain.getActivityConfigJson().getIsSend())&&
                            IsSendMessageFlag.SEND.getCode().equals(activityMain.getActivityConfigJson().getIsSend())){
                        //如果当前活动发送模板消息
                        Map<String,Object> messageTemplateMap=activityMain.getActivityConfigJson().getWxMessageTemplate();
                        SendVouCouponMessageDto sendVouCouponMessageDto=new SendVouCouponMessageDto();
                        sendVouCouponMessageDto.setUnionid(sendVouCouponDto.getUnionid());
                        sendVouCouponMessageDto.setOpenid(sendVouCouponDto.getOpenid());
                        sendVouCouponMessageDto.setWeid(sendVouCouponDto.getWeid());
                        sendVouCouponMessageDto.setWxMessageTemplateId(Long.valueOf(messageTemplateMap.get(sendVouCouponDto.getWeid()).toString()));
                        sendVouCouponMessageDto.setActivityId(sendVouCouponDto.getActivityId());
                      //  sendVouCouponMessageDto.setLinkNo(map.get("linkNo").toString());
                        sendVouCouponMessageDto.setType(ActivityprizeType.COUPON.getCode());
                        sendVouCouponMessageDto.setPrizeId(sendVouCouponDto.getPrizeId());
                        sendVouCouponMessageDto.setCouponId(Long.valueOf(sendVouCouponDto.getCouponId()));
                        MESSAGE=MESSAGE.replaceAll("\\{couponName}",viewWxscgift.getName());
                        MESSAGE=MESSAGE.replaceAll("\\{linkno}",map.get("linkNo").toString());
                        sendVouCouponMessageDto.setMessage(MESSAGE);
                        ActivityPrize activityPrize=activityPrizeDao.selectByPrimaryKey(sendVouCouponDto.getPrizeId());
                        Map<String,String> urlMap=activityPrize.getActivityPrizeConfig().getUrlMap();
                        sendVouCouponMessageDto.setUrl(urlMap.get(sendVouCouponDto.getWeid()));
                        sendVouCouponMessageDto.setActivityName(activityMain.getActivityName());
                        messageService.sendMessageToReids(sendVouCouponMessageDto);
                    }
                }
            } else {
                logger.info("券规则" + sendVouCouponDto.getCouponId() + "表不存在");
            }
        }
        return flag;
    }



    private void saveVoucherBase(Map<String, Object> map,
                                 SimpleDateFormat s, Calendar c,
                                 ViewWxscgift viewWxscgift, SendVouCouponDto sendVouCouponDto) {
        VoucherBase voucherBase = new VoucherBase();
        voucherBase.setRentid(1);
        voucherBase.setWeid(Long.valueOf(sendVouCouponDto.getWeid()));
        voucherBase.setOpenid(sendVouCouponDto.getOpenid());
        voucherBase.setName(viewWxscgift.getName());
        voucherBase.setType("WXSC");
        voucherBase.setStatus("Y");
        voucherBase.setHykh(map.get("linkNo").toString());
        voucherBase.setSclx(1);
        voucherBase.setMaxdate(s.format(new Date()) + "至" + map.get("maxData").toString());
        voucherBase.setMemo(viewWxscgift.getUsememo());
        voucherBase.setInsertsource("微信商城" + viewWxscgift.getId());
        voucherBase.setLinksource(map.get("linkNo").toString());
        voucherBase.setBodjt("WXSC_JFHQ" + s.format(c.getTime()));
        voucherBase.setSc_ruleid(viewWxscgift.getRuleid());
        voucherBase.setAmt((BigDecimal) map.get("amt"));
        voucherBase.setAwarid(Integer.valueOf(sendVouCouponDto.getCouponId()));
        voucherBase.setValiddate(Integer.valueOf(map.get("maxData").toString()));
        voucherBase.setIshot(viewWxscgift.getIshot());
        voucherBase.setIsnew(viewWxscgift.getIsnew());
        voucherBase.setIntegral(viewWxscgift.getJz());
        voucherBase.setPpurl(viewWxscgift.getPpurl());
        voucherBase.setUsermemo(viewWxscgift.getUsememo());
        voucherBase.setExmemo(viewWxscgift.getExdetails());
        voucherBase.setVoutype(viewWxscgift.getVou_type());
        voucherBase.setExpintai(viewWxscgift.getExpintai());
        voucherBase.setExdetails(viewWxscgift.getExdetails());
        voucherBase.setUservalidity(viewWxscgift.getUservalidity());
        voucherBase.setExmonthid(viewWxscgift.getExmonthid());
        voucherBaseDao.insert(voucherBase);
    }


    private Map<String, Object> callWxscInsertVoucher(Map<String, Object> map,
                                                      ActivityMain activityMain,
                                                         UserInfo userInfo,
                                                      ViewWxscgift viewWxscgift,
                                                      NewActivityAward newActivityAward,
                                                      SendVouCouponDto sendVouCouponDto, SimpleDateFormat s, Calendar c) {
        //伯俊存储过程封装参数
        map.put("brand", "WX");
        BigDecimal amt = null;
        // map.put("parValue",viewWxscgift.getMz());
        if (null != viewWxscgift.getZk() && (viewWxscgift.getZk() == 1 || viewWxscgift.getZk() == 0)) {
            //现金券
            map.put("parValue", viewWxscgift.getMz());
            map.put("discount", 1);
            amt = new BigDecimal(viewWxscgift.getMz());
        } else {
            //折扣
            map.put("parValue", 0);
            map.put("discount", viewWxscgift.getZk());
            amt = new BigDecimal(viewWxscgift.getZk());
        }
        map.put("maxData", s.format(c.getTime()));
        map.put("department", activityMain.getActivityName());
        if (12899 == newActivityAward.getRuleid() || null==userInfo.getcStoreId()) {
            map.put("stores", "WDDC0000");
        } else {
            map.put("stores", userInfo.getStoreCode());
        }
        map.put("cityName", sendVouCouponDto.getDementpart());
        map.put("maxNum", viewWxscgift.getQtylimit());
        newActivityAwardDao.callWxscInsertVoucher(map);
        map.put("amt", amt);
        return map;
    }
}
