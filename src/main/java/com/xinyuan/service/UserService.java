package com.xinyuan.service;

import com.xinyuan.pojo.LoginDTO;
import com.xinyuan.pojo.User;

public interface UserService {
    User getLogin(LoginDTO loginDTO);
}
