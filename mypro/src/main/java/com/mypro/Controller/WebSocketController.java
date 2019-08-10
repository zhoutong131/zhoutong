package com.mypro.Controller;

import com.mypro.util.webcocket.Constants;
import com.mypro.util.webcocket.TextMessageHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/socket")
public class WebSocketController {
    @ResponseBody
    @RequestMapping(value ="/login",method = {RequestMethod.GET})
    public String login(HttpServletRequest request, @RequestParam("username") String username) {
        HttpSession session = request.getSession();
        session.setAttribute(Constants.DEFAULT_SESSION_USERNAME, username);
        return "redirect:index";
    }

    @ResponseBody
    @RequestMapping("index")
    public String index() {
        return "index";
    }

    @Bean
    public TextMessageHandler textMessageHandler() {
        return new TextMessageHandler();
    }

    @RequestMapping
    public String view() {
        return "message";
    }

    /**
     * 发送消息到页面
     * @param request
     * @param username
     * @return
     */
    @ResponseBody
    @RequestMapping(value ="/send",method = {RequestMethod.POST})
    public String send(HttpServletRequest request, @RequestParam("username") String username) {
        TextMessage message = new TextMessage(request.getParameter("message"));
        textMessageHandler().sendMessageToUser(username, message);
        return "true";
    }
}
