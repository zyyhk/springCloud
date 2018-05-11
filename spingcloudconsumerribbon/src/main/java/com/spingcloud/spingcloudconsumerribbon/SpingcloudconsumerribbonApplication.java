package com.spingcloud.spingcloudconsumerribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 为了构建更为健壮的应用系统，
 * 我们希望当请求失败的时候能够有一定策略的重试机制，
 * 而不是直接返回失败。
 * 这个时候就需要开发人员人工的来为上面的RestTemplate
 * 调用实现重试机制。
 * 2.	在应用启动入口添加@EnableFeignClients注解，并指定扫描@FeignClient注解的包路径，可定义多个，用逗号间隔
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableCircuitBreaker
@EnableFeignClients({"com.spingcloud.spingcloudconsumerribbon.service"})
public class SpingcloudconsumerribbonApplication {
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(SpingcloudconsumerribbonApplication.class, args);
	}
}
