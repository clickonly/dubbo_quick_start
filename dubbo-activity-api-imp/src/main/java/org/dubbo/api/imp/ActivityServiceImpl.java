package org.dubbo.api.imp;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;

import org.dubbo.api.activity.lottery.Lottery;
import org.dubbo.api.activity.lottery.PoolLotteryStrategy;
import org.dubbo.api.dao.*;
import org.dubbo.api.service.*;
import org.dubbo.pojo.base.BaseResponse;
import org.dubbo.pojo.bean.activity.*;
import org.dubbo.pojo.bean.wx.WxInfo;
import org.dubbo.pojo.dto.activity.*;
import org.dubbo.pojo.enums.ActivityCheckResult;
import org.dubbo.pojo.enums.ActivityType;
import org.dubbo.pojo.enums.ContainSubactivityStatus;
import org.dubbo.pojo.enums.ResultCode;
import org.dubbo.pojo.lock.RedisLock;
import org.dubbo.pojo.redis.RedisUtil;
import org.dubbo.pojo.utils.CommonRedisKey;
import org.dubbo.pojo.utils.CsvUtil;
import org.dubbo.pojo.utils.FTPUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by jiangbin on 2018/1/4.
 */
@Service("activityService")
public class ActivityServiceImpl implements ActivityService {

    private static final Logger logger = Logger.getLogger(ActivityServiceImpl.class);

    @Autowired
    private PoolLotteryStrategy poolLotteryStrategy;

    @Autowired(required = false)
    private ActivityMainDao activityMainDao;

    @Autowired(required = false)
    private SendActivityResultService sendActivityResultService;

    @Autowired(required = false)
    private ActivityPrizeDao activityPrizeDao;

    @Autowired(required = false)
    private RedisUtil redisUtil;

    @Autowired(required = false)
    CheckActivityRuleService checkActivityRuleService;

    @Autowired(required = false)
    ActivityLogDao activityLogDao;

    @Autowired(required = false)
    BarrageInfoDao barrageInfoDao;

    @Autowired(required = false)
    ActivityGiveUpDao activityGiveUpDao;

    @Autowired(required = false)
    WxInfoDao wxInfoDao;

    @Autowired
    private ActivityWinResultDao activityWinResultDao;

    @Autowired(required = false)
    private UserIntegralService userIntegralService;

    @Autowired(required = false)
    private UserService userService;

    @Autowired
    private ActivityAddressDao activityAddressDao;



    /**
     * 获取活动首页数据
     * 1.活动名称
     * 2.活动时间
     * 3.活动规则
     *
     * @return
     */
    @Override
    public ActivityMain getIndexData(ActivityDto activityDto) {
        logger.info("into ActivityServiceImp getIndexData method");
        ActivityMain activityMain = null;
        try {
            activityMain = (ActivityMain) redisUtil.get(CommonRedisKey.acticity.ACTIVITY_MAIN + activityDto.getActivityId());
            if (activityMain == null) {
                activityMain = activityMainDao.getActivityInfo(activityDto.getActivityId());
                if (!StringUtils.isEmpty(activityMain.getCofigJson())) {
                    //  activityMain.setActivityConfigJson(JSONObject.parseObject(activityMain.getCofigJson(), ActivityCheckJson.class));
                    //判断是否包含子活动
                    if (!StringUtils.isEmpty(activityMain.getActivityConfigJson().getIsContainSubactivity()) &&
                            ContainSubactivityStatus.IS_Contain.getCode().equals(activityMain.getActivityConfigJson().getIsContainSubactivity())) {
                        //包含子活动情况
                        List<ActivityMain> activityMainList = activityMainDao.getSubactivityList(activityMain.getId());
                        ActivityDto subactivityActivityDto=null;
                        for (ActivityMain subactivity : activityMainList) {
                            subactivityActivityDto =new ActivityDto();
                            subactivityActivityDto.setActivityId(subactivity.getId());
                            subactivity.setActivityPrizes(getActivityPrize(subactivityActivityDto));
                            redisUtil.set(CommonRedisKey.acticity.ACTIVITY_MAIN + subactivity.getId(), subactivity, CommonRedisKey.acticity.ExpiryTime);
                        }
                        activityMain.setSubactivityList(activityMainList);
                    } else {
                        activityMain.setActivityPrizes(getActivityPrize(activityDto));
                    }
                }
                redisUtil.set(CommonRedisKey.acticity.ACTIVITY_MAIN + activityDto.getActivityId(), activityMain, CommonRedisKey.acticity.ExpiryTime);
            }
        } catch (Exception e) {
            logger.error("ActivityServiceImp getIndexData error", e);
        }
        return activityMain;
    }


