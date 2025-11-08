package com.xinyuan.controller.user;

import com.xinyuan.pojo.*;

import com.xinyuan.service.UserService;
import com.xinyuan.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/code")
    public Result getVerifyCode(@RequestParam String phone){
        String code = userService.getCode(phone);
        // 第三方
        // XXX.send(code);
        return Result.success(code); // TODO 记得接入短信第三方后不再传回code
    }

    @PostMapping("/register")
    public Result Register(@RequestBody RegisterDTO registerDTO){
        userService.register(registerDTO);
        return Result.success();
    }
}
