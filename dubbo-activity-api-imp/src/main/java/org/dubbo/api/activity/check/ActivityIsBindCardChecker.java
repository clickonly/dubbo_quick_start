package org.dubbo.api.activity.check;

import org.apache.log4j.Logger;
import org.dubbo.pojo.dto.activity.ActivityCheckJson;
import org.dubbo.pojo.enums.ActivityCheckResult;

public class ActivityIsBindCardChecker extends Checker {

    Logger logger = Logger.getLogger(ActivityIsBindCardChecker.class);

    public ActivityIsBindCardChecker(Checker nextChecker, boolean isOpen){
        super(nextChecker,isOpen);
    }

    @Override
    public ActivityCheckResult doCheck(ActivityCheckJson activityCheckJson) {
        logger.info("ActivityIsBindCardChecker.doCheck method start" );
        if(activityCheckJson.getActivityCheckUserData().getUserInfo()!=null){
            return ActivityCheckResult.SUCCESS;
        }else {
            return ActivityCheckResult.NOT_OPEN_CARD;
        }
    }
}
