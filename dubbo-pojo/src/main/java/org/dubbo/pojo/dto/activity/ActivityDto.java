package org.dubbo.pojo.dto.activity;

import org.dubbo.pojo.base.PageBase;

import java.io.Serializable;

public class ActivityDto extends PageBase implements Serializable{

    //活动Id
    private Long activityId;

    private String openId;

    private String unionId;

    private String weid;

    private String activityType; //获得类型

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getWeid() {
        return weid;
    }

    public void setWeid(String weid) {
        this.weid = weid;
    }

    @Override
    public String toString() {
        return "ActivityDto{" +
                "activityId=" + activityId +
                ", openId='" + openId + '\'' +
                ", unionId='" + unionId + '\'' +
                '}';
    }
}
