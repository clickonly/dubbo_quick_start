package org.dubbo.api.activity.check;

import org.apache.log4j.Logger;
import org.dubbo.pojo.dto.activity.ActivityCheckJson;
import org.dubbo.pojo.enums.ActivityCheckResult;

public class ActivityIsSubscribeChecker extends Checker {

    Logger logger = Logger.getLogger(ActivityIsSubscribeChecker.class);

    public ActivityIsSubscribeChecker(Checker nextChecker, boolean isOpen){
        super(nextChecker,isOpen);
    }

    @Override
    public ActivityCheckResult doCheck(ActivityCheckJson activityCheckJson) {
        logger.info("ActivityIsSubscribeChecker.doCheck method start" );
        if("1".equals(activityCheckJson.getActivityCheckUserData().getUserIsSubscribe())){
            return ActivityCheckResult.SUCCESS;
        }else {
            return ActivityCheckResult.NOT_FOLLOW;
        }
    }

}
