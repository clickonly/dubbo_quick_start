package org.dubbo.api.activity.check;

import org.apache.log4j.Logger;
import org.dubbo.pojo.base.PageResponse;
import org.dubbo.pojo.dto.activity.ActivityCheckJson;
import org.dubbo.pojo.enums.ActivityCheckResult;


public class ActivityCardLevelChecker extends Checker {

    Logger logger = Logger.getLogger(ActivityCardLevelChecker.class);

    public ActivityCardLevelChecker(Checker nextChecker, boolean isOpen){
        super(nextChecker,isOpen);
    }

    @Override
    public ActivityCheckResult doCheck(ActivityCheckJson activityCheckJson) {
        String[] ids = activityCheckJson.getCardLevel().split(",");
        boolean result = false;
        for(String id : ids){
            if(activityCheckJson.getActivityCheckUserData().getUserCardLevelId().equals(id)){
                result = true;
                break;
            }
        }
        if(result){
            return ActivityCheckResult.SUCCESS;
        }else {
            return ActivityCheckResult.USER_LEVEL_NOT_ENOUGH;
        }
    }


}
