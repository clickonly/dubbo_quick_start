package org.dubbo.pojo.bean.product;

import java.io.Serializable;

/**
 * Created by jiangbin on 2018/1/17.
 */
public class GoodsDetalCount implements Serializable {

    private Long goodsId;

    private Integer goodsCount;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }
}
