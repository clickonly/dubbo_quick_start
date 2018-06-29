package org.dubbo.task.logistic;

import org.springframework.stereotype.Component;

/**
 * Created by fanglei on 2018/4/25.
 */

@Component
public class LogisticTask {

   /** private static final Logger logger = Logger.getLogger(LogisticTask.class);

    @Autowired
    private LogisticService logisticService;


    //@Scheduled(cron="0/10 * *  * * ? ")
   // @Scheduled(cron="0 45 23 * * ?")   //每天23点执行
    public void synchronizationLogistic(){
        logger.info("into LogisticTask synchronizationLogistic >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        logisticService.synchronizationLogistic();
    }**/
}
