package org.dubbo.api.activity.check;

import org.apache.log4j.Logger;
import org.dubbo.pojo.dto.activity.ActivityCheckJson;
import org.dubbo.pojo.enums.ActivityCheckResult;

public class ActivityAllCountChecker extends Checker {

    Logger logger = Logger.getLogger(ActivityAllCountChecker.class);

    public ActivityAllCountChecker(Checker nextChecker, boolean isOpen){
        super(nextChecker,isOpen);
    }

    @Override
    public ActivityCheckResult doCheck(ActivityCheckJson activityCheckJson) {
        logger.info("ActivityAllCountChecker.doCheck method start" );
        if(activityCheckJson.getActivityCheckUserData().getUserAllCount() < activityCheckJson.getAllCount()){
            return ActivityCheckResult.SUCCESS;
        }else {
            return ActivityCheckResult.ALL_OVER_LIMIT;
        }
    }

}
