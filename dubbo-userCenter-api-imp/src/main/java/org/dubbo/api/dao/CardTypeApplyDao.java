package org.dubbo.api.dao;

import org.apache.ibatis.annotations.Param;
import org.dubbo.pojo.bean.user.CardTypeApply;

public interface CardTypeApplyDao {
    CardTypeApply getCardTypeApply(@Param("weid") String weid, @Param("userphone") String userphone);
}