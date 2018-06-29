package org.dubbo.api.activity.check;

import org.apache.log4j.Logger;
import org.dubbo.pojo.dto.activity.ActivityCheckJson;
import org.dubbo.pojo.enums.ActivityCheckResult;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ActivityIntegralChecker extends Checker {

    Logger logger = Logger.getLogger(ActivityIntegralChecker.class);

    public ActivityIntegralChecker(Checker nextChecker, boolean isOpen){
        super(nextChecker,isOpen);
    }

    @Override
    public ActivityCheckResult doCheck(ActivityCheckJson activityCheckJson) {
        logger.info("ActivityIntegralChecker.doCheck method start" );
        if(activityCheckJson.getActivityCheckUserData().getUserIntegral() > activityCheckJson.getIntegral()){
            return ActivityCheckResult.SUCCESS;
        }else {
            return ActivityCheckResult.NOT_ENOUGH_INTEGRAL;
        }
    }

}
