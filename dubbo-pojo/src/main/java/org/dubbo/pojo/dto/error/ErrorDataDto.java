package org.dubbo.pojo.dto.error;

import java.io.Serializable;

/**
 * Created by fanglei on 2018/5/17.
 */
public class ErrorDataDto implements Serializable {

    private Integer sumNum ;//扣积分次数
    private Integer activityId;
    private String unionid;
    private String openid;

    public Integer getSumNum() {
        return sumNum;
    }

    public void setSumNum(Integer sumNum) {
        this.sumNum = sumNum;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
}
