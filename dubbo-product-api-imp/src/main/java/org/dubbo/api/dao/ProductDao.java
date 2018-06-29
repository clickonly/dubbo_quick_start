package org.dubbo.api.dao;

import org.dubbo.pojo.bean.product.*;
import org.dubbo.pojo.dto.product.AboutGoodsDto;
import org.dubbo.pojo.dto.product.GoodsSearchDto;

import java.util.List;
import java.util.Map;

/**
 * Created by fanglei on 2017/11/17.
 */
public interface ProductDao {

    /**
     * 产品查询翻页/搜索
     *
     * @return
     */
    List<GoodsView> getGoodsListPage(GoodsSearchDto goodsSearchDto);

    /**
     * 查询单个商品所有静态数据信息
     * @param goodsSearchDto
     * @return
     */
//    GoodsBase getGoodsBaseByOne(GoodsSearchDto goodsSearchDto);

    /**
     * 产品Count
     * @param goodsSearchDto
     * @return
     */
    Integer getGoodsListCount(GoodsSearchDto goodsSearchDto);

    /**
     * 是否收藏
     * @param goodsSearchDto
     * @return
     */
    String isCollect(GoodsSearchDto goodsSearchDto);

    /**
     * 获取商品基本信息
     * @param goodsSearchDto
     * @return
     */
    List<GoodsInfo> getProductInfo(GoodsSearchDto goodsSearchDto);

    /**
     * 获取详情页大图模特图信息
     * @param goodsSearchDto
     * @return
     */
    GoodsImage getModelImage(GoodsSearchDto goodsSearchDto);

    /**
     * 获取商品成分信息
     * @param goodsSearchDto
     * @return
     */
    List<GoodsElement> getGoodsElement(GoodsSearchDto goodsSearchDto);

    /**
     * 选择颜色尺码中的尺码数据
     * @param goodsSearchDto
     * @return
     */
    List<GoodsSize> getGoodsSize (GoodsSearchDto goodsSearchDto);

    /**
     * 获取商品尺码对照表数据
     * @param goodsSearchDto
     * @return
     */
    List<GoodsSizeTableItem> getGoodSizeTable (GoodsSearchDto goodsSearchDto);

    /**
     * 获取购物车商品总数量
     * @param goodsSearchDto
     * @return
     */
    Integer getCartSumGoods(GoodsSearchDto goodsSearchDto);

    /**
     * 根据分类翻页搜索
     * @param goodsSearchDto
     * @return
     */
    List<GoodsView> getGoodsListSearchPage(GoodsSearchDto goodsSearchDto);

    Integer getGoodsListSearchPageCount(GoodsSearchDto goodsSearchDto);

    /**
     * 单独获取轮播数据
     * @param goodsSearchDto
     * @return
     */
    List<String> getTopCarouselImgs(GoodsSearchDto goodsSearchDto);

    /**
     * 产品查询翻页/搜索
     *
     * @return
     */
    List<GoodsView> getGoodsListByHeadPage(GoodsSearchDto goodsSearchDto);



    /**
     * 产品Count
     * @param goodsSearchDto
     * @return
     */
    Integer getGoodsListCountByHead(GoodsSearchDto goodsSearchDto);

    List<AboutGoods> getAboutGoodsList(AboutGoodsDto aboutGoodsDto);



    /**
     * 获取一个商品的库存
     * @param goodsId
     * @return
     */
    List<GoodsStock> getGoodsStock(Long goodsId);

    void callInsertCollect(Map<String,Object> paramsMap);


    List<GoodsStockInfo> getGoodsStockInfo(String code);

}
