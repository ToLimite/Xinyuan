package com.xinyuan.exception;

import com.xinyuan.pojo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    
    /**
     * 处理业务异常
     */
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Result<?>> handleBusinessException(BusinessException e) {
        logger.warn("业务异常: {}", e.getMessage());
        
        Result<?> result = Result.error(e.getMessage());
        if(e.getCode() == 401) return new ResponseEntity<>(result, HttpStatus.UNAUTHORIZED); // 401
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST); // 400
        // 或者使用其他状态码：HttpStatus.UNPROCESSABLE_ENTITY(422)等
    }
    
    /**
     * 处理其他异常
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Result<?>> handleException(Exception e) {
        logger.error("系统异常: ", e);
        
        Result<?> result = Result.error("SYSTEM_ERROR, 系统繁忙，请稍后再试");
        return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR); // 500
    }
}