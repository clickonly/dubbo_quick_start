package org.dubbo.servlet;

import org.dubbo.pojo.utils.PropertyUtils;
import org.dubbo.task.activity.SendActivityIntegralTask;
import org.dubbo.task.activity.SendCoupnTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * Created by fanglei on 2018/5/25.
 */
public class SendCoupnServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(SendIntegralServlet.class);

    private static final long serialVersionUID = 1L;

    public void init() throws ServletException {
        int count= Integer.valueOf(PropertyUtils.getProperty("SendCoupn_count"));
        Thread t = null;
        SendCoupnTask thThread=null;
        //新开一个计划批次执行的消费者
        for (int i=0;i<count;i++) {
            thThread = new SendCoupnTask("SendCoupnTask"+"_"+i);
            t = new Thread(thThread);
            t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                public void uncaughtException(Thread t, Throwable e) {
                    logger.error(t.getName()+" 【线程执行异常】:", e);
                }
            });
            t.start();
        }
    }
}
