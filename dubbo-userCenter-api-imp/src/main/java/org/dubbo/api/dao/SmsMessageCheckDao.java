package org.dubbo.api.dao;

import org.apache.ibatis.annotations.Param;
import org.dubbo.pojo.bean.user.SmsMessageCheck;

/**
 * Created by fanglei on 2017/12/19.
 */
public interface SmsMessageCheckDao {

    SmsMessageCheck getSmsMessageCheck(String tel);
}
