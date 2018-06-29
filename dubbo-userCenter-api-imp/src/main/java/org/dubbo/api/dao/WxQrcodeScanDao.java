package org.dubbo.api.dao;

import org.apache.ibatis.annotations.Param;
import org.dubbo.pojo.bean.user.WxQrcodeScan;

public interface WxQrcodeScanDao {

    WxQrcodeScan getWxQrcodeScan(@Param("openId") String openId);
}