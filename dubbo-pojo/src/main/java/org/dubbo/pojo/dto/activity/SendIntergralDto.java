package org.dubbo.pojo.dto.activity;

import java.io.Serializable;

/**
 * Created by jiangbin on 2018/1/5.
 * 发送积分使用dto
 *
 */
public class SendIntergralDto implements Serializable {

    private String openid;

    private String unionid;

    private Long integral;

    private Long activityId;

    private Long addTime; //抽奖时间

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

    public Long getIntegral() {
        return integral;
    }

    public void setIntegral(Long integral) {
        this.integral = integral;
    }

    public Long getAddTime() {
        return addTime;
    }

    public void setAddTime(Long addTime) {
        this.addTime = addTime;
    }
}
