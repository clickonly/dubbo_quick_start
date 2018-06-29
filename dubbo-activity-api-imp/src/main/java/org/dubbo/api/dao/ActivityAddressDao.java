package org.dubbo.api.dao;

import org.dubbo.pojo.bean.activity.ActivityAddress;

/**
 * Created by fanglei on 2018/6/1.
 */
public interface ActivityAddressDao {

    /**
     * 获取收货地址
     * @param activityAddress
     * @return
     */
    ActivityAddress getActivityAddress(ActivityAddress activityAddress);


    /**
     * 保存收货地址
     * @param activityAddress
     */
    void  inserActivityAddress(ActivityAddress activityAddress);


    /**
     * 获取默认收货地址
     * @param activityAddress
     * @return
     */
    ActivityAddress getDefaultActivityAddress(ActivityAddress activityAddress);

    Long getSeq();


    void delActivityAddress(ActivityAddress activityAddress);
}
