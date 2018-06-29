package org.dubbo.api.dao;

import org.dubbo.pojo.bean.product.GoodsBanner;

import java.util.List;

/**
 * Created by fanglei on 2018/2/9.
 */
public interface GoodsBannerDao {

    List<GoodsBanner> getGoodsBannerList(GoodsBanner goodsBanner);
}
