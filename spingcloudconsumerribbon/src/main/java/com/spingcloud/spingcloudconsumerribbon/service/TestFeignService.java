package com.spingcloud.spingcloudconsumerribbon.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author:zhouyuanyuan
 * @Description:
 * @Date:created in ${time} 2018/4/26
 * @Modified By:
 * 3.	接口声明@FeignClient注解，并指定服务提供方实例名。在接口方法上声明调用服务的路径及调用方式，路径与方式必须与service端一致。
 * @FeignClient("provider-service")  里面的provider-service 为调用的项目服务名（调的是springcloudclient服务的某个接口）
 **/
@FeignClient("provider-service")
public interface TestFeignService {

    /**
     * value="/dc" 为所调接口的请求地址
     * @return
     */
    @RequestMapping(value="/dc",method= RequestMethod.GET)
    public String test();
}
