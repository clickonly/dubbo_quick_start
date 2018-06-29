package org.dubbo.pojo.dto.activity;

import java.io.Serializable;

/**
 * Created by jiangbin on 2018/1/9.
 */
public class SendVouCouponDto implements Serializable {

    private String openid;

    private String unionid;

    private Long activityId;

    private Long addTime; //抽奖时间

    private String couponId;

    private String  dementpart;

    private String weid;

    private Long prizeId;

    public Long getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(Long prizeId) {
        this.prizeId = prizeId;
    }

    public String getWeid() {
        return weid;
    }

    public void setWeid(String weid) {
        this.weid = weid;
    }

    public String getDementpart() {
        return dementpart;
    }

    public void setDementpart(String dementpart) {
        this.dementpart = dementpart;
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

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Long getAddTime() {
        return addTime;
    }

    public void setAddTime(Long addTime) {
        this.addTime = addTime;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }
}
