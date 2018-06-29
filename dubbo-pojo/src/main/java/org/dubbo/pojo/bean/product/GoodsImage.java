package org.dubbo.pojo.bean.product;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by fanglei on 2017/11/15.
 */
public class GoodsImage implements Serializable {

    private Integer rentId;

    private Integer weId;

    private String code;

    private String imgType;//1:列表中图,2:详情页大图,3:详情页颜色图,4:其他列表页图

    private String colorCode;

    private String imgUrl;

    private Integer orderIndex;
    private String status;
    private Date inputDate;
    private String no;
    private Integer id;

    public Integer getRentId() {
        return rentId;
    }

    public void setRentId(Integer rentId) {
        this.rentId = rentId;
    }

    public Integer getWeId() {
        return weId;
    }

    public void setWeId(Integer weId) {
        this.weId = weId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImgType() {
        return imgType;
    }

    public void setImgType(String imgType) {
        this.imgType = imgType;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
