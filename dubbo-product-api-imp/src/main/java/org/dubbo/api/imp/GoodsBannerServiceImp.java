package org.dubbo.api.imp;

import org.apache.log4j.Logger;
import org.dubbo.api.dao.GoodsBannerDao;
import org.dubbo.api.service.GoodsBannerService;
import org.dubbo.pojo.bean.product.GoodsBanner;
import org.dubbo.pojo.redis.RedisUtil;
import org.dubbo.pojo.utils.CommonRedisKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangbin on 2018/2/9.
 */

@Service("goodsBannerService")
public class GoodsBannerServiceImp implements GoodsBannerService {


    private static final Logger logger = Logger.getLogger(GoodsClassServiceImp.class);


    @Autowired
    private GoodsBannerDao goodsBannerDao;

    @Autowired
    private RedisUtil redisUtil;

    public List<GoodsBanner> getGoodsBannerList(GoodsBanner goodsBanner){
        logger.info("into getGoodsBannerList method");
        List<GoodsBanner> goodsBannerList=new ArrayList<>();
        try {
            goodsBannerList=(List<GoodsBanner>) redisUtil.get(CommonRedisKey.goodsBanner.GOODS_BANNER_KEY+"_"+goodsBanner.getWeid()+"_"+goodsBanner.getTypeval());
            if (null==goodsBannerList||goodsBannerList.isEmpty()){
                goodsBannerList=goodsBannerDao.getGoodsBannerList(goodsBanner);
                if (!goodsBannerList.isEmpty()){
                    redisUtil.set(CommonRedisKey.goodsBanner.GOODS_BANNER_KEY+"_"+goodsBanner.getWeid()+"_"+goodsBanner.getTypeval(),goodsBannerList,3600);
                }
            }
        }catch (Exception e){
            logger.error("getGoodsBannerList error",e);
        }
        return goodsBannerList;
    }
}