    @Override
    public ActivityPrize getActivityPrizeById(Long id) {
        ActivityPrize activityPrize = (ActivityPrize) redisUtil.get(CommonRedisKey.acticity.ACTIVITY_PRIZE_CONFIG + id);
        if (activityPrize == null) {
            activityPrize = activityPrizeDao.selectByPrimaryKey(id);
            redisUtil.set(CommonRedisKey.acticity.ACTIVITY_PRIZE_CONFIG + activityPrize.getId(),activityPrize,CommonRedisKey.acticity.ExpiryTime);
        }
        return activityPrize;
    }

    @Override
    public ActivityMain getActivityMainById(Long id) {
        ActivityMain activityMain = (ActivityMain) redisUtil.get(CommonRedisKey.acticity.ACTIVITY_MAIN +id);
        if (activityMain == null) {
            activityMain= activityMainDao.getActivityInfo(id);
        }
        return activityMain;
    }

    @Override
    public ActivityCheckResult auction(ActivityAuctionDto activityAuctionDto) {
        ActivityCheckResult activityCheckResult = ActivityCheckResult.SUCCESS;
        activityAuctionDto.setTimestamp(String.valueOf(System.currentTimeMillis()));
//        redisUtil.hset(CommonRedisKey.Auction.AUCTION_OFFER_RECORD,activityAuctionDto.getUnionId(),activityAuctionDto);
        //校验一 ：用户出价与最高价
        long hlen = redisUtil.hlen(CommonRedisKey.Auction.AUCTION_OFFER_RECORD+activityAuctionDto.getPrizeId());
        if(hlen > 0){
            ActivityAuctionDto result = (ActivityAuctionDto) redisUtil.hget(CommonRedisKey.Auction.AUCTION_OFFER_RECORD+activityAuctionDto.getPrizeId(),String.valueOf(hlen));
            BigDecimal price = result.getPrice();
            if(price.compareTo(activityAuctionDto.getPrice()) >= 0){
                activityCheckResult = ActivityCheckResult.OFFER_LESS_MAX;
            }
        }
        //校验二 ：用户积分与出价积分
        if(activityCheckResult.getCode().equals("0")){
            Long userIntergralByRedis = userService.getUserIntergralByRedis(activityAuctionDto.getUnionId());
            if(new BigDecimal(userIntergralByRedis).compareTo(activityAuctionDto.getPrice()) < 0){
                activityCheckResult = ActivityCheckResult.NOT_ENOUGH_INTEGRAL;
            }
        }
        //竞价成功
        if(activityCheckResult.getCode().equals("0")){
            //记录用户出价成功记录
            redisUtil.hset(CommonRedisKey.Auction.AUCTION_OFFER_RECORD+activityAuctionDto.getPrizeId(), String.valueOf(redisUtil.hlen(CommonRedisKey.Auction.AUCTION_OFFER_RECORD+activityAuctionDto.getPrizeId())+1),activityAuctionDto);
        }
        //用户所有出价都记录
        activityAuctionDto.setCode(activityCheckResult.getCode());
        activityAuctionDto.setMessage(activityCheckResult.getDesc());
        redisUtil.lpush(CommonRedisKey.Auction.AUCTION_OFFER_ALL_RECORD+activityAuctionDto.getPrizeId(),activityAuctionDto);
        redisUtil.lpush(CommonRedisKey.Auction.AUCTION_OFFER_ALL_RECORD,activityAuctionDto);
        return activityCheckResult;
    }

