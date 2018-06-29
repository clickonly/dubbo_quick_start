package org.dubbo.api.dao;

import org.dubbo.pojo.bean.activity.FaVipIntegralFtpLocal;
import org.dubbo.pojo.dto.activity.SendIntergraError;

/**
 * Created by fanglei on 2018/1/8.
 */
public interface FaVipIntegralFtpLocalDao {

    void  insert(FaVipIntegralFtpLocal faVipIntegralFtpLocal);

    void  inserSendIntegralKey(SendIntergraError sendIntergraError);
}
