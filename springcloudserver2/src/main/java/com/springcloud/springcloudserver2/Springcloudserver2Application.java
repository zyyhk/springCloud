package com.springcloud.springcloudserver2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Springcloudserver2Application {

	public static void main(String[] args) {
		SpringApplication.run(Springcloudserver2Application.class, args);
	}
}
