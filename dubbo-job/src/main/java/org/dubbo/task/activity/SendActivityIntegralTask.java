package org.dubbo.task.activity;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.dubbo.api.service.UserIntegralService;
import org.dubbo.configs.BeanContext;
import org.dubbo.pojo.dto.activity.SendIntergralDto;
import org.dubbo.pojo.redis.RedisUtil;
import org.dubbo.pojo.utils.CommonRedisKey;
import org.dubbo.pojo.utils.FileUtils;
import org.dubbo.pojo.utils.PropertyUtils;
import org.springframework.context.ApplicationContext;

/**
 * Created by jiangbin on 2018/1/11.
 */
public class SendActivityIntegralTask implements Runnable {

    private static final Logger logger = Logger.getLogger(SendActivityIntegralTask.class);


    private String threadName = "SendActivityIntegralTask";
    private boolean isActive = true;

    public SendActivityIntegralTask(String threadName) {
        this.threadName = threadName;
    }


    @Override
    public void run() {
        logger.info("发送积分[" + threadName + "] 启动 ...");
        try {
            ApplicationContext beanContext = BeanContext.getApplicationContext();
            UserIntegralService userIntegralService = beanContext.getBean(UserIntegralService.class);
            RedisUtil redisUtil = beanContext.getBean(RedisUtil.class);
            while (isActive) {
                if (doExceptionJob(userIntegralService,redisUtil)) {// 将之前的异常处理
                    clearMessageFromLocal(); // 清空临时文件
                } else {

                    continue;
                }
                if (doJob(userIntegralService, redisUtil)) {
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
    private boolean doExceptionJob(UserIntegralService userIntegralService,RedisUtil redisUtil) {
        logger.debug("当前正在进行积分异常恢复处理");
        boolean result = false;
        String json = readMessageFromLocalFile(); // 获取临时文件里的要处理数据
        SendIntergralDto sendIntergralDto = JSON.parseObject(json, SendIntergralDto.class);
        try{
            if (!StringUtils.isEmpty(json)) {
                result = userIntegralService.insertSendError(sendIntergralDto);
            }else {
                result=true;
            }
        } catch (Exception e) {
            logger.error("", e);
            result = false;
        }

        logger.debug("当前正在进行积分异常恢复处理完成");
        return result;
    }

    /**
     * 正常处理数据
     */
    private boolean doJob(UserIntegralService userIntegralService, RedisUtil redisUtil) {
        logger.debug("当前正在进行积分正常处理");
        boolean result = false;
        try {
            SendIntergralDto sendIntergralDto = (SendIntergralDto) redisUtil.lpop(CommonRedisKey.userInfo.INTEGRAL_LIST_KEY);
            if (null != sendIntergralDto) {
                saveMessageToLocalFile(JSON.toJSONString(sendIntergralDto));
                result = userIntegralService.handRealIntegral(sendIntergralDto);
            } else {
                Thread.sleep(5000);
            }

        } catch (Exception e) {
            logger.error("", e);
            result = false;
        }
        logger.debug("当前正在进行积分正常处理完成");
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
