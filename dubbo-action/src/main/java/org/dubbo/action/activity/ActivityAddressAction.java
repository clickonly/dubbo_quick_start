package org.dubbo.action.activity;

import org.apache.log4j.Logger;
import org.dubbo.api.service.ActivityService;
import org.dubbo.api.service.SendActivityResultService;
import org.dubbo.pojo.base.BaseResponse;
import org.dubbo.pojo.bean.activity.ActivityAddress;
import org.dubbo.pojo.bean.activity.ActivityWinResult;
import org.dubbo.pojo.enums.ResultCode;
import org.dubbo.pojo.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fanglei on 2018/6/1.
 */

@RestController
@RequestMapping("/address")
public class ActivityAddressAction {

    private static final Logger logger = Logger.getLogger(ActivityAddressAction.class);

    @Autowired(required = false)
    private ActivityService activityService;

    @Autowired(required = false)
    private SendActivityResultService sendActivityResultService;


    @PostMapping(value = "/getActivityAddress")
    public BaseResponse getActivityAddress(ActivityAddress activityAddress) {
        logger.info("into ActivityAddressAction getActivityAddress method");
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessage(ResultCode.SUCCESS.getDesc());
        baseResponse.setCode(ResultCode.SUCCESS.getCode());
        baseResponse.setData(activityService.getActivityAddress(activityAddress));
        return baseResponse;
    }


    @PostMapping(value = "/inserActivityAddress")
    public BaseResponse inserActivityAddress(ActivityAddress activityAddress) {
        BaseResponse baseResponse = new BaseResponse();
        if (CommonUtils.checkObjFieldIsNotNullByremark(activityAddress, "id")) {
            baseResponse.setMessage(ResultCode.SUCCESS.getDesc());
            baseResponse.setCode(ResultCode.SUCCESS.getCode());
            baseResponse.setData(activityService.inserActivityAddress(activityAddress));
        } else {
            baseResponse.setMessage(ResultCode.NOT_ENOUGH_PARAMS.getDesc());
            baseResponse.setCode(ResultCode.NOT_ENOUGH_PARAMS.getCode());
        }
        return baseResponse;
    }

    @PostMapping(value = "/updateSize")
    public BaseResponse updateSize(ActivityWinResult activityWinResult) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessage(ResultCode.SUCCESS.getDesc());
        baseResponse.setCode(ResultCode.SUCCESS.getCode());
        baseResponse.setData(sendActivityResultService.updateSize(activityWinResult));

        return baseResponse;
    }
    @PostMapping(value = "/sendAddressIsNullMessage")
    public BaseResponse sendAddressIsNullMessage() {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessage(ResultCode.SUCCESS.getDesc());
        baseResponse.setCode(ResultCode.SUCCESS.getCode());
        sendActivityResultService.sendAddressIsNullMessage();
        return baseResponse;
    }
}
