package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class HelloController {

    @RequestMapping("hello")
    public String hello(Model model) {
        model.addAttribute("now", new Date());
        return "hello";
    }
}
