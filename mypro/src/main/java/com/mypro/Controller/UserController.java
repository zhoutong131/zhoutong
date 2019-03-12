package com.mypro.Controller;

import com.mypro.Service.UserService;
import com.mypro.model.User;
import com.mypro.util.Code;
import com.mypro.util.FileUtils;
import com.mypro.util.ResultJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;


    /**
     *
//     * @param account 账号
//     * @param password 密码
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login",method = {RequestMethod.POST})
    public String Login(@RequestBody User user){
        return userService.haveLogin(user);
    }

    @ResponseBody
    @RequestMapping(value = "/send-email",method = {RequestMethod.POST})
    public String sendEmail(@RequestBody Map data){
        String email=data.get("email").toString();
        return userService.sendEmail(email);
    }

    @ResponseBody
    @RequestMapping(value = "/register",method = {RequestMethod.POST})
    public String register(@RequestBody User user){
        return userService.regist(user);
    }

    @ResponseBody
    @RequestMapping(value="/uploadFile", method=RequestMethod.POST)
    public String doUploadFile(@RequestBody MultipartFile file,
                               @RequestParam String fileName,
                               HttpServletRequest request){
        String path="";
        if(!file.isEmpty()){
            try {
                path=FileUtils.uploadFile(file,"emotions",request);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return ResultJson.toJson(Code.SUCCESS,"上传成功！",path);  //上传成功
    }
}
