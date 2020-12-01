package com.zhenzhen.demo.springcloud2.gateway.filter.factory;

import com.netflix.hystrix.*;
import com.zhenzhen.demo.springcloud2.gateway.config.MyGatewayProperties;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.gateway.filter.factory.HystrixGatewayFilterFactory;
import org.springframework.web.reactive.DispatcherHandler;
import org.springframework.web.server.ServerWebExchange;

/**
 * @author zhen.yin
 * @title:
 * @description: 原生的HystrixGatewayFilterFactory不支持线程池隔离，在其基础上扩展支持线程池
 * @date 2020/12/1 10:24
 */
public class MyHystrixGatewayFilterFactory extends HystrixGatewayFilterFactory {


    private MyGatewayProperties myGatewayProperties;

    public MyHystrixGatewayFilterFactory(ObjectProvider<DispatcherHandler> dispatcherHandlerProvider) {
        super(dispatcherHandlerProvider);
    }

    public MyHystrixGatewayFilterFactory(ObjectProvider<DispatcherHandler> dispatcherHandler, MyGatewayProperties myGatewayProperties) {
        super(dispatcherHandler);
        this.myGatewayProperties = myGatewayProperties;
    }

    @Override
    protected HystrixObservableCommand.Setter createCommandSetter(Config config, ServerWebExchange exchange) {


        String serviceId = config.getName();

        String groupId = getClass().getSimpleName();
        if(myGatewayProperties.getSeparateThreadPoolKeys().indexOf(serviceId) != -1) {
            groupId = serviceId;
        }

        HystrixObservableCommand.Setter commandSetter = HystrixObservableCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(groupId))
                .andCommandKey(HystrixCommandKey.Factory.asKey(serviceId));

        final HystrixCommandProperties.Setter setter = HystrixCommandProperties.Setter()
                .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD);

        config.setSetter(commandSetter.andCommandPropertiesDefaults(setter));

        return super.createCommandSetter(config,exchange);
    }
}
