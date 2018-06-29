package org.dubbo.api.dao;

import org.apache.ibatis.annotations.Param;
import org.dubbo.pojo.bean.user.CardMain;

/**
 * Created by fanglei on 2017/12/13.
 */
public interface CardMainDao {

    CardMain getCardMain(@Param("openId") String openId);


    /**
     * 完善资料
     * @param cardMain
     */
    void  updateCardMain(CardMain cardMain);


    String getOpenid(CardMain cardMain);
}
