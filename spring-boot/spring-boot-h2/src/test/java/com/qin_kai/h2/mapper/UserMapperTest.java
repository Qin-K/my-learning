package com.qin_kai.h2.mapper;

import com.qin_kai.h2.model.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    void insertUser() {
        User user = new User();
        user.setName("test");
        user.setAge(18);
        int effectNum = userMapper.insertUser(user);
        Assert.assertEquals(1, effectNum);
    }

    @Test
    void selectUserById() {
        User user = userMapper.selectUserById(1);
        System.out.println(user);
    }
}