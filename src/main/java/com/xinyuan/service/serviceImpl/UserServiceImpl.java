package com.xinyuan.service.serviceImpl;

import cn.hutool.core.util.RandomUtil;
import com.xinyuan.exception.BusinessException;
import com.xinyuan.mapper.CodeMapper;
import com.xinyuan.mapper.UserMapper;
import com.xinyuan.pojo.CodeDTO;
import com.xinyuan.pojo.LoginDTO;
import com.xinyuan.pojo.RegisterDTO;
import com.xinyuan.pojo.User;
import com.xinyuan.service.UserService;
import com.xinyuan.utils.RegexUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CodeMapper codeMapper;

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

    @Override
    public String getCode(String phone) {
        if(RegexUtils.isPhoneInvalid(phone)){
            throw new BusinessException("手机号格式错误");
        }
        User user = userMapper.getByPhone(phone);
        if(user != null){
            throw new BusinessException("用户已存在，请直接登录");
        }
        CodeDTO codeDTO = codeMapper.getByPhone(phone);
        if(codeDTO == null){
            String code = RandomUtil.randomNumbers(6);
            codeMapper.addCode(phone, code, System.currentTimeMillis() / 1000);
            return code;
        }
        else{
            if(System.currentTimeMillis() / 1000 - codeDTO.getTime() < 60){
                throw new BusinessException("操作繁忙，请1分钟后再尝试");
            }
            else{
                String code = RandomUtil.randomNumbers(6);
                codeMapper.updateCode(phone, code, System.currentTimeMillis() / 1000);
                return code;
            }
        }
    }

    @Override
    public void register(RegisterDTO registerDTO) {
        String phone = registerDTO.getPhone();
        String password = registerDTO.getPassword();
        String code = registerDTO.getCode();
        String name = registerDTO.getName();
        User user = userMapper.getByPhone(phone);
        if(user != null){
            throw new BusinessException("用户已存在，请直接登录");
        }
        CodeDTO codeDTO = codeMapper.getByPhone(phone);
        if(codeDTO == null || !codeDTO.getCode().equals(code) || System.currentTimeMillis() / 1000 - codeDTO.getTime() >15 * 60 ){
            // ！！！60s验证码过期时间！！！
            throw new BusinessException("验证码错误或已失效");
        }else{
            userMapper.add(name, phone, password);
        }
    }
}
