package com.zhenzhen.demo.springboot2.springboot2demo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class DemoExceptionHandler {


/*    @ExceptionHandler(value = DemoException.class)
    @ResponseBody
    public Map<String,Object> dealException(DemoException demoException){
        Map<String,Object> retInfo = new HashMap<>();
        retInfo.put("code",demoException.getCode());
        retInfo.put("message",demoException.getMessage());
        return retInfo;
    }*/



    @ExceptionHandler(value = DemoException.class)
    public String dealException(DemoException demoException, HttpServletRequest httpServletRequest){
        Map<String,Object> retInfo = new HashMap<>();
        retInfo.put("code",demoException.getCode());
        retInfo.put("message",demoException.getMessage());
        httpServletRequest.setAttribute("ext",retInfo);
        httpServletRequest.setAttribute("javax.servlet.error.status_code",500);
        return "forward:/error";
    }

}
