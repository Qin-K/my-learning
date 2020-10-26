package com.qin_kai.validation.controller;

import com.qin_kai.validation.dto.HttpResult;
import com.qin_kai.validation.dto.UserRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author qinkai
 * @date 2020/10/26
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/register")
    public HttpResult register(@RequestBody @Valid UserRequest userRequest) {
        return HttpResult.success("注册成功");
    }

}
