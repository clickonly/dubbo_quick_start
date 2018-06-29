package org.dubbo.action.product;


import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.dubbo.api.service.ProductService;
import org.dubbo.pojo.base.BaseResponse;
import org.dubbo.pojo.base.PageResponse;
import org.dubbo.pojo.bean.product.AboutGoods;
import org.dubbo.pojo.bean.product.GoodsStock;
import org.dubbo.pojo.bean.product.GoodsView;
import org.dubbo.pojo.dto.product.AboutGoodsDto;
import org.dubbo.pojo.dto.product.GoodsSearchDto;
import org.dubbo.pojo.enums.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Jiangbin on 2017/11/15.
 */
@Controller
@Scope("prototype")
@RequestMapping(value = "/product")
public class GoodsBaseAction {

    private static final Logger logger = Logger.getLogger(GoodsBaseAction.class);

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/getGoodsListPage", method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getGoodsListPage(GoodsSearchDto goodsSearchDto){
//        logger.info("into GoodsBaseAction getGoodsListPage method");
//        goodsSearchDto.setOpenId("oVFOhjvgvdt866J7z8YKBKmzhDCs");
//        goodsSearchDto.setWeId("2738574294");
//        goodsSearchDto.setTypeVal("all");
//        goodsSearchDto.setOrderVal("new");
//        goodsSearchDto.setPageNo(1);
//        goodsSearchDto.setPageSize(20);
        PageResponse<List<GoodsView>> pageResponse=productService.getGoodsListPage(goodsSearchDto);

        return JSON.toJSONString(pageResponse);

    }


    @RequestMapping(value = "/getGoodsListSearchPage", method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getGoodsListSearchPage(GoodsSearchDto goodsSearchDto){

        PageResponse<List<GoodsView>> pageResponse=productService.getGoodsListSearchPage(goodsSearchDto);

        return JSON.toJSONString(pageResponse);
    }


    @ResponseBody
    @RequestMapping(value = "/getOneGood" ,method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    public String getGoodsBaseByOne(GoodsSearchDto goodsSearchDto){
//        goodsSearchDto.setRentId("1");
//        goodsSearchDto.setWeId("2738574294");
//        goodsSearchDto.setOpenId("oVFOhjvgvdt866J7z8YKBKmzhDCs");
//        goodsSearchDto.setGoodsId("591451");
//        goodsSearchDto.setCode("5H0701840");
//        goodsSearchDto.setStyleId("5H0701840");
        return JSON.toJSONString(productService.getGoodsBaseByOne(goodsSearchDto));
    }

    @ResponseBody
    @RequestMapping(value = "/getAboutGoods" ,method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    public String getAboutGoods(AboutGoodsDto aboutGoodsDto){
        logger.info("into GoodsBaseAction getAboutGoods method");
        List<AboutGoods> aboutGoodsList=productService.getAboutGoodsList(aboutGoodsDto);
        BaseResponse<List<AboutGoods>> baseResponse=new BaseResponse<>();
        baseResponse.setData(aboutGoodsList);
        baseResponse.setMessage(ResultCode.SUCCESS.getDesc());
        baseResponse.setCode(ResultCode.SUCCESS.getCode());
        return JSON.toJSONString(baseResponse);
    }

    @ResponseBody
    @RequestMapping(value = "/getGoodsStock" ,method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    public String getGoodsStock(Long goodsId){
        logger.info("into GoodsBaseAction getGoodsStock method");
        List<GoodsStock> goodsStockList=productService.getGoodsStock(goodsId);
        BaseResponse<List<GoodsStock>> baseResponse=new BaseResponse<>();
        baseResponse.setData(goodsStockList);
        baseResponse.setMessage(ResultCode.SUCCESS.getDesc());
        baseResponse.setCode(ResultCode.SUCCESS.getCode());
        return JSON.toJSONString(baseResponse);
    }

}
