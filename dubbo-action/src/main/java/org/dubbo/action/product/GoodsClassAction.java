package org.dubbo.action.product;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.dubbo.api.service.GoodsClassService;
import org.dubbo.pojo.base.BaseResponse;
import org.dubbo.pojo.bean.product.GoodsClass;
import org.dubbo.pojo.enums.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by fanglei on 2017/12/21.
 */
@Controller
@Scope("prototype")
@RequestMapping(value = "/goodsClass")
public class GoodsClassAction {

    private static final Logger logger = Logger.getLogger(GoodsClassAction.class);

    @Autowired
    private GoodsClassService goodsClassService;

    @RequestMapping(value = "/getGoodsClass", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getGoodsClass(GoodsClass goodsClass) {
        logger.info("into GoodsClassAction getGoodsClass method");
        BaseResponse<List<GoodsClass>> baseResponse = new BaseResponse<>();
        List<GoodsClass> goodsClasses = goodsClassService.getGoodsClass(goodsClass);
        baseResponse.setData(goodsClasses);
        baseResponse.setCode(ResultCode.SUCCESS.getCode());
        baseResponse.setMessage(ResultCode.SUCCESS.getDesc());
        return JSON.toJSONString(baseResponse);

    }



}
