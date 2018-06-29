package org.dubbo.api.dao;

import org.dubbo.pojo.bean.wx.WxInfo;

/**
 * Created by fanglei on 2018/4/13.
 */
public interface WxInfoDao {

    WxInfo getWxInfo(String weid);
}
