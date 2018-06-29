package org.dubbo.api.activity.check;

import org.dubbo.pojo.dto.activity.ActivityCheckJson;
import org.dubbo.pojo.enums.ActivityCheckResult;

public abstract class Checker {

    private String checkName;
    private Checker nextChecker;
    private boolean isOpen;

    public Checker (Checker nextChecker,boolean isOpen){
        this.checkName = this.getClass().getSimpleName();
        this.nextChecker = nextChecker;
        this.isOpen = isOpen;
    }

    public ActivityCheckResult check(ActivityCheckJson activityCheckJson){
        ActivityCheckResult activityCheckResult = ActivityCheckResult.SUCCESS;
        if(isOpen){
            activityCheckResult = doCheck(activityCheckJson);
            if(!"0".equals(activityCheckResult.getCode())){
                return activityCheckResult;
            }
        }
        if(nextChecker != null){
            return nextChecker.check(activityCheckJson);
        }else {
            return activityCheckResult;
        }
    }

    public abstract ActivityCheckResult doCheck(ActivityCheckJson activityCheckJson);

}
