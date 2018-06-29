package org.dubbo.pojo.bean.activity;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.math.BigDecimal;

public class ActivityPrize  implements Serializable {
    private Long id;

    private Long activityId;

    private String prizeName;

    private String prizeType; //1:积分 2：优惠券 3：现金4:图片5 实物物品 6竞价物品7虚拟物品8商品

   private String sort;
   private String json;

   private String department; //奖项描述


    //奖项配置
    private ActivityPrizeConfig activityPrizeConfig;


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

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName;
    }

    public String getPrizeType() {
        return prizeType;
    }

    public void setPrizeType(String prizeType) {
        this.prizeType = prizeType;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
        if (!StringUtils.isEmpty(json)){
            this.activityPrizeConfig=JSONObject.parseObject(json,ActivityPrizeConfig.class);
        }
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public ActivityPrizeConfig getActivityPrizeConfig() {
        return activityPrizeConfig;
    }

    public void setActivityPrizeConfig(ActivityPrizeConfig activityPrizeConfig) {
        this.activityPrizeConfig = activityPrizeConfig;
    }
}