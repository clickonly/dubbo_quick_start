package org.dubbo.action.product;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.dubbo.api.service.GoodsBannerService;
import org.dubbo.pojo.base.BaseResponse;
import org.dubbo.pojo.bean.product.GoodsBanner;
import org.dubbo.pojo.enums.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by fanglei on 2018/2/9.
 */
@Controller
@Scope("prototype")
@RequestMapping(value = "/goodsBanner")
public class GoodsBannerAction {
    private static final Logger logger = Logger.getLogger(GoodsBannerAction.class);


    @Autowired
    private GoodsBannerService goodsBannerService;

    /**
     * 获取列表banner
     * @param goodsBanner
     */
    @ResponseBody
    @RequestMapping(value = "/getGoodsBannerList" ,method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    public String getGoodsBannerList(GoodsBanner goodsBanner){
        logger.info("into GoodsBannerAction getGoodsBannerList method");
        BaseResponse baseResponse =new BaseResponse();
        baseResponse.setData(goodsBannerService.getGoodsBannerList(goodsBanner));
        baseResponse.setCode(ResultCode.SUCCESS.getCode());
        baseResponse.setMessage(ResultCode.SUCCESS.getDesc());
        return JSON.toJSONString(baseResponse);
    }
}
