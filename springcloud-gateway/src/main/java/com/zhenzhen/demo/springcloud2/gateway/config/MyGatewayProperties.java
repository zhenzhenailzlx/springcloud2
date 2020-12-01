package com.zhenzhen.demo.springcloud2.gateway.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zhen.yin
 * @title:
 * @description:
 * @date 2020/12/1 14:09
 */
@ConfigurationProperties("mygateway")
@EnableConfigurationProperties(MyGatewayProperties.class)
@Component
public class MyGatewayProperties {
    private String separateThreadPoolKeys;

    public String getSeparateThreadPoolKeys() {
        return separateThreadPoolKeys;
    }

    public void setSeparateThreadPoolKeys(String separateThreadPoolKeys) {
        this.separateThreadPoolKeys = separateThreadPoolKeys;
    }
}
