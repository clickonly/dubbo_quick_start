package org.dubbo.api.service;

import org.dubbo.pojo.dto.wx.SendVouCouponMessageDto;

/**
 * Created by fanglei on 2018/5/24.
 */
public interface MessageService {


    /**
     * 消息提交到队列
     * @param sendVouCouponMessageDto
     * @return
     */
    boolean sendMessageToReids(SendVouCouponMessageDto sendVouCouponMessageDto);

    /**
     * 发送消息模板
     * @param sendVouCouponMessageDto
     * @return
     */
    boolean sendMessage(SendVouCouponMessageDto sendVouCouponMessageDto);


    void sendErrorMessage(Long activtiyId,String message);



}
