package com.xinyuan.controller.user;

import com.xinyuan.exception.BaseException;
import com.xinyuan.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public Result helloWorld(){
        return Result.success("Hello, world!");
//        throw new BaseException("测试异常");
    }

}
