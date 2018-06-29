package org.dubbo.task.activity;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.dubbo.api.service.CouponService;
import org.dubbo.configs.BeanContext;
import org.dubbo.pojo.dto.activity.SendVouCouponDto;
import org.dubbo.pojo.redis.RedisUtil;
import org.dubbo.pojo.utils.CommonRedisKey;
import org.dubbo.pojo.utils.FileUtils;
import org.dubbo.pojo.utils.PropertyUtils;
import org.springframework.context.ApplicationContext;

/**
 * 发送优惠券线程
 * Created by  on 2018/5/25.
 */
public class SendCoupnTask implements Runnable  {

    private static final Logger logger = Logger.getLogger(SendCoupnTask.class);

    private String threadName = "SendCoupnTask";
    private boolean isActive = true;

    public SendCoupnTask(String threadName) {
        this.threadName = threadName;
    }

    public String getThreadName() {
        return threadName;
    }

    @Override
    public void run() {
        logger.info("发送优惠券[" + threadName + "] 启动 ...");
        try {
            ApplicationContext beanContext = BeanContext.getApplicationContext();

            CouponService couponService = beanContext.getBean(CouponService.class);
            RedisUtil redisUtil = beanContext.getBean(RedisUtil.class);
            while (isActive) {
                if (doExceptionJob(couponService)) {// 将之前的异常处理
                    clearMessageFromLocal(); // 清空临时文件
                } else {
                    continue;
                }
                if (doJob(couponService, redisUtil)) {
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
    private boolean doExceptionJob(CouponService couponService) {
        logger.debug(threadName + "当前正在进行发券异常恢复处理");
        boolean result = false;
        try {
            String json = readMessageFromLocalFile(); // 获取临时文件里的要处理数据
            if (!StringUtils.isEmpty(json)) {
                SendVouCouponDto sendVouCouponDto = JSON.parseObject(json, SendVouCouponDto.class);
                result = couponService.sendVouCoupon(sendVouCouponDto);
            }else {
                result=true;
            }
        } catch (Exception e) {
            logger.error("", e);
            result = false;
        }
        logger.debug(threadName + "当前正在进行发券异常恢复处理完成");
        return result;
    }

    /**
     * 正常处理数据
     */
    private boolean doJob(CouponService couponService, RedisUtil redisUtil) {
        logger.debug(threadName + "当前正在进行发券正常处理");
        boolean result = false;
        try {
            SendVouCouponDto sendVouCouponDto = (SendVouCouponDto) redisUtil.lpop(CommonRedisKey.acticity.COUPON_KEY);
            if (null != sendVouCouponDto) {
                saveMessageToLocalFile(JSON.toJSONString(sendVouCouponDto));
                result = couponService.sendVouCoupon(sendVouCouponDto);
            } else {
                Thread.sleep(5000);
            }
        } catch (Exception e) {
            logger.error("", e);
            result = false;
        }

        logger.debug(threadName + "当前正在进行发券正常处理完成");
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
