package org.dubbo.api.activity.check;

import org.apache.log4j.Logger;
import org.dubbo.pojo.dto.activity.ActivityCheckJson;
import org.dubbo.pojo.enums.ActivityCheckResult;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ActivityTimeStartChecker extends Checker {

    Logger logger = Logger.getLogger(ActivityTimeStartChecker.class);

    public ActivityTimeStartChecker(Checker nextChecker, boolean isOpen){
        super(nextChecker,isOpen);
    }

    @Override
    public ActivityCheckResult doCheck(ActivityCheckJson activityCheckJson) {
        logger.info("ActivityTimeStartChecker.doCheck method start" );
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long time = 0l;
        try {
            time = simpleDateFormat.parse(activityCheckJson.getStartTime()).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(System.currentTimeMillis() > time){
            return ActivityCheckResult.SUCCESS;
        }else {
            return ActivityCheckResult.NOT_START;
        }
    }

}
