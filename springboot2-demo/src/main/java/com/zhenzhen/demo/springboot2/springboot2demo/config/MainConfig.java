package com.zhenzhen.demo.springboot2.springboot2demo.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(value = Person.class)
public class MainConfig {
}
