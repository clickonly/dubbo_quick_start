package org.dubbo.api.imp;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.dubbo.api.dao.GoodsDetailCountDao;
import org.dubbo.api.dao.ProductDao;
import org.dubbo.api.service.ProductService;
import org.dubbo.pojo.base.BaseResponse;
import org.dubbo.pojo.base.PageResponse;
import org.dubbo.pojo.bean.product.*;
import org.dubbo.pojo.dto.product.AboutGoodsDto;
import org.dubbo.pojo.dto.product.GoodsCountDto;
import org.dubbo.pojo.dto.product.GoodsSearchDto;
import org.dubbo.pojo.enums.ResultCode;
import org.dubbo.pojo.redis.RedisUtil;
import org.dubbo.pojo.utils.CommonRedisKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Jiangbin on 2017/11/15.
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {


    private static final Logger logger = Logger.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductDao productDao;

    @Autowired
    private GoodsDetailCountDao goodsDetailCountDao;

    @Autowired
    private RedisUtil redisUtil;


    /**
     *收藏 取消收藏
     * @param goodsSearchDto
     * @return
     */
    public BaseResponse collectGoods(GoodsSearchDto goodsSearchDto){
        BaseResponse baseResponse = new BaseResponse();
        Map<String,Object> params = new HashMap<>();
        params.put("p_rentid",goodsSearchDto.getRentId());
        params.put("p_weid",goodsSearchDto.getWeId());
        params.put("p_openid",goodsSearchDto.getOpenId());
        params.put("p_goodsid",goodsSearchDto.getGoodsId());
        productDao.callInsertCollect(params);
        baseResponse.setCode(String.valueOf(params.get("RET")));
        baseResponse.setMessage(String.valueOf(params.get("ERRMSG")));
        baseResponse.setData(productDao.isCollect(goodsSearchDto));
        return baseResponse;
    }

    /**
     * 分页/搜索查询
     * @param goodsSearchDto
     * @return
     */
    public PageResponse<List<GoodsView>> getGoodsListPage(GoodsSearchDto goodsSearchDto){

        PageResponse<List<GoodsView>> pageResponse =new PageResponse<List<GoodsView>>();
        try{
            Integer count=0;
            List<GoodsView> goodsViewList=new ArrayList<GoodsView>();
            if ("all".equals(goodsSearchDto.getTypeVal())){
                count =productDao.getGoodsListCount(goodsSearchDto);
                goodsViewList=productDao.getGoodsListPage(goodsSearchDto);
            }else {
                goodsViewList =productDao.getGoodsListByHeadPage(goodsSearchDto);
                count=productDao.getGoodsListCountByHead(goodsSearchDto);
            }
            pageResponse.setData(goodsViewList);
            pageResponse.setCount(count);
            pageResponse.setCode(ResultCode.SUCCESS.getCode());
            pageResponse.setMessage(ResultCode.SUCCESS.getDesc());

        }catch (Exception e){
            logger.error(e);
            pageResponse.setCode(ResultCode.FAIL.getCode());
            pageResponse.setMessage(ResultCode.FAIL.getDesc());
        }
        return  pageResponse;
    }


    /**
     * 分类分页查询
     * @param goodsSearchDto
     * @return
     */
    public PageResponse<List<GoodsView>> getGoodsListSearchPage(GoodsSearchDto goodsSearchDto){
        PageResponse<List<GoodsView>> pageResponse =new PageResponse<List<GoodsView>>();
        try{
            List<GoodsView> goodsViewList=productDao.getGoodsListSearchPage(goodsSearchDto);
            Integer count =productDao.getGoodsListSearchPageCount(goodsSearchDto);
            pageResponse.setData(goodsViewList);
            pageResponse.setCount(count);
            pageResponse.setCode(ResultCode.SUCCESS.getCode());
            pageResponse.setMessage(ResultCode.SUCCESS.getDesc());

        }catch (Exception e){
            logger.error(e);
            pageResponse.setCode(ResultCode.FAIL.getCode());
            pageResponse.setMessage(ResultCode.FAIL.getDesc());

        }
        return  pageResponse;
    }
    /**
     * 查询单个产品
     * @param goodsSearchDto
     * @return
     */
    public BaseResponse<GoodDetailResult> getGoodsBaseByOne(GoodsSearchDto goodsSearchDto){
        BaseResponse<GoodDetailResult> baseResponse=new BaseResponse<GoodDetailResult>();
        try{
            GoodDetailResult goodDetailResult = new GoodDetailResult();
            goodDetailResult.setIsCollect(productDao.isCollect(goodsSearchDto));
            goodDetailResult.setModelImage(productDao.getModelImage(goodsSearchDto));
            goodDetailResult.setProductInfo(productDao.getProductInfo(goodsSearchDto));
            goodDetailResult.setCartSumGoods(productDao.getCartSumGoods(goodsSearchDto));
            goodDetailResult.setGoodSizeTable(productDao.getGoodSizeTable(goodsSearchDto));
            goodDetailResult.setGoodsElement(productDao.getGoodsElement(goodsSearchDto));
            goodDetailResult.setTopCarouselImgs(productDao.getTopCarouselImgs(goodsSearchDto));
            goodDetailResult.setGoodsSize(productDao.getGoodsSize(goodsSearchDto));
            goodDetailResult.setGoodsStockList(productDao.getGoodsStock(Long.valueOf(goodsSearchDto.getGoodsId())));
            goodDetailResult.setGoodsStockInfos(productDao.getGoodsStockInfo(goodsSearchDto.getCode()));
            baseResponse.setData(goodDetailResult);
            baseResponse.setCode(ResultCode.SUCCESS.getCode());
            baseResponse.setMessage(ResultCode.SUCCESS.getDesc());
        }catch (Exception e){
            logger.error(e);
            baseResponse.setCode(ResultCode.FAIL.getCode());
            baseResponse.setMessage(ResultCode.FAIL.getDesc());
        }
        return  baseResponse;
    }

    /**
     * 定時更新產品銷售
     */
    public void productTimingQuery(){
        logger.info("into productTimingQuery method");
        GoodsCountDto goodsCountDto =new GoodsCountDto();
        SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, -15);//计算30天后的时间
        goodsCountDto.setStatus("S");
        goodsCountDto.setEnd_time(s.format(new Date()));
        goodsCountDto.setStart_time(s.format(c.getTime()));
        List<GoodsDetalCount> goodsDetalCountList=goodsDetailCountDao.getGoodsCount(goodsCountDto);
        if (!goodsDetalCountList.isEmpty()){
            goodsDetailCountDao.deleteGoodsDetalCount();
            for (GoodsDetalCount goodsDetalCount:goodsDetalCountList){
                goodsDetailCountDao.insert(goodsDetalCount);
            }
        }

    }


    public  List<AboutGoods> getAboutGoodsList(AboutGoodsDto aboutGoodsDto){
        logger.info("into getAboutGoodsList method");
        List<AboutGoods> aboutGoodsList;
        String json =(String)redisUtil.get(CommonRedisKey.goods.ABOUT_GOODS+aboutGoodsDto.getGoodsId());
        if (!StringUtils.isEmpty(json)){
            aboutGoodsList= JSON.parseArray(json,AboutGoods.class);
        }else {
            aboutGoodsList=productDao.getAboutGoodsList(aboutGoodsDto);
            if (null!=aboutGoodsList){
                redisUtil.set(CommonRedisKey.goods.ABOUT_GOODS+aboutGoodsDto.getGoodsId(), JSON.toJSONString(aboutGoodsList),3600);
            }
        }
        return aboutGoodsList;
    }

    public  List<GoodsStock> getGoodsStock(Long goodsId){
        logger.info("into getGoodsStock method");
        List<GoodsStock> goodsStockList =new ArrayList<>();
        goodsStockList=productDao.getGoodsStock(goodsId);
        return goodsStockList;
    }



    public static void main(String args[]) {
        Object a = 1;
        String b = (String) a;
//        s
    }
}
