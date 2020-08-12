package vip.penint.netty.websocket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vip.penint.netty.websocket.service.PushService;

/**
 * 请求Controller(用于postman测试)
 */
@RestController
@RequestMapping("/push")
public class PushController {

    @Autowired
    private PushService pushService;

    /**
     * 推送给所有用户
     *
     * @param msg 消息信息
     */
    @PostMapping("/pushAll")
    public void pushToAll(@RequestParam("msg") String msg) {
        pushService.pushMsgToAll(msg);
    }

    /**
     * 推送给指定用户
     *
     * @param userId 用户ID
     * @param msg    消息信息
     */
    @PostMapping("/pushOne")
    public void pushMsgToOne(@RequestParam("userId") String userId, @RequestParam("msg") String msg) {
        pushService.pushMsgToOne(userId, msg);
    }

    /**
     * 获取当前连接数
     */
    @GetMapping("/getConnectCount")
    public int getConnectCout() {
        return pushService.getConnectCount();
    }
}
