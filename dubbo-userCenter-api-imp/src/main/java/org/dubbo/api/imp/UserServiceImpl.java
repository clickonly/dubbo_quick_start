package org.dubbo.api.imp;

import com.alibaba.druid.util.StringUtils;
import org.apache.log4j.Logger;
import org.dubbo.api.dao.BojunDao;
import org.dubbo.api.dao.ClientVipDao;
import org.dubbo.api.dao.SmsMessageCheckDao;
import org.dubbo.api.dao.WxFansDao;
import org.dubbo.api.service.UserService;
import org.dubbo.pojo.bean.user.SmsMessageCheck;
import org.dubbo.pojo.bean.user.UserInfo;
import org.dubbo.pojo.bean.user.WxFans;
import org.dubbo.pojo.redis.RedisUtil;
import org.dubbo.pojo.utils.CommonRedisKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by fanglei on 2017/12/13.
 */

@Service("userService")
public class UserServiceImpl implements UserService {


    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private BojunDao bojunDao;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private SmsMessageCheckDao smsMessageCheckDao;

    @Autowired
    private WxFansDao wxFansDao;


    @Autowired
    private ClientVipDao clientVipDao;



    /**
     * 获取手机验证码
     *
     * @param tel
     * @return
     */
    public SmsMessageCheck getSendCode(String tel) {
        logger.info("into getSendCode method");
        SmsMessageCheck smsMessageCheck = new SmsMessageCheck();
        try {
            smsMessageCheck = smsMessageCheckDao.getSmsMessageCheck(tel);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return smsMessageCheck;
    }


    /**
     * 獲取
     *
     * @param openId
     * @return
     */
    public WxFans getWxFans(String openId) {
        logger.info("into getWxFans method");
        WxFans wxFans = new WxFans();
        try {
            wxFans = wxFansDao.getWxFans(openId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return wxFans;
    }



    @Override
    public UserInfo setCardMainRedis(UserInfo userInfo) {
       UserInfo info=clientVipDao.getClientVipInfo(userInfo);
       if (null!=info){
           redisUtil.set(info.getUnionId()+CommonRedisKey.userInfo.USER_KEY,info,CommonRedisKey.userInfo.TIME);
       }
       return info;
    }

    @Override
    public Long getUserIntergral(String unionid) {
        logger.info("into getUserIntergral method");
       // return bojunDao.getUserIntergral(cardMain.getUnionId());
       return  clientVipDao.getUserIntergral(unionid);
    }


    @Override
    public Long getUserIntergralByRedis(String unionid) {
        Object count = redisUtil.get(unionid + CommonRedisKey.userInfo.USER_INTEGRAL_KEY);
        Long integral = 0L;
        if (count == null) {
            integral = clientVipDao.getUserIntergral(unionid);
            UserInfo userInfo=new UserInfo();
            userInfo.setUnionId(unionid);
            userInfo.setAllIntegral(integral);
            setUserIntergraToRedis(userInfo);
        } else {
            integral = Long.valueOf(String.valueOf(count));

        }
        return integral;
    }

    @Override
    public boolean setUserIntergraToRedis(UserInfo userInfo) {
        boolean flag = false;
        try {
           if(null!=userInfo){
               if (!StringUtils.isEmpty(userInfo.getUnionId())&null!=userInfo.getAllIntegral()){
                   //更新缓存积分
                   redisUtil.set(userInfo.getUnionId()+CommonRedisKey.userInfo.USER_INTEGRAL_KEY,userInfo.getAllIntegral(),CommonRedisKey.userInfo.TIME);
               }
           }
           flag = true;
        } catch (Exception e) {
            flag = false;
            logger.error("setUserIntergraToRedis error", e);
        }
        return flag;
    }



    /**
     * 获取伯俊用户详情
     * @param userInfo
     * @return
     */
    @Override
    public UserInfo getClientVipInfo(UserInfo userInfo) {
        logger.info("into getClientVipInfo method");
        UserInfo info =null;
        try{
            Object object=redisUtil.get(userInfo.getUnionId()+CommonRedisKey.userInfo.USER_KEY);
            if (null!=object){
                info=(UserInfo)object;
            }else {
                   //redisUtil.set(info.getUnionid()+CommonRedisKey.userInfo.USER_KEY,CommonRedisKey.userInfo.TIME);
                info=setCardMainRedis(userInfo);

            }
        }catch (Exception e){
            logger.error("into getClientVipInfo error",e);
        }
        return info;
    }
}
