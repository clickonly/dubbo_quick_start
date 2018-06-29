package org.dubbo.api.service;

import org.dubbo.pojo.bean.activity.ActivityAddress;
import org.dubbo.pojo.bean.activity.ActivityMain;
import org.dubbo.pojo.bean.activity.ActivityPrize;
import org.dubbo.pojo.bean.activity.ActivityWinResult;
import org.dubbo.pojo.bean.wx.WxInfo;
import org.dubbo.pojo.dto.activity.*;
import org.dubbo.pojo.enums.ActivityCheckResult;
import org.dubbo.pojo.enums.ResultCode;

import java.util.List;
import java.util.Map;

/**
 * 活动业务处理 2018-1-4
 */
public interface ActivityService {

    /**
     * 获取活动首页数据
     * 1.活动名称
     * 2.活动时间
     * 3.活动规则
     *
     * @return
     */
     ActivityMain getIndexData(ActivityDto activityDto);


    /**
     * 获取活动下的奖品
     * @param activityDto
     * @return
     */
    List<ActivityPrize> getActivityPrize(ActivityDto activityDto);



    ActivityPrize getActivityPrizeById(Long id);


    /**
     * 添加活动参与次数
     * @return
     */
    boolean AddActivityTimes(ActivityDto activityDto);


    /**
     * 获取全部活动的参与人数
     * @param activityDto
     * @return
     */
    ActivityCountDto getAllActivityCount(ActivityDto activityDto);


    /**
     * 获取单个活动的参与人数
     * @param activityDto
     * @return
     */
    ActivityCountDto getActivityCountById(ActivityDto activityDto);



    /**
     * 所有活动点击日志报表导出
     * @param activityLogDto 活动参数DTO对象
     * @return
     */
    String exportUrlClickReport(ActivityLogDto activityLogDto);



    /**
     * 活动日志插入
     * @param activityLogDto
     */
    void requestLogInsert(ActivityLogDto activityLogDto);



    /**
     * 获取微信信息
     * @param weid
     * @return
     */
    WxInfo getWxInfo(String weid);


    String lotteryFromPool(ActivityDto activityDto);

    ResultCode cashPrize(ActivityCashPrizeDto activityCashPrizeDto);


    /**
     * 处理发奖错误数据
     */
    void sendErrorResult();


    /**
     * 发送中间件
     * @param activityWinResult
     * @return
     */
    boolean sendTransmissionMiddleware(ActivityWinResult activityWinResult);




    ActivityMain getActivityMainById(Long id);

    ActivityCheckResult auction(ActivityAuctionDto auctionDto);

    Map<String,Integer> getPrizeSurplus(ActivityDto activityDto);


    /**
     * 获取收货地址
     * @param activityAddress
     * @return
     */
    ActivityAddress getActivityAddress(ActivityAddress activityAddress);


    /**
     * 保存收货地址
     * @param activityAddress
     */
    boolean  inserActivityAddress(ActivityAddress activityAddress);


    /**
     * 获取要启动定时任务的活动
     * @return
     */
    List<ActivityMain>  getTaskActivityMain();


}
