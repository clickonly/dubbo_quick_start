package org.dubbo.task.activity;

import org.apache.log4j.Logger;
import org.dubbo.api.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by jiangbin on 2018/1/25.
 */
@Component
public class SendActivityErrorResultTask {

    private static final Logger logger = Logger.getLogger(SendActivityErrorResultTask.class);


    @Autowired
    private ActivityService activityService;

    @Scheduled(cron="* 0/5 * * * ? ")
    // @Scheduled(cron="0/10 * *  * * ? ")   //每5秒执行一次
    public void sendErrorResult(){
        logger.info("into SendActivityErrorResultTask sendErrorResult >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        activityService.sendErrorResult();
    }
}
