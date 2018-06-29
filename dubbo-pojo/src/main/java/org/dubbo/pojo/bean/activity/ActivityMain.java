package org.dubbo.pojo.bean.activity;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.jfinal.json.Json;
import org.dubbo.pojo.dto.activity.ActivityCheckJson;
import org.dubbo.pojo.dto.activity.ActivityConfigJson;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 活动主表
 */
public class ActivityMain implements Serializable {

    private Long id;

    private String activityName; //活动名称

    private String activityType;//活动类型 1:抽奖2:9宫格3：微信摇一摇4:兑奖5积分加油6资格池7竞价

    private String status; //活动状态 0：未开启 1：已开启

    private String checkJson; //活动配置JSON

    private Long parentId; //父ID


    private String cofigJson; //活动配置json

    private List<ActivityPrize> activityPrizes;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    private ActivityCheckJson activityCheckJson; //check配置json对应的实体

    private ActivityConfigJson activityConfigJson;


    List<ActivityMain> subactivityList; //子活动

    public List<ActivityMain> getSubactivityList() {
        return subactivityList;
    }

    public void setSubactivityList(List<ActivityMain> subactivityList) {
        this.subactivityList = subactivityList;
    }

    public String getCheckJson() {
        return checkJson;
    }

    public void setCheckJson(String checkJson) {
        this.checkJson = checkJson;
        if (!StringUtils.isEmpty(checkJson)){
            this.activityCheckJson= JSONObject.parseObject(checkJson,ActivityCheckJson.class);
        }
    }

    public String getCofigJson() {
        return cofigJson;
    }

    public void setCofigJson(String cofigJson) {
        this.cofigJson = cofigJson;
        if (!StringUtils.isEmpty(cofigJson)){
            this.activityConfigJson= JSONObject.parseObject(cofigJson,ActivityConfigJson.class);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ActivityCheckJson getActivityCheckJson() {
        return activityCheckJson;
    }

    public void setActivityCheckJson(ActivityCheckJson activityCheckJson) {
        this.activityCheckJson = activityCheckJson;
    }

    public List<ActivityPrize> getActivityPrizes() {
        return activityPrizes;
    }

    public void setActivityPrizes(List<ActivityPrize> activityPrizes) {
        this.activityPrizes = activityPrizes;
    }

    public ActivityConfigJson getActivityConfigJson() {
        return activityConfigJson;
    }

    public void setActivityConfigJson(ActivityConfigJson activityConfigJson) {
        this.activityConfigJson = activityConfigJson;
    }
}