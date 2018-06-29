package org.dubbo.api.service;

import org.dubbo.pojo.bean.product.GoodsBanner;

import java.util.List;

/**
 * Created by jiangbin on 2018/2/9.
 */
public interface GoodsBannerService {

    List<GoodsBanner> getGoodsBannerList(GoodsBanner goodsBanner);

}
