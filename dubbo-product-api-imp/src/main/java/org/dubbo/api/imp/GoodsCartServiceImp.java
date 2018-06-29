package org.dubbo.api.imp;

import org.apache.log4j.Logger;
import org.dubbo.api.dao.GoodsCartDao;
import org.dubbo.api.service.GoodsCartService;
import org.dubbo.pojo.bean.product.GoodsBanner;
import org.dubbo.pojo.bean.product.GoodsCart;
import org.dubbo.pojo.bean.user.CardMain;
import org.dubbo.pojo.redis.RedisUtil;
import org.dubbo.pojo.utils.CommonRedisKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangbin on 2018/2/24.
 */

@Service("goodsCartService")
public class GoodsCartServiceImp implements GoodsCartService {

    private static final Logger logger = Logger.getLogger(GoodsCartServiceImp.class);


    @Autowired
    private GoodsCartDao goodsCartDao;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 获取当前用户购物车信息
     * @param cardMain
     * @return
     */
    public List<GoodsCart> getGoodsCartList(CardMain cardMain){
        logger.info("into GoodsCartServiceImp getGoodsCartList method");
        List<GoodsCart> goodsCartList=new ArrayList<>();
        try {
          //  goodsCartList=(List<GoodsCart>) redisUtil.get(cardMain.getOpenId()+CommonRedisKey.goodsCart.GOODS_CART);
           // if (null==goodsCartList||goodsCartList.isEmpty()){
                goodsCartList=goodsCartDao.getGoodsCartList(cardMain);
              //  if (!goodsCartList.isEmpty()){
               //     redisUtil.set(cardMain.getOpenId()+CommonRedisKey.goodsCart.GOODS_CART,goodsCartList,600);
              //  }
         //   }
        }catch (Exception e){
            logger.error("getGoodsCartList error",e);
        }
        return  goodsCartList;
    }

    public Integer getGoodsCardCount(CardMain cardMain){
        logger.info("into GoodsCartServiceImp getGoodsCardCount method");
        Integer count=0;
        try{
          //  count=(Integer)redisUtil.get(cardMain.getOpenId()+CommonRedisKey.goodsCart.COUNT);
            //if (count==null){
                count=goodsCartDao.getGoodsCardCount(cardMain);
              //  if (null!=count){
              //      redisUtil.set(cardMain.getOpenId()+CommonRedisKey.goodsCart.COUNT,count,600);
              //  }
           // }
        }catch (Exception e){
            logger.error("getGoodsCardCount error",e);
        }
        return count;
    }



}
