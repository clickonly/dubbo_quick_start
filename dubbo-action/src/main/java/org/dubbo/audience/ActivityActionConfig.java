package org.dubbo.audience;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.dubbo.api.service.ActivityCheckService;
import org.dubbo.pojo.base.BaseResponse;
import org.dubbo.pojo.dto.activity.ActivityDto;
import org.dubbo.pojo.enums.ActivityCheckResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by jinpan12430 on 2018/1/22.
 */
@Aspect
@Component
public class ActivityActionConfig {

    private static final Logger logger = Logger.getLogger(ActivityActionConfig.class);

    @Autowired(required = false)
    private ActivityCheckService activityCheckService;
//
//    public void setActivityCheckService(ActivityCheckService activityCheckService) {
//        this.activityCheckService = activityCheckService;
//    }

    //    切入点
    @Pointcut("execution(* org.dubbo.action.activity.ActivityAction.*PonitCut(..))")
    public void Activity (){}

    @Around("Activity()")
    public Object aroundActivity(ProceedingJoinPoint pjp) throws Throwable {
        ActivityDto activityDto = (ActivityDto) pjp.getArgs()[0];
        ActivityCheckResult activityCheckResult = isParameterIsNull(activityDto);
        if(!"0".equals(activityCheckResult.getCode())){
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setCode(activityCheckResult.getCode());
            baseResponse.setMessage(activityCheckResult.getDesc());
            return baseResponse;
        }
        activityCheckResult = activityCheckService.activityOverCheck(activityDto);
        if(!"0".equals(activityCheckResult.getCode())){
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setCode(activityCheckResult.getCode());
            baseResponse.setMessage(activityCheckResult.getDesc());
            return baseResponse;
        }

        return pjp.proceed();
    }

    private ActivityCheckResult isParameterIsNull(ActivityDto activityDto){
        if(activityDto.getActivityId()==null){
            return ActivityCheckResult.MISS_ACTIVITY_ID;
        }else if (activityDto.getUnionId()==null){
            return ActivityCheckResult.MISS_UNIONID;
        }else if (activityDto.getWeid()==null){
            return ActivityCheckResult.MISS_WEID;
        }else if(activityDto.getOpenId()==null){
            return ActivityCheckResult.MISS_OPENID;
        }else {
            return ActivityCheckResult.SUCCESS;
        }
    }

}
