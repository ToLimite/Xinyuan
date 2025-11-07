package com.xinyuan.controller;

import com.xinyuan.pojo.Result;
import com.xinyuan.pojo.Xinyuan;
import com.xinyuan.service.XinyuanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class XinyuanItemController {

    @Autowired
    private XinyuanService xinyuanService;

    @GetMapping("/getXinyuan")
    public Result getXinyuan(@RequestParam Long state){
        List<Xinyuan> list = new ArrayList<>();
//        list = XinyuanService.getItems();
        return Result.success(list);
    }
}
