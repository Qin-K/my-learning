package com.example;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
public class FileUploadController {
    private final String path = "F:/upload/";

    @PostMapping("/upload")
    public String upload(MultipartFile uploadFile, HttpServletRequest request) {
        try {
            FileUtil.uploadFile(uploadFile, "test");
            return "上传成功";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败";

    }
}
