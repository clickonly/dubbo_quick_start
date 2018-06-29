package org.dubbo.api.dao;

import org.apache.ibatis.annotations.Param;
import org.dubbo.pojo.bean.user.CardMain;
import org.dubbo.pojo.bean.user.CardMainLog;

import java.util.List;

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

    List<CardMain> getCardMainErrorList();

    void insertCardMain(CardMain cardMain);

    void updateCardMainRemark(CardMain cardMain);

    void deleteCardmainById(@Param("id") String id);

    Integer getId();

    CardMainLog getCardmainLogInfo(@Param("weid") String weId, @Param("openid") String openid, @Param("tel") String tel, @Param("id") String wx_id);


    List<String> getOpenIdList(String unionId);
}
