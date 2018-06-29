package org.dubbo.api.dao;

import org.dubbo.pojo.bean.product.GoodsClass;

import java.util.List;

/**
 * Created by fanglei on 2017/12/21.
 */
public interface ProductClassDao {

    List<GoodsClass> getGoodsClass(String weid);

    List<String> getGoodsClassWid();


}
