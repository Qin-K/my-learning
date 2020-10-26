package com.qin_kai.shiro.repository;

import com.qin_kai.shiro.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserInfoRepositoryTest {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Test
    void test() {
        List<UserInfo> all = userInfoRepository.findAll();
        System.out.println(all);
    }

}