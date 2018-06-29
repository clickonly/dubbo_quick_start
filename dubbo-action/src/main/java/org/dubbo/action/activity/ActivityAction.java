package org.dubbo.action.activity;

import org.apache.log4j.Logger;
import org.dubbo.api.service.ActivityService;
import org.dubbo.api.service.SendActivityResultService;
import org.dubbo.api.service.UserService;
import org.dubbo.pojo.base.BaseResponse;
import org.dubbo.pojo.bean.activity.ActivityMain;
import org.dubbo.pojo.bean.activity.ActivityWinResult;
import org.dubbo.pojo.bean.user.WxFans;
import org.dubbo.pojo.dto.activity.ActivityAuctionDto;
import org.dubbo.pojo.dto.activity.ActivityCashPrizeDto;
import org.dubbo.pojo.dto.activity.ActivityDto;
import org.dubbo.pojo.dto.activity.PrizeRecordDto;
import org.dubbo.pojo.enums.ResultCode;
import org.dubbo.pojo.redis.RedisUtil;
import org.dubbo.pojo.utils.CommonRedisKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/active")
public class ActivityAction {

    private static final Logger logger = Logger.getLogger(ActivityAction.class);

    @Autowired(required = false)
    private ActivityService activityService;

    @Autowired(required = false)
    private UserService userService;

    @Autowired(required = true)
    private RedisUtil redisUtil;

    @Autowired(required = false)
    private SendActivityResultService sendActivityResultService;

    /**
     * 获取活动首页数据
     * 用户剩余抽奖次数
     * 用户是否关注
     * @param activityDto
     * @return
     */
    @PostMapping(value = "/getIndexData")
    public BaseResponse getIndexData(ActivityDto activityDto){
        BaseResponse baseResponse = new BaseResponse();
        Map<String,Object> map = new HashMap<String,Object>();
        try{
            //获取活动首页数据
            ActivityMain indexData = activityService.getIndexData(activityDto);
            //获取用户是否关注信息
            WxFans wxFans = userService.getWxFans(activityDto.getOpenId());
            map.put("indexData",indexData);
            map.put("isSubscribe",wxFans==null?0:wxFans.getSubscribe());
            baseResponse.setData(map);
            baseResponse.setMessage(ResultCode.SUCCESS.getDesc());
            baseResponse.setCode(ResultCode.SUCCESS.getCode());
        }catch (Exception e){
            baseResponse.setMessage(ResultCode.FAIL.getDesc());
            baseResponse.setCode(ResultCode.FAIL.getCode());
            e.printStackTrace();
        }
        return baseResponse;
    }

    /**
     * 抽奖接口
     * @param activityDto
     * @return
     */
    @PostMapping(value = "/lottery")
    public BaseResponse lotteryPonitCut(ActivityDto activityDto){
        BaseResponse baseResponse = new BaseResponse();
        String lottery = activityService.lotteryFromPool(activityDto);
        if("-1".equals(lottery)){
            baseResponse.setMessage(ResultCode.FAIL.getDesc());
            baseResponse.setCode(ResultCode.FAIL.getCode());
            baseResponse.setData(lottery);
            return baseResponse;
        }
        //判断抽奖结果
        baseResponse.setMessage(ResultCode.SUCCESS.getDesc());
        baseResponse.setCode(ResultCode.SUCCESS.getCode());
        baseResponse.setData(lottery);
        return baseResponse;
    }

    /**
     * 兑奖接口
     * @param activityCashPrizeDto
     * @return
     */
    @PostMapping(value = "/cashPrize")
    public BaseResponse cashPrizePonitCut(ActivityCashPrizeDto activityCashPrizeDto){
        BaseResponse baseResponse = new BaseResponse();
        ResultCode resultCode = activityService.cashPrize(activityCashPrizeDto);
        baseResponse.setCode(resultCode.getCode());
        baseResponse.setMessage(resultCode.getDesc());
        return baseResponse;
    }

