package org.dubbo.api.dao;

import org.dubbo.pojo.bean.activity.BarrageInfo;
import org.dubbo.pojo.dto.activity.BarrageInfoDto;

import java.util.List;

/**
 * Created by fanglei on 2018/3/26.
 */
public interface BarrageInfoDao {

    void  insert(BarrageInfo barrageInfo);

    Long  getSeq();

    List<BarrageInfo> getBarrageInfoList(BarrageInfoDto barrageInfoDto);

    Integer getCount(BarrageInfoDto barrageInfoDto);
}
