package org.dubbo.api.imp;

import org.apache.log4j.Logger;
import org.dubbo.api.dao.ActivityBidRecordDao;
import org.dubbo.api.service.ActivityBidRecordService;
import org.dubbo.pojo.base.PageResponse;
import org.dubbo.pojo.bean.activity.ActivityBidRecord;
import org.dubbo.pojo.dto.activity.ActivityAuctionDto;
import org.dubbo.pojo.redis.RedisUtil;
import org.dubbo.pojo.utils.CommonRedisKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fanglei on 2018/5/29.
 */
@Service("activityBidRecordService")
public class ActivityBidRecordServiceImpl implements ActivityBidRecordService {


    private static final Logger logger = Logger.getLogger(ActivityBidRecordService.class);


    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private ActivityBidRecordDao activityBidRecordDao;

    @Override
    public boolean sendActivityBidRecordToRedis(ActivityBidRecord activityBidRecord) {
        logger.info("into ActivityBidRecordService sendActivityBidRecordToRedis method");
        boolean flag;
        try {
            redisUtil.lSet(CommonRedisKey.acticity.ACTIVITY_BIG_RECORD, activityBidRecord);
            flag = true;
        } catch (Exception e) {
            flag = false;
            logger.error("ActivityBidRecordService sendActivityBidRecordToRedis error", e);
        }
        return flag;
    }

    @Override
    public boolean insertActivityBidRecord(ActivityAuctionDto activityAuctionDto) {
        logger.info("into ActivityBidRecordService insertActivityBidRecord method");
        boolean flag;
        try {
            activityAuctionDto.setId(activityBidRecordDao.getSeq());
            activityBidRecordDao.insert(activityAuctionDto);
            flag = true;
        } catch (Exception e) {
            flag = false;
            logger.error("ActivityBidRecordService insertActivityBidRecord error", e);
        }
        return flag;
    }

    @Override
    public PageResponse<List<ActivityAuctionDto>> getActivityBidRecordList(ActivityAuctionDto  activityAuctionDto) {
        logger.info("into ActivityBidRecordService getActivityBidRecordList method");
        PageResponse pageResponse = new PageResponse();
        pageResponse.setCount(activityBidRecordDao.getActivityBidRecordCount(activityAuctionDto));
        pageResponse.setData(activityBidRecordDao.getActivityBidRecordList(activityAuctionDto));
        return pageResponse;
    }
}
