package com.qin_kai.shiro.controller;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author qinkai
 * @date 2020/10/26
 */
@Controller
public class UIController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UIController.class);

    @RequestMapping("/login")
    public String login(HttpServletRequest request, Model model) {
        String exception= (String) request.getAttribute("shiroLoginFailure");
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                LOGGER.info("UnknownAccountException -- > 账号不存在：");
                msg = "UnknownAccountException -- > 账号不存在：";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                LOGGER.info("IncorrectCredentialsException -- > 密码不正确：");
                msg = "IncorrectCredentialsException -- > 密码不正确：";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                LOGGER.info("kaptchaValidateFailed -- > 验证码错误");
                msg = "kaptchaValidateFailed -- > 验证码错误";
            } else {
                msg = "else >> "+exception;
                LOGGER.info("else -- >" + exception);
            }
        }
        model.addAttribute("msg", msg);
        return "/login";
    }

    @GetMapping("/403")
    public String unAuthorized() {
        return "403";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

}
