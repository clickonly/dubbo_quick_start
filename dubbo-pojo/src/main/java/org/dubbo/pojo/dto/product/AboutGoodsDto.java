package org.dubbo.pojo.dto.product;

import java.io.Serializable;

/**
 * Created by jiangbin on 2018/2/24.
 */
public class AboutGoodsDto implements Serializable {

    private String openId;
    private Long goodsId;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }
}
