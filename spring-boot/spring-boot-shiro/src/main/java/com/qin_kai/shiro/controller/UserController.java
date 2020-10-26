package com.qin_kai.shiro.controller;

import com.qin_kai.shiro.model.UserInfo;
import com.qin_kai.shiro.service.UserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;

/**
 * @author qinkai
 * @date 2020/10/26
 */
@Controller
public class UserController {

    @Resource
    private UserInfoService userInfoService;

    @PostMapping("/register")
    public String register(UserInfo userInfo, Model model) {
        userInfoService.register(userInfo);
        model.addAttribute("msg", "注册成功，请登录");
        return "login";
    }
}
