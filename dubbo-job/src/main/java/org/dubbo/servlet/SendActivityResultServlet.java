package org.dubbo.servlet;

import org.dubbo.pojo.utils.PropertyUtils;
import org.dubbo.task.activity.SendActivityResultTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * Created by jiangbin on 2018/1/11.
 */
public class SendActivityResultServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(SendActivityResultServlet.class);

    private static final long serialVersionUID = 1L;

    public void init() throws ServletException {
        int count= Integer.valueOf(PropertyUtils.getProperty("SendActivityResultTask_count"));
        Thread t=null;
        SendActivityResultTask thThread=null;
        for (int i=0;i<count;i++){
            //新开一个计划批次执行的消费者
            thThread=new SendActivityResultTask("SendActivityResult"+"_"+i);
            t = new Thread(thThread);
            t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                public void uncaughtException(Thread t, Throwable e) {
                    logger.error(t.getName()+" 【线程执行异常】:",e);
                }
            });
            t.start();
        }


    }


}
