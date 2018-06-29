package org.dubbo.pojo.bean.product;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Jiangbin on 2017/11/20.
 */
public class GoodsView implements Serializable {

    private Long goodsId;

    private String name;

    private String style;

    private String isNew;

    private String isHot;

    private String memo3;

    private String img;
    private BigDecimal price;
    private Long weId;
    private String code;
    private String sort1;
    private String sort2;
    private String orderIndex;
    private String order1;
    private String goodsIndex;
    private String type;
    private String headId;
    private String listInfo;
    private String rn;
    private String itemsort;
    private String targetsort;
    private String unit;

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getIsNew() {
        return isNew;
    }

    public void setIsNew(String isNew) {
        this.isNew = isNew;
    }

    public String getIsHot() {
        return isHot;
    }

    public void setIsHot(String isHot) {
        this.isHot = isHot;
    }

    public String getMemo3() {
        return memo3;
    }

    public void setMemo3(String memo3) {
        this.memo3 = memo3;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getWeId() {
        return weId;
    }

    public void setWeId(Long weId) {
        this.weId = weId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSort1() {
        return sort1;
    }

    public void setSort1(String sort1) {
        this.sort1 = sort1;
    }

    public String getSort2() {
        return sort2;
    }

    public void setSort2(String sort2) {
        this.sort2 = sort2;
    }

    public String getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(String orderIndex) {
        this.orderIndex = orderIndex;
    }

    public String getOrder1() {
        return order1;
    }

    public void setOrder1(String order1) {
        this.order1 = order1;
    }

    public String getGoodsIndex() {
        return goodsIndex;
    }

    public void setGoodsIndex(String goodsIndex) {
        this.goodsIndex = goodsIndex;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHeadId() {
        return headId;
    }

    public void setHeadId(String headId) {
        this.headId = headId;
    }

    public String getListInfo() {
        return listInfo;
    }

    public void setListInfo(String listInfo) {
        this.listInfo = listInfo;
    }

    public String getRn() {
        return rn;
    }

    public void setRn(String rn) {
        this.rn = rn;
    }

    public String getItemsort() {
        return itemsort;
    }

    public void setItemsort(String itemsort) {
        this.itemsort = itemsort;
    }

    public String getTargetsort() {
        return targetsort;
    }

    public void setTargetsort(String targetsort) {
        this.targetsort = targetsort;
    }
}
