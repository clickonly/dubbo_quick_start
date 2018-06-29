package org.dubbo.pojo.lock;

import com.alibaba.fastjson.JSONObject;
import org.dubbo.pojo.redis.RedisUtil;

public class RedisLock extends MyLock implements Lock {

    private RedisUtil redisUtil;

    public RedisLock(RedisUtil redisUtil,String lockName){
        super(lockName);
        this.redisUtil = redisUtil;
    }

    @Override
    public boolean lock() {
        return redisUtil.setnx(this.getLockName(), JSONObject.toJSONString(this));
    }

    @Override
    public void unlock() {
        redisUtil.del(this.getLockName());
    }
}
