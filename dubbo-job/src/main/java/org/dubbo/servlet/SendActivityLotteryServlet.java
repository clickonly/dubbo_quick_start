package org.dubbo.servlet;

import org.dubbo.pojo.utils.PropertyUtils;
import org.dubbo.task.activity.SendActivityLotteryTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * Created by fanglei on 2018/5/16.
 */
public class SendActivityLotteryServlet extends HttpServlet {


    private static final Logger logger = LoggerFactory.getLogger(SendActivityLotteryServlet.class);

    private static final long serialVersionUID = 1L;

    public void init() throws ServletException {
        int count = Integer.valueOf(PropertyUtils.getProperty("SendActivityLotteryServlet_Count"));
        Thread t = null;
        SendActivityLotteryTask thThread = null;
        for (int i = 0; i < count; i++) {
            //新开一个计划批次执行的消费者
            thThread = new SendActivityLotteryTask("SendActivityLotteryTask" + "_" + i);
            t = new Thread(thThread);
            t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                public void uncaughtException(Thread t, Throwable e) {
                    logger.error(t.getName() + " 【线程执行异常】:", e);
                }
            });
            t.start();
        }

    }
}
