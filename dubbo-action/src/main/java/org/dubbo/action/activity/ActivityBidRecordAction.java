package org.dubbo.action.activity;

import org.apache.log4j.Logger;
import org.dubbo.api.service.ActivityBidRecordService;
import org.dubbo.pojo.base.PageResponse;
import org.dubbo.pojo.bean.activity.ActivityBidRecord;
import org.dubbo.pojo.dto.activity.ActivityAuctionDto;
import org.dubbo.pojo.enums.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fanglei on 2018/6/2.
 */

@RestController
@RequestMapping("/activityBidRecord")
public class ActivityBidRecordAction {
    private static final Logger logger = Logger.getLogger(ActivityBidRecordAction.class);



    @Autowired(required = false)
    private ActivityBidRecordService activityBidRecordService;

    @PostMapping(value = "/getActivityBidRecordList")
    public PageResponse getActivityBidRecordList(ActivityAuctionDto activityAuctionDto){
        logger.info("into ActivityAddressAction getActivityAddress method");
        PageResponse pageResponse=activityBidRecordService.getActivityBidRecordList(activityAuctionDto);
        if (pageResponse!=null){
            pageResponse.setMessage(ResultCode.SUCCESS.getDesc());
            pageResponse.setCode(ResultCode.SUCCESS.getCode());
        }else {
            pageResponse=new PageResponse();
            pageResponse.setMessage(ResultCode.FAIL.getDesc());
            pageResponse.setCode(ResultCode.FAIL.getCode());
        }

        return pageResponse;
    }

}
