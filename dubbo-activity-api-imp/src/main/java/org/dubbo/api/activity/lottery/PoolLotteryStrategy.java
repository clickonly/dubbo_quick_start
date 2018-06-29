package org.dubbo.api.activity.lottery;

import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.dubbo.api.service.ActivityService;
import org.dubbo.pojo.bean.activity.ActivityMain;
import org.dubbo.pojo.bean.activity.ActivityPrize;
import org.dubbo.pojo.dto.activity.ActivityDto;
import org.dubbo.pojo.lock.RedisLock;
import org.dubbo.pojo.redis.RedisUtil;
import org.dubbo.pojo.utils.Activity;
import org.dubbo.pojo.utils.CommonRedisKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class PoolLotteryStrategy implements LotteryStrategy {

    private final static Logger logger = Logger.getLogger(PoolLotteryStrategy.class);

    @Autowired(required = true)
    private RedisUtil redisUtil;

    @Autowired(required = true)
    private ActivityService activityService;

    @Override
    public String lottery(ActivityDto activityDto) {
        String lotteryResult = null;
        //日志操作
        logger.info("insert into PoolLotteryStrategy lottery method");
        logger.info("in parameters :" + JSONObject.toJSONString(activityDto));
        //抽奖操作
        lotteryResult = doLottery(activityDto);
        return lotteryResult;
    }

    private String doLottery(ActivityDto activityDto) {
        final String key = CommonRedisKey.acticity.LOTTERY_POOL+activityDto.getActivityId();
        if(redisUtil.lGetListSize(key)==0){
            return doInitLottryPool(activityDto);
        }else{
            return String.valueOf(redisUtil.lpop(key));
        }
    }

    private String doInitLottryPool(ActivityDto activityDto) {
        final String key = CommonRedisKey.MyLock.POOL_LOTTERY_STRATEGY_INIT_LOCK+activityDto.getActivityId();
        RedisLock redisLock = new RedisLock(redisUtil,key);
        try {
            while (!redisLock.lock()){
                logger.debug("try lock");
            }
            logger.debug("get lock");
            if(redisUtil.lGetListSize(CommonRedisKey.acticity.LOTTERY_POOL+activityDto.getActivityId())==0){
                initLottryPool(activityDto);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            redisLock.unlock();
        }
        return doLottery(activityDto);
    }

    private void initLottryPool(ActivityDto activityDto){
        long start = System.currentTimeMillis();
        Map<String,Integer> map = getActivityPrizeConfigMap(activityDto);
        String redisListName = CommonRedisKey.acticity.LOTTERY_POOL+activityDto.getActivityId();
        List<String> pool= Activity.getPoolList(map);
        System.out.println(pool);
        Map<String,Integer> resMap= new TreeMap<String,Integer>();
        for(String res : pool){
            if(resMap.get(res.split("_")[0])==null){
                resMap.put(res.split("_")[0], 1);
            }else{
                resMap.put(res.split("_")[0],resMap.get(res.split("_")[0])+1);
            }
        }
        for(String key : map.keySet()){
            if(resMap.get(String.valueOf(key)).intValue() !=(map.get(key)).intValue()){
                logger.info("奖池初始化"+key+"等奖个数异常，重新初始化");
            }
        }
        System.out.println(resMap);
        redisUtil.lSet(redisListName,(String[])pool.toArray(new String[pool.size()]));
        redisUtil.incr(redisListName+"_init_count",1);
        logger.info("本次初始化奖池 耗时："+(System.currentTimeMillis() - start));
    }

    private <T> List<String> getPoolList(Map<T,Integer> poolSize){
        //初始化奖池数量
        List<T> myList = new ArrayList<T>();

        for(T key : poolSize.keySet()){
            Integer length = poolSize.get(key);
            for(int i =0;i<length;i++){
                myList.add(key);
            }
        }
        //随机读取奖项填入堆栈
        Stack<T> mystack = new Stack<T>();
        mystack = randomList(myList);
        //将堆栈数据拼接序号，填入列表
        List<String> poolList = new ArrayList<String>();
        int index = 0;
        while(!mystack.isEmpty()){
            index++;
            T i = mystack.pop();
            poolList.add(i+"_"+index);
        }
        return poolList;
    }

    private <T> Stack<T> randomList(List<T> list){
        Stack<T> stack = new Stack<T>();
        while(list.size()>0){
            int random = (int) (Math.random() * list.size());
            stack.add(list.get(random));
            list.remove(random);
        }
        return stack;
    }

    private Map<String,Integer> getActivityPrizeConfigMap(ActivityDto activityDto){
        Map<String,Integer> prizeConfig = new HashMap<>();
        Integer initCount = (Integer) redisUtil.get(CommonRedisKey.acticity.LOTTERY_POOL+activityDto.getActivityId()+"_init_count");
        initCount = initCount == null?0:initCount;
        ActivityMain indexData = activityService.getIndexData(activityDto);
        List<ActivityPrize> activityPrizes = indexData.getActivityPrizes();
        for(ActivityPrize activityPrize : activityPrizes){
            if(activityPrize.getActivityPrizeConfig().getNum()==null||activityPrize.getActivityPrizeConfig().getNum() > initCount){
                prizeConfig.put(String.valueOf(activityPrize.getId()),activityPrize.getActivityPrizeConfig().getProbability());
            }
        }
        return prizeConfig;
    }

}
