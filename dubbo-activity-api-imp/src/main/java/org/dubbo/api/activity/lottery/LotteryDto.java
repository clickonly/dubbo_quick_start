package org.dubbo.api.activity.lottery;

import java.util.Map;

public class LotteryDto {
    private String activityId;
    private Map<String,Integer> poolCinfigMap;

    public LotteryDto(String activityId, Map<String, Integer> poolCinfigMap) {
        this.activityId = activityId;
        this.poolCinfigMap = poolCinfigMap;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public Map<String, Integer> getPoolCinfigMap() {
        return poolCinfigMap;
    }

    public void setPoolCinfigMap(Map<String, Integer> poolCinfigMap) {
        this.poolCinfigMap = poolCinfigMap;
    }
}
