package org.dubbo.api.dao;

import org.apache.ibatis.annotations.Param;
import org.dubbo.pojo.bean.user.CardType;
import org.dubbo.pojo.bean.user.MiddleEntity;

/**
 * Created by fanglei on 2017/12/27.
 */
public interface CardTypeDao {


    CardType getCardType(CardType cardType);

    /**
     * 获取卡号
     * @return
     */
    String getCardNo();

    MiddleEntity getCardTypeApply(@Param("weid") String weid, @Param("userphone") String userphone);

}
