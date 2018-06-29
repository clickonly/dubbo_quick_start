package org.dubbo.pojo.bean.activity;

import java.io.Serializable;
import java.util.Date;

public class ActivityParticipation implements Serializable {
    private Integer id;

    private Short activityId;

    private String openid;

    private String unionid;

    private String weid;

    private Date addTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getActivityId() {
        return activityId;
    }

    public void setActivityId(Short activityId) {
        this.activityId = activityId;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid == null ? null : unionid.trim();
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
}