package com.springcloud.eurekafeignuploadclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@EnableCircuitBreaker
@EnableFeignClients({"com.springcloud.eurekafeignuploadclient.service"})
public class EurekaFeignUploadClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaFeignUploadClientApplication.class, args);
	}
}
