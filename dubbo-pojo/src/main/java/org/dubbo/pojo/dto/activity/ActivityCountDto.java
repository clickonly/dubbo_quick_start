package org.dubbo.pojo.dto.activity;

import java.io.Serializable;
import java.util.List;

/**
 * 活动参与人数实体
 */
public class ActivityCountDto implements Serializable {

    private Long activityId;
    private Integer count; //当前活动参与人数
    private Integer activityUnionidCount;//当前unionid参与当前活动的次数
    private Integer activityOpenIdCount; //当前openid参与当前活动的次数

    //子活动参与次数
    private List<ActivityCountDto> activityCountDtoList;

    public List<ActivityCountDto> getActivityCountDtoList() {
        return activityCountDtoList;
    }

    public void setActivityCountDtoList(List<ActivityCountDto> activityCountDtoList) {
        this.activityCountDtoList = activityCountDtoList;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getActivityUnionidCount() {
        return activityUnionidCount;
    }

    public void setActivityUnionidCount(Integer activityUnionidCount) {
        this.activityUnionidCount = activityUnionidCount;
    }


    public Integer getActivityOpenIdCount() {
        return activityOpenIdCount;
    }

    public void setActivityOpenIdCount(Integer activityOpenIdCount) {
        this.activityOpenIdCount = activityOpenIdCount;
    }
}
