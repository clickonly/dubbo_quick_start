package org.dubbo.api.dao;

import org.dubbo.pojo.bean.user.WxFans;

import java.util.List;

/**
 * Created by fanglei on 2017/12/26.
 */
public interface WxFansDao {

    WxFans getWxFans(String openId);

    List<WxFans> getWxFansList(String unionId);


}
