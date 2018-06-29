package org.dubbo.servlet;

import org.apache.log4j.Logger;
import org.dubbo.api.service.ActivityService;
import org.dubbo.configs.BeanContext;
import org.dubbo.pojo.bean.activity.ActivityMain;
import org.dubbo.pojo.utils.SchedulerRun;
import org.dubbo.task.activity.SaveBigRecordTask;
import org.dubbo.task.activity.SendAcitvityAuctionResultTask;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fanglei on 2018/6/7.
 */
public class ActitvityIntTaskServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(SaveBigRecordTask.class);

    private static final long serialVersionUID = 1L;

    ApplicationContext beanContext = BeanContext.getApplicationContext();

    ActivityService activityService= beanContext.getBean(ActivityService.class);

    public void init() throws ServletException {
        logger.info("into ActitvityIntTaskServlet intt ");
        //获取当前所有活动
        List<ActivityMain> activityMainList=activityService.getTaskActivityMain();
        for (ActivityMain activityMain:activityMainList){
            logger.info(">>>>>>>>创建活动>>>>>>>>>>>>>>>>"+activityMain.getId());
            Map<String,Object> map=new HashMap();
            map.put("activityMain",activityMain);
            SchedulerRun.addJob(activityMain.getActivityName(),
                    activityMain.getActivityName(),
                    activityMain.getActivityName(),
                    activityMain.getActivityName(),
                    SendAcitvityAuctionResultTask.class,
                    activityMain.getActivityConfigJson().getStartJobTime(),map); //创建定时任务
        }
    }

}
