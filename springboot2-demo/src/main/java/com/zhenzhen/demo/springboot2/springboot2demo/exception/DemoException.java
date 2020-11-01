package com.zhenzhen.demo.springboot2.springboot2demo.exception;

import lombok.Data;

@Data
public class DemoException extends RuntimeException {

    private String code;
    private String message;

    public DemoException(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
