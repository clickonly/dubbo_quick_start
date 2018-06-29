package org.dubbo.pojo.dto.activity;

import java.io.Serializable;

/**
 * 活動參與驗證json
 */
public class ActivityCheckJson implements Serializable {

    //用户数据
    private ActivityCheckUserData activityCheckUserData;

    private String isStartTimeOpen;//活動開始時間校验是否开启
    private String startTime; //活動開始時間

    private String isEndTimeOpen;//活動結束時間校验是否开启
    private String endTime; //活動結束時間

    private String isAllCountOpen;//活動總參與次數校验是否开启
    private Integer allCount; //活動總參與次數

    private String isCardLevelOpen;//是否属于哪个卡等级校验是否开启
    private String cardLevel;//卡等級 多個等級,相隔

    private String isIntegralOpen;//活动参与积分门槛校验是否开启
    private Integer integral ;//活动参与积分门槛

    private String isUnionidsOpen;//活動指定人員unionid校验是否开启
    private String unionids;//活動指定人員unionid 多個,相隔

    private String isWeidsOpen;//活动参与品牌限制是否开启
    private String weids;//活动参与品牌 多个,分割

    private String isEveryDayCountOpen;//活動每天參次數校验是否开启
    private Integer everyDayCount; //活動每天參次數

    private String isEveryDayStartTimeOpen;//每天活動開始時間是否开启
    private String everyDayStartTime;//每天活動開始時間

    private String isEveryDayEndTimeOpen;//每天活動結束時間是否开启
    private String everyDayEndTime;//每天活動結束時間

    private String isSubscribeOpen;//是否关注开关
    private String isSubscribe;//是否关注

    private String isBindCardOpen;//是否绑卡开关
    private String isBindCard;//是否绑卡

    public String getIsSubscribeOpen() {
        return isSubscribeOpen;
    }

    public void setIsSubscribeOpen(String isSubscribeOpen) {
        this.isSubscribeOpen = isSubscribeOpen;
    }

    public String getIsSubscribe() {
        return isSubscribe;
    }

    public void setIsSubscribe(String isSubscribe) {
        this.isSubscribe = isSubscribe;
    }

    public String getIsBindCardOpen() {
        return isBindCardOpen;
    }

    public void setIsBindCardOpen(String isBindCardOpen) {
        this.isBindCardOpen = isBindCardOpen;
    }

    public String getIsBindCard() {
        return isBindCard;
    }

    public void setIsBindCard(String isBindCard) {
        this.isBindCard = isBindCard;
    }

    public String getIsStartTimeOpen() {
        return isStartTimeOpen;
    }

