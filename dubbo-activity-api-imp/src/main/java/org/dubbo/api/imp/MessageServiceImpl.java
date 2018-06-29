package org.dubbo.api.imp;

import com.alibaba.druid.util.StringUtils;
import org.apache.log4j.Logger;
import org.dubbo.api.dao.*;
import org.dubbo.api.service.MessageService;
import org.dubbo.api.service.UserService;
import org.dubbo.pojo.bean.activity.ActivityPrize;
import org.dubbo.pojo.bean.activity.ViewWxscgift;
import org.dubbo.pojo.bean.user.UserInfo;
import org.dubbo.pojo.bean.wx.WxConfig;
import org.dubbo.pojo.bean.wx.WxMessageInfo;
import org.dubbo.pojo.bean.wx.WxMessageTask;
import org.dubbo.pojo.bean.wx.WxMessageTemplate;
import org.dubbo.pojo.dto.wx.SendVouCouponMessageDto;
import org.dubbo.pojo.enums.MessageType;
import org.dubbo.pojo.redis.RedisUtil;
import org.dubbo.pojo.utils.CommonRedisKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by fanglei on 2018/5/24.
 */
@Service("messageService")
public class MessageServiceImpl implements MessageService {


    private static final Logger logger = Logger.getLogger(MessageService.class);


    @Autowired
    private WxMessageTemplateDao wxMessageTemplateDao;

    @Autowired
    private WxConfigDao wxConfigDao;

    @Autowired
    private UserService userService;

    @Autowired
    private WxMessageInfoDao wxMessageInfoDao;

    @Autowired
    private WxMessageTaskDao wxMessageTaskDao;

    @Autowired
    private RedisUtil redisUtil;


    @Override
    public boolean sendMessageToReids(SendVouCouponMessageDto sendVouCouponMessageDto) {
        logger.info("into MessageService sendMessageToReids method");
        boolean flag;
        try {
            redisUtil.lSet(CommonRedisKey.acticity.MESSAGE_LIST, sendVouCouponMessageDto);
            flag = true;
        } catch (Exception e) {
            flag = false;
            logger.error("MessageService sendMessageToReids error", e);
        }
        return flag;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean sendMessage(SendVouCouponMessageDto sendVouCouponMessageDto) {
        logger.info("into MessageService sendMessage method");
        boolean flag = false;
        //获取消息模板
        WxMessageTemplate wxMessageTemplate = wxMessageTemplateDao.getWxMessageTemplateById(sendVouCouponMessageDto.getWxMessageTemplateId());
        if (null != wxMessageTemplate) {
            //CardMain cardMain = userService.getCardMainByOpenId(sendVouCouponMessageDto.getOpenid());//TODO
            UserInfo userInfo=new UserInfo();
            userInfo.setOpenId(sendVouCouponMessageDto.getOpenid());
            userInfo.setUnionId(sendVouCouponMessageDto.getUnionid());
            userInfo=userService.getClientVipInfo(userInfo);
            if (null != userInfo) {
                String json = "";
                switch (MessageType.getByValue(sendVouCouponMessageDto.getType())) {
                    case INTEGRAL:
                        //积分模板消息
                        json = "";
                        break;
                    case BIDPRICE: //竞价物品
                        json = ""; //TODO
                        break;
                    case CASH://现金
                        break;
                    case COUPON: //优惠券
                        json = getCouponSendMessage(sendVouCouponMessageDto, wxMessageTemplate, userInfo);
                        break;
                    case INVENTED://虚拟物品
                        json = getInventedJson(sendVouCouponMessageDto, wxMessageTemplate, userInfo);
                        break;
                    case PIKU://实物奖品
                        json = getPikuJson(sendVouCouponMessageDto, wxMessageTemplate, userInfo);
                        break;
                    case PRODUCT://商品
                        json = getProductJson(sendVouCouponMessageDto, wxMessageTemplate, userInfo);
                        break;
                    default: //发送模板消息
                        json=getErrorJson(sendVouCouponMessageDto, wxMessageTemplate, userInfo);
                        break;
                }
                if (!StringUtils.isEmpty(json)){
                    saveMssageInfo(sendVouCouponMessageDto, json);
                    savewxMessageTask(sendVouCouponMessageDto, json);
                    flag = true;
                }

            } else {
                flag = true;
                logger.info("sendMessage error>>>>>>>>>>用户数据为空" + sendVouCouponMessageDto.getOpenid());
            }
        } else {
            flag = false;
            logger.info("sendMessage error>>>>>>>>>>模板数据为空" + sendVouCouponMessageDto.getWxMessageTemplateId());
        }
        return flag;
    }


    /**
     * 保存微信模板任务
     *
     * @param sendVouCouponMessageDto
     * @param json
     */
    private void savewxMessageTask(SendVouCouponMessageDto sendVouCouponMessageDto, String json) {
        WxMessageTask wxMessageTask = new WxMessageTask();
        wxMessageTask.setRentid(1);
        wxMessageTask.setWeid(sendVouCouponMessageDto.getWeid());
        wxMessageTask.setOpenid(sendVouCouponMessageDto.getOpenid());
        wxMessageTask.setTemplateid(sendVouCouponMessageDto.getWxMessageTemplateId());
        wxMessageTask.setMessagebody(json);
        wxMessageTask.setSendtimes(0);
        wxMessageTaskDao.insert(wxMessageTask);
    }


    /**
     * 保存微信消息详情
     *
     * @param sendVouCouponMessageDto
     * @param json
     */
    private void saveMssageInfo(SendVouCouponMessageDto sendVouCouponMessageDto, String json) {
        WxMessageInfo wxMessageInfo = new WxMessageInfo();
        wxMessageInfo.setWeid(sendVouCouponMessageDto.getWeid());
        wxMessageInfo.setOpenid(sendVouCouponMessageDto.getOpenid());
        wxMessageInfo.setTitle(json);
        wxMessageInfo.setTitle2(json);
        wxMessageInfo.setMessageType("0");
        wxMessageInfo.setIsEnable("N");
        wxMessageInfo.setTemplateId(sendVouCouponMessageDto.getWxMessageTemplateId().intValue());
        wxMessageInfoDao.insert(wxMessageInfo);

    }



    /**
     * 出错
     *
     * @param sendVouCouponMessageDto
     * @param wxMessageTemplate
     * @param userInfo
     * @return
     */
    private String getErrorJson(SendVouCouponMessageDto sendVouCouponMessageDto, WxMessageTemplate wxMessageTemplate,  UserInfo userInfo) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        WxConfig wxConfig = new WxConfig();
        wxConfig.setWeid(sendVouCouponMessageDto.getWeid());
        wxConfig.setRentid(1);
        wxConfig = wxConfigDao.getWxConfig(wxConfig);
        String str = wxMessageTemplate.getTemplateformat();
        str = str.replaceAll("\\{openid}", sendVouCouponMessageDto.getOpenid());
        String userNameStr = wxConfig.getHash() + userInfo.getVipTypeName()+ "会员：" + userInfo.getNickName();
        str = str.replaceAll("\\{url}", "#");
        str = str.replaceAll("\\{username}", userNameStr);
        str = str.replaceAll("\\{activityName}", sendVouCouponMessageDto.getActivityName());
        str = str.replaceAll("\\{addTime}", sdf.format(new Date()));
        str = str.replaceAll("\\{remark}", sendVouCouponMessageDto.getMessage());
        logger.info("出错" + str.trim());
        return str.trim();
    }



