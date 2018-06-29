package org.dubbo.pojo.bean.product;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by fanglei on 2018/3/1.
 */
public class GoodsStockInfo implements Serializable {


    private String weid;
    private String name;
    private String  skuid;
    private String  goodsid;
    private String code;
    private String barcode;
    private String unit;
    private Integer kcsl;
    private BigDecimal price;
    private BigDecimal ori_price;
    private String     colorname;
    private String     sizename;
    private String  sizedetail;
    private String  colorcode;
    private String  sizecode;
    private String icon_url;
    private String  sttype;

    public String getWeid() {
        return weid;
    }

    public void setWeid(String weid) {
        this.weid = weid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkuid() {
        return skuid;
    }

    public void setSkuid(String skuid) {
        this.skuid = skuid;
    }

    public String getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(String goodsid) {
        this.goodsid = goodsid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getKcsl() {
        return kcsl;
    }

    public void setKcsl(Integer kcsl) {
        this.kcsl = kcsl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getOri_price() {
        return ori_price;
    }

    public void setOri_price(BigDecimal ori_price) {
        this.ori_price = ori_price;
    }

    public String getColorname() {
        return colorname;
    }

    public void setColorname(String colorname) {
        this.colorname = colorname;
    }

    public String getSizename() {
        return sizename;
    }

    public void setSizename(String sizename) {
        this.sizename = sizename;
    }

    public String getSizedetail() {
        return sizedetail;
    }

    public void setSizedetail(String sizedetail) {
        this.sizedetail = sizedetail;
    }

    public String getColorcode() {
        return colorcode;
    }

    public void setColorcode(String colorcode) {
        this.colorcode = colorcode;
    }

    public String getSizecode() {
        return sizecode;
    }

    public void setSizecode(String sizecode) {
        this.sizecode = sizecode;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }

    public String getSttype() {
        return sttype;
    }

    public void setSttype(String sttype) {
        this.sttype = sttype;
    }
}
