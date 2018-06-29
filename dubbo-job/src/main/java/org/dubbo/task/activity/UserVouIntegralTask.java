package org.dubbo.task.activity;

import org.apache.log4j.Logger;
import org.dubbo.api.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by jiangbin on 2018/1/26.
 * 定时刷新用户积分任务
 */

@Component
public class UserVouIntegralTask {

    private static final Logger logger = Logger.getLogger(UserVouIntegralTask.class);


    @Autowired
    private ActivityService activityService;


   // @Scheduled(cron="0/30 * *  * * ? ")   //每5秒执行一次
    public void intAddActivityUserIntegral(){
        logger.info("into UserVouIntegralTask intAddActivityUserIntegral");
       // activityService.intAddActivityUserIntegral();
    }
}
