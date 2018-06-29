package org.dubbo.api.dao;

import org.dubbo.pojo.bean.user.VipIntegralFtp;

/**
 * Created by jiangbin on 2018/3/13.
 */
public interface VipIntegralFtpDao {


    /**
     * 保存流水
     * @param vipIntegralFtp
     */
    void insert(VipIntegralFtp vipIntegralFtp);

    /**
     * 获取主键
     * @return
     */
    Long getSeq();
}
