package org.dubbo.api.dao;

import org.dubbo.pojo.bean.product.GoodsCart;
import org.dubbo.pojo.bean.user.CardMain;

import java.util.List;

/**
 * Created by jiangbin on 2018/2/24.
 */
public interface GoodsCartDao {

    List<GoodsCart> getGoodsCartList(CardMain cardMain);

    Integer getGoodsCardCount(CardMain cardMain);
}
