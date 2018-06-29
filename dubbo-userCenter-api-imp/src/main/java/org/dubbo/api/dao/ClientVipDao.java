package org.dubbo.api.dao;

import org.dubbo.pojo.bean.user.UserInfo;

import java.util.List;

/**
 * Created by fanglei on 2018/6/11.
 */
public interface ClientVipDao {

    /**
     * 获取用户数据
     * @param userInfo
     * @return
     */
    UserInfo getClientVipInfo(UserInfo userInfo);


    /**
     * 获取用户积分
     * @param unionid
     * @return
     */
    Long getUserIntergral(String unionid);

    /**
     * 更新积分
     * @param userInfo
     */
    void updateIntergral(UserInfo userInfo);

    /**
     * 通过ID
     * @param userInfo
     */
    void updateIntergralById(UserInfo userInfo);


    /**
     * 当前vipid实际积分
     * @param id
     * @return
     */
    Long getUserRealIntergral(Long id);

    /**
     * 获取其他品牌积分之和
     * @param userInfo
     * @return
     */
    Long gerOrtherIntergral(UserInfo userInfo);

    /**
     * 获取其他品牌卡
     * @param userInfo
     * @return
     */
    List<UserInfo> getOrtherUserInfo(UserInfo userInfo);

}
