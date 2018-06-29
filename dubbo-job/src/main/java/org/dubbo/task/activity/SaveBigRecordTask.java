package org.dubbo.task.activity;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.dubbo.api.service.ActivityBidRecordService;
import org.dubbo.configs.BeanContext;
import org.dubbo.pojo.bean.activity.ActivityBidRecord;
import org.dubbo.pojo.dto.activity.ActivityAuctionDto;
import org.dubbo.pojo.redis.RedisUtil;
import org.dubbo.pojo.utils.CommonRedisKey;
import org.dubbo.pojo.utils.FileUtils;
import org.dubbo.pojo.utils.PropertyUtils;
import org.springframework.context.ApplicationContext;

/**
 * Created by fanglei on 2018/5/29.
 */
public class SaveBigRecordTask implements Runnable {


    private static final Logger logger = Logger.getLogger(SaveBigRecordTask.class);


    private String threadName = "SaveBigRecordTask";
    private boolean isActive = true;

    public SaveBigRecordTask(String threadName) {
        this.threadName = threadName;
    }

    public String getThreadName() {
        return threadName;
    }


    @Override
    public void run() {
        try {
            ApplicationContext beanContext = BeanContext.getApplicationContext();
            ActivityBidRecordService activityBidRecordService = beanContext.getBean(ActivityBidRecordService.class);
            RedisUtil redisUtil = beanContext.getBean(RedisUtil.class);
            while (isActive) {
                if (doExceptionJob(activityBidRecordService)) {// 将之前的异常处理
                    clearMessageFromLocal(); // 清空临时文件
                } else {
                    continue;
                }
                if (doJob(activityBidRecordService, redisUtil)) {
                    clearMessageFromLocal(); // 清空临时文件
                    continue;
                } else {
                    Thread.sleep(5000);
                }
            }
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    /**
     * 先进行异常处理
     */
    private boolean doExceptionJob(ActivityBidRecordService activityBidRecordService) {
        boolean result = false;
        try {
            String json = readMessageFromLocalFile(); // 获取临时文件里的要处理数据
            if (!StringUtils.isEmpty(json)) {
                ActivityAuctionDto activityAuctionDto = JSON.parseObject(json, ActivityAuctionDto.class);
                result = activityBidRecordService.insertActivityBidRecord(activityAuctionDto);
            }else {
                result=true;
            }
        }catch (Exception e) {
            logger.error("", e);
            result = false;
        }
        return result;
    }

    /**
     * 正常处理数据
     */
    private boolean doJob(ActivityBidRecordService activityBidRecordService, RedisUtil redisUtil) {
        boolean result = false;
        try {
            ActivityAuctionDto activityAuctionDto = (ActivityAuctionDto) redisUtil.lpop(CommonRedisKey.Auction.AUCTION_OFFER_ALL_RECORD);
            if (null != activityAuctionDto) {
                saveMessageToLocalFile(JSON.toJSONString(activityAuctionDto));
                result = activityBidRecordService.insertActivityBidRecord(activityAuctionDto);
            }
        } catch (Exception e) {
            logger.error("", e);
            result = false;
        }
        return result;
    }


    /**
     * 保存消息至本地文件
     *
     * @param messageText
     */
    private void saveMessageToLocalFile(String messageText) {
        String filePath = PropertyUtils.getProperty("tmp_cache_file_save_path");
        String fileName = threadName + ".txt";
        if (FileUtils.createDir(filePath)) {
            FileUtils.writeToTxtFile(filePath, fileName, messageText);
        }
    }

    /**
     * 从本地文件中读取消息
     *
     * @return
     */
    private String readMessageFromLocalFile() {
        String filePath = PropertyUtils.getProperty("tmp_cache_file_save_path");
        String fileName = threadName + ".txt";
        String messageText = FileUtils.readFromTxtFile(filePath, fileName);
        return messageText;
    }

    /**
     * 清空本地消息文件
     */
    private void clearMessageFromLocal() {
        String filePath = PropertyUtils.getProperty("tmp_cache_file_save_path");
        String fileName = threadName + ".txt";
        FileUtils.writeToTxtFile(filePath, fileName, "");
    }
}
