package org.dubbo.pojo.bean.product;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by jiangbin on 2018/2/24.
 */
public class AboutGoods implements Serializable {

    private String code;
    private BigDecimal price;
    private String goodsName;
    private Long goodsId;
    private String modelpict;
    private String listinfo;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getModelpict() {
        return modelpict;
    }

    public void setModelpict(String modelpict) {
        this.modelpict = modelpict;
    }

    public String getListinfo() {
        return listinfo;
    }

    public void setListinfo(String listinfo) {
        this.listinfo = listinfo;
    }
}


