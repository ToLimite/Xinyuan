package com.xinyuan.controller.user;

import com.xinyuan.pojo.LoginDTO;
import com.xinyuan.pojo.LoginVO;
import com.xinyuan.pojo.Result;

import com.xinyuan.pojo.User;
import com.xinyuan.service.UserService;
import com.xinyuan.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
public class LoginController {

    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public Result login(@RequestBody LoginDTO loginDTO){
        User user = userService.getLogin(loginDTO);
        Map claims = new HashMap();
        claims.put("id", user.getId());
        claims.put("name", user.getName());
        claims.put("phone", user.getPhone());
        String jwt = JwtUtils.generateJwt(claims);
        LoginVO loginVO = new LoginVO(user.getId(), user.getName(), user.getPhone(), jwt);
        return Result.success(loginVO);
    }
}
