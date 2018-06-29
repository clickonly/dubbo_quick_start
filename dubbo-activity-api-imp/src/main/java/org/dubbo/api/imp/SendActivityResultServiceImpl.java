package org.dubbo.api.imp;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.dubbo.api.dao.ActivationCodeListDao;
import org.dubbo.api.dao.ActivityMainDao;
import org.dubbo.api.dao.ActivityPrizeDao;
import org.dubbo.api.dao.ActivityWinResultDao;
import org.dubbo.api.service.*;
import org.dubbo.pojo.bean.activity.*;
import org.dubbo.pojo.dto.activity.*;
import org.dubbo.pojo.dto.wx.SendVouCouponMessageDto;
import org.dubbo.pojo.enums.*;
import org.dubbo.pojo.redis.RedisUtil;
import org.dubbo.pojo.utils.CommonRedisKey;
import org.dubbo.pojo.utils.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by fanglei on 2018/5/23.
 */
@Service("sendActivityResultService")
public class SendActivityResultServiceImpl implements SendActivityResultService {

    private static final Logger logger = Logger.getLogger(SendActivityResultServiceImpl.class);


    private static String PIKU_MESSAGE="恭喜您获得了{prizeName},点击此链接维护您的收货地址,我们会尽快和您取得联系。";

    private static String PRODUCT_MESSAGE="恭喜您获得了{prizeName}物品，请选择商品尺码并且维护您的收货地址，我们会尽快和您取得联系。";

    private static String INVENTED_MESSAGE="恭喜您获得了{prizeName}，{activationCodeList},请您尽快激活，以免过期。";


    @Autowired(required = false)
    private RedisUtil redisUtil;

    @Autowired(required = false)
    private ActivityMainDao activityMainDao;

    @Autowired(required = false)
    private ActivityPrizeDao activityPrizeDao;

    @Autowired(required = false)
    private ActivityWinResultDao activityWinResultDao;

    @Autowired(required = false)
    private UserIntegralService userIntegralService;

    @Autowired(required = false)
    private CouponService couponService;

    @Autowired(required = false)
    private MessageService messageService;

    @Autowired
    private ActivationCodeListDao activationCodeListDao;

    @Autowired
    private UserService userService;

    @Autowired
    private ActivityService activityService;