    @Override
    public Map<String,Integer> getPrizeSurplus(ActivityDto activityDto) {
        ActivityMain indexData = getIndexData(activityDto);
        Object init = redisUtil.get(CommonRedisKey.acticity.ACTIVITY_CASH_PRIZE_IS_INIT + activityDto.getActivityId());
        List<ActivityPrize> activityPrizes = indexData.getActivityPrizes();
        Map<String,Integer> map = new HashMap<>();
        for(ActivityPrize activityPrize : activityPrizes){
            Integer num = activityPrize.getActivityPrizeConfig().getNum();
            if(init == null){
                if(num != null){
                    map.put(String.valueOf(activityPrize.getId()),num);
                }
            }else {
                if(num != null){
                    Long llen = redisUtil.llen(CommonRedisKey.acticity.ACTIVITY_CASH_PRIZE_TICKET + activityPrize.getActivityId() + activityPrize.getId());
                    llen = llen == null?0l:llen;
                    map.put(String.valueOf(activityPrize.getId()), llen.intValue());
                }
            }
        }
        return map;

    }

    /**
     * 获取一个活动所有奖项
     *
     * @param activityDto
     * @return
     */
    @Override
    public List<ActivityPrize> getActivityPrize(ActivityDto activityDto) {
        logger.info("into ActivityServiceImp getActivityPrize method");
        List<ActivityPrize> activityPrizeList = null;
        try {
            activityPrizeList = (List<ActivityPrize>) redisUtil.get(CommonRedisKey.acticity.ACTIVITY_PRIZE + activityDto.getActivityId());
            if (null == activityPrizeList) {
                activityPrizeList = activityPrizeDao.selectByActivityId(activityDto.getActivityId());
                for (ActivityPrize activityPrize : activityPrizeList) {
                    activityPrize.setActivityPrizeConfig(JSONObject.parseObject(activityPrize.getJson(), ActivityPrizeConfig.class));
                    redisUtil.set(CommonRedisKey.acticity.ACTIVITY_PRIZE_CONFIG + activityPrize.getId(),activityPrize,CommonRedisKey.acticity.ExpiryTime);
                }
                redisUtil.set(CommonRedisKey.acticity.ACTIVITY_PRIZE + activityDto.getActivityId(), activityPrizeList, CommonRedisKey.acticity.ExpiryTime);
            }
        } catch (Exception e) {
            logger.error("ActivityServiceImp getActivityPrize error", e);
        }
        return activityPrizeList;
    }


    /**
     * 添加活动参与次数
     *
     * @return
     */
    @Override
    public boolean AddActivityTimes(ActivityDto activityDto) {
        logger.info("into ActivityServiceImp getActivityPrize method");
        boolean flag = false;
        try {
            redisUtil.incr(CommonRedisKey.acticity.ACTIVITY_COUNT + activityDto.getActivityId(), 1);
            redisUtil.incr(CommonRedisKey.acticity.ACTIVITY_UNIONID_COUNT + activityDto.getActivityId() + "_" + activityDto.getUnionId(), 1);
            redisUtil.incr(CommonRedisKey.acticity.ACTIVITY_OPENID_COUNT + activityDto.getActivityId() + "_" + activityDto.getOpenId(), 1);
            ActivityMain activityMain = getIndexData(activityDto);
            if (null != activityMain.getParentId()) {
                redisUtil.incr(CommonRedisKey.acticity.ACTIVITY_COUNT + activityMain.getParentId(), 1);
                redisUtil.incr(CommonRedisKey.acticity.ACTIVITY_UNIONID_COUNT + activityMain.getParentId() + "_" + activityDto.getUnionId(), 1);
                redisUtil.incr(CommonRedisKey.acticity.ACTIVITY_OPENID_COUNT + activityMain.getParentId() + "_" + activityDto.getOpenId(), 1);
            }
            flag = true;
        } catch (Exception e) {
            logger.error("ActivityServiceImp AddActivityTimes error", e);
            flag = false;
        }
        return flag;
    }

