package com.qin_kai.mongo;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@SpringBootTest
@RunWith(SpringRunner.class)
class UserDaoImplTest {

    @Autowired
    private UserDao userDao;

    private User buildUser() {
        User user = new User();
        user.setUserId(UUID.randomUUID().toString().replace("-", ""));
        user.setName("test");
        Random random = new Random();
        user.setAge(random.nextInt(100));
        return user;
    }

    @Test
    void insert() {
        User user = buildUser();
        userDao.insert(user);
    }

    @Test
    void update() {
        User user = buildUser();
        userDao.insert(user);
        user.setName("hhh");
        int effectNum = userDao.update(user);
        Assert.assertEquals(1, effectNum);
    }

    @Test
    void findUserById() {
        User user = buildUser();
        userDao.insert(user);
        User userResult = userDao.findUserById(user.getUserId());
        Assert.assertEquals(user, userResult);
    }

    @Test
    void remove() {
        User user = buildUser();
        userDao.insert(user);
        int effectNum = userDao.remove(user.getUserId());
        Assert.assertEquals(1, effectNum);
    }

    @Test
    void findUserList() {
        List<User> userList = userDao.findUserList(2, 2);
        Assert.assertEquals(2, userList.size());
    }
}