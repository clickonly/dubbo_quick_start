package org.dubbo.api.service;

import org.dubbo.pojo.bean.user.*;

import java.util.List;

/**
 * 用户信息service
 *
 * Created by jiangbin on 2017/12/13.
 */
public interface UserService {


    SmsMessageCheck getSendCode(String tel);

    /**
     * 獲取微信關注信息
     * @param openId
     * @return
     */
    WxFans getWxFans(String openId);


    UserInfo setCardMainRedis(UserInfo userInfo);

    /**
     * 获取当前用户实际积分
     * @param unionid
     * @return
     */
    Long getUserIntergral(String unionid);



    Long getUserIntergralByRedis(String unionid);

    /**
     * 将积分更新到缓存中
     * @param userInfo
     * @return
     */
    boolean setUserIntergraToRedis(UserInfo userInfo);


    /**
     * 获取用户数据
     * @param userInfo
     * @return
     */
    UserInfo getClientVipInfo(UserInfo userInfo);


}
