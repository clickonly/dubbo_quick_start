package org.dubbo.api.imp;

import org.apache.log4j.Logger;
import org.dubbo.api.dao.ClientVipDao;
import org.dubbo.api.dao.CustjftotDao;
import org.dubbo.api.dao.VipIntegralFtpDao;
import org.dubbo.api.service.ActivityService;
import org.dubbo.api.service.UserIntegralService;
import org.dubbo.api.service.UserService;
import org.dubbo.pojo.bean.activity.ActivityMain;
import org.dubbo.pojo.bean.user.Custjftot;
import org.dubbo.pojo.bean.user.UserInfo;
import org.dubbo.pojo.bean.user.VipIntegralFtp;
import org.dubbo.pojo.dto.activity.SendIntergralDto;
import org.dubbo.pojo.redis.RedisUtil;
import org.dubbo.pojo.utils.CommonRedisKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by fanglei on 2018/6/11.
 */
@Service("userIntegralService")
public class UserIntegralServiceImp implements UserIntegralService {

    private static final Logger logger = Logger.getLogger(UserIntegralService.class);


    @Autowired
    private RedisUtil redisUtil;

    @Autowired(required = false)
    private UserService userService;


    @Autowired
    private CustjftotDao custjftotDao;

    @Autowired
    private ClientVipDao clientVipDao;

    @Autowired(required = false)
    private ActivityService activityService;

    @Autowired
    private VipIntegralFtpDao vipIntegralFtpDao;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean handRealIntegral(SendIntergralDto sendIntergralDto) {
        logger.info("into handRealIntegral method");
        //首先判断用户是否存在
        UserInfo userInfo=new UserInfo();
        userInfo.setUnionId(sendIntergralDto.getUnionid());
        userInfo.setOpenId(sendIntergralDto.getOpenid());
        userInfo=userService.getClientVipInfo(userInfo);
        if (null!=userInfo){
            if(sendIntergralDto.getIntegral()>0){
                //积分增加
                addIntegral(userInfo,sendIntergralDto);
            }else {
                //积分扣减
                subtractionIntegral(userInfo,sendIntergralDto);

            }
            return true;
        }else {
            logger.error("当前用户unionid"+sendIntergralDto.getUnionid()+"和openid"+sendIntergralDto.getOpenid()+"在伯俊中不存在");
            return false;
        }
    }

    private void addIntegral(UserInfo userInfo,SendIntergralDto sendIntergralDto){
        logger.info("当前正在处理增加积分操作");
        Custjftot custjftot=new Custjftot();
        custjftot.setOpenid(sendIntergralDto.getOpenid());
        custjftot.setBatch(0);
        custjftot.setClentVipId(userInfo.getId());
        //首先获取当前最新批次是否存在
        custjftot=custjftotDao.checkCustjftot(custjftot);
        if (null!=custjftot){
            custjftot.setIntegral(sendIntergralDto.getIntegral());
            //更新批次积分
            custjftotDao.updatetCustjftotInteger(custjftot);
        }else {
            custjftot=new Custjftot();
            custjftot.setBatch(0);
            custjftot.setClentVipId(userInfo.getId());
            custjftot.setIntegral(sendIntergralDto.getIntegral());
            custjftotDao.insert(custjftot);
        }

        //更新当前品牌卡积分
        userInfo.setAllIntegral(sendIntergralDto.getIntegral());
        clientVipDao.updateIntergral(userInfo);
        insertFtp(userInfo,sendIntergralDto);
    }


