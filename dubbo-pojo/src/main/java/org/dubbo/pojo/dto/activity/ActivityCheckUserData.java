package org.dubbo.pojo.dto.activity;

import org.dubbo.pojo.bean.user.CardMain;
import org.dubbo.pojo.bean.user.UserInfo;

public class ActivityCheckUserData {

    private Integer userAllCount;

    private String userCardLevelId;

    private Integer userTodayCount;

    private Long userIntegral;

    private String userUnionId;

    private String userWeid;

    private String userIsSubscribe;

    private UserInfo userInfo;

    public Integer getUserAllCount() {
        return userAllCount;
    }

    public void setUserAllCount(Integer userAllCount) {
        this.userAllCount = userAllCount;
    }

    public String getUserCardLevelId() {
        return userCardLevelId;
    }

    public void setUserCardLevelId(String userCardLevelId) {
        this.userCardLevelId = userCardLevelId;
    }

    public Integer getUserTodayCount() {
        return userTodayCount;
    }

    public void setUserTodayCount(Integer userTodayCount) {
        this.userTodayCount = userTodayCount;
    }

    public Long getUserIntegral() {
        return userIntegral;
    }

    public void setUserIntegral(Long userIntegral) {
        if(userIntegral == null){
            userIntegral = 0L;
        }
        this.userIntegral = userIntegral;
    }

    public String getUserUnionId() {
        return userUnionId;
    }

    public void setUserUnionId(String userUnionId) {
        this.userUnionId = userUnionId;
    }

    public String getUserWeid() {
        return userWeid;
    }

    public void setUserWeid(String userWeid) {
        this.userWeid = userWeid;
    }

    public String getUserIsSubscribe() {
        return userIsSubscribe;
    }

    public void setUserIsSubscribe(String userIsSubscribe) {
        this.userIsSubscribe = userIsSubscribe;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
