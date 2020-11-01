package com.zhenzhen.demo.springcloud2.orderservice;

import com.zhenzhen.demo.springcloud2.orderservice.util.HttpClientUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class OrderServiceApplication {

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate(HttpClientUtil.createClientHttpRequestFactory());
		return restTemplate;
	}

	public static void main(String[] args) {

		SpringApplication.run(OrderServiceApplication.class, args);
	}

}