    /**
     * 插入积分流水
     */
    private void insertFtp(UserInfo userInfo,SendIntergralDto sendIntergralDto){
        logger.info("插入积分流水.....");
        String activityName="";
        Long activityId=0L;
        if (null!=sendIntergralDto.getActivityId()){
            ActivityMain activityMain=activityService.getActivityMainById(sendIntergralDto.getActivityId());
            activityName=activityMain.getActivityName();
            activityId=sendIntergralDto.getActivityId();
        }
        VipIntegralFtp vipIntegralFtp = new VipIntegralFtp();
        vipIntegralFtp.setId(vipIntegralFtpDao.getSeq());
        vipIntegralFtp.setAd_client_id(37L);
        vipIntegralFtp.setAd_org_id(27L);
        vipIntegralFtp.setOwnerid(3293L);
        vipIntegralFtp.setModifierid(3293L);
        vipIntegralFtp.setIsactive("Y");
        vipIntegralFtp.setC_vip_id(userInfo.getId());
        vipIntegralFtp.setDocno(activityName +"获得了"+ sendIntergralDto.getIntegral()+"积分");
        vipIntegralFtp.setDescription(activityName +"获得了"+ sendIntergralDto.getIntegral()+"积分");
        vipIntegralFtp.setAmt_actual(0.00);
        vipIntegralFtp.setVip_payamt(0.00);
        vipIntegralFtp.setIntegral(sendIntergralDto.getIntegral());
        vipIntegralFtp.setJf1(sendIntergralDto.getIntegral());
        vipIntegralFtp.setJf2(0L);
        vipIntegralFtp.setJf3(0L);
        vipIntegralFtp.setActiveid(activityId);
        vipIntegralFtpDao.insert(vipIntegralFtp);
    }


    /**
     * 减积分
     * @param userInfo
     * @param sendIntergralDto
     */
    private void subtractionIntegral(UserInfo userInfo,SendIntergralDto sendIntergralDto){
        Custjftot custjftot=null;
        Long allIntegral=Math.abs(sendIntergralDto.getIntegral());//当前要扣总积分
       for (int i=2;i>=0;i--){
            //首先判断当前批次的积分是否足够
           custjftot=new Custjftot();
           custjftot.setBatch(i);
           custjftot.setUnionid(userInfo.getUnionId());
           Long batchIntegral=custjftotDao.getCustjftotByBatchByUnionid(custjftot);
           if (allIntegral>=batchIntegral&&batchIntegral>0){
               //则当前批次所有品牌积分都直接扣没
               allIntegral=allIntegral-subtractionBatchIntegral(custjftot,sendIntergralDto);//剩余积分

           }else {
               //开始分摊
               //首先分摊当前品牌当前批次卡
               allIntegral=allIntegral-subtractionBatchMainIntegral(custjftot,userInfo,sendIntergralDto,allIntegral);
               //轮询其他品牌其他卡其他批次
               allIntegral=subtractionBatchOtherIntegral(custjftot,sendIntergralDto,allIntegral);
           }
           if (allIntegral==0){
               break;
           }
       }
       if (allIntegral>0){
           subAll(sendIntergralDto,userInfo,allIntegral);
       }

    }


    private void subAll(SendIntergralDto sendIntergralDto,UserInfo userInfo,Long allIntegral){
        //没有批次情况
        //先扣本品牌积分
        Long mainIntegral=clientVipDao.getUserRealIntergral(userInfo.getId());
        Long subtractionIntegral=0L;//要扣除积分
        if (allIntegral>mainIntegral){
            subtractionIntegral=mainIntegral;
        }else {
            subtractionIntegral=allIntegral;
        }
        //扣除本品牌
        userInfo.setAllIntegral(subtractionIntegral*-1);
        clientVipDao.updateIntergralById(userInfo);
        Custjftot custjftot=new Custjftot();
        custjftot.setClentVipId(userInfo.getId());
        custjftot.setIntegral(subtractionIntegral*-1);
        custjftot.setBatch(0);
        insertSubtractionFtp(sendIntergralDto,custjftot);
        allIntegral=allIntegral-subtractionIntegral;
        if (allIntegral>0){
            //如果还有剩余要扣除积分 分摊其他品牌
            userInfo.setUnionId(sendIntergralDto.getUnionid());
            Long ortherIntergralAll=clientVipDao.gerOrtherIntergral(userInfo);
            List<UserInfo> userInfoList=clientVipDao.getOrtherUserInfo(userInfo);
            for (UserInfo u:userInfoList){
                Long mathIntegral = u.getCardIntegral() * allIntegral / ortherIntergralAll;  // 计算分摊值
                if (allIntegral>mathIntegral){
                  //  u.setAllIntegral(mathIntegral);
                    subtractionIntegral=mathIntegral;
                }else {
                  //  u.setAllIntegral(allIntegral);
                    subtractionIntegral=allIntegral;
                }
                u.setAllIntegral(subtractionIntegral*-1);
                clientVipDao.updateIntergralById(u);
                custjftot=new Custjftot();
                custjftot.setClentVipId(u.getId());
                custjftot.setIntegral(u.getAllIntegral()*-1);
                custjftot.setBatch(0);
                insertSubtractionFtp(sendIntergralDto,custjftot);
                allIntegral=allIntegral-subtractionIntegral;
                ortherIntergralAll=ortherIntergralAll-u.getCardIntegral();
                insertSubtractionFtp(sendIntergralDto,custjftot);
                if (allIntegral==0){
                    break;
                }
            }
        }

    }



