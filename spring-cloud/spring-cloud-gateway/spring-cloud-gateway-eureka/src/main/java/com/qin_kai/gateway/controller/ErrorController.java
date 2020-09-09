package com.qin_kai.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qin kai
 * @Date 2020/9/9
 */
@RestController
public class ErrorController {

    @RequestMapping("/error")
    public String error() {
        return "sorry, some error happened.";
    }

}
