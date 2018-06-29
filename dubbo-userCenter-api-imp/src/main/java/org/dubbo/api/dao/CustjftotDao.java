package org.dubbo.api.dao;

import org.dubbo.pojo.bean.user.Custjftot;

import java.util.List;

/**
 * Created by fanglei on 2018/6/11.
 */
public interface CustjftotDao {


    /**
     * 更新当前批次当前用户积分
     * @param custjftot
     */
    void updatetCustjftotInteger(Custjftot custjftot);

    /**
     * 插入批次表
     * @param custjftot
     */
    void insert(Custjftot custjftot);

    /**
     * 获取当前批次当前用户
     * @param custjftot
     * @return
     */
    Custjftot getCustjftot(Custjftot custjftot);

    /**
     * 获取当前批次当前用户积分
     * @param custjftot
     * @return
     */
    Long getCustjftotByBatch(Custjftot custjftot);

    /**
     * 获取当前unionid下当前批次总积分
     * @param custjftot
     * @return
     */
    Long getCustjftotByBatchByUnionid(Custjftot custjftot);


    /**
     * 获取当前批次当前用户所有卡积分
     * @param custjftot
     * @return
     */
    List<Custjftot> getListCustjftotByBatch(Custjftot custjftot);

    /**
     * 获取除了本品牌以外的批次积分
     * @param custjftot
     * @return
     */
    List<Custjftot> getListCustjftotByOtherBatch(Custjftot custjftot);


    /**
     * 获取其他品牌当前批次的总积分
     * @param custjftot
     * @return
     */
    Long getCustjftotByOtherBatch(Custjftot custjftot);

    /**
     * 验证当前批次当前用户是否存在
     * @param custjftot
     * @return
     */
    Custjftot checkCustjftot(Custjftot custjftot);
}
