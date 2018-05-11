package com.springcloud.springcloudclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:zhouyuanyuan
 * @Description:
 * @Date:created in ${time} 2018/4/18
 * @Modified By:
 **/
@RestController
public class TestController {

    @Value("${server.port}")
    String port;

    @Autowired
    DiscoveryClient discoveryClient;


    @RequestMapping("/hi")
    public String home(@RequestParam String name) {
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
        return "hi "+name+",i am from port:" +port;
    }

    @RequestMapping("/dc")
    public String consumer() {
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
        return "hi ,i am from port:" +port;
    }
}
