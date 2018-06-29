package org.dubbo.action.user;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.dubbo.api.service.ActivityService;
import org.dubbo.api.service.MessageService;
import org.dubbo.api.service.UserIntegralService;
import org.dubbo.api.service.UserService;
import org.dubbo.pojo.base.BaseResponse;
import org.dubbo.pojo.bean.user.SmsMessageCheck;
import org.dubbo.pojo.bean.user.UserInfo;
import org.dubbo.pojo.dto.activity.ActivityLogDto;
import org.dubbo.pojo.dto.activity.SendIntergralDto;
import org.dubbo.pojo.dto.wx.SendVouCouponMessageDto;
import org.dubbo.pojo.enums.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jiangbin on 2017/12/14.
 */

@Controller
@Scope("prototype")
@RequestMapping(value = "/user")
public class UserAction {

    private static final Logger logger = Logger.getLogger(UserAction.class);

    @Autowired(required = false)
    private UserService userService;


    @Autowired(required = false)
    private ActivityService activityService;

    @Autowired(required = false)
    private UserIntegralService userIntegralService;



    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getUserInfo(UserInfo userInfo) {
        logger.info("into UserAction getUserInfo");
        BaseResponse<UserInfo> baseResponse = new BaseResponse<>();
        UserInfo cardMain = userService.getClientVipInfo(userInfo);
        baseResponse.setCode(ResultCode.SUCCESS.getCode());
        baseResponse.setData(cardMain);
        baseResponse.setMessage(ResultCode.SUCCESS.getDesc());
        return JSON.toJSONString(baseResponse);
    }


    @RequestMapping(value = "/checkSendCode", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String checkSendCode(SmsMessageCheck smsMessageCheck) {
        logger.info("into UserAction checkSendCode");
        BaseResponse<Boolean> baseResponse = new BaseResponse();
        SmsMessageCheck smsMessageCheckResult = userService.getSendCode(smsMessageCheck.getTel());
        if (null != smsMessageCheckResult) {
            if (smsMessageCheckResult.getCode().equals(smsMessageCheck.getCode())) {
                baseResponse.setData(true);
            } else {
                baseResponse.setData(false);
            }
        } else {
            baseResponse.setData(false);
        }
        baseResponse.setCode(ResultCode.SUCCESS.getCode());
        baseResponse.setMessage(ResultCode.SUCCESS.getDesc());

        return JSON.toJSONString(baseResponse);
    }





    @RequestMapping(value = "/refreshUser", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String refreshUser(UserInfo userInfo) {
        userService.setCardMainRedis(userInfo);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(ResultCode.SUCCESS.getCode());
        baseResponse.setMessage(ResultCode.SUCCESS.getDesc());
        return JSON.toJSONString(baseResponse);
    }



    @PostMapping(value = "/getUserIntergral")
    @ResponseBody
    public BaseResponse getUserIntergral(String unionid) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessage(ResultCode.SUCCESS.getDesc());
        baseResponse.setCode(ResultCode.SUCCESS.getCode());
        if (StringUtils.isEmpty(unionid)){
            baseResponse.setData(-1);
        }else {
            baseResponse.setData(userService.getUserIntergralByRedis(unionid));
        }
        return baseResponse;
    }


    @PostMapping(value = "/logInsert")
    @ResponseBody
    public BaseResponse logInsert(ActivityLogDto activityLogDto) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessage(ResultCode.SUCCESS.getDesc());
        baseResponse.setCode(ResultCode.SUCCESS.getCode());
        activityService.requestLogInsert(activityLogDto);
        return baseResponse;
    }

    /**
     * 处理缓存积分
     * @param sendIntergralDto
     * @return
     */
    @PostMapping(value = "/handIntegral")
    @ResponseBody
    public BaseResponse handIntegral(SendIntergralDto sendIntergralDto) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessage(ResultCode.SUCCESS.getDesc());
        baseResponse.setCode(ResultCode.SUCCESS.getCode());
        userIntegralService.handIntegral(sendIntergralDto);
        return baseResponse;
    }


    /**
     * 处理真正积分
     * @param sendIntergralDto
     * @return
     */
    @PostMapping(value = "/handRealIntegral")
    @ResponseBody
    public BaseResponse handRealIntegral(SendIntergralDto sendIntergralDto) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessage(ResultCode.SUCCESS.getDesc());
        baseResponse.setCode(ResultCode.SUCCESS.getCode());
        userIntegralService.handRealIntegral(sendIntergralDto);
        return baseResponse;
    }
}