    @RequestMapping(value = "/getPrizeSurplus")
    public BaseResponse getPrizeSurplusPonitCut(ActivityDto activityDto){
        BaseResponse baseResponse = new BaseResponse();
        try{
            Map<String, Integer> prizeSurplus = activityService.getPrizeSurplus(activityDto);
            baseResponse.setData(prizeSurplus);
            baseResponse.setMessage(ResultCode.SUCCESS.getDesc());
            baseResponse.setCode(ResultCode.SUCCESS.getCode());
        }catch (Exception e){
            e.printStackTrace();
            baseResponse.setData(false);
            baseResponse.setMessage(ResultCode.FAIL.getDesc());
            baseResponse.setCode(ResultCode.FAIL.getCode());
        }
        return  baseResponse;
    }

    /**
     * 获奖记录
     * @param activityDto
     * @return
     */
    @PostMapping(value = "/getPrizeRecord")
    public BaseResponse getPrizeRecordPonitCut(ActivityDto activityDto){
        BaseResponse baseResponse = new BaseResponse();
        List<ActivityWinResult> activityWinResultList = sendActivityResultService.getActivityWinResultList(activityDto);
        baseResponse.setData(activityWinResultList);
        baseResponse.setCode(ResultCode.SUCCESS.getCode());
        baseResponse.setMessage(ResultCode.SUCCESS.getDesc());
        return baseResponse;
    }


    /**
     * 获奖记录
     * @param prizeRecordDto
     * @return
     */
    @PostMapping(value = "/getActivityWinResultListByActivityIdList")
    public BaseResponse getActivityWinResultListByActivityIdList(PrizeRecordDto prizeRecordDto){
        BaseResponse baseResponse = new BaseResponse();
        List<ActivityWinResult> activityWinResultList = sendActivityResultService.getActivityWinResultListByActivityIdList(prizeRecordDto);
        baseResponse.setData(activityWinResultList);
        baseResponse.setCode(ResultCode.SUCCESS.getCode());
        baseResponse.setMessage(ResultCode.SUCCESS.getDesc());
        return baseResponse;
    }


    @PostMapping(value = "/getPrizeRecordByActivityType")
    public BaseResponse getPrizeRecordByActivityTypePonitCut(ActivityDto activityDto){
        BaseResponse baseResponse = new BaseResponse();
        List<ActivityWinResult> activityWinResultList = sendActivityResultService.getPrizeRecordByActivityType(activityDto);
        baseResponse.setData(activityWinResultList);
        baseResponse.setCode(ResultCode.SUCCESS.getCode());
        baseResponse.setMessage(ResultCode.SUCCESS.getDesc());
        return baseResponse;
    }

    @PostMapping(value = "/{length}/getAuctionTopRecord")
    public BaseResponse getAuctionTopRecordPointCut(ActivityAuctionDto activityAuctionDto,
                                                    @PathVariable(value = "length",required = true)int length){
        String[] prizeIds = activityAuctionDto.getPrizeIds().split(",");
        Map<String,Object> resultMap = new HashMap<>();
        for(String prizeId : prizeIds){
            String key = CommonRedisKey.Auction.AUCTION_OFFER_RECORD + prizeId;
            Long max = redisUtil.hlen(key);
            List<Object> keys = new ArrayList<>();
            for(int i =0;i<length&&i<max;i++){
                keys.add(max-i+"");
            }
            List<Object> objs = redisUtil.hmget(key, keys);
            resultMap.put(prizeId,objs);
        }
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(resultMap);
        baseResponse.setCode(ResultCode.SUCCESS.getCode());
        baseResponse.setMessage(ResultCode.SUCCESS.getDesc());
        return baseResponse;
    }


    /**
     * 处理竞价记录
     * @param activityDto
     * @return
     */
    @PostMapping(value = "/handAuctionResult")
    public BaseResponse handAuctionResult(ActivityDto activityDto){
        BaseResponse baseResponse = new BaseResponse();
        sendActivityResultService.handAuctionResultByAction(activityDto);
        baseResponse.setCode(ResultCode.SUCCESS.getCode());
        baseResponse.setMessage(ResultCode.SUCCESS.getDesc());
        return baseResponse;
    }
}
