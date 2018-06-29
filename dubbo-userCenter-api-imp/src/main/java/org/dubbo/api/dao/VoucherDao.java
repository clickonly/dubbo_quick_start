package org.dubbo.api.dao;

import org.dubbo.pojo.bean.voucher.VoucherListBean;

import java.util.List;
import java.util.Map;

/**
 * Created by jiangbin on 2018/1/23.
 */
public interface VoucherDao {

    List<VoucherListBean> getVoucherListBean(String unionid);

    void CallEchangeVoucher(Map<String,Object> map);
}