    /**
     * 处理其他品牌当前批次卡
     * @param custjftot
     * @param sendIntergralDto
     * @param allIntegral
     * @return
     */
    private long subtractionBatchOtherIntegral(Custjftot custjftot,SendIntergralDto sendIntergralDto,Long allIntegral){
        custjftot.setOpenid(sendIntergralDto.getOpenid());
        List<Custjftot> custjftotList=custjftotDao.getListCustjftotByOtherBatch(custjftot);//获取其他品牌批次卡
        Long allCustjfto=custjftotDao.getCustjftotByOtherBatch(custjftot);    //获取其他品牌卡的总积分
        UserInfo isSubUserInfo=null;
        if(null!=custjftotList){
            for (Custjftot c:custjftotList){
                Long mathIntegral = c.getIntegral() * allIntegral / allCustjfto;  // 计算分摊值
                Long isSubIntegral=0L;//要扣除积分
                if(mathIntegral<=c.getIntegral()){
                    isSubIntegral=mathIntegral;
                }
                //在获取当前用户实际积分
                Long userIntegral=clientVipDao.getUserRealIntergral(c.getClentVipId());
                if (userIntegral<isSubIntegral){
                    isSubIntegral=userIntegral;
                }
                if (isSubIntegral>0){
                    allCustjfto=allCustjfto-c.getIntegral();//减去当前卡的所有积分
                    allIntegral=allIntegral-isSubIntegral;
                    c.setIntegral(isSubIntegral*-1);//更新要扣减积分
                    custjftotDao.updatetCustjftotInteger(c);//减去当前品牌当前批次
                    isSubUserInfo =new UserInfo();
                    isSubUserInfo.setId(c.getClentVipId());
                    isSubUserInfo.setAllIntegral(c.getIntegral());
                    clientVipDao.updateIntergralById(isSubUserInfo);
                    insertSubtractionFtp(sendIntergralDto,c);
                }
            }
        }
        return allIntegral;
    }



    /**
     * 当前品牌当前批次扣积分
     * @return 返回当前扣的积分
     */
    private long subtractionBatchMainIntegral(Custjftot custjftot,UserInfo userInfo,SendIntergralDto sendIntergralDto,Long allIntegral){
        custjftot.setClentVipId(userInfo.getId());
        Long mainCardIntegral=custjftotDao.getCustjftotByBatch(custjftot);//获取当前品牌当前批次值
        if (allIntegral>mainCardIntegral){
            custjftot.setIntegral(mainCardIntegral*-1);
        }else {
            custjftot.setIntegral(allIntegral*-1);
        }
        if(Math.abs(custjftot.getIntegral())>0){
            //再次进行判断当前人的vip积分是否一致
            UserInfo u=clientVipDao.getClientVipInfo(userInfo);
            if (custjftot.getIntegral()>u.getCardIntegral()){
                //如果当前要扣积分大于vip里面实际积分 已实际积分为准
                custjftot.setIntegral(u.getCardIntegral()*-1);
            }
            custjftotDao.updatetCustjftotInteger(custjftot);//减去当前品牌当前批次
            userInfo.setAllIntegral(custjftot.getIntegral());
            clientVipDao.updateIntergralById(userInfo);
            insertSubtractionFtp(sendIntergralDto,custjftot);
        }
        return Math.abs(custjftot.getIntegral());
    }



    /**
     * 分摊全部扣除情况
     * @param custjftot
     */
    private Long subtractionBatchIntegral(Custjftot custjftot,SendIntergralDto sendIntergralDto){
        List<Custjftot> custjftotList=custjftotDao.getListCustjftotByBatch(custjftot);
        UserInfo userInfo=null;
        Long returnIntegral=0l;
        for(Custjftot c:custjftotList){
            Long realIntegral=clientVipDao.getUserRealIntergral(c.getClentVipId());
            if (realIntegral>c.getIntegral()){
                c.setIntegral(c.getIntegral()*-1);
            }else {
                c.setIntegral(realIntegral*-1);
            }
            custjftotDao.updatetCustjftotInteger(c);//批次减
            //更新伯俊积分
            userInfo=new UserInfo();
            userInfo.setId(c.getClentVipId());
            userInfo.setAllIntegral(c.getIntegral());
            clientVipDao.updateIntergralById(userInfo);
            insertSubtractionFtp(sendIntergralDto,c);
            returnIntegral=returnIntegral+Math.abs(c.getIntegral());
        }
        return returnIntegral;
    }



