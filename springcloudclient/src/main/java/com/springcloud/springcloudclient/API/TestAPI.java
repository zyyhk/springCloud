package com.springcloud.springcloudclient.API;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author:zhouyuanyuan
 * @Description:
 * @Date:created in ${time} 2018/4/26
 * @Modified By:
 **/
@RequestMapping("provider-service")
public interface TestAPI {
    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);


}
