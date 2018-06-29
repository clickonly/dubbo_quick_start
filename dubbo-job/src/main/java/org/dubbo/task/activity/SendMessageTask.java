package org.dubbo.task.activity;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.dubbo.api.service.MessageService;
import org.dubbo.configs.BeanContext;
import org.dubbo.pojo.dto.wx.SendVouCouponMessageDto;
import org.dubbo.pojo.redis.RedisUtil;
import org.dubbo.pojo.utils.CommonRedisKey;
import org.dubbo.pojo.utils.FileUtils;
import org.dubbo.pojo.utils.PropertyUtils;
import org.springframework.context.ApplicationContext;

/**
 * Created by jiangbin on 2018/1/11.
 */
public class SendMessageTask implements Runnable {
    private static final Logger logger =Logger.getLogger(SendMessageTask.class);


    private static final String REDIS_KEY = CommonRedisKey.acticity.MESSAGE_LIST;

    private String threadName = "SendMessageTask";
    private boolean isActive = true;

    public SendMessageTask(String threadName) {
        this.threadName = threadName;
    }


    @Override
    public void run() {
        logger.info("发送消息[" + threadName + "] 启动 ...");
        try {
            ApplicationContext beanContext = BeanContext.getApplicationContext();
            MessageService messageService = beanContext.getBean(MessageService.class);
            RedisUtil redisUtil = beanContext.getBean(RedisUtil.class);
            while (isActive) {
                if (doExceptionJob(messageService)) {// 将之前的异常处理
                    clearMessageFromLocal(); // 清空临时文件
                } else {
                    continue;
                }
                if (doJob(messageService, redisUtil)) {
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
     * 先进行发送消息异常处理
     */
    private boolean doExceptionJob(MessageService messageService) {
        logger.debug("当前正在进行发送消息异常恢复处理");
        boolean result = true;
        try {
            String json = readMessageFromLocalFile(); // 获取临时文件里的要处理数据
            if (!StringUtils.isEmpty(json)) {
                result = messageService.sendMessage(JSON.parseObject(json, SendVouCouponMessageDto.class));
            }else {
                result=true;
            }
        }catch (Exception e) {
            logger.error("", e);
            result = false;
        }
        logger.debug("当前正在进行发送消息异常恢复处理完成");
        return result;
    }

    /**
     * 正常处理数据
     */
    private boolean doJob(MessageService messageService, RedisUtil redisUtil) {
        logger.debug("当前正在进行发送消息正常处理");
        boolean result = false;
        try {
            SendVouCouponMessageDto sendVouCouponMessageDto = (SendVouCouponMessageDto) redisUtil.lpop(REDIS_KEY);
            if (null!=sendVouCouponMessageDto) {
                saveMessageToLocalFile(JSON.toJSONString(sendVouCouponMessageDto));
                result = messageService.sendMessage(sendVouCouponMessageDto);
            } else {
                Thread.sleep(5000);
            }

        } catch (Exception e) {
            logger.error("", e);
            result = false;
        }

        logger.debug("当前正在进行发送消息正常处理完成");
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
