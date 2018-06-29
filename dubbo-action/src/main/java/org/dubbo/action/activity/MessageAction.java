package org.dubbo.action.activity;

import org.apache.log4j.Logger;
import org.dubbo.api.service.MessageService;
import org.dubbo.pojo.base.BaseResponse;
import org.dubbo.pojo.dto.wx.SendVouCouponMessageDto;
import org.dubbo.pojo.enums.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fanglei on 2018/6/13.
 */

@RestController
@RequestMapping("/message")
public class MessageAction {

    private static final Logger logger = Logger.getLogger(MessageAction.class);


    @Autowired(required = false)
    private MessageService messageService;

    @PostMapping(value = "/sendMessageToReids")
    public BaseResponse sendMessageToReids(SendVouCouponMessageDto sendVouCouponMessageDto){
        logger.info("into ActivityAddressAction getActivityAddress method");
        BaseResponse baseResponse=new BaseResponse();
        baseResponse.setMessage(ResultCode.SUCCESS.getDesc());
        baseResponse.setCode(ResultCode.SUCCESS.getCode());
        messageService.sendMessageToReids(sendVouCouponMessageDto);
        return baseResponse;
    }


    @PostMapping(value = "/sendMessage")
    public BaseResponse sendMessage(SendVouCouponMessageDto sendVouCouponMessageDto){
        logger.info("into ActivityAddressAction getActivityAddress method");
        BaseResponse baseResponse=new BaseResponse();
        baseResponse.setMessage(ResultCode.SUCCESS.getDesc());
        baseResponse.setCode(ResultCode.SUCCESS.getCode());
        messageService.sendMessage(sendVouCouponMessageDto);
        return baseResponse;
    }


}
