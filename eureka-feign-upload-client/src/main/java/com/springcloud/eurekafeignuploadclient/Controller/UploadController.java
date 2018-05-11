package com.springcloud.eurekafeignuploadclient.Controller;

import com.springcloud.eurekafeignuploadclient.service.UploadService;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @Author:zhouyuanyuan
 * @Description:
 * @Date:created in ${time} 2018/5/10
 * @Modified By:
 **/
@RestController
public class UploadController {
    @Autowired
    private UploadService uploadService;


    @PostMapping(value = "/uploadFiles")
    public String testHandleFileUpload() {

        File file = new File("upload.txt");
        DiskFileItem fileItem = (DiskFileItem) new DiskFileItemFactory().createItem("file",
                MediaType.TEXT_PLAIN_VALUE, true, file.getName());

        try (InputStream input = new FileInputStream(file); OutputStream os = fileItem.getOutputStream()) {
            IOUtils.copy(input, os);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid file: " + e, e);
        }

        MultipartFile multi = new CommonsMultipartFile(fileItem);
       return uploadService.handleFileUpload(multi);
    }
}
