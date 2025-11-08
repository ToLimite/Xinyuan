package com.xinyuan.controller.user;

import com.xinyuan.exception.BusinessException;
import com.xinyuan.pojo.Result;
import com.xinyuan.pojo.Xinyuan;
import com.xinyuan.service.XinyuanService;
import com.xinyuan.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class XinyuanItemController {

    @Autowired
    private XinyuanService xinyuanService;

    @GetMapping("/getXyItems")
    public Result getXinyuan(@RequestParam Long state){
        List<Xinyuan> list = new ArrayList<>();
        list = xinyuanService.getItems(state);
        return Result.success(list);
    }

    @PostMapping("/starupXyItem")
    public Result starupXinyuan(@RequestParam Long userId, @RequestParam Long itemId, @RequestHeader("token") String token){
        try {
            Claims claims = JwtUtils.parseJWT(token);
            Long tokenUserId = claims.get("id", Long.class);
            if(!tokenUserId.equals(userId)){
                throw new BusinessException("token 无效（签名错误、被篡改等）", 401L);
            }
            xinyuanService.starupXinyuan(userId, itemId);
            return Result.success();
        } catch (ExpiredJwtException e) {
            // token 已过期
            throw new BusinessException("token 已过期", 401L);
        } catch (JwtException e) {
            // token 无效（签名错误、被篡改等）
            throw new BusinessException("token 无效（签名错误、被篡改等）", 401L);
        }
    }

    @GetMapping("/myStar")
    public Result getMyStar(@RequestHeader("token") String token){
        try {
            Claims claims = JwtUtils.parseJWT(token);
            Long userId = claims.get("id", Long.class);
            List<Xinyuan> itemsByStarUser = xinyuanService.getItemsByStarUser(userId);
            return Result.success(itemsByStarUser);
        } catch (ExpiredJwtException e) {
            // token 已过期
            throw new BusinessException("token 已过期", 401L);
        } catch (JwtException e) {
            // token 无效（签名错误、被篡改等）
            throw new BusinessException("token 无效（签名错误、被篡改等）", 401L);
        }
    }
}
