package org.dubbo.api.dao;

import org.dubbo.pojo.bean.product.GoodsDetalCount;
import org.dubbo.pojo.dto.product.GoodsCountDto;

import java.util.List;

/**
 * Created by jiangbin on 2018/1/17.
 */
public interface GoodsDetailCountDao {

    List<GoodsDetalCount> getGoodsCount(GoodsCountDto goodsCountDto);

    void insert(GoodsDetalCount goodsDetalCount);

    void  deleteGoodsDetalCount();
}
