package org.dubbo.pojo.utils;

/**
 * Created by jiangbin on 2018/1/26.
 */
public class CommonRedisKey {





    public static class userInfo{
        public static final String USER_KEY="_INFO";
        public static final String INTEGRAL_LIST_KEY="send_integral_key";
        public static final String HAND_USER_INTEGRAL_KEY="hand_user_integral_key";
        public static final String USER_INTEGRAL_KEY="_integral";
        public static final String ERROR_INTEGRAL_KEY="send_integral_error_key";
        public static final Long TIME=3600L;

    }


    public static class  goodsBanner{
        public static final String GOODS_BANNER_KEY="goodsBanner";

    }


    public static class goods{
        public static final String ABOUT_GOODS="GoodsAbout_";

    }
    public static class goodsCart{
        public static final String GOODS_CART="_GoodsCart";
        public static final String COUNT="_GOODS_CART_COUNT";

    }

    public static class acticity{
        public static final String COUPON_KEY="coupon_list";//优惠券队列
        public static final String MESSAGE_LIST="message_list";
        public static final String AWARD_LIST="award_list";//活动结果队列
        public static final String LOTTERY_POOL="lottery_pool";//活动奖池
        public static final String SEND_LIST="send_list";//活动消息队列
        public static final String LOTTERY_LIST="lottery_list";//活动发奖队列
        public static final String ACTIVITY_MAIN="activityMain_"; //活动基本缓存
        public static final String ACTIVITY_PRIZE="activityPrize_"; //奖项缓存
        public static final String ACTIVITY_COUNT="activityCount_"; //活动总参与次数
        public static final String ACTIVITY_UNIONID_COUNT="activityUnionidCount_"; //单个人单个活动参与次数
        public static final String ACTIVITY_OPENID_COUNT="activityOpenIdCount_"; //单个人单个活动参与次数
        public static final String ACTIVITY_BIG_RECORD="activityBigRecord_list"; //竞价记录key
        public static final Long  ExpiryTime=10*24*60*60L;//获取时间
        public static final String TRANSMISSIONMIDDLEWARE="transmissionmiddleware"; //中间件处理
        public static final String ACTIVITY_ALL_COUNT="activity_all_count_";
        public static final String ACTIVITY_EVERY_DAY_ALL_COUNT="activity_every_day_all_count_";
        public static final String ACTIVITY_CASH_PRIZE_IS_INIT="activity_cash_prize_is_init";
        public static final String ACTIVITY_CASH_PRIZE_TICKET="activity_cash_prize_ticket";
        public static final String ACTIVITY_CASH_PRIZE_RESULT="activity_cash_prize_result";
        public static final String ACTIVITY_PRIZE_CONFIG="activityPrizeConfig_";//奖项配置

    }

    /**
     * 分布式锁
     */
    public static class MyLock{
        //抽奖奖池锁
        public static final String POOL_LOTTERY_STRATEGY_INIT_LOCK = "POOL_LOTTERY_STRATEGY_INIT_LOCK";
        //兑奖名额初始化锁
        public static final String CASH_PRIZE_INIT_LOCK = "CASH_PRIZE_INIT_LOCK";
    }

    /**
     *  竞价
     */
    public static class Auction{
        //websocket
        public final static String WEBSOCEKT_ONLINE_COUNT = "WEBSOCEKT_ONLINE_COUNT";
        public final static String AUCTION_OFFER_RECORD = "AUCTION_OFFER_RECORD"; //竞价结果
        public final static String AUCTION_OFFER_ALL_RECORD = "AUCTION_OFFER_ALL_RECORD";
        public final static String AUCTION_OFFER_MAX = "AUCTION_OFFER_MAX";

        public final static String AUCTION_OFFER_LIST_SEQ = "AUCTION_OFFER_LIST_SEQ";



    }


}
