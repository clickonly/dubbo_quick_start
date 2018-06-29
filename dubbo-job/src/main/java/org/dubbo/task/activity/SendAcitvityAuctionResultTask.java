package org.dubbo.task.activity;

import org.apache.log4j.Logger;
import org.dubbo.api.service.ActivityService;
import org.dubbo.api.service.SendActivityResultService;
import org.dubbo.configs.BeanContext;
import org.dubbo.pojo.bean.activity.ActivityMain;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fanglei on 2018/6/6.
 */
public class SendAcitvityAuctionResultTask implements Job {

    private static final Logger logger = Logger.getLogger(SendAcitvityAuctionResultTask.class);


    ApplicationContext beanContext = BeanContext.getApplicationContext();

    @Autowired
    SendActivityResultService sendActivityResultService=beanContext.getBean(SendActivityResultService.class);


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info(">>>>>>>>执行活动>>>>>>>>>>>>>>>>");
        Object object = jobExecutionContext.getJobDetail().getJobDataMap().get("parms");
        if (null!=object){
            Map<String,Object> map=(Map<String, Object>) object;
            ActivityMain activityMain=(ActivityMain)map.get("activityMain");
            sendActivityResultService.handAuctionResult(activityMain);
        }
    }
}
