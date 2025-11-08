package com.xinyuan.service.serviceImpl;

import com.xinyuan.exception.BusinessException;
import com.xinyuan.mapper.UserMapper;
import com.xinyuan.pojo.LoginDTO;
import com.xinyuan.pojo.User;
import com.xinyuan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getLogin(LoginDTO loginDTO) {
        String phone = loginDTO.getPhone();
        String password = loginDTO.getPassword();
        User user = userMapper.getByPhone(phone);
        if(user == null){
            throw new BusinessException("用户不存在！");
        }else if (!user.getPassword().equals(password)){
            throw new BusinessException("密码错误！");
        }else{
            return user;
        }
    }
}