    /**
     * 用户抽奖
     * 1.获取本次活动相关配置数据
     * 2.判断用户是否满足各类规范约束
     * 3.抽奖
     * 4.redis中插入抽奖结果
     *
     * @return
     */
    @Override
    public String lotteryFromPool(ActivityDto activityDto) {
        logger.info("into ActivityServiceImp lotteryFromPool method");
        String lottery = "22_1";
        //更新总抽奖次数
        long incr = redisUtil.incr("lottery_total_count" + activityDto.getActivityId(), 1);
        if(incr > 250000){
            lottery = "22_250001";
        }else {
            lottery = Lottery.getSingleLottery().lottery(activityDto, poolLotteryStrategy);
        }
        //每个集团会员最多抽两张七折券
        if(lottery.split("_")[0].equals("26")){
            double hincr = redisUtil.hincr("7_level_count", activityDto.getUnionId(), 1);
            if(hincr > 2){
                lottery = "22_777777";
            }
        }
        lottery = lottery.split("_")[0];
        //写发奖队列
        ActivityWinResult activityWinResult = getActivityWinResultByActivityDto(activityDto);
        activityWinResult.setPrizeId(Long.valueOf(lottery));
        boolean b = sendTransmissionMiddleware(activityWinResult);
        if(!b){
            return "-1";
        }
        redisUtil.hincr(CommonRedisKey.acticity.ACTIVITY_ALL_COUNT+activityDto.getActivityId(),
                activityDto.getUnionId(),1l);
        redisUtil.hincr(CommonRedisKey.acticity.ACTIVITY_EVERY_DAY_ALL_COUNT+activityDto.getActivityId(),
                activityDto.getUnionId(),1l);
        return lottery;
    }

