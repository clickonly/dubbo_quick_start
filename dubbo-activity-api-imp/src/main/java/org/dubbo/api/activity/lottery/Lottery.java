package org.dubbo.api.activity.lottery;

import org.dubbo.pojo.dto.activity.ActivityDto;

public class Lottery {

    private static Lottery singleLottery = null;

    private LotteryStrategy lotteryStrategy;

    private Lottery() {}

    public static Lottery getSingleLottery() {
        if(singleLottery == null){
            synchronized(Lottery.class){
                if(singleLottery == null){
                    singleLottery = new Lottery();
                }
            }
        }
        return singleLottery;
    }

    public String lottery(ActivityDto activityDto, LotteryStrategy lotteryStrategy){
        return lotteryStrategy.lottery(activityDto);
    }

}
