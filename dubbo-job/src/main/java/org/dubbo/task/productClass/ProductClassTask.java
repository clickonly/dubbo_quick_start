package org.dubbo.task.productClass;

import org.apache.log4j.Logger;
import org.dubbo.api.service.GoodsClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by jiangbin on 2017/12/21.
 * 同步产品分类定时任务
 */

@Component
public class ProductClassTask {

    private static final Logger logger = Logger.getLogger(ProductClassTask.class);

    @Autowired
    private GoodsClassService goodsClassService;

  @Scheduled(cron="0 0 23 * * ?")   //每天23点执行
 //  @Scheduled(cron="0/5 * *  * * ? ")   //每5秒执行一次
   public void synchronizationProductClass(){
        logger.info("into ProductClassTask synchronizationProductClass >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        goodsClassService.synchronizationProductClass();
    }
}
