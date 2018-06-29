package org.dubbo.action.product;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.dubbo.api.service.GoodsCartService;
import org.dubbo.pojo.base.BaseResponse;
import org.dubbo.pojo.bean.product.GoodsCart;
import org.dubbo.pojo.bean.product.GoodsClass;
import org.dubbo.pojo.bean.user.CardMain;
import org.dubbo.pojo.enums.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by jiangbin on 2018/2/24.
 */

@Controller
@Scope("prototype")
@RequestMapping(value = "/goodsCart")
public class GoodsCartAction {


    private static final Logger logger = Logger.getLogger(GoodsCartAction.class);


    @Autowired
    private GoodsCartService goodsCartService;

    @RequestMapping(value = "/getGoodsCart", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getGoodsCart(CardMain cardMain) {
        logger.info("into GoodsCartAction getGoodsCart method");
        BaseResponse<List<GoodsCart>> baseResponse = new BaseResponse<>();
        List<GoodsCart> goodsCartList = goodsCartService.getGoodsCartList(cardMain);
        baseResponse.setData(goodsCartList);
        baseResponse.setCode(ResultCode.SUCCESS.getCode());
        baseResponse.setMessage(ResultCode.SUCCESS.getDesc());
        return JSON.toJSONString(baseResponse);

    }
    @RequestMapping(value = "/getGoodsCardCount", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getGoodsCardCount(CardMain cardMain) {
        logger.info("into GoodsCartAction getGoodsCart method");
        BaseResponse<Integer> baseResponse = new BaseResponse<>();
        Integer count = goodsCartService.getGoodsCardCount(cardMain);
        baseResponse.setData(count);
        baseResponse.setCode(ResultCode.SUCCESS.getCode());
        baseResponse.setMessage(ResultCode.SUCCESS.getDesc());
        return JSON.toJSONString(baseResponse);

    }
}
