package org.dubbo.api.activity.lottery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LotteryStrategyFactory {

    @Autowired
    private static PoolLotteryStrategy poolLotteryStrategy;

    public LotteryStrategyFactory(PoolLotteryStrategy poolLotteryStrategy){
        this.poolLotteryStrategy = poolLotteryStrategy;
    }

    public static PoolLotteryStrategy getPoolLotteryStrategy() {
        return poolLotteryStrategy;
    }
}
