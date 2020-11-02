package com.zhenzhen.demo.spring;

import com.zhenzhen.demo.spring.config.MainConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhen.yin
 * @title:
 * @description:
 * @date 2020/11/2 10:29
 */
public class ApplicationContextTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig.class);

        for (String beanDefinitionName : annotationConfigApplicationContext.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }

        /**
         * org.springframework.context.annotation.internalConfigurationAnnotationProcessor
         * org.springframework.context.annotation.internalAutowiredAnnotationProcessor
         * org.springframework.context.annotation.internalCommonAnnotationProcessor
         * org.springframework.context.event.internalEventListenerProcessor
         * org.springframework.context.event.internalEventListenerFactory
         * mainConfig
         * importTest
         * com.zhenzhen.demo.spring.bean.TestImportBean1
         * testImportSelectBean3
         * com.zhenzhen.demo.spring.bean.TestImportSelectBean1
         * com.zhenzhen.demo.spring.bean.TestImportSelectBean2
         */
    }
}
