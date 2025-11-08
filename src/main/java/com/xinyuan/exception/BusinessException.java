package com.xinyuan.exception;


import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BusinessException extends RuntimeException {
    // getter 和 setter
    private String message;
    private Long code;

    public BusinessException(String message, Long code) {
        super(message);
        this.message = message;
        this.code = code;
    }

    public BusinessException(String message) {
        super(message);
        this.message = message;
        this.code = 400L;
    }

}