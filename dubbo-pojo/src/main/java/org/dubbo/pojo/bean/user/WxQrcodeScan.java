package org.dubbo.pojo.bean.user;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by fanglei on 2017/12/29.
 */
public class WxQrcodeScan implements Serializable {

    private Integer id;
    private Integer rendId;
    private Integer weId;
    private String openId;
    private Integer isSubScribe; //是否订阅时扫描
    private Integer qrcId;//二维码场景ID号，扫描时得到
    private Date insertDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRendId() {
        return rendId;
    }

    public void setRendId(Integer rendId) {
        this.rendId = rendId;
    }

    public Integer getWeId() {
        return weId;
    }

    public void setWeId(Integer weId) {
        this.weId = weId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Integer getIsSubScribe() {
        return isSubScribe;
    }

    public void setIsSubScribe(Integer isSubScribe) {
        this.isSubScribe = isSubScribe;
    }

    public Integer getQrcId() {
        return qrcId;
    }

    public void setQrcId(Integer qrcId) {
        this.qrcId = qrcId;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }
}
