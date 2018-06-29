package org.dubbo.api.service;

import org.dubbo.pojo.dto.activity.SendIntergralDto;

/**
 * Created by jiangbin on 2018/6/11.
 */
public interface UserIntegralService {

    /**
     * 发生积分到redis
     * @param sendIntergralDto
     * @return
     */
    boolean sendVouIntegralToRedis(SendIntergralDto sendIntergralDto) ;


    /**
     * 处理缓存中积分
     * @param sendIntergralDto
     * @return
     */
    boolean handIntegral(SendIntergralDto sendIntergralDto);




    boolean insertSendError(SendIntergralDto sendIntergralDto);


    boolean handRealIntegral(SendIntergralDto sendIntergralDto);



}
