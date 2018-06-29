package org.dubbo.action.activity;

import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.dubbo.api.service.ActivityCheckService;
import org.dubbo.api.service.ActivityService;
import org.dubbo.config.BeanContext;
import org.dubbo.pojo.dto.activity.ActivityAuctionDto;
import org.dubbo.pojo.dto.activity.ActivityDto;
import org.dubbo.pojo.enums.ActivityCheckResult;
import org.dubbo.pojo.redis.RedisUtil;
import org.dubbo.pojo.utils.CommonRedisKey;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @ServerEndpoint 注解是一个类层次的注解，它的功能主要是将目前的类定义成一个websocket服务器端,
 * 注解的值将被用于监听用户连接的终端访问URL地址,客户端可以通过这个URL来连接到WebSocket服务器端
 */
@ServerEndpoint(value = "/websocket/{activityId}/{unionId}")
public class WebSocket{

	//concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识

	private static ConcurrentHashMap<String,CopyOnWriteArraySet<WebSocket>> webSocketMap = new ConcurrentHashMap<String,CopyOnWriteArraySet<WebSocket>>();

	private static final Logger logger = Logger.getLogger(WebSocket.class);

	private static final String WEBSOCKET_ONLINE_COUNT = "WEBSOCKET_ONLINE_COUNT";

	private static final String WEBSOCKET_ = "WEBSOCKET_";


	//与某个客户端的连接会话，需要通过它来给客户端发送数据
	private Session session;

    private RedisUtil redisUtil = getBean(RedisUtil.class);

	private ActivityCheckService activityCheckService = getBean(ActivityCheckService.class);

	private ActivityService activityService = getBean(ActivityService.class);

	/**
	 * 连接建立成功调用的方法
	 * @param session  可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
	 */
	@OnOpen
	public String onOpen(@PathParam(value="activityId") String activityId, @PathParam(value="prizeId") String prizeId,
                       @PathParam(value="unionId") String unionId,Session session){
	    this.unionId = unionId;
	    this.activityId = activityId;
        this.session = session;
        if(webSocketMap.get(activityId) == null){
			webSocketMap.put(activityId,new CopyOnWriteArraySet<WebSocket>());
			webSocketMap.get(activityId).add(this);
		}else {
			webSocketMap.get(activityId).add(this);
		}
		logger.info("当前"+"活动Id"+activityId+"    "+unionId+"正在创建连接");
		addOnlineCount();
        logger.debug("有新连接加入！当前在线人数为" + getOnlineCount());
        return "SUCCESS";
	}

	/**
	 * 连接关闭调用的方法
	 */
	@OnClose
	public void onClose(){
		webSocketMap.get(activityId).remove(this);
		subOnlineCount();           //在线数减1
		logger.debug("有一连接关闭！当前在线人数为" + getOnlineCount());
	}

	/**
	 * 收到客户端消息后调用的方法
	 * @param json 客户端发送过来的消息
	 * @param session 可选的参数
	 */
	@OnMessage
	public void onMessage(String json, Session session) {
		ActivityCheckResult activityCheckResult = ActivityCheckResult.ERROR;
		logger.info("收到客户端消息>>>"+json);
		ActivityAuctionDto activityAuctionDto = null;
		try{
			activityAuctionDto = JSONObject.parseObject(json,ActivityAuctionDto.class);
			ActivityDto activityDto=new ActivityDto();
			activityDto.setActivityId(activityAuctionDto.getActivityId());
			activityDto.setUnionId(activityAuctionDto.getUnionId());
			activityDto.setWeid(activityAuctionDto.getWeid());
			activityDto.setOpenId(activityAuctionDto.getOpenId());
			//基本的前置校验
			activityCheckResult=activityCheckService.activityOverCheck(activityDto);
			if (ActivityCheckResult.SUCCESS.getCode().equals(activityCheckResult.getCode())){//验证成功
				activityCheckResult =  activityService.auction(activityAuctionDto);
				if(!activityCheckResult.equals(ActivityCheckResult.SUCCESS)){//竞价失败 直接返回
					this.sendMessage(activityCheckResult.getCode());
					return;
				}
			}else {//前置校验不成功
				this.sendMessage(JSONObject.toJSONString(activityCheckResult));
				return;
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		String key = CommonRedisKey.Auction.AUCTION_OFFER_RECORD+ activityAuctionDto.getPrizeId();
		ActivityAuctionDto result  = (ActivityAuctionDto) redisUtil.hget(key, String.valueOf(redisUtil.hlen(key)));
		if(result.getPrice().compareTo(activityAuctionDto.getPrice())>0){//当前积分竞价结果已经不是最高积分了，直接返回成功
			this.sendMessage(activityCheckResult.getCode());
			return;
		}
		//跑线程推送消息
		final CopyOnWriteArraySet<WebSocket> webSockets = webSocketMap.get(activityId);
		final String message = JSONObject.toJSONString(result);
		new Thread(new Runnable() {
            @Override
            public void run() {
                for(WebSocket webSocket : webSockets){
                    webSocket.sendMessage(message);
                }
            }
        }).start();
	}

	/**
	 * 发生错误时调用
	 * @param session
	 * @param error
	 */
	@javax.websocket.OnError
	public void onError(Session session, Throwable error){
		logger.error(error.getMessage());
	}

	/**
	 * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。
	 * @param message
	 * @throws IOException
	 */
	public void sendMessage(String message){
		try {
			this.session.getAsyncRemote().sendText(message);
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	public int getOnlineCount() {
        Object websocket_onlineCount = redisUtil.get(WEBSOCKET_ONLINE_COUNT+"_"+activityId);
        return websocket_onlineCount == null?0: (Integer) websocket_onlineCount;
    }

	public void addOnlineCount() {
		redisUtil.incr(WEBSOCKET_ONLINE_COUNT+"_"+activityId,1);
	}

	public void subOnlineCount() {
		redisUtil.decr(WEBSOCKET_ONLINE_COUNT+"_"+activityId,1);
	}

	private <T> T  getBean(Class<T> clazz) {
		return BeanContext.getApplicationContext().getBean(clazz);
	}

    private String activityId;

    private String prizeId;

    private String unionId;

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(String prizeId) {
        this.prizeId = prizeId;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

}
