package com.mypro.Service.Impl;

import com.mypro.Service.UserService;
import com.mypro.mapper.UserMapper;
import com.mypro.model.User;
import com.mypro.model.VO.Login;
import com.mypro.util.Code;
import com.mypro.util.JWT;
import com.mypro.util.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Autowired
    private JavaMailSender javaMailSender;//在spring中配置的邮件发送的bean

    @Override
    public String haveLogin(User user) {
        User user1=userMapper.getUserDetail(user);
        if(user1!=null){
            Login login=new Login();
            login.setId(user1.getId());
            login.setNick_name(user1.getNick_name());
            login.setPoint(user1.getPoint());
            login.setAccount(user1.getAccount());
            login.setPassword(user1.getPassword());
            login.setStatus(user1.getStatus());
            login.setEmail(user1.getEmail());
            String token = JWT.sign(login, 60L* 1000L* 30L);
            login.setToken(token);
            return ResultJson.toJson(Code.SUCCESS,Code.FIND_SUCC_MSG,login);
        }
        return ResultJson.toJson(Code.FAILED,Code.FIND_FAIL_MSG,Code.NULL_STR);
    }

    @Override
    public String sendEmail(String email) {
        MimeMessage mMessage=javaMailSender.createMimeMessage();//创建邮件对象
        MimeMessageHelper mMessageHelper;
        Properties prop = new Properties();
        String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);
        String from;
        try {
            prop.load(this.getClass().getClassLoader().getResourceAsStream("mail.properties"));
            from = prop.get("mail.smtp.username")+"";
            mMessageHelper=new MimeMessageHelper(mMessage,true);
            mMessageHelper.setFrom(from);//发件人邮箱
            mMessageHelper.setTo(email);//收件人邮箱
            mMessageHelper.setSubject("Service");//邮件的主题
            mMessageHelper.setText("您的验证码是："+verifyCode,true);//邮件的文本内容，true表示文本以html格式打开
        }catch (Exception ex){
            ex.printStackTrace();
        }
        javaMailSender.send(mMessage);//发送邮件
        return ResultJson.toJson(Code.SUCCESS,"成功发送邮件！",verifyCode);
    }

    @Override
    public String regist(User user) {
        //检查account是否重复。
        Integer sum=userMapper.countSum(user.getAccount());
        if(sum>0){
            return ResultJson.toJson(Code.FAILED,"账号重复！",Code.NULL_STR);
        }
        else{
            user.setPoint(0);
            user.setStatus(Code.ONE);
            user.setUpdate_time(new Date());
            Integer res=userMapper.insertSelective(user);
            if(res>0)
                return ResultJson.toJson(Code.SUCCESS,Code.SAVE_SUCC_MSG,Code.NULL_STR);
        }
        return ResultJson.toJson(Code.FAILED,Code.SAVE_FAIL_MSG,Code.NULL_STR);
    }
}
