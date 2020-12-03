package com.zhenzhen.demo.springcloud2.producer.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhen.yin
 * @title:
 * @description:
 * @date 2020/12/2 20:49
 */
@Configuration
public class RabbitmqConfig {

    @Bean
    public Exchange bootExchange(){
        return ExchangeBuilder.topicExchange("bootExchange").durable(true).build();
    }

    @Bean
    public Queue bootQueue(){
        return QueueBuilder.durable("bootQueue").build();
    }

    @Bean
    public Binding bootBinding(){
        return BindingBuilder.bind(bootQueue()).to(bootExchange()).with("yinzhen.#").noargs();
    }




}
