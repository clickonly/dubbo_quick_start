package org.dubbo.api.service;

import org.dubbo.pojo.bean.product.GoodsClass;

import java.util.List;

/**
 * Created by fanglei on 2017/12/21.
 */
public interface GoodsClassService {


    /**
     * 同步产品分类
     */
    void synchronizationProductClass();

    /**
     * 获取产品
     * @param goodsClass
     * @return
     */
    List<GoodsClass> getGoodsClass(GoodsClass goodsClass);
}
