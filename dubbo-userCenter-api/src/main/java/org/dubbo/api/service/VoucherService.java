package org.dubbo.api.service;

import org.dubbo.pojo.bean.user.CardMain;
import org.dubbo.pojo.bean.voucher.VoucherListBean;
import org.dubbo.pojo.dto.voucher.EchangeVoucherDto;

import java.util.List;
import java.util.Map;

/**
 * Created by jiangbin on 2018/1/19.
 * 微信优惠券逻辑处理
 */
public interface VoucherService {

    /**
     * 获取当前用户的优惠券列表
     * @param cardMain
     * @return
     */
    List<VoucherListBean> getVoucherListBean(CardMain cardMain);

    /**
     * 兑换券
     * @param echangeVoucherDto
     */
    Map EchangeVoucher(EchangeVoucherDto echangeVoucherDto);

}
