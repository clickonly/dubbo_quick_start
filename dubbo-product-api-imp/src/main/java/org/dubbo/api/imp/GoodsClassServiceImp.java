package org.dubbo.api.imp;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.dubbo.api.dao.ProductClassDao;
import org.dubbo.api.service.GoodsClassService;
import org.dubbo.pojo.bean.product.GoodsClass;
import org.dubbo.pojo.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fanglei on 2017/12/21.
 */

@Service("goodsClassService")
public class GoodsClassServiceImp  implements GoodsClassService {


    private static final Logger logger = Logger.getLogger(GoodsClassServiceImp.class);

    private static final String GOODS_CLASS_KEY="goodsClass_";


    @Resource
    private ProductClassDao productClassDao;


    @Autowired
    private RedisUtil redisUtil;
    /**
     * 同步产品分类
     */
    public void synchronizationProductClass(){
        logger.info("into GoodsClassServiceImp synchronizationProductClass metho");
        try{
            logger.info("开始同步信息..........");
            List<String> weidList=productClassDao.getGoodsClassWid();
            for (String weid:weidList){
                List<GoodsClass> goodsClasses=productClassDao.getGoodsClass(weid);
                redisUtil.set(GOODS_CLASS_KEY+weid, JSON.toJSONString(goodsClasses),60*60*24);
            }
            logger.info("结束同步信息..........");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 获取分类
     * @param goodsClass
     * @return
     */
    public List<GoodsClass> getGoodsClass(GoodsClass goodsClass){
        logger.info("into GoodsClassServiceImp getGoodsClass metho");
        List<GoodsClass> goodsClassList=new ArrayList<>();
        try{
            String json =(String)redisUtil.get(GOODS_CLASS_KEY+goodsClass.getWeid());
            if (!StringUtils.isEmpty(json)){
                goodsClassList=JSON.parseArray(json,GoodsClass.class);
            }else {
                goodsClassList=productClassDao.getGoodsClass(goodsClass.getWeid());
                redisUtil.set(GOODS_CLASS_KEY+goodsClass.getWeid(), JSON.toJSONString(goodsClassList),60*60*24);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
       return goodsClassList;
    }
}
