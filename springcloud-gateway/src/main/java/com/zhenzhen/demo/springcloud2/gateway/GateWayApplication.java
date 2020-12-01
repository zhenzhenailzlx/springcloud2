package com.zhenzhen.demo.springcloud2.gateway;

import com.zhenzhen.demo.springcloud2.gateway.config.MyGatewayProperties;
import com.zhenzhen.demo.springcloud2.gateway.filter.factory.MyHystrixGatewayFilterFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.DispatcherHandler;

@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableCircuitBreaker
public class GateWayApplication {

	@Bean
	public MyHystrixGatewayFilterFactory myHystrixGatewayFilterFactory(
			ObjectProvider<DispatcherHandler> dispatcherHandler,MyGatewayProperties myGatewayProperties) {
		return new MyHystrixGatewayFilterFactory(dispatcherHandler,myGatewayProperties);
	}

	@RequestMapping("/ping")
	public String getOrder() {
		return "gateway tong"+System.currentTimeMillis();
	}

	public static void main(String[] args) {

		SpringApplication.run(GateWayApplication.class, args);
	}

}
