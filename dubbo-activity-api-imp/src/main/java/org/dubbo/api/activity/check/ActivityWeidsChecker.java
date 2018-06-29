package org.dubbo.api.activity.check;

import org.apache.log4j.Logger;
import org.dubbo.pojo.dto.activity.ActivityCheckJson;
import org.dubbo.pojo.enums.ActivityCheckResult;

public class ActivityWeidsChecker extends Checker {

    Logger logger = Logger.getLogger(ActivityWeidsChecker.class);

    public ActivityWeidsChecker(Checker nextChecker, boolean isOpen){
        super(nextChecker,isOpen);
    }

    @Override
    public ActivityCheckResult doCheck(ActivityCheckJson activityCheckJson) {
        logger.info("ActivityWeidsChecker.doCheck method start" );
        String userWeid = activityCheckJson.getActivityCheckUserData().getUserWeid();
        String[] weids = activityCheckJson.getWeids().split(",");
        boolean result = false;
        for(String weid : weids){
            if(weid.equals(userWeid)){
                result = true;
                break;
            }
        }
        if(result){
            return ActivityCheckResult.SUCCESS;
        }else {
            return ActivityCheckResult.WEID_NOT_ALLOW;
        }
    }

}
