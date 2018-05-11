package com.springcloud.springcloudconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author:zhouyuanyuan
 * @Description:loadBalancerClient 的学习
 * @Date:created in ${time} 2018/4/22
 * @Modified By: A项目直接使用restTemplate 请求B项目接口
 *
 * 我们注入了LoadBalancerClient和RestTemplate，
 * 并在/consumer接口的实现中，先通过loadBalancerClient的choose函数来负载均衡的选出一个provider-service的服务实例，
 * 这个服务实例的基本信息存储在ServiceInstance中，然后通过这些对象中的信息拼接出访问/hi接口的详细地址，
 * 最后再利用RestTemplate对象实现对服务提供者接口的调用。
 **/
@RestController
public class DcController {
    @Autowired
    LoadBalancerClient loadBalancerClient;
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/consumer")
    public String dc() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("provider-service");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/hi?name=111";
        System.out.println(url);
        return restTemplate.getForObject(url, String.class);
    }
}
