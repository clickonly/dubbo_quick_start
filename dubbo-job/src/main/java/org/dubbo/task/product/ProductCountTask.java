package org.dubbo.task.product;

import org.apache.log4j.Logger;
import org.dubbo.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by jiangbin on 2018/1/17.
 * 定時統計產品銷量定時任務
 */
@Component
public class ProductCountTask {

    private static final Logger logger = Logger.getLogger(ProductCountTask.class);

    @Autowired
    private ProductService productService;

   @Scheduled(cron="0 30 23 * * ?")   //每天23点执行
  // @Scheduled(cron="0/10 * *  * * ? ")   //每5秒执行一次
    public void productTimingQuery(){
        logger.info("into ProductCountTask productTimingQuery >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        productService.productTimingQuery();
    }
}
