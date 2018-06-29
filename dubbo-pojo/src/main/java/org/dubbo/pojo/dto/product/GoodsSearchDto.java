package org.dubbo.pojo.dto.product;

import org.dubbo.pojo.base.PageBase;

import java.io.Serializable;

/**
 * Created by fanglei on 2017/11/15.
 */
public class GoodsSearchDto extends PageBase implements Serializable {

    private Long id;

    private String name;

    private String openId;

    private String weId;

    private String typeVal;

    private String classVal;

    private String orderVal;

    private String rentId;

    private String styleId;

    private String goodsId;

    private String code;

    private String like;

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getWeId() {
        return weId;
    }

    public void setWeId(String weId) {
        this.weId = weId;
    }

    public String getTypeVal() {
        return typeVal;
    }

    public void setTypeVal(String typeVal) {
        this.typeVal = typeVal;
    }

    public String getClassVal() {
        return classVal;
    }

    public void setClassVal(String classVal) {
        this.classVal = classVal;
    }

    public String getOrderVal() {
        return orderVal;
    }

    public void setOrderVal(String orderVal) {
        this.orderVal = orderVal;
    }

    public String getRentId() {
        return rentId;
    }

    public void setRentId(String rentId) {
        this.rentId = rentId;
    }

    public String getStyleId() {
        return styleId;
    }

    public void setStyleId(String styleId) {
        this.styleId = styleId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}


