package com.example;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
public class FileUploadController {
    private final String path = "F:/upload/";

    @PostMapping("/upload")
    public String upload(MultipartFile uploadFile, HttpServletRequest request) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());
        File folder = new File(path + date);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        String oldName = uploadFile.getOriginalFilename();
        String ext = oldName.substring(oldName.lastIndexOf("."));
        String newName = UUID.randomUUID().toString() + ext;

        try {
            uploadFile.transferTo(new File(folder, newName));

            return "上传成功";
         } catch (IOException e) {
            e.printStackTrace();
        }

        return "上传失败";

    }
}
