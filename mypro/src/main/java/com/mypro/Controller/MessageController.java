package com.mypro.Controller;

import com.mypro.util.RobotClient;
import com.mypro.util.TextMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/message")
public class MessageController {
    public static String WEBHOOK_TOKEN = "https://oapi.dingtalk.com/robot/send?access_token=77e146206ce43d4d4f640724eb1665145e947f4043bff83c15685052bc712e2a";

    @ResponseBody
    @RequestMapping(value = "/send-error",method = {RequestMethod.POST})
    public String addArticle(@RequestParam String mess){
        TextMessage textMessage=new TextMessage(mess);
        try {
            return  RobotClient.send(WEBHOOK_TOKEN,textMessage);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
//        return commentService.addComment(comment);
    }
}
