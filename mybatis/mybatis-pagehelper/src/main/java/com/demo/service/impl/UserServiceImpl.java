package com.demo.service.impl;

import com.demo.mapper.UserMapper;
import com.demo.model.User;
import com.demo.service.UserService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public Page<User> getAllUsers() {
        return userMapper.findAllUsers();
    }
}
