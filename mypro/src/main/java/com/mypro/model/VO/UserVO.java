package com.mypro.model.VO;

import com.mypro.model.User;
import com.mypro.util.Code;
import com.mypro.util.CommonUtils;

import java.util.ArrayList;
import java.util.List;

public class UserVO {
    private Integer id;

    private String account;

    private String nick_name;

    private String password;

    private Integer point;

    private Byte status;

    private String creat_time;

    private String update_time;

    public UserVO(User user) {
        this.id = user.getId();
        this.account = CommonUtils.getStr(user.getAccount());
        this.nick_name = CommonUtils.getStr(user.getNick_name());
        this.password = CommonUtils.getStr(user.getPassword());
        this.point = user.getPoint();
        this.status = user.getStatus();
        this.creat_time = CommonUtils.dateCastToString(user.getCreat_time(), Code.YYYY_MM_DD);
        this.update_time = CommonUtils.dateCastToString(user.getUpdate_time(), Code.YYYY_MM_DD);
    }
    public static List<UserVO> getList(List<User> users){
        List<UserVO> userVOS=new ArrayList<>();
        for(User u:users){
            userVOS.add(new UserVO(u));
        }
        return  userVOS;
    }
}
