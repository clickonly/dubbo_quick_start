package org.dubbo.api.activity.check;

import org.dubbo.pojo.dto.activity.ActivityCheckJson;
import org.dubbo.pojo.enums.ActivityCheckResult;
import org.junit.Test;
import org.springframework.stereotype.Component;

@Component
public class CheckProxy {


    /**
     * 初始化并调用校验链
     * @param activityCheckJson
     * @return
     */
    public ActivityCheckResult check(ActivityCheckJson activityCheckJson){
        Checker activityIsSubscribeChecker,activityIsBindCardChecker,timeStarterCheck,timeEndChecker,everyTimeStartChecker,everyTimeEndChecker,
                allCountChecker,everyDayCountChecker,integralChecker,weidsChecker,
                cardLevelChecker,unionIdsChecker;
        unionIdsChecker = new ActivityUnionIdsChecker(null,"1".equals(activityCheckJson.getIsUnionidsOpen()));
        cardLevelChecker = new ActivityCardLevelChecker(unionIdsChecker,"1".equals(activityCheckJson.getIsCardLevelOpen()));
        weidsChecker =  new ActivityWeidsChecker(cardLevelChecker,"1".equals(activityCheckJson.getIsWeidsOpen()));
        integralChecker = new ActivityIntegralChecker(weidsChecker,"1".equals(activityCheckJson.getIsIntegralOpen()));
        everyDayCountChecker = new ActivityEveryDayCountChecker(integralChecker,"1".equals(activityCheckJson.getIsEveryDayCountOpen()));
        allCountChecker = new ActivityAllCountChecker(everyDayCountChecker,"1".equals(activityCheckJson.getIsAllCountOpen()));
        everyTimeEndChecker = new ActivityEveryDayTimeEndChecker(allCountChecker,"1".equals(activityCheckJson.getIsEveryDayEndTimeOpen()));
        everyTimeStartChecker = new ActivityEveryDayTimeStartChecker(everyTimeEndChecker,"1".equals(activityCheckJson.getIsEveryDayStartTimeOpen()));
        timeEndChecker = new ActivityTimeEndChecker(everyTimeStartChecker,"1".equals(activityCheckJson.getIsEndTimeOpen()));
        timeStarterCheck = new ActivityTimeStartChecker(timeEndChecker,"1".equals(activityCheckJson.getIsStartTimeOpen()));
        activityIsBindCardChecker = new ActivityIsBindCardChecker(timeStarterCheck,"1".equals(activityCheckJson.getIsBindCardOpen()));
        activityIsSubscribeChecker = new ActivityIsSubscribeChecker(activityIsBindCardChecker,"1".equals(activityCheckJson.getIsSubscribeOpen()));
        return activityIsSubscribeChecker.check(activityCheckJson);
    }

    /**
     * 校验链参数处理
     */

    @Test
    public void test(){
        ActivityCheckJson activityCheckJson = ActivityCheckJson.getActivityCheckJsonTestData();
        long l = System.currentTimeMillis();
        ActivityCheckResult check = check(activityCheckJson);
        System.out.println(System.currentTimeMillis() - l);
        System.out.println(check.getCode());
        System.out.println(check.getDesc());
    }

}
