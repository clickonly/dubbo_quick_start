package org.dubbo.api.dao;

import org.apache.ibatis.annotations.Param;
import org.dubbo.pojo.bean.user.CardMain;
import org.dubbo.pojo.bean.user.ClentVip;
import org.dubbo.pojo.bean.user.Custjftot;
import org.dubbo.pojo.bean.user.MaxLevelCardMain;

import java.util.List;

/**
 * Created by fanglei on 2017/12/13.
 */
public interface BojunDao {

    ClentVip getClentVip(@Param("cardno") String cardno);

    void updateClentVip(ClentVip clentVip);

    void insertClentVip(ClentVip clentVip);

    Integer getCid();

    Integer getCustomerId(@Param("ves_id") String ves_id);

    Integer getSalesrepId(@Param("openid") String openId, @Param("storeid") String storeId);

    Integer getJTCardLevel(@Param("openid") String openId);

    Integer getClentVipLmaxid(@Param("weid") String weId, @Param("mobil") String mobil);

    Integer isBound(@Param("rowid") String rowId);

    ClentVip getCustomerByBoJun(@Param("openId") String openId);

    MaxLevelCardMain getMaxLevelCardMain(@Param("weid") String weId, @Param("mobil") String mobil, @Param("lmaxid") String lMaxId);

    Long getUserIntergral(String unionid);

    Integer getUserIntergralByOpenid(String openid);



    /**
     * 获取当个品牌的过期积分
     * @param
     * @return
     */
    Custjftot getCustjftotByOpenid(Custjftot custjftot);

    /**
     * 通过unionid获取会员列表
     * @param cardMain
     * @return
     */
    List<ClentVip> getClentVipByUnionid(CardMain cardMain);


    /**
     * 减积分
     * @param custjftot
     */
    void updatetCustjftot(Custjftot custjftot);


    List<Custjftot> getCustjftotByUnionid(Custjftot custjftot);

    Integer getUserIntergralByUnionid(Custjftot custjftot);

    ClentVip getClentVipInfo(String openid);

    void insertCustjftot(Custjftot custjftot);

    /**
     * 增加积分
     * @param custjftot
     */
    void updatetAddCustjftot(Custjftot custjftot);

    Custjftot getCustjftotBy(Custjftot custjftot);

    Long getCustjftotCountByUnionid(Custjftot custjftot);

    Long getClentVipByUnionidCount(CardMain cardMain);
}