    @Override
    public ResultCode cashPrize(ActivityCashPrizeDto activityCashPrizeDto) {

        boolean isNeedTicket = true;

        //积分校验
        List<ActivityPrize> activityPrizes = getActivityPrize(activityCashPrizeDto);
        for(ActivityPrize activityPrize : activityPrizes){
            if(activityPrize.getId().equals(activityCashPrizeDto.getPrizeId())){
                Long userIntergralByRedis = userService.getUserIntergralByRedis(activityCashPrizeDto.getUnionId());
                if (userIntergralByRedis < activityPrize.getActivityPrizeConfig().getDeductionIntegral()){
                    return ResultCode.NOT_ENOUGH_INTEGRAL;
                }
                if(activityPrize.getActivityPrizeConfig().getNum() == null){
                    isNeedTicket = false;
                }
            }
        }

        Object ticket = redisUtil.lpop(CommonRedisKey.acticity.ACTIVITY_CASH_PRIZE_TICKET+
                activityCashPrizeDto.getActivityId()+activityCashPrizeDto.getPrizeId());

        if(isNeedTicket == false){
            ticket = System.currentTimeMillis();
        }

        //奖项发放完毕或者没有初始化
        if(ticket == null){
            final String key = CommonRedisKey.MyLock.CASH_PRIZE_INIT_LOCK+activityCashPrizeDto.getActivityId();
            RedisLock redisLock = new RedisLock(redisUtil,key);
            //获取初始化锁
            while (!redisLock.lock()){
                logger.debug("try lock" + key);
            }
            try {
                //获取初始化状态
                Object o = redisUtil.get(CommonRedisKey.acticity.ACTIVITY_CASH_PRIZE_IS_INIT + activityCashPrizeDto.getActivityId());
                if (o == null) {
                    initPrize(activityCashPrizeDto);
                } else {
                    long l = redisUtil.lGetListSize(CommonRedisKey.acticity.ACTIVITY_CASH_PRIZE_TICKET +
                            activityCashPrizeDto.getActivityId() + activityCashPrizeDto.getPrizeId());
                    if (l == 0) {
                        return ResultCode.TICKET_NOT_ENOUGH;
                    } else {
                        return cashPrize(activityCashPrizeDto);
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                redisLock.unlock();
            }
            return cashPrize(activityCashPrizeDto);
        }else {
            ActivityWinResult activityWinResult = getActivityWinResultByActivityDto(activityCashPrizeDto);
            activityWinResult.setPrizeId(activityCashPrizeDto.getPrizeId());
            redisUtil.hincr(CommonRedisKey.acticity.ACTIVITY_ALL_COUNT+activityCashPrizeDto.getActivityId(),
                    activityCashPrizeDto.getUnionId(),1l);
            redisUtil.hincr(CommonRedisKey.acticity.ACTIVITY_EVERY_DAY_ALL_COUNT+activityCashPrizeDto.getActivityId(),
                    activityCashPrizeDto.getUnionId(),1l);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String format = sdf.format(System.currentTimeMillis());
            Object o = redisUtil.hget(CommonRedisKey.acticity.ACTIVITY_CASH_PRIZE_RESULT +
                    activityCashPrizeDto.getActivityId() + "_" + activityCashPrizeDto.getPrizeId(),
                    activityCashPrizeDto.getUnionId() + format);
            if(o != null){
                redisUtil.lpush(CommonRedisKey.acticity.ACTIVITY_CASH_PRIZE_TICKET+
                        activityCashPrizeDto.getActivityId()+activityCashPrizeDto.getPrizeId(),ticket);
                return ResultCode.OVER_TIMES;
            }
            redisUtil.hset(CommonRedisKey.acticity.ACTIVITY_CASH_PRIZE_RESULT+activityCashPrizeDto.getActivityId()+"_"+activityCashPrizeDto.getPrizeId(),activityCashPrizeDto.getUnionId()+format,activityWinResult);
            try{
                sendTransmissionMiddleware(activityWinResult);
            }catch (Exception e){
                e.printStackTrace();
                redisUtil.lpush(CommonRedisKey.acticity.ACTIVITY_CASH_PRIZE_TICKET+
                        activityCashPrizeDto.getActivityId()+activityCashPrizeDto.getPrizeId(),ticket);
                return ResultCode.FAIL;
            }
            return ResultCode.SUCCESS;
        }
    }

    private void initPrize(ActivityCashPrizeDto activityCashPrizeDto) {
        Object isInit = redisUtil.get(CommonRedisKey.acticity.ACTIVITY_CASH_PRIZE_IS_INIT + activityCashPrizeDto.getActivityId());
        if(isInit == null){
            redisUtil.set(CommonRedisKey.acticity.ACTIVITY_CASH_PRIZE_IS_INIT + activityCashPrizeDto.getActivityId(),"init");
            ActivityMain indexData = getIndexData(activityCashPrizeDto);
            List<ActivityPrize> activityPrizes = indexData.getActivityPrizes();
            for(ActivityPrize activityPrize : activityPrizes){
                Integer num = activityPrize.getActivityPrizeConfig().getNum();
                if(num!=null){
                    String[] arr = new String[num];
                    for(int i =0;i<num;i++){
                        arr[i] = String.valueOf(i);
                    }
                    redisUtil.lSet(CommonRedisKey.acticity.ACTIVITY_CASH_PRIZE_TICKET+
                            activityPrize.getActivityId()+activityPrize.getId(),arr);
                }
            }
        }
    }

    private ActivityWinResult getActivityWinResultByActivityDto(ActivityDto activityDto){
        ActivityWinResult activityWinResult = new ActivityWinResult();
        activityWinResult.setUnionid(activityDto.getUnionId());
        activityWinResult.setWeid(activityDto.getWeid());
        activityWinResult.setOpenid(activityDto.getOpenId());
        activityWinResult.setWinTime(System.currentTimeMillis());
        activityWinResult.setStatus("0");
        activityWinResult.setActivityId(activityDto.getActivityId());
        return activityWinResult;
    }

    /**
     * 获取全部活动的参与人数
     *
     * @param activityDto
     * @return
     */
    @Override
    public ActivityCountDto getAllActivityCount(ActivityDto activityDto) {
        logger.info("into ActivityServiceImp getAllActivityCount method");
        ActivityCountDto activityCountDto = new ActivityCountDto();
        try {
            ActivityMain activityMain = getIndexData(activityDto);
            if (null != activityMain.getParentId()) {
                //当前活动为子活动 获取主活动数据
                activityDto.setActivityId(activityMain.getParentId());
                ActivityMain activityTopMain = getIndexData(activityDto);
                activityCountDto.setActivityId(activityTopMain.getId());
                activityCountDto.setCount((Integer) redisUtil.get(CommonRedisKey.acticity.ACTIVITY_COUNT + activityTopMain.getId()));
                activityCountDto.setActivityUnionidCount((Integer) redisUtil.get(CommonRedisKey.acticity.ACTIVITY_UNIONID_COUNT + activityTopMain.getId() + "_" + activityDto.getUnionId()));
                activityCountDto.setActivityOpenIdCount((Integer) redisUtil.get(CommonRedisKey.acticity.ACTIVITY_OPENID_COUNT + activityTopMain.getId() + "_" + activityDto.getOpenId()));
                activityCountDto.setActivityCountDtoList(getSubActivityCount(activityTopMain.getSubactivityList(), activityDto));
            } else {
                //当前传入不是子活动ID
                activityCountDto.setActivityId(activityMain.getId());
                activityCountDto.setCount((Integer) redisUtil.get(CommonRedisKey.acticity.ACTIVITY_COUNT + activityMain.getId()));
                activityCountDto.setActivityUnionidCount((Integer) redisUtil.get(CommonRedisKey.acticity.ACTIVITY_UNIONID_COUNT + activityMain.getId() + "_" + activityDto.getUnionId()));
                activityCountDto.setActivityOpenIdCount((Integer) redisUtil.get(CommonRedisKey.acticity.ACTIVITY_OPENID_COUNT + activityMain.getId() + "_" + activityDto.getOpenId()));
                if (null != activityMain.getSubactivityList()) {
                    activityCountDto.setActivityCountDtoList(getSubActivityCount(activityMain.getSubactivityList(), activityDto));
                }
            }
        } catch (Exception e) {
            logger.error("ActivityServiceImp getAllActivityCount error", e);
        }
        return activityCountDto;
    }


    /**
     * 获取子活动的参与人数
     *
     * @param activityMainList
     * @param activityDto
     * @return
     */
    private List<ActivityCountDto> getSubActivityCount(List<ActivityMain> activityMainList, ActivityDto activityDto) {
        List<ActivityCountDto> activityCountDtoList = new ArrayList<>();
        for (ActivityMain activitySmallMain : activityMainList) {
            ActivityCountDto activitySubCountDto = new ActivityCountDto();
            activitySubCountDto.setActivityId(activitySmallMain.getId());
            activitySubCountDto.setCount((Integer) redisUtil.get(CommonRedisKey.acticity.ACTIVITY_COUNT + activitySmallMain.getId()));
            activitySubCountDto.setActivityUnionidCount((Integer) redisUtil.get(CommonRedisKey.acticity.ACTIVITY_UNIONID_COUNT + activitySmallMain.getId() + "_" + activityDto.getUnionId()));
            activitySubCountDto.setActivityOpenIdCount((Integer) redisUtil.get(CommonRedisKey.acticity.ACTIVITY_OPENID_COUNT + activitySmallMain.getId() + "_" + activityDto.getOpenId()));
            activityCountDtoList.add(activitySubCountDto);
        }
        return activityCountDtoList;
    }


    /**
     * 获取单个活动参与次数
     *
     * @param activityDto
     * @return
     */
    @Override
    public ActivityCountDto getActivityCountById(ActivityDto activityDto) {
        logger.info("into ActivityServiceImp getActivityCountById method");
        ActivityCountDto activityCountDto = new ActivityCountDto();
        try {
            activityCountDto.setActivityId(activityDto.getActivityId());
            activityCountDto.setCount((Integer) redisUtil.get(CommonRedisKey.acticity.ACTIVITY_COUNT + activityDto.getActivityId()));
            activityCountDto.setActivityUnionidCount((Integer) redisUtil.get(CommonRedisKey.acticity.ACTIVITY_UNIONID_COUNT + activityDto.getActivityId() + "_" + activityDto.getUnionId()));
            activityCountDto.setActivityOpenIdCount((Integer) redisUtil.get(CommonRedisKey.acticity.ACTIVITY_OPENID_COUNT + activityDto.getActivityId() + "_" + activityDto.getOpenId()));
        } catch (Exception e) {
            logger.error("ActivityServiceImp getActivityCountById error", e);
        }
        return activityCountDto;
    }

    /**
     * 活动用户访问日志记录导出
     *
     * @param activityLogDto
     * @return
     */
    @Override
    public String exportUrlClickReport(final ActivityLogDto activityLogDto) {
        final String key = "exportUrlClickReport" + activityLogDto.getActivityId();
        final String fileName = key + System.currentTimeMillis() / 1000 / 60 / 60 + ".csv";
        final String returnUrl = FTPUtils.DOWLOAD_URL + "export/" + key + "/" + fileName;
        //处理jar包启动时
        String classPath = this.getClass().getProtectionDomain().getCodeSource().getLocation().getFile();
        int firstIndex = classPath.lastIndexOf(System.getProperty("path.separator")) + 1;
        int lastIndex = classPath.lastIndexOf(File.separator) + 1;
        classPath = classPath.substring(firstIndex, lastIndex);
        //本地调试时
//        String classPath = Class.class.getClass().getResource("/").getPath();
        logger.info("====================================================" + classPath);
        final String fileDirPath = classPath + "/report/" + File.separator + key + File.separator;
        new Thread(new Runnable() {
            @Override
            public void run() {
                //加载的对象属性
                String[] props = new String[]{"url", "openId", "addTime"};
                //标题
                LinkedHashMap headSortMap = new LinkedHashMap<>();
                headSortMap.put("1", "点击链接");
                headSortMap.put("2", "微信ID");
                headSortMap.put("3", "点击时间");
                //文件路径
                File file = null;
                if (redisUtil.hget(key, fileName) == null) {//redis中是否有生成记录
                    redisUtil.hset(key, fileName, "0", 3600l);
                    CsvUtil.writeHead(headSortMap, fileDirPath, fileName);
                    //数据总条数
                    Integer size = activityLogDao.getUserUrlClickListSize(activityLogDto);
                    int pageSize = 1000;
                    //分页每次10000数据
                    for (int i = 0; i < size / pageSize + 1; i++) {
                        activityLogDto.setStart(pageSize * i);
                        activityLogDto.setEnd(pageSize * (i + 1) + 1);
                        List<ActivityWebLog> userUrlClickList = activityLogDao.getUserUrlClickList(activityLogDto);
                        file = CsvUtil.writeContext(userUrlClickList, props, fileDirPath, fileName);
                    }
                    try {
                        FTPUtils.upload(FTPUtils.connect("/web/export/" + key + "/"), file);
                        redisUtil.hset(key, fileName, "1", 3600l);
                    } catch (Exception e) {
                        redisUtil.setRemove(key);
                        e.printStackTrace();
                    } finally {
                        if (!"1".equals(redisUtil.hget(key, fileName))) {
                            redisUtil.setRemove(key);
                        }
                        file.delete();
                    }
                }
            }
        }).start();

        return returnUrl;
    }


    /**
     * 活动日志插入
     * (id,activity_id,openid,unionid,brand,add_time,menu_type,URL)
     *
     * @param activityLogDto
     */
    @Override
    public void requestLogInsert(ActivityLogDto activityLogDto) {
        try {
            activityLogDao.logInsert(activityLogDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void intAwardList() {

    }

    public static void main(String args[]) {
//        System.out.println(System.getProperty("user.dir"));
//        String jarFilePath =
//        System.out.println((new File("")).getAbsolutePath());

    }


    @Override
    public WxInfo getWxInfo(String weid) {
        return wxInfoDao.getWxInfo(weid);
    }


    @Override
    public void sendErrorResult() {
        logger.info("into sendErrorResult method");
        List<ActivityWinResult> activityWinResultList=activityWinResultDao.getErrorActivityWinResultList();
        for (ActivityWinResult activityWinResult:activityWinResultList){
           // redisUtil.lSet(CommonRedisKey.acticity.LOTTERY_LIST, activityWinResult);
            sendActivityResultService.insertActivityWinResult(activityWinResult);
        }
    }




    @Override
    public boolean sendTransmissionMiddleware(ActivityWinResult activityWinResult) {
        logger.info("into sendTransmissionMiddleware method");
        boolean flag = false;
        try {
            Long integral = 0L;
            ActivityMain activityMain = this.getActivityMainById(activityWinResult.getActivityId());
            if (null != activityMain.getActivityConfigJson() &&
                    !ActivityType.EXCHANGE.getCode().equals(activityMain.getActivityType()) &&
                    !ActivityType.BID_PRICE.getCode().equals(activityMain.getActivityType())) {
                if (null != activityMain.getActivityConfigJson().getDeductionIntegral()) {
                    integral = activityMain.getActivityConfigJson().getDeductionIntegral();
                }
            }
            if (ActivityType.EXCHANGE.getCode().equals(activityMain.getActivityType())) {
                ActivityPrize activityPrize=this.getActivityPrizeById(activityWinResult.getPrizeId());
                if (null != activityPrize.getActivityPrizeConfig()) {
                    integral=activityPrize.getActivityPrizeConfig().getDeductionIntegral();
                }
            }
            if (integral > 0) {
                SendIntergralDto sendIntergralDto = new SendIntergralDto();
                sendIntergralDto.setActivityId(activityWinResult.getActivityId());
                sendIntergralDto.setAddTime(activityWinResult.getWinTime());
                sendIntergralDto.setIntegral(integral * -1);
                sendIntergralDto.setOpenid(activityWinResult.getOpenid());
                sendIntergralDto.setUnionid(activityWinResult.getUnionid());
                activityWinResult.setIntegral(integral * -1);
                if (userIntegralService.handIntegral(sendIntergralDto)) {
                    sendActivityResultService.sendRedisActivityWinResult(activityWinResult);
                    flag = true;
                } else {
                    flag = false;
                }
            } else {
                flag = false;
            }

        } catch (Exception e) {
            flag = false;
            logger.error(" sendTransmissionMiddleware method error", e);

        }
        return flag;
    }



    @Override
    public ActivityAddress getActivityAddress(ActivityAddress activityAddress) {
        logger.info("into getActivityAddress method");
        //获取当前奖项的收货地址
        ActivityAddress activityMainAddress = activityAddressDao.getActivityAddress(activityAddress);
        if (null == activityMainAddress) {
            activityAddress.setPrizeId(null);
            activityMainAddress = activityAddressDao.getActivityAddress(activityAddress);
            if (null == activityMainAddress) {
                activityMainAddress = activityAddressDao.getDefaultActivityAddress(activityAddress);
            }
        }
        return activityMainAddress;
    }

    @Override
    public boolean inserActivityAddress(ActivityAddress activityAddress) {
        activityAddressDao.delActivityAddress(activityAddress);
        activityAddress.setId(activityAddressDao.getSeq());
        activityAddressDao.inserActivityAddress(activityAddress);
        return true;
    }

    @Override
    public List<ActivityMain> getTaskActivityMain() {
        return activityMainDao.getTaskActivityMain();
    }
}
