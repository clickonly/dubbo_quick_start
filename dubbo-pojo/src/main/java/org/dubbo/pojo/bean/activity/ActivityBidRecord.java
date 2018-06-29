package org.dubbo.pojo.bean.activity;

import org.dubbo.pojo.base.PageBase;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by fanglei on 2018/5/29.
 * 竞价出价记录
 */
public class ActivityBidRecord extends PageBase implements Serializable {

    private Long id;
    private Long activityId;
    private String openid;
    private String unionid;
    private String weid;
    private Long prizeId;
    private BigDecimal amount;
    private String addTime;

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getWeid() {
        return weid;
    }

    public void setWeid(String weid) {
        this.weid = weid;
    }

    public Long getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(Long prizeId) {
        this.prizeId = prizeId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
