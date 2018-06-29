package org.dubbo.api.activity.check;

import org.apache.log4j.Logger;
import org.dubbo.pojo.dto.activity.ActivityCheckJson;
import org.dubbo.pojo.enums.ActivityCheckResult;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ActivityEveryDayTimeEndChecker extends Checker {

    Logger logger = Logger.getLogger(ActivityEveryDayTimeEndChecker.class);

    public ActivityEveryDayTimeEndChecker(Checker nextChecker, boolean isOpen){
        super(nextChecker,isOpen);
    }

    @Override
    public ActivityCheckResult doCheck(ActivityCheckJson activityCheckJson) {
        logger.info("ActivityEveryDayTimeStartChecker.doCheck method start" );
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd ");
        long time = 0l;
        try {
            time = simpleDateFormat.parse(simpleDateFormat2.format(System.currentTimeMillis()) + activityCheckJson.getEveryDayEndTime()).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(System.currentTimeMillis() < time){
            return ActivityCheckResult.SUCCESS;
        }else {
            return ActivityCheckResult.TODAT_END;
        }
    }

}
