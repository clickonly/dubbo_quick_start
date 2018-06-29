package org.dubbo.pojo.bean.activity;

import java.io.Serializable;
import java.util.Date;

public class ActivityWinResult implements Serializable {
    private Long id;

    private Long activityId;

    private String unionid;

    private String openid;

    private String weid;

    private Date addTime;

    private Long prizeId;

    private String status;

    private Long winTime; //抽奖时间

    private String activationCode; //兑换码

    private String colourName;

    private String sizeName;

    public String getColourName() {
        return colourName;
    }

    public void setColourName(String colourName) {
        this.colourName = colourName;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    private Integer sendIntegralStatus;//发送积分状态  0 不需要扣除积分 1已发送 -1 发送失败
    private Integer sendWinStatus;//发奖结果状态 0发送成 -1 失败

    private Long integral; //扣除积分

    public Long getIntegral() {
        return integral;
    }

    public void setIntegral(Long integral) {
        this.integral = integral;
    }

    public Integer getSendIntegralStatus() {
        return sendIntegralStatus;
    }

    public void setSendIntegralStatus(Integer sendIntegralStatus) {
        this.sendIntegralStatus = sendIntegralStatus;
    }

    public Integer getSendWinStatus() {
        return sendWinStatus;
    }

    public void setSendWinStatus(Integer sendWinStatus) {
        this.sendWinStatus = sendWinStatus;
    }

    public Long getWinTime() {
        return winTime;
    }

    public void setWinTime(Long winTime) {
        this.winTime = winTime;
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

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid == null ? null : unionid.trim();
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getWeid() {
        return weid;
    }

    public void setWeid(String weid) {
        this.weid = weid == null ? null : weid.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Long getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(Long prizeId) {
        this.prizeId = prizeId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }
}