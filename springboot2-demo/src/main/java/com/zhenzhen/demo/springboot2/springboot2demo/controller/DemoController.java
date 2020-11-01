package com.zhenzhen.demo.springboot2.springboot2demo.controller;

import com.zhenzhen.demo.springboot2.springboot2demo.config.Person;
import com.zhenzhen.demo.springboot2.springboot2demo.exception.DemoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private Person person;

    @RequestMapping("ping")
    public String ping(){
        return "demo-tong"+System.currentTimeMillis();
    }

    @RequestMapping("getPerson")
    public Person getPerson(){
        return person;
    }

    @RequestMapping("testException")
    public Person testException() throws Exception{
        throw new DemoException("500","异常");
        //return person;
    }
}
