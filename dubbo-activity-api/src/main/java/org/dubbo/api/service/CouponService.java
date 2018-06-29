package org.dubbo.api.service;

import org.dubbo.pojo.dto.activity.SendVouCouponDto;

/**
 * 优惠券
 * Created by fanglei on 2018/5/24.
 */
public interface CouponService {

    /**
     * 将优惠券发送队列
     * @param sendVouCouponDto
     * @return
     */
    boolean sendCouponTorRedis(SendVouCouponDto sendVouCouponDto);


    /**
     * 发送优惠券
     * @param sendVouCouponDto
     * @return
     */
    boolean sendVouCoupon(SendVouCouponDto sendVouCouponDto);
}
