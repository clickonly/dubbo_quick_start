package org.dubbo.api.service;

import org.dubbo.pojo.bean.product.GoodsCart;
import org.dubbo.pojo.bean.user.CardMain;

import java.util.List;

/**
 * Created by jiangbin on 2018/2/24.
 */
public interface GoodsCartService {

    List<GoodsCart> getGoodsCartList(CardMain cardMain);

    Integer getGoodsCardCount(CardMain cardMain);
}