    private void insertSubtractionFtp(SendIntergralDto sendIntergralDto,Custjftot custjftot){
        logger.info("插入积分流水.....");
        String activityName="";
        Long activityId=0L;
        if (null!=sendIntergralDto.getActivityId()){
            ActivityMain activityMain=activityService.getActivityMainById(sendIntergralDto.getActivityId());
            activityName=activityMain.getActivityName();
            activityId=sendIntergralDto.getActivityId();
        }
        VipIntegralFtp vipIntegralFtp = new VipIntegralFtp();
        vipIntegralFtp.setId(vipIntegralFtpDao.getSeq());
        vipIntegralFtp.setAd_client_id(37L);
        vipIntegralFtp.setAd_org_id(27L);
        vipIntegralFtp.setOwnerid(3293L);
        vipIntegralFtp.setModifierid(3293L);
        vipIntegralFtp.setIsactive("Y");
        vipIntegralFtp.setC_vip_id(custjftot.getClentVipId());
        vipIntegralFtp.setDocno(activityName +"消费"+ custjftot.getIntegral()+"积分");
        vipIntegralFtp.setDescription(activityName +"消费"+ custjftot.getIntegral()+"积分");
        vipIntegralFtp.setAmt_actual(0.00);
        vipIntegralFtp.setVip_payamt(0.00);
        vipIntegralFtp.setIntegral(custjftot.getIntegral());
        vipIntegralFtp.setActiveid(activityId);
        if (0==custjftot.getBatch()){
            vipIntegralFtp.setJf1(custjftot.getIntegral());
            vipIntegralFtp.setJf2(0L);
            vipIntegralFtp.setJf3(0L);
        }
        if (1==custjftot.getBatch()){
            vipIntegralFtp.setJf2(custjftot.getIntegral());
            vipIntegralFtp.setJf1(0L);
            vipIntegralFtp.setJf3(0L);
        }
        if (2==custjftot.getBatch()){
            vipIntegralFtp.setJf3(custjftot.getIntegral()*-1);
            vipIntegralFtp.setJf1(0L);
            vipIntegralFtp.setJf2(0L);
        }
        vipIntegralFtpDao.insert(vipIntegralFtp);
    }



    @Override
    public boolean sendVouIntegralToRedis(SendIntergralDto sendIntergralDto) {
        logger.info("into sendVouIntegralToRedis method");
        boolean flag = false;
        try {
            redisUtil.lSet(CommonRedisKey.userInfo.INTEGRAL_LIST_KEY, sendIntergralDto);
            flag = true;
        } catch (Exception e) {
            flag = false;
            logger.error("sendVouIntegralToRedis error", e);
        }
        return flag;
    }




    @Override
    public boolean handIntegral(SendIntergralDto sendIntergralDto) {
        logger.info("into handIntegral>>>>>>>>");
        boolean flag = false;
        try {
            Long count = userService.getUserIntergralByRedis(sendIntergralDto.getUnionid());
            count = count + sendIntergralDto.getIntegral();
            UserInfo userInfo = new UserInfo();
            userInfo.setAllIntegral(count);
            userInfo.setUnionId(sendIntergralDto.getUnionid());
            userService.setUserIntergraToRedis(userInfo);
            flag = sendVouIntegralToRedis(sendIntergralDto);
        } catch (Exception e) {
            flag = false;
            logger.error("handIntegral error", e);

        }
        return flag;
    }


    @Override
    public boolean insertSendError(SendIntergralDto sendIntergralDto) {
        boolean flag = false;
        try {
            redisUtil.lSet(CommonRedisKey.userInfo.ERROR_INTEGRAL_KEY, sendIntergralDto);
            flag = true;
        } catch (Exception e) {
            flag = false;
            logger.error("sendHandIntegralRedis error", e);
        }
        return flag;
    }



}
