package com.qin_kai.guavatest.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author qin kai
 * @date 2020/8/26
 */
public class UserDao {

    private Map<Integer, User> userMap = new HashMap<>();

    private static volatile UserDao userDao;

    public static UserDao getInstance() {
        if (userDao == null) {
            synchronized (UserDao.class) {
                if (userDao == null) {
                    userDao = new UserDao();
                }
            }
        }
        return userDao;
    }

    private UserDao() {
        for (int i = 0; i < 1000; i++) {
            User user = new User();
            user.setName("test" + i);
            user.setUserId(i);
            user.setAge(new Random().nextInt(100));
            userMap.put(i, user);
        }
    }

    public User getUserById(int userId) {
        return userMap.get(userId);
    }
}
