package com.springcloud.eurekafeignuploadserver.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author:zhouyuanyuan
 * @Description:
 * @Date:created in ${time} 2018/5/7
 * @Modified By:
 **/
@RestController
public class UploadController {

    @RequestMapping(value = "/uploadFile",method = RequestMethod.POST,consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String handleFileUpload(@RequestPart(value = "file") MultipartFile file) {
        System.out.println("开始");
        return file.getName();
    }

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public String test() {
        return "test";
    }
}
