package com.spingcloud.spingcloudconsumerribbon.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.spingcloud.spingcloudconsumerribbon.service.TestFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author:zhouyuanyuan
 * @Description:Ribbon 的学习
 * @Date:created in ${time} 2018/4/22
 * @Modified By: A项目直接使用restTemplate 请求B项目接口
 * 可以看到这里，我们除了去掉了原来与LoadBalancerClient相关的逻辑之外，
 * 对于RestTemplate的使用，我们的第一个url参数有一些特别。
 * 这里请求的host位置并没有使用一个具体的IP地址和端口的形式，
 * 而是采用了服务名的方式组成。那么这样的请求为什么可以调用成功呢？
 * 因为Spring Cloud Ribbon有一个拦截器，它能够在这里进行实际调用的时候，
 * 自动的去选取服务实例，并将实际要请求的IP地址和端口替换这里的服务名，
 * 从而完成服务接口的调用。
 *
 **/
@RestController
public class DcController {
    @Autowired
    LoadBalancerClient loadBalancerClient;
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private TestFeignService testFeignService;


    /**
     *    @HystrixCommand(fallbackMethod="error") 方法报错 之后会走error() 方法
     * @return
     */
    @GetMapping("/test")
    @HystrixCommand(fallbackMethod="error")
   // @Retryable(value = { RemoteAccessException.class }, maxAttempts = 3, backoff = @Backoff(delay = 5000l, multiplier = 1))
    public String dc() {
        System.out.println("使用Spring Cloud Ribbon 服务器直接相互调用");
        return restTemplate.getForObject("http://provider-service/hi?name=222", String.class);
    }

    public String error(){
        return "rquest error";
    }

    /** 用来测试Feign
     * Spring Cloud Feign是一套基于Netflix Feign实现的声明式服务调用客户端。它使得编写Web服务客户端变得更加简单。我们只需要通过创建接口并用注解来配置它既可完成对Web服务接口的绑定。它具备可插拔的注解支持，包括Feign注解、JAX-RS注解。
     * 它也支持可插拔的编码器和解码器。Spring Cloud Feign还扩展了对Spring MVC注解的支持，
     * 同时还整合了Ribbon和Eureka来提供均衡负载的HTTP客户端实现。
     *
     * 通过@FeignClient定义的接口来统一的生命我们需要依赖的微服务接口。而在具体使用的时候就跟调用本地方法一点的进行调用即可。
     * 由于Feign是基于Ribbon实现的，所以它自带了客户端负载均衡功能，也可以通过Ribbon的IRule进行策略扩展。另外，
     * Feign还整合的Hystrix来实现服务的容错保护，
     * 在Dalston版本中，Feign的Hystrix默认是关闭的。待后文介绍Hystrix带领大家入门之后，我们再结合介绍Feign中的Hystrix以及配置方式。
     * @return
     */
    @GetMapping("/consumer")
    public  String testFeign(){

        return testFeignService.test();
    }

}
