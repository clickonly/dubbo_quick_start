package org.dubbo.pojo.bean.product;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Jiangbin on 2017/11/15.
 */
public class GoodsBase implements Serializable{

    private Long id;
    private Long rentId;
    private Long weId;
    private String code;
    private String name;
    private Integer typeId;
    private String unit;
    private Integer orderIndex;
    private String linkId;
    private String status;
    private Date lifeStart;
    private Date lifeEnd;
    private Integer buyLimit;
    private String isNew;
    private String isRecomment;
    private String isHot;
    private String isPop;
    private BigDecimal price;
    private BigDecimal oriPrice;
    private String style;
    private Integer order1;
    private Integer order2;
    private Integer order3;
    private Integer order4;
    private String memol1;
    private String memol2;
    private String memol4;
    private String memol3;

    private List<GoodsImage> goodsImageList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRentId() {
        return rentId;
    }

    public void setRentId(Long rentId) {
        this.rentId = rentId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getLifeStart() {
        return lifeStart;
    }

    public void setLifeStart(Date lifeStart) {
        this.lifeStart = lifeStart;
    }

    public Date getLifeEnd() {
        return lifeEnd;
    }

    public void setLifeEnd(Date lifeEnd) {
        this.lifeEnd = lifeEnd;
    }

    public Integer getBuyLimit() {
        return buyLimit;
    }

    public void setBuyLimit(Integer buyLimit) {
        this.buyLimit = buyLimit;
    }

    public String getIsNew() {
        return isNew;
    }

    public void setIsNew(String isNew) {
        this.isNew = isNew;
    }

    public String getIsRecomment() {
        return isRecomment;
    }

    public void setIsRecomment(String isRecomment) {
        this.isRecomment = isRecomment;
    }

    public String getIsHot() {
        return isHot;
    }

    public void setIsHot(String isHot) {
        this.isHot = isHot;
    }

    public String getIsPop() {
        return isPop;
    }

    public void setIsPop(String isPop) {
        this.isPop = isPop;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getOriPrice() {
        return oriPrice;
    }

    public void setOriPrice(BigDecimal oriPrice) {
        this.oriPrice = oriPrice;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public Integer getOrder1() {
        return order1;
    }

    public void setOrder1(Integer order1) {
        this.order1 = order1;
    }

    public Integer getOrder2() {
        return order2;
    }

    public void setOrder2(Integer order2) {
        this.order2 = order2;
    }

    public Integer getOrder3() {
        return order3;
    }

    public void setOrder3(Integer order3) {
        this.order3 = order3;
    }

    public Integer getOrder4() {
        return order4;
    }

    public void setOrder4(Integer order4) {
        this.order4 = order4;
    }

    public String getMemol1() {
        return memol1;
    }

    public void setMemol1(String memol1) {
        this.memol1 = memol1;
    }

    public String getMemol2() {
        return memol2;
    }

    public void setMemol2(String memol2) {
        this.memol2 = memol2;
    }

    public String getMemol4() {
        return memol4;
    }

    public void setMemol4(String memol4) {
        this.memol4 = memol4;
    }

    public String getMemol3() {
        return memol3;
    }

    public void setMemol3(String memol3) {
        this.memol3 = memol3;
    }

    public List<GoodsImage> getGoodsImageList() {
        return goodsImageList;
    }

    public void setGoodsImageList(List<GoodsImage> goodsImageList) {
        this.goodsImageList = goodsImageList;
    }
}
