package com.zhenzhen.demo.springboot2.springboot2demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "person")
@Data
public class Person {

    private String name;
    private int age;
    private List<String> addr;
    private Map<String,String> maps;
}
