package com.springcloud.springcloudclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@SpringBootApplication
@EnableEurekaClient
public class SpringcloudclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudclientApplication.class, args);
	/*	new SpringApplicationBuilder(
				SpringcloudclientApplication.class)
				.web(true).run(args);*/
	}
}
