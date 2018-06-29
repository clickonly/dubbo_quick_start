package org.dubbo.api.dao;

import org.dubbo.pojo.bean.activity.ActivationCodeList;
import org.dubbo.pojo.bean.activity.ActivityWinResult;

/**
 * Created by fanglei on 2018/5/30.
 */
public interface ActivationCodeListDao {

    /**
     * 获取一个兑换码
     * @param activityWinResult
     * @return
     */
    ActivationCodeList getActivationCodeList(ActivityWinResult activityWinResult);


    /**
     * 更新兑换码状态
     * @param activationCodeList
     */
    void updateStatus(ActivationCodeList activationCodeList);
}
