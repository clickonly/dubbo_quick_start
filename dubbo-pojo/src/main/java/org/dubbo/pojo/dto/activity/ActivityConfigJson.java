package org.dubbo.pojo.dto.activity;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 活动配置表
 * Created by fanglei on 2018/5/25.
 */
public class ActivityConfigJson  implements Serializable {

    private String isInitialization;
    private String isSend;//是否发送模板消息
    private String isContainSubactivity; //是否包含子活动
    private String rule;//活动规则
    private String activityPrizeClass; //抽奖类型 1：奖池 2：中奖率
    private String isDeductionIntegralOpen;
    private Long deductionIntegral; // 活动参与扣除积分
    private Map<String,Object> wxMessageTemplate; //微信模板消息ID weid#模板消息,weid#模板消息
    private String startJobTime; //定时任务启动时间 [秒] [分] [小时] [日] [月] [周] [年] 50 30 14 06 18 ? "startJobTime":""

    public String getStartJobTime() {
        return startJobTime;
    }

    public void setStartJobTime(String startJobTime) {
        this.startJobTime = startJobTime;
    }

    public Map<String, Object> getWxMessageTemplate() {
        return wxMessageTemplate;
    }

    public void setWxMessageTemplate(Map<String, Object> wxMessageTemplate) {
        this.wxMessageTemplate = wxMessageTemplate;
    }



    public String getIsInitialization() {
        return isInitialization;
    }

    public void setIsInitialization(String isInitialization) {
        this.isInitialization = isInitialization;
    }

    public String getIsSend() {
        return isSend;
    }

    public void setIsSend(String isSend) {
        this.isSend = isSend;
    }

    public String getIsContainSubactivity() {
        return isContainSubactivity;
    }

    public void setIsContainSubactivity(String isContainSubactivity) {
        this.isContainSubactivity = isContainSubactivity;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getActivityPrizeClass() {
        return activityPrizeClass;
    }

    public void setActivityPrizeClass(String activityPrizeClass) {
        this.activityPrizeClass = activityPrizeClass;
    }

    public String getIsDeductionIntegralOpen() {
        return isDeductionIntegralOpen;
    }

    public void setIsDeductionIntegralOpen(String isDeductionIntegralOpen) {
        this.isDeductionIntegralOpen = isDeductionIntegralOpen;
    }

    public Long getDeductionIntegral() {
        return deductionIntegral;
    }

    public void setDeductionIntegral(Long deductionIntegral) {
        this.deductionIntegral = deductionIntegral;
    }

    public static void main(String args[]) {
        ActivityConfigJson activityConfigJson=new ActivityConfigJson();
        Map<String,Object> wxMessageTemplate =new HashMap<>();
        wxMessageTemplate.put("2738574294",43);
        activityConfigJson.setWxMessageTemplate(wxMessageTemplate);
        activityConfigJson.setActivityPrizeClass("1");
        activityConfigJson.setIsSend("1");
        activityConfigJson.setDeductionIntegral(100L);
        System.out.print(JSON.toJSON(activityConfigJson));
    }
}