    public void setIsStartTimeOpen(String isStartTimeOpen) {
        this.isStartTimeOpen = isStartTimeOpen;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getIsEndTimeOpen() {
        return isEndTimeOpen;
    }

    public void setIsEndTimeOpen(String isEndTimeOpen) {
        this.isEndTimeOpen = isEndTimeOpen;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getIsAllCountOpen() {
        return isAllCountOpen;
    }

    public void setIsAllCountOpen(String isAllCountOpen) {
        this.isAllCountOpen = isAllCountOpen;
    }

    public Integer getAllCount() {
        return allCount;
    }

    public void setAllCount(Integer allCount) {
        this.allCount = allCount;
    }

    public String getIsCardLevelOpen() {
        return isCardLevelOpen;
    }

    public void setIsCardLevelOpen(String isCardLevelOpen) {
        this.isCardLevelOpen = isCardLevelOpen;
    }

    public String getCardLevel() {
        return cardLevel;
    }

    public void setCardLevel(String cardLevel) {
        this.cardLevel = cardLevel;
    }

    public String getIsIntegralOpen() {
        return isIntegralOpen;
    }

    public void setIsIntegralOpen(String isIntegralOpen) {
        this.isIntegralOpen = isIntegralOpen;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public String getIsUnionidsOpen() {
        return isUnionidsOpen;
    }

    public void setIsUnionidsOpen(String isUnionidsOpen) {
        this.isUnionidsOpen = isUnionidsOpen;
    }

    public String getUnionids() {
        return unionids;
    }

    public void setUnionids(String unionids) {
        this.unionids = unionids;
    }

    public String getIsWeidsOpen() {
        return isWeidsOpen;
    }

    public void setIsWeidsOpen(String isWeidsOpen) {
        this.isWeidsOpen = isWeidsOpen;
    }

    public String getWeids() {
        return weids;
    }

    public void setWeids(String weids) {
        this.weids = weids;
    }

    public String getIsEveryDayCountOpen() {
        return isEveryDayCountOpen;
    }

    public void setIsEveryDayCountOpen(String isEveryDayCountOpen) {
        this.isEveryDayCountOpen = isEveryDayCountOpen;
    }

    public Integer getEveryDayCount() {
        return everyDayCount;
    }

    public void setEveryDayCount(Integer everyDayCount) {
        this.everyDayCount = everyDayCount;
    }

    public String getIsEveryDayStartTimeOpen() {
        return isEveryDayStartTimeOpen;
    }

    public void setIsEveryDayStartTimeOpen(String isEveryDayStartTimeOpen) {
        this.isEveryDayStartTimeOpen = isEveryDayStartTimeOpen;
    }

    public String getEveryDayStartTime() {
        return everyDayStartTime;
    }

    public void setEveryDayStartTime(String everyDayStartTime) {
        this.everyDayStartTime = everyDayStartTime;
    }

    public String getIsEveryDayEndTimeOpen() {
        return isEveryDayEndTimeOpen;
    }

    public void setIsEveryDayEndTimeOpen(String isEveryDayEndTimeOpen) {
        this.isEveryDayEndTimeOpen = isEveryDayEndTimeOpen;
    }

    public String getEveryDayEndTime() {
        return everyDayEndTime;
    }

    public void setEveryDayEndTime(String everyDayEndTime) {
        this.everyDayEndTime = everyDayEndTime;
    }

    public ActivityCheckUserData getActivityCheckUserData() {
        return activityCheckUserData;
    }

    public void setActivityCheckUserData(ActivityCheckUserData activityCheckUserData) {
        this.activityCheckUserData = activityCheckUserData;
    }

    public static ActivityCheckJson getActivityCheckJsonTestData(){
        ActivityCheckJson activityCheckJson = new ActivityCheckJson();
        activityCheckJson.setIsStartTimeOpen("1");
        activityCheckJson.setStartTime("2018-05-25 13:00:00");
        activityCheckJson.setIsEndTimeOpen("1");
        activityCheckJson.setEndTime(("2018-06-25 11:00:00"));
        activityCheckJson.setIsEveryDayStartTimeOpen("1");
        activityCheckJson.setEveryDayStartTime("12:00:00");
        activityCheckJson.setIsEveryDayEndTimeOpen("1");
        activityCheckJson.setEveryDayEndTime("22:00:00");
        activityCheckJson.setIsAllCountOpen("10");
        activityCheckJson.setAllCount(1);
        activityCheckJson.setIsEveryDayCountOpen("1");
        activityCheckJson.setEveryDayCount(10);
        activityCheckJson.setIsCardLevelOpen("0");
        activityCheckJson.setCardLevel("6");
        activityCheckJson.setIsIntegralOpen("1");
        activityCheckJson.setIntegral(50);
        activityCheckJson.setIsUnionidsOpen("1");
        activityCheckJson.setUnionids("oZpUxszZf7QtJwujYcq0hB5CjofU");
        activityCheckJson.setIsWeidsOpen("1");
        activityCheckJson.setWeids("2738574294");
        ActivityCheckUserData activityCheckUserData = new ActivityCheckUserData();
        activityCheckUserData.setUserAllCount(10);
        activityCheckUserData.setUserCardLevelId("1");
        activityCheckUserData.setUserUnionId("oZpUxszZf7QtJwujYcq0hB5CjofU");
        activityCheckUserData.setUserWeid("2738574294");
        activityCheckUserData.setUserTodayCount(1);
        activityCheckUserData.setUserIntegral(149L);
        activityCheckJson.setActivityCheckUserData(activityCheckUserData);
        return activityCheckJson;
    }

}