    /**
     * 处理中奖结果
     *
     * @param activityWinResult
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean insertActivityWinResult(ActivityWinResult activityWinResult) {
        logger.info("into insertActivityWinResult method");
        boolean flag = false;
        activityWinResult.setStatus(ActivitySendStatus.OTHER.getCode());
        if (activityWinResult != null) {
            //获取当前活动的信息
            ActivityMain activityMain = activityMainDao.getActivityInfo(activityWinResult.getActivityId());
            if (null == activityMain) {
                activityWinResult.setStatus(ActivitySendStatus.OTHER.getCode());
            } else {
                //获取当前奖项的详情
                ActivityPrize activityPrize = new ActivityPrize();
                activityPrize.setId(activityWinResult.getPrizeId());
                activityPrize.setActivityId(activityWinResult.getActivityId());
                activityPrize = activityPrizeDao.getActivityPrize(activityPrize);
                if (null == activityPrize) { //如果奖项为空
                    activityWinResult.setStatus(ActivitySendStatus.OTHER.getCode());
                } else {
                    ActivityPrizeConfig activityPrizeConfig = JSONObject.parseObject(activityPrize.getJson(), ActivityPrizeConfig.class);
                    //奖项 积分
                    if (ActivityprizeType.INTEGRAL.getCode().equals(activityPrize.getPrizeType())) {
                        if (!StringUtils.isEmpty(activityPrize.getJson())) {
                            if (null != activityPrizeConfig.getIntegral()) {
                                SendIntergralDto sendIntergralDto = new SendIntergralDto();
                                sendIntergralDto.setOpenid(activityWinResult.getOpenid());
                                sendIntergralDto.setUnionid(activityWinResult.getUnionid());
                                sendIntergralDto.setActivityId(activityWinResult.getActivityId());
                                sendIntergralDto.setIntegral(activityPrizeConfig.getIntegral());
                                sendIntergralDto.setAddTime(activityWinResult.getWinTime());
                                flag = userIntegralService.handIntegral(sendIntergralDto);
                            } else {
                                throw new MyException("当前奖项.........Id" + activityPrize.getId() + "的JSON>>>>>>" + activityPrize.getJson() + "积分没有");
                            }
                        } else {
                           throw new MyException("当前奖项配置没有...."+ activityPrize.getId() );
                        }
                    } else if (ActivityprizeType.COUPON.getCode().equals(activityPrize.getPrizeType())) {
                        //优惠券
                        if (!StringUtils.isEmpty(activityPrize.getJson())) {
                            if (null != activityPrizeConfig.getCouponId()) {
                                SendVouCouponDto sendVouCouponDto = new SendVouCouponDto();
                                sendVouCouponDto.setAddTime(activityWinResult.getWinTime());
                                sendVouCouponDto.setOpenid(activityWinResult.getOpenid());
                                sendVouCouponDto.setUnionid(activityWinResult.getUnionid());
                                sendVouCouponDto.setActivityId(activityWinResult.getActivityId());
                                sendVouCouponDto.setCouponId(String.valueOf(activityPrizeConfig.getCouponId()));
                                sendVouCouponDto.setPrizeId(activityWinResult.getPrizeId());
                                sendVouCouponDto.setWeid(activityWinResult.getWeid());
                                flag = couponService.sendCouponTorRedis(sendVouCouponDto);
                            } else {
                                throw new MyException("当前奖项.........Id" + activityPrize.getId() + "的JSON>>>>>>" + activityPrize.getJson() + "优惠券ID没有" );
                            }
                        } else {
                            throw new MyException("当前优惠券奖项.........Id" + activityPrize.getId() + "的JSON>为空" );
                        }

                    }else if (ActivityprizeType.INVENTED.getCode().equals(activityPrize.getPrizeType())){
                        //虚拟物品 则要更新兑换码
                        ActivityWinResult activityWinResult1=activityWinResultDao.getActivityWinResultById(activityWinResult.getId());
                        if (null==activityWinResult1.getActivationCode()|| StringUtils.isEmpty(activityWinResult1.getActivationCode())){
                            ActivationCodeList activationCodeList=activationCodeListDao.getActivationCodeList(activityWinResult);
                            if (null!=activationCodeList){
                                activityWinResult.setActivationCode(activationCodeList.getActivationCode());
                                activityWinResultDao.updateActivationCode(activityWinResult);
                                activationCodeList.setStatus("Y");
                                activationCodeListDao.updateStatus(activationCodeList);
                                flag = true;
                            }else{
                                throw new MyException("当前奖项.........Id" + activityPrize.getId() + "兑换码不存在>>>>>>" );
                            }

                        }else {
                            activityWinResult1.setActivationCode(activityWinResult1.getActivationCode());
                            flag = true;
                        }
                    } else {//其他情况
                        flag = true;
                    }
                    if (flag) {
                        //判断当前奖项是否要发送消息
                        if (null!=activityMain.getActivityConfigJson()&&!ActivityprizeType.COUPON.getCode().equals(activityPrize.getPrizeType())&&!ActivityprizeType.INTEGRAL.getCode().equals(activityPrize.getPrizeType())){
                            //如果当前奖项类型不是优惠券在此发送消息 否则在发送券发送消息
                            if(!StringUtils.isEmpty(activityMain.getActivityConfigJson().getIsSend())&& IsSendMessageFlag.SEND.getCode().equals(activityMain.getActivityConfigJson().getIsSend())){
                                Map<String,Object> messageTemplateMap=activityMain.getActivityConfigJson().getWxMessageTemplate();
                                SendVouCouponMessageDto sendVouCouponMessageDto=new SendVouCouponMessageDto();
                                sendVouCouponMessageDto.setUnionid(activityWinResult.getUnionid());
                                sendVouCouponMessageDto.setOpenid(activityWinResult.getOpenid());
                                sendVouCouponMessageDto.setActivityId(activityWinResult.getActivityId());
                                sendVouCouponMessageDto.setWeid(activityWinResult.getWeid());
                                sendVouCouponMessageDto.setWxMessageTemplateId(Long.valueOf(messageTemplateMap.get(activityWinResult.getWeid()).toString()));
                                sendVouCouponMessageDto.setPrizeId(activityWinResult.getPrizeId());
                                sendVouCouponMessageDto.setType(activityPrize.getPrizeType());
                                Map<String,String> map=getMessage(activityPrize,activityWinResult);
                                sendVouCouponMessageDto.setMessage(map.get("message"));
                                sendVouCouponMessageDto.setUrl(map.get("url"));
                                sendVouCouponMessageDto.setActivityName(activityMain.getActivityName());
                                messageService.sendMessageToReids(sendVouCouponMessageDto);
                            }
                        }
                        activityWinResult.setStatus(ActivitySendStatus.IS_SEND.getCode());
                    }
                }
            }
        }
        activityWinResultDao.updateActivityWinResultStatus(activityWinResult);
        return flag;
    }




    private Map<String,String> getMessage(ActivityPrize activityPrize,ActivityWinResult activityWinResult){
       Map<String,String> map=new HashMap<>();
        String message;
        switch (PrizeType.getByValue(activityPrize.getPrizeType())) {
            case INTEGRAL:
                //积分模板消息
                break;
            case CASH://现金
                break;
            case COUPON: //优惠券
                break;
            case INVENTED://虚拟物品
                 message=INVENTED_MESSAGE.replaceAll("\\{prizeName}",activityPrize.getPrizeName());
                message=message.replaceAll("\\{activationCodeList}",activityWinResult.getActivationCode());
                map.put("message",message);
                map.put("url","#");
                break;
            case PIKU://实物奖品
                message=PIKU_MESSAGE.replaceAll("\\{prizeName}",activityPrize.getPrizeName());
                map.put("message",message);
                String url=activityPrize.getActivityPrizeConfig().getUrlMap().get(activityWinResult.getWeid());
                url=url.replaceAll("\\{activityId}",String.valueOf(activityWinResult.getActivityId()));
                url=url.replaceAll("\\{prizeId}",String.valueOf(activityPrize.getId()));
                map.put("url",url);
                break;
            case PRODUCT://商品
                message=PRODUCT_MESSAGE.replaceAll("\\{prizeName}",activityPrize.getPrizeName());
                map.put("message",message);
                String productUrl=activityPrize.getActivityPrizeConfig().getUrlMap().get(activityWinResult.getWeid());
                productUrl=productUrl.replaceAll("\\{activityId}",String.valueOf(activityWinResult.getActivityId()));
                productUrl=productUrl.replaceAll("\\{prizeId}",String.valueOf(activityPrize.getId()));
                if (productUrl.indexOf("\\{goodsid}")>0&& null!=activityPrize.getActivityPrizeConfig().getProductId()){
                    productUrl=productUrl.replaceAll("\\{goodsid}",activityPrize.getActivityPrizeConfig().getProductId());
                }
                if (productUrl.indexOf("\\{skcno}")>0&&null!=activityPrize.getActivityPrizeConfig().getSkuNo()){
                    productUrl=productUrl.replaceAll("\\{skcno}",activityPrize.getActivityPrizeConfig().getSkuNo());
                }
                map.put("url",productUrl);
                break;

        }
    return  map;
    }

    /**
     * 保存中奖并且发奖
     *
     * @param activityWinResult
     * @return
     */
    @Override
    public boolean sendRedisActivityWinResult(ActivityWinResult activityWinResult) {
        logger.info("into sendRedisActivityWinResult method");
        boolean flag;
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(activityWinResult.getWinTime());
            activityWinResult.setId(activityWinResultDao.getSeqId());
            activityWinResult.setAddTime(calendar.getTime());
            activityWinResultDao.insert(activityWinResult);
            redisUtil.lSet(CommonRedisKey.acticity.LOTTERY_LIST, activityWinResult);
            flag = true;
        } catch (Exception e) {
            flag = false;
            logger.error("sendRedisActivityWinResult error", e);
        }
        return flag;
    }


    /**
     * 发送中奖结果
     * @param activityWinResult
     * @return
     */
    @Override
    public boolean sendWinResultToRedis(ActivityWinResult activityWinResult) {
        logger.info("into sendWinResultToRedis method");
        boolean flag;
        try{
            redisUtil.lSet(CommonRedisKey.acticity.AWARD_LIST, activityWinResult);
            flag = true;
        }catch (Exception e){
            flag = false;
            logger.error("sendWinResultToRedis error", e);
        }
        return flag;
    }


    @Override
    public List<ActivityWinResult> getActivityWinResultList(ActivityDto activityDto) {
        logger.info("into getActivityWinResultList method");
        return activityWinResultDao.getActivityWinResultListByActivityId(activityDto);
    }


    @Override
    public List<ActivityWinResult> getPrizeRecordByActivityType(ActivityDto activityDto) {
        return activityWinResultDao.getPrizeRecordByActivityType(activityDto);
    }


    @Override
    public List<ActivityWinResult> getActivityWinResultListByActivityIdList(PrizeRecordDto prizeRecordDto) {
        logger.info("into getActivityWinResultListByActivityIdList method");

        return activityWinResultDao.getActivityWinResultListByActivityIdList(prizeRecordDto);
    }


    /**
     * 处理竞价结果
     * @param activityMain
     */
    @Override
    public void handAuctionResult(ActivityMain activityMain) {
        logger.info("当前处理竞价....."+activityMain.getId());
        try{
            ActivityDto activityDto=new ActivityDto();
            activityDto.setActivityId(activityMain.getId());
            List<ActivityPrize> activityPrizeList=activityService.getActivityPrize(activityDto);
            for (ActivityPrize activityPrize:activityPrizeList){
                Long size=redisUtil.hlen(CommonRedisKey.Auction.AUCTION_OFFER_RECORD+activityPrize.getId());
                if (size>0||size!=null){
                    for(int i=size.intValue();i>0;i--){
                        Object object=redisUtil.hget(CommonRedisKey.Auction.AUCTION_OFFER_RECORD+activityPrize.getId(),String.valueOf(i));
                        if (object==null){
                            logger.info("当前处理竞价....." + activityPrize.getId() + "出价记录"+i+"为null继续执行");
                            continue;
                        }else {
                            ActivityAuctionDto activityAuctionDto=(ActivityAuctionDto)object;
                            if (null==activityAuctionDto.getPrice()){
                                logger.info("当前处理竞价....." + activityPrize.getId() + "出价记录进"+i+"为null继续执行");
                                continue;
                            }else {
                                if (null==activityAuctionDto.getUnionId()){
                                    logger.info("当前处理竞价....." + activityPrize.getId() + "出价记录"+i+"unionid为空...");
                                    continue;
                                }else {
                                    //验证积分
                                    logger.info("当前处理竞价....." + activityPrize.getId() + "出价记录"+i+"开始验证积分..."+activityAuctionDto.getPrice());
                                    //获取当前用户积分
                                    Long intergral=userService.getUserIntergralByRedis(activityAuctionDto.getUnionId());
                                    if (intergral<activityAuctionDto.getPrice().longValue()){
                                        logger.info("当前处理竞价....." + activityMain.getId() + "出价记录"+i+"积分不足，进行下一个操作");
                                        continue;
                                    }else {
                                        //扣积分
                                        SendIntergralDto sendIntergralDto = new SendIntergralDto();
                                        sendIntergralDto.setActivityId(activityAuctionDto.getActivityId());
                                        sendIntergralDto.setAddTime(Long.valueOf(activityAuctionDto.getTimestamp()));
                                        sendIntergralDto.setIntegral(activityAuctionDto.getPrice().longValue() * -1);
                                        sendIntergralDto.setOpenid(activityAuctionDto.getOpenId());
                                        sendIntergralDto.setUnionid(activityAuctionDto.getUnionId());
                                        if (userIntegralService.handIntegral(sendIntergralDto)){
                                            //发奖
                                            ActivityWinResult activityWinResult =new ActivityWinResult();
                                            activityWinResult.setActivityId(activityAuctionDto.getActivityId());
                                            activityWinResult.setPrizeId(activityAuctionDto.getPrizeId());
                                            activityWinResult.setOpenid(activityAuctionDto.getOpenId());
                                            activityWinResult.setUnionid(activityAuctionDto.getUnionId());
                                            activityWinResult.setIntegral(activityAuctionDto.getPrice().longValue() * -1);
                                            activityWinResult.setWeid(activityAuctionDto.getWeid());
                                            activityWinResult.setAddTime(new Date());
                                            sendRedisActivityWinResult(activityWinResult);
                                            break;
                                        }else{
                                            logger.error("当前用户积分发送错误.....应该扣奖"+ JSON.toJSONString(activityAuctionDto));
                                        }

                                    }
                                }

                            }
                        }
                    }

                }else {
                    logger.info("当前处理竞价....." + activityPrize.getId() + "出价记录为0");
                }
            }
        }catch (Exception e){
            messageService.sendErrorMessage(activityMain.getId(),"竞价发奖出现问题，请赶快查看");
            logger.error("竞价处理结果....",e);
        }

    }


    @Override
    public void handAuctionResultByAction(ActivityDto activityDto) {
        ActivityMain activityMain =new ActivityMain();
        activityMain.setId(activityDto.getActivityId());
        handAuctionResult(activityMain);
    }


    @Override
    public boolean updateSize(ActivityWinResult activityWinResult) {
        boolean flag=false;
        try{
            activityWinResultDao.updateSize(activityWinResult);
            flag=true;
        }catch (Exception e){
            logger.error("updateSize error",e);
        }

        return flag;
    }

    @Override
    public void sendAddressIsNullMessage() {
        List<ActivityWinResult> activityWinResultList=activityWinResultDao.sendAddressIsNullActivityWinResult();
        ActivityPrize activityPrize =null;
        ActivityMain activityMain =null;
        for (ActivityWinResult activityWinResult:activityWinResultList){
            activityMain = activityMainDao.getActivityInfo(activityWinResult.getActivityId());
            activityPrize= new ActivityPrize();
            activityPrize.setId(activityWinResult.getPrizeId());
            activityPrize.setActivityId(activityWinResult.getActivityId());
            activityPrize = activityPrizeDao.getActivityPrize(activityPrize);
            Map<String,Object> messageTemplateMap=activityMain.getActivityConfigJson().getWxMessageTemplate();
            SendVouCouponMessageDto sendVouCouponMessageDto=new SendVouCouponMessageDto();
            sendVouCouponMessageDto.setUnionid(activityWinResult.getUnionid());
            sendVouCouponMessageDto.setOpenid(activityWinResult.getOpenid());
            sendVouCouponMessageDto.setActivityId(activityWinResult.getActivityId());
            sendVouCouponMessageDto.setWeid(activityWinResult.getWeid());
            sendVouCouponMessageDto.setWxMessageTemplateId(Long.valueOf(messageTemplateMap.get(activityWinResult.getWeid()).toString()));
            sendVouCouponMessageDto.setPrizeId(activityWinResult.getPrizeId());
            sendVouCouponMessageDto.setType(activityPrize.getPrizeType());
            Map<String,String> map=getMessage(activityPrize,activityWinResult);
            sendVouCouponMessageDto.setMessage("您尚未填写收货地址"+map.get("message")+"请在72小时内填写您的收货信息，逾期未填写视为自动弃权");
            sendVouCouponMessageDto.setUrl(map.get("url"));
            sendVouCouponMessageDto.setActivityName(activityMain.getActivityName());
            messageService.sendMessageToReids(sendVouCouponMessageDto);
        }

    }
}
