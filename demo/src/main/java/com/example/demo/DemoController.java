package com.example.demo;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author qinkai
 * @date 2023/8/14
 */
@RestController
public class DemoController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/demo")
    public String demo() {
        return "Hello " + port;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }


    @GetMapping("/video.mp4")
    public void video(HttpServletResponse response) throws IOException {
        try (FileInputStream fis = new FileInputStream("E:\\materials\\孤勇者.mp4")) {
            IOUtils.copy(fis, response.getOutputStream());
        }
    }

}
