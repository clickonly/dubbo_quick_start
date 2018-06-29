package org.dubbo.api.dao;

import org.apache.ibatis.annotations.Param;
import org.dubbo.pojo.bean.user.MiddleEntity;
import org.dubbo.pojo.bean.user.WxQrcode;

public interface WxQrcodeDao {

    MiddleEntity getWxQrcode(@Param("openId") String openId,
                             @Param("weid") String weid);
}