package org.dubbo.api.service;

import org.dubbo.pojo.base.BaseResponse;
import org.dubbo.pojo.base.PageResponse;
import org.dubbo.pojo.bean.product.*;
import org.dubbo.pojo.dto.product.AboutGoodsDto;
import org.dubbo.pojo.dto.product.GoodsSearchDto;

import java.util.List;

/**
 * Created by jiangbin on 2017/11/15.
 */
public interface ProductService {

    /**
     * 产品查询翻页/搜索
     *
     * @return
     */
    PageResponse<List<GoodsView>> getGoodsListPage(GoodsSearchDto goodsSearchDto);

    BaseResponse<GoodDetailResult> getGoodsBaseByOne(GoodsSearchDto goodsSearchDto);

    PageResponse<List<GoodsView>> getGoodsListSearchPage(GoodsSearchDto goodsSearchDto);


    /**
     * 定時更新產品銷量
     */
    void productTimingQuery();


    /**
     * 获取商品相关商品
     * @param aboutGoodsDto
     * @return
     */
    List<AboutGoods> getAboutGoodsList(AboutGoodsDto aboutGoodsDto);


    /**
     * 获取一个商品的库存
     * @param goodsId
     * @return
     */
    List<GoodsStock> getGoodsStock(Long goodsId);

    /**
     * 收藏商品/取消收藏
     * @param goodsSearchDto
     * @return
     */
    BaseResponse<?> collectGoods(GoodsSearchDto goodsSearchDto);
}
