package com.demo.service;

import com.demo.model.User;
import com.github.pagehelper.Page;

public interface UserService {

    Page<User> getAllUsers();
}
