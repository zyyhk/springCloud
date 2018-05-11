package com.springcloud.springcloudclient.API.support;

import com.springcloud.springcloudclient.API.TestAPI;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:zhouyuanyuan
 * @Description:
 * @Date:created in ${time} 2018/4/26
 * @Modified By:
 **/
@RestController
public class TestAPISupport implements TestAPI {
    @Override
    public String hello(String name) {
        return "hello " + name;
    }
}
