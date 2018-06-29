package org.dubbo.api.activity.lottery;

import org.dubbo.pojo.dto.activity.ActivityDto;

public interface LotteryStrategy {

    String lottery(ActivityDto activityDto);

}
