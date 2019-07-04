package com.example;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 上传文件工具类
 */
public class FileUtil {

    private static final String BASE_PATH = "F:/upload/";

    /**
     * @param uploadFile MutipartFile
     * @param parent 父文件夹
     * @return 文件夹路径
     * @throws IOException
     */
    public static String uploadFile(MultipartFile uploadFile, String parent) throws IOException {

        String path = BASE_PATH + parent;
        String oldName = uploadFile.getOriginalFilename();
        String ext = oldName.substring(oldName.lastIndexOf("."));
        String newName = UUID.randomUUID().toString().replaceAll("-", "") + ext;
        File floder = new File(path);
        if (!floder.exists()){
            floder.mkdirs();
        }

        uploadFile.transferTo(new File(path, newName));
        return "/upload/" + parent + "/" + newName;
    }

}
