/**
 * 项目名：websocket
 * 日  期：2020/8/12
 * 包  名：vip.penint.netty.websocket.controller
 *
 * @author： HuangXiuxiang
 */
package vip.penint.netty.websocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/websocket")
    public String index() {
        return "websocket";
    }

}
