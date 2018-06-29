package org.dubbo.api.imp;

import org.apache.log4j.Logger;
import org.dubbo.api.dao.VoucherDao;
import org.dubbo.api.service.UserService;
import org.dubbo.api.service.VoucherService;
import org.dubbo.pojo.bean.activity.VoucherBase;
import org.dubbo.pojo.bean.user.CardMain;
import org.dubbo.pojo.bean.user.UserInfo;
import org.dubbo.pojo.bean.voucher.VoucherListBean;
import org.dubbo.pojo.dto.voucher.EchangeVoucherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jiangbin on 2018/1/23.
 */

@Service("voucherService")
public class VoucherServiceImp implements VoucherService {


    @Autowired
    private VoucherDao voucherDao;

    @Autowired
    private UserService userService;




    private static final Logger logger = Logger.getLogger(VoucherServiceImp.class);

    /**
     * 获取一个用户的优惠券列表
     *
     * @param cardMain
     * @return
     */
    public List<VoucherListBean> getVoucherListBean(CardMain cardMain){
        logger.info("into VoucherServiceImp getVoucherListBean method");
        List<VoucherListBean> voucherListBeanList=voucherDao.getVoucherListBean(cardMain.getUnionId());

        return voucherListBeanList;
    }

    @Override
    public Map EchangeVoucher(EchangeVoucherDto echangeVoucherDto) {
        logger.info("into VoucherServiceImp EchangeVoucher method");
        Long count=userService.getUserIntergralByRedis(echangeVoucherDto.getUnionId());
        Map<String,Object> map =new HashMap();
        if (null!=count){
            if (count<echangeVoucherDto.getIntegeral()*echangeVoucherDto.getNum()){
                map.put("ret","-1");
                map.put("retmsg","积分兑换积分余额不足");
            }else {
                count=count-echangeVoucherDto.getIntegeral()*echangeVoucherDto.getNum();
                UserInfo userInfo =new UserInfo();
                userInfo.setUnionId(echangeVoucherDto.getUnionId());
                userInfo.setAllIntegral(count);
                userService.setUserIntergraToRedis(userInfo);
                map.put("p_openid",echangeVoucherDto.getOpenId());
                map.put("p_id",echangeVoucherDto.getVouid());
                map.put("p_zs",echangeVoucherDto.getNum());
                voucherDao.CallEchangeVoucher(map);
            }
        }else {
            map.put("ret","-1");
            map.put("retmsg","积分兑换积分余额不足");
        }
        return map;
    }
}
