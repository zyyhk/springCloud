package com.springcloud.eurekafeignuploadclient.service;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(value = "consumer-feign-update-server", configuration = UploadService.MultipartSupportConfig.class)
public interface UploadService {

    @RequestMapping(value = "/uploadFile",method = RequestMethod.POST,consumes =MediaType.MULTIPART_FORM_DATA_VALUE )
    String handleFileUpload(@RequestPart(value = "file") MultipartFile file);

    @Configuration
    class MultipartSupportConfig {
        @Bean
        public Encoder feignFormEncoder() {
            return new SpringFormEncoder();
        }
    }

}
