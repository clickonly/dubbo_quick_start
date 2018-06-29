package org.dubbo.api.dao;

import org.apache.ibatis.annotations.Param;
import org.dubbo.pojo.bean.activity.NewActivityAward;
import org.dubbo.pojo.bean.activity.ViewWxscgift;
import org.dubbo.pojo.bean.activity.WxscInsertVoucher;

import java.util.Map;

/**
 * Created by fanglei on 2018/1/9.
 */
public interface NewActivityAwardDao {

    /**
     * 通过一个Id 获取当前在有效时间的优惠券
     * @param id
     * @return
     */
    NewActivityAward getNewActivityAwardBy(@Param("id") Integer id);

    ViewWxscgift getViewWxscgiftBy(@Param("id") Integer id);

    /**
     * 伯俊存储过程
     * @param map
     */
    String callWxscInsertVoucher(Map<String,Object> map);
}
