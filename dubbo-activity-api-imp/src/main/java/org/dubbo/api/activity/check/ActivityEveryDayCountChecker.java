package org.dubbo.api.activity.check;

import org.apache.log4j.Logger;
import org.dubbo.pojo.dto.activity.ActivityCheckJson;
import org.dubbo.pojo.enums.ActivityCheckResult;

public class ActivityEveryDayCountChecker extends Checker {

    Logger logger = Logger.getLogger(ActivityEveryDayCountChecker.class);

    public ActivityEveryDayCountChecker(Checker nextChecker, boolean isOpen){
        super(nextChecker,isOpen);
    }

    @Override
    public ActivityCheckResult doCheck(ActivityCheckJson activityCheckJson) {
        logger.info("ActivityEveryDayCountChecker.doCheck method start" );
        if(activityCheckJson.getActivityCheckUserData().getUserTodayCount()< activityCheckJson.getEveryDayCount()){
            return ActivityCheckResult.SUCCESS;
        }else {
            return ActivityCheckResult.TODAY_OVER_LIMIT;
        }
    }


}
