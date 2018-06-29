package org.dubbo.api.imp;

import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.dubbo.api.dao.ActivityMainDao;
import org.dubbo.api.dao.CheckActivityRuleDao;
import org.dubbo.api.service.CheckActivityRuleService;
import org.dubbo.pojo.bean.user.WxFans;
import org.dubbo.pojo.dto.activity.ActivityCheckJson;
import org.dubbo.pojo.dto.activity.ActivityDto;
import org.dubbo.pojo.enums.ActivityCheckResult;
import org.dubbo.pojo.redis.RedisUtil;
import org.dubbo.pojo.utils.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class CheckActivityRuleServiceImpl implements CheckActivityRuleService {

    private static final Logger logger = Logger.getLogger(CheckActivityRuleServiceImpl.class);

    @Autowired(required = false)
    private CheckActivityRuleDao checkActivityRuleDao;

    @Autowired(required = false)
    private ActivityMainDao activityMainDao;

    /**
     * 校验用户是否满足活动规则
     *
     * @return code 返回不满足活动规则的枚举code
     */
    @Override
    public ActivityCheckResult checkActivityRule(ActivityDto activityDto, RedisUtil redisUtil) {
        /**
         * 1.取数据库配置信息  method  相关参数列表
         * 2.反射当前类对应method参数值
         * 3.循环调用
         */
        ActivityCheckResult result = ActivityCheckResult.SUCCESS;
        String activityConfig="";
     //   String activityConfig = activityMainDao.getActivityConfig(activityDto);
        ActivityCheckJson activityCheckJson = JSONObject.parseObject(activityConfig, ActivityCheckJson.class);
        //
        Integer fansCount = 0;
        //查询wx_fans表中单个openid的记录条数
        fansCount = isUserFollowed(activityDto);
        if(fansCount == 0){//用户未关注
            logger.debug("用户未关注");
            return ActivityCheckResult.NOT_FOLLOW;
        }else if(fansCount > 1){//用户关注信息异常
            logger.debug("用户关注信息异常,关注信息条数为"+fansCount);
            logger.debug(activityDto.toString());
            return ActivityCheckResult.USER_EXCEPTION;
        }else if(fansCount == 1){
            WxFans wxFan = checkActivityRuleDao.getWxFan(activityDto);
            if (null==wxFan){
                return ActivityCheckResult.NOT_FOLLOW;
            }
            if("0".equals(wxFan.getSubscribe())){
                return ActivityCheckResult.NOT_FOLLOW;
            }
        }


        if("1".equals(activityCheckJson.getIsIntegralOpen())) {//活动参与积分限制
            if (!isUserIntegralEnough(activityDto, activityCheckJson.getIntegral())) {
                return ActivityCheckResult.NOT_ENOUGH_INTEGRAL;
            }
        }

        if("1".equals(activityCheckJson.getIsEveryDayCountOpen())){//每天次数限制
            if (!isLotteryTimesEveryDayLimit(activityDto,redisUtil,activityCheckJson)) {
                return ActivityCheckResult.TODAY_OVER_LIMIT;
            }
        }

        if("1".equals(activityCheckJson.getIsAllCountOpen())){//总次数限制
            if (!isLotteryTimesAllLimit(activityDto,redisUtil,activityCheckJson)) {
                return ActivityCheckResult.ALL_OVER_LIMIT;
            }
        }

     /**   if("1".equals(activityCheckJson.getIsEveryDayTimeOpen())){//每天时间限制
            if (!isLotteryEveryDayStartLimit(activityDto,redisUtil,activityCheckJson)) {
                return ActivityCheckResult.TODAT_NOT_START;
            }else if(!isLotteryEveryDayEndLimit(activityDto,redisUtil,activityCheckJson)){
                return ActivityCheckResult.TODAT_END;
            }
        }**/

        if("1".equals(activityCheckJson.getIsCardLevelOpen())){//卡等级限制
            if (!isCardLevelOpen(activityDto,redisUtil,activityCheckJson)) {
                return ActivityCheckResult.USER_LEVEL_NOT_ENOUGH;
            }
        }

        if("1".equals(activityCheckJson.getIsUnionidsOpen())){//指定用户限制
            if (!isUnionidsOpen(activityDto,redisUtil,activityCheckJson)) {
                return ActivityCheckResult.NOT_ALLOW;
            }
        }

        /*
        if("1".equals(activityCheckJson.getIsDeductionIntegralOpen())){//活动参与扣除积分
            if (!isDeductionIntegral(activityDto,redisUtil,activityCheckJson)) {
                return ActivityCheckResult.NOT_ENOUGH_INTEGRAL;
            }
        }
        */


        return result;
    }

    private boolean isDeductionIntegral(ActivityDto activityDto, RedisUtil redisUtil, ActivityCheckJson activityCheckJson) {
        return false;
    }

    private boolean isUnionidsOpen(ActivityDto activityDto, RedisUtil redisUtil, ActivityCheckJson activityCheckJson) {
        return false;
    }

    private boolean isCardLevelOpen(ActivityDto activityDto, RedisUtil redisUtil, ActivityCheckJson activityCheckJson) {
        return false;
    }

    private boolean isLotteryEveryDayStartLimit(ActivityDto activityDto, RedisUtil redisUtil, ActivityCheckJson activityCheckJson) {
        return false;
    }

    private boolean isLotteryEveryDayEndLimit(ActivityDto activityDto, RedisUtil redisUtil, ActivityCheckJson activityCheckJson) {
        return false;
    }


    //根据openId获取用户关注信息
    private Integer isUserFollowed(ActivityDto activityDto){
        return  checkActivityRuleDao.getWxFansResult(activityDto);
    }

    //根据unionid获取用户积分
    private boolean isUserIntegralEnough(ActivityDto activityDto,Integer integralLimit){
        boolean result = false;
        final Integer wxIntegral = checkActivityRuleDao.getWxIntegral(activityDto);
        result = wxIntegral > integralLimit ;
        return result;
    }

    //判断用户当日抽奖次数
    private boolean isLotteryTimesEveryDayLimit(ActivityDto activityDto,RedisUtil redisUtil,ActivityCheckJson activityCheckJson){
        boolean result = false;
        Object object = redisUtil.get(Activity.getPoolKey(activityDto)+"_"+Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        if(object != null){
            Integer times = (Integer) object ;
            result = times < activityCheckJson.getEveryDayCount();
        }else {
            result = true;
        }
        return result;
    }

    //判断用户总抽奖次数
    private boolean isLotteryTimesAllLimit(ActivityDto activityDto,RedisUtil redisUtil,ActivityCheckJson activityCheckJson){
        boolean result = false;
        Object object = redisUtil.get(Activity.getPoolKey(activityDto)+"_all");
        if(object != null){
            Integer times = (Integer) object ;
            result = times < activityCheckJson.getAllCount();
        }else {
            result = true;
        }
        return result;
    }





}
