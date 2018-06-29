package org.dubbo.api.dao;

import org.dubbo.pojo.bean.user.CardMain;
import org.dubbo.pojo.bean.user.ClentVip;

import java.util.List;

/**
 * Created by jiangbin on 2017/12/13.
 */
public interface BojunDao {

    ClentVip getClentVip(ClentVip clentVip);

    /**
     * 获取一个用户的总积分
     * @param clentVip
     * @return
     */
    Integer getIntegralCount(ClentVip clentVip);


    /**
     * 加积分
     * @param clentVip
     */
    void updateIntegral(ClentVip clentVip);

    /**
     * 通过unionid获取会员列表
     * @param cardMain
     * @return
     */
    List<ClentVip> getClentVipByUnionid(CardMain cardMain);


    void subIntegral(ClentVip clentVip);

}
