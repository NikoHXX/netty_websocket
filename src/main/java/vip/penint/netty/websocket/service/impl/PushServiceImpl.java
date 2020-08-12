package vip.penint.netty.websocket.service.impl;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.springframework.stereotype.Service;
import vip.penint.netty.websocket.config.NettyConfig;
import vip.penint.netty.websocket.service.PushService;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 推送消息接口实现类
 */
@Service
public class PushServiceImpl implements PushService {

    /**
     * 推送给指定用户
     * @param userId 用户ID
     * @param msg 消息信息
     */
    @Override
    public void pushMsgToOne(String userId, String msg){
        ConcurrentHashMap<String, Channel> userChannelMap = NettyConfig.getUserChannelMap();
        Channel channel = userChannelMap.get(userId);
        channel.writeAndFlush(new TextWebSocketFrame(msg));
    }

    /**
     * 推送给所有用户
     * @param msg 消息信息
     */
    @Override
    public void pushMsgToAll(String msg){
        NettyConfig.getChannelGroup().writeAndFlush(new TextWebSocketFrame(msg));
    }

    /**
     * 获取当前连接数
     * @return 连接数
     */
    @Override
    public int getConnectCount() {
        return NettyConfig.getChannelGroup().size();
    }
}
