package org.dubbo.api.activity.check;

import org.apache.log4j.Logger;
import org.dubbo.pojo.dto.activity.ActivityCheckJson;
import org.dubbo.pojo.enums.ActivityCheckResult;

public class ActivityUnionIdsChecker extends Checker {

    Logger logger = Logger.getLogger(ActivityUnionIdsChecker.class);

    public ActivityUnionIdsChecker(Checker nextChecker, boolean isOpen){
        super(nextChecker,isOpen);
    }

    @Override
    public ActivityCheckResult doCheck(ActivityCheckJson activityCheckJson) {
        logger.info("ActivityUnionIdsChecker.doCheck method start" );
        String userUnionId = activityCheckJson.getActivityCheckUserData().getUserUnionId();
        String[] unionIds = activityCheckJson.getUnionids().split(",");
        boolean result = false;
        for(String unionid : unionIds){
            if(unionid.equals(userUnionId)){
                result = true;
                break;
            }
        }
        if(result){
            return ActivityCheckResult.SUCCESS;
        }else {
            return ActivityCheckResult.NOT_ALLOW;
        }
    }

}