    /**
     * 商品物品
     *
     * @param sendVouCouponMessageDto
     * @param wxMessageTemplate
     * @param userInfo
     * @return
     */
    private String getProductJson(SendVouCouponMessageDto sendVouCouponMessageDto, WxMessageTemplate wxMessageTemplate,  UserInfo userInfo) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        WxConfig wxConfig = new WxConfig();
        wxConfig.setWeid(sendVouCouponMessageDto.getWeid());
        wxConfig.setRentid(1);
        wxConfig = wxConfigDao.getWxConfig(wxConfig);
        String str = wxMessageTemplate.getTemplateformat();
        str = str.replaceAll("\\{openid}", sendVouCouponMessageDto.getOpenid());
        String userNameStr = wxConfig.getHash() + userInfo.getVipTypeName() + "会员：" + userInfo.getNickName();
        str = str.replaceAll("\\{url}", sendVouCouponMessageDto.getUrl());
        str = str.replaceAll("\\{username}", userNameStr);
        str = str.replaceAll("\\{activityName}", sendVouCouponMessageDto.getActivityName());
        str = str.replaceAll("\\{addTime}", sdf.format(new Date()));
        str = str.replaceAll("\\{remark}", sendVouCouponMessageDto.getMessage());
        str = str.replaceAll("\\{activityId}", String.valueOf(sendVouCouponMessageDto.getActivityId()));
        str = str.replaceAll("\\{prizeId}", String.valueOf(sendVouCouponMessageDto.getPrizeId()));
        logger.info("商品物品拼装" + str.trim());
        return str.trim();
    }


    /**
     * 实物物品
     *
     * @param sendVouCouponMessageDto
     * @param wxMessageTemplate
     * @param userInfo
     * @return
     */
    private String getPikuJson(SendVouCouponMessageDto sendVouCouponMessageDto, WxMessageTemplate wxMessageTemplate,  UserInfo userInfo) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        WxConfig wxConfig = new WxConfig();
        wxConfig.setWeid(sendVouCouponMessageDto.getWeid());
        wxConfig.setRentid(1);
        wxConfig = wxConfigDao.getWxConfig(wxConfig);
        String str = wxMessageTemplate.getTemplateformat();
        str = str.replaceAll("\\{openid}", sendVouCouponMessageDto.getOpenid());
        String userNameStr = wxConfig.getHash() + userInfo.getVipTypeName() + "会员：" + userInfo.getNickName();
        str = str.replaceAll("\\{url}", sendVouCouponMessageDto.getMessage());
        str = str.replaceAll("\\{username}", userNameStr);
        str = str.replaceAll("\\{activityName}", sendVouCouponMessageDto.getActivityName());
        str = str.replaceAll("\\{addTime}", sdf.format(new Date()));
        str = str.replaceAll("\\{remark}", sendVouCouponMessageDto.getMessage());
        str = str.replaceAll("\\{activityId}", String.valueOf(sendVouCouponMessageDto.getActivityId()));
        str = str.replaceAll("\\{prizeId}",String.valueOf(sendVouCouponMessageDto.getPrizeId()));
        logger.info("实物物品拼装" + str.trim());
        return str.trim();
    }


    /**
     * 虚拟物品拼装json
     *
     * @param sendVouCouponMessageDto
     * @param wxMessageTemplate
     * @param userInfo
     * @return
     */
    private String getInventedJson(SendVouCouponMessageDto sendVouCouponMessageDto, WxMessageTemplate wxMessageTemplate,  UserInfo userInfo) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        WxConfig wxConfig = new WxConfig();
        wxConfig.setWeid(sendVouCouponMessageDto.getWeid());
        wxConfig.setRentid(1);
        wxConfig = wxConfigDao.getWxConfig(wxConfig);
        String str = wxMessageTemplate.getTemplateformat();
        str = str.replaceAll("\\{openid}", sendVouCouponMessageDto.getOpenid());
        String userNameStr = wxConfig.getHash() + userInfo.getVipTypeName() + "会员：" + userInfo.getNickName();
        str = str.replaceAll("\\{url}", sendVouCouponMessageDto.getUrl());
        str = str.replaceAll("\\{username}", userNameStr);
        str = str.replaceAll("\\{activityName}", sendVouCouponMessageDto.getActivityName());
        str = str.replaceAll("\\{addTime}", sdf.format(new Date()));
        str = str.replaceAll("\\{remark}", sendVouCouponMessageDto.getMessage());
        logger.info("虚拟物品拼装" + str.trim());
        return str.trim();
    }


    /**
     * 优惠券JSON
     *
     * @param sendVouCouponMessageDto
     * @param wxMessageTemplate
     * @param userInfo
     * @return
     */
    private String getCouponSendMessage(SendVouCouponMessageDto sendVouCouponMessageDto, WxMessageTemplate wxMessageTemplate, UserInfo userInfo) {
        //获取当前券规则ID的
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        WxConfig wxConfig = new WxConfig();
        wxConfig.setWeid(sendVouCouponMessageDto.getWeid());
        wxConfig.setRentid(1);
        wxConfig = wxConfigDao.getWxConfig(wxConfig);
        String str = wxMessageTemplate.getTemplateformat();
        String userNameStr = wxConfig.getHash() + userInfo.getVipTypeName() + "会员：" + userInfo.getNickName();
        str = str.replaceAll("\\{openid}", sendVouCouponMessageDto.getOpenid());
        str = str.replaceAll("\\{username}", userNameStr);
        str = str.replaceAll("\\{activityName}", sendVouCouponMessageDto.getActivityName());
        str = str.replaceAll("\\{addTime}", sdf.format(new Date()));
        str = str.replaceAll("\\{remark}", sendVouCouponMessageDto.getUrl());
        str = str.replaceAll("\\{url}", sendVouCouponMessageDto.getUrl());

        logger.info("优惠券拼装" + str.trim());
        return str.trim();
    }


    public static void main(String args[]) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.print(sdf.format(new Date()));
    }


    @Override
    public void sendErrorMessage(Long activtiyId, String message) {
        SendVouCouponMessageDto sendVouCouponMessageDto=new SendVouCouponMessageDto();
        sendVouCouponMessageDto.setUnionid("oZpUxs3SSL83Y6oRoNcAlWpFlkCQ");
        sendVouCouponMessageDto.setOpenid("oVFOhjqy-0pZs35YNqP58LgfnrPs");
        sendVouCouponMessageDto.setActivityId(activtiyId);
        sendVouCouponMessageDto.setWeid("2738574294");
        sendVouCouponMessageDto.setWxMessageTemplateId(1305l);
        sendVouCouponMessageDto.setMessage(message);
        sendVouCouponMessageDto.setPrizeId(0L);
        sendVouCouponMessageDto.setType(MessageType.EEOR.getCode());
        sendMessageToReids(sendVouCouponMessageDto);
        SendVouCouponMessageDto sendVouCouponMessageDto1=new SendVouCouponMessageDto();
        sendVouCouponMessageDto1.setUnionid("oZpUxszZf7QtJwujYcq0hB5CjofU");
        sendVouCouponMessageDto1.setOpenid("oVFOhjvgvdt866J7z8YKBKmzhDCs");
        sendVouCouponMessageDto1.setActivityId(activtiyId);
        sendVouCouponMessageDto1.setWeid("2738574294");
        sendVouCouponMessageDto1.setWxMessageTemplateId(1305l);
        sendVouCouponMessageDto1.setPrizeId(0L);
        sendVouCouponMessageDto1.setMessage(message);
        sendVouCouponMessageDto1.setType(MessageType.EEOR.getCode());
        sendMessageToReids(sendVouCouponMessageDto1);
    }


}
