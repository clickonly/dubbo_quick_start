package org.dubbo.pojo.bean.product;

import java.io.Serializable;

/**
 * Created by jiangbin on 2018/2/26.
 * 库存
 */
public class GoodsStock implements Serializable {

    private Long skuId;
    private Integer stocknum ;

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Integer getStocknum() {
        return stocknum;
    }

    public void setStocknum(Integer stocknum) {
        this.stocknum = stocknum;
    }
}
