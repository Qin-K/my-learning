package com.example.web;

import com.example.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello() throws Exception {
        throw new Exception("发生错误");
    }

    @GetMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("host", "www.baidu.com");
        return "index";
    }

    @GetMapping("/json")
    public String json() throws MyException {
        throw new MyException("发生错误，返回json");
    }
}
