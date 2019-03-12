package com.mypro.Service;

import com.mypro.model.User;

public interface UserService {
    String haveLogin(User user);

    String sendEmail(String email);

    String regist(User user);
}
