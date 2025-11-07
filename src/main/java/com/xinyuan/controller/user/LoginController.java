package com.xinyuan.controller.user;

import com.xinyuan.pojo.LoginDTO;
import com.xinyuan.pojo.Result;
import com.xinyuan.pojo.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping("/login")
    public Result login(@RequestBody LoginDTO loginDTO){

        return Result.success();
    }
}
