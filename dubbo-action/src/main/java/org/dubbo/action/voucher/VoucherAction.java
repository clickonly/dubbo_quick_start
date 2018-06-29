package org.dubbo.action.voucher;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.dubbo.api.service.CouponService;
import org.dubbo.api.service.VoucherService;
import org.dubbo.pojo.base.BaseResponse;
import org.dubbo.pojo.bean.user.CardMain;
import org.dubbo.pojo.bean.voucher.VoucherListBean;
import org.dubbo.pojo.dto.activity.SendVouCouponDto;
import org.dubbo.pojo.dto.voucher.EchangeVoucherDto;
import org.dubbo.pojo.enums.ResultCode;
import org.dubbo.pojo.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by fanglei on 2018/1/23.
 */

@Controller
@Scope("prototype")
@RequestMapping(value = "/voucher")
public class VoucherAction {

    private static final Logger logger = Logger.getLogger(VoucherAction.class);


    @Autowired(required = false)
    private VoucherService voucherService;

    @Autowired(required = false)
    private CouponService couponService;

    @RequestMapping(value = "/getVoucherList", method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getVoucherList(CardMain cardMain){
        logger.info("into VoucherAction getVoucherList");
        BaseResponse<List<VoucherListBean>> baseResponse=new BaseResponse<>();
        List<VoucherListBean> voucherListBeanList=voucherService.getVoucherListBean(cardMain);
        baseResponse.setCode(ResultCode.SUCCESS.getCode());
        baseResponse.setData(voucherListBeanList);
        baseResponse.setMessage(ResultCode.SUCCESS.getDesc());
        return JSON.toJSONString(baseResponse);
    }

    /**
     * 兑换券
     * @param echangeVoucherDto
     * @return
     */
    @RequestMapping(value = "/exchangeVoucheDetail", method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String exchangeVoucheDetail(EchangeVoucherDto echangeVoucherDto){
        logger.info("into VoucherAction exchangeVoucheDetail");
        BaseResponse baseResponse=new BaseResponse<>();
        if (CommonUtils.checkObjFieldIsNotNull(echangeVoucherDto)){
            baseResponse.setCode(ResultCode.SUCCESS.getCode());
            baseResponse.setMessage(ResultCode.SUCCESS.getDesc());
            baseResponse.setData(voucherService.EchangeVoucher(echangeVoucherDto));
        }else {
            baseResponse.setCode(ResultCode.NOT_ENOUGH_PARAMS.getCode());
            baseResponse.setMessage(ResultCode.NOT_ENOUGH_PARAMS.getDesc());
        }

        return JSON.toJSONString(baseResponse);
    }


    /**
     *
     * @param sendVouCouponDto
     * @return
     */
    @PostMapping(value = "/sendVouCoupon")
    public BaseResponse sendVouCoupon(SendVouCouponDto sendVouCouponDto) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessage(ResultCode.SUCCESS.getDesc());
        baseResponse.setCode(ResultCode.SUCCESS.getCode());
        baseResponse.setData(couponService.sendVouCoupon(sendVouCouponDto));
        return baseResponse;
    }



}
