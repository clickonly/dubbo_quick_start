package org.dubbo.action.product;

import org.dubbo.api.service.ProductService;
import org.dubbo.pojo.base.BaseResponse;
import org.dubbo.pojo.dto.product.GoodsSearchDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jinpan12430 on 2018/2/26.
 */
@RestController
@RequestMapping("/collect")
public class GoodsCollectAction {

    @Autowired(required = false)
    ProductService productService;

    /**
     * 添加收藏
     * @param goodsSearchDto
     * @return
     */
    @PostMapping("/collectionGoods")
    public BaseResponse collectionGoods(GoodsSearchDto goodsSearchDto){
        BaseResponse baseResponse= productService.collectGoods(goodsSearchDto);
        return baseResponse;
    }

//    /**
//     * 取消收藏  可以换着用
//     * @param goodsSearchDto
//     * @return
//     */
//    @PostMapping("/cancelCollect")
//    public BaseResponse cancelCollect(GoodsSearchDto goodsSearchDto){
//        BaseResponse baseResponse= productService.collectGoods(goodsSearchDto);
//        return baseResponse;
//    }

}
