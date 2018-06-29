package org.dubbo.pojo.bean.activity;

import java.io.Serializable;

/**
 * Created by jiangbin on 2018/1/10.
 */
public class WxscInsertVoucher implements Serializable {

    private String brand; //品牌
    private Double parValue; //面值 折扣券面值为null 现金券必填*/
    private Double discount; //折扣 /*折扣 现金券折扣为1*/
    private String  maxData ;//最大使用期限
    private String department; //领用部门
    private String stores; //店铺 用逗号分隔
    private String cityName; //券使用范围描述信息
    private Integer maxNum;//最大数量限制
    private String linkNo ;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getParValue() {
        return parValue;
    }

    public void setParValue(Double parValue) {
        this.parValue = parValue;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getMaxData() {
        return maxData;
    }

    public void setMaxData(String maxData) {
        this.maxData = maxData;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getStores() {
        return stores;
    }

    public void setStores(String stores) {
        this.stores = stores;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(Integer maxNum) {
        this.maxNum = maxNum;
    }

    public String getLinkNo() {
        return linkNo;
    }

    public void setLinkNo(String linkNo) {
        this.linkNo = linkNo;
    }
}
