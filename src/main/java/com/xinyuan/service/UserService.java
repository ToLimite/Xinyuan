package com.xinyuan.service;

import com.xinyuan.pojo.LoginDTO;
import com.xinyuan.pojo.RegisterDTO;
import com.xinyuan.pojo.User;

public interface UserService {
    User getLogin(LoginDTO loginDTO);

    String getCode(String phone);

    void register(RegisterDTO registerDTO);
}
