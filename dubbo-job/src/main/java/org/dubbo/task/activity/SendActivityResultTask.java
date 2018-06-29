package org.dubbo.task.activity;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.dubbo.api.service.SendActivityResultService;
import org.dubbo.configs.BeanContext;
import org.dubbo.pojo.bean.activity.ActivityWinResult;
import org.dubbo.pojo.redis.RedisUtil;
import org.dubbo.pojo.utils.CommonRedisKey;
import org.dubbo.pojo.utils.FileUtils;
import org.dubbo.pojo.utils.PropertyUtils;
import org.springframework.context.ApplicationContext;

/**
 * Created by jiangbin on 2018/1/11.
 */
public class SendActivityResultTask implements Runnable {
    private static final Logger logger = Logger.getLogger(SendActivityResultTask.class);


    private static final String WIN_RESULT_KEY = CommonRedisKey.acticity.AWARD_LIST;

    private String threadName = "SendActivityResult";
    private boolean isActive = true;

    public SendActivityResultTask(String threadName) {
        this.threadName = threadName;
    }

    public String getThreadName() {
        return threadName;
    }

    @Override
    public void run() {
        logger.info("保存抽奖结果[" + threadName + "] 启动 ...");
        try {
            ApplicationContext beanContext = BeanContext.getApplicationContext();

            SendActivityResultService sendActivityResultService = beanContext.getBean(SendActivityResultService.class);
            RedisUtil redisUtil = beanContext.getBean(RedisUtil.class);
            while (isActive) {
                if (doExceptionJob(sendActivityResultService)) {// 将之前的异常处理
                    clearMessageFromLocal(); // 清空临时文件
                } else {
                    continue;
                }
                if (doJob(sendActivityResultService, redisUtil)) {
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
    private boolean doExceptionJob(SendActivityResultService sendActivityResultService) {
        logger.debug(threadName + "当前正在进行保存抽奖异常恢复处理");
        boolean result = false;
        try {
            String json = readMessageFromLocalFile(); // 获取临时文件里的要处理数据
            if (!StringUtils.isEmpty(json)) {
                ActivityWinResult activityWinResult = JSON.parseObject(json, ActivityWinResult.class);
                result = sendActivityResultService.sendRedisActivityWinResult(activityWinResult);
            }else {
                result=true;
            }
        }catch (Exception e) {
            logger.error("", e);
            result = false;
        }
        logger.debug(threadName + "当前正在进行保存抽奖异常恢复处理完成");
        return result;
    }

    /**
     * 正常处理数据
     */
    private boolean doJob(SendActivityResultService sendActivityResultService, RedisUtil redisUtil) {
        logger.debug(threadName + "当前正在进行保存抽奖正常处理");
        boolean result = false;
        try {
            ActivityWinResult activityWinResult = (ActivityWinResult) redisUtil.lpop(WIN_RESULT_KEY);
            if (null != activityWinResult) {
                saveMessageToLocalFile(JSON.toJSONString(activityWinResult));
                result = sendActivityResultService.sendRedisActivityWinResult(activityWinResult);
            } else {
                Thread.sleep(5000);
            }
        } catch (Exception e) {
            logger.error("", e);
            result = false;
        }

        logger.debug(threadName + "当前正在进行保存抽奖正常处理完成");
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
