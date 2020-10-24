package com.qin_kai.guavatest.cache;

import com.google.common.cache.CacheLoader;

/**
 * @author qin kai
 * @date 2020/8/26
 */
public class UserCacheLoader extends CacheLoader<Integer, User> {

    @Override
    public User load(Integer key) throws Exception {
        return UserDao.getInstance().getUserById(key);
    }
}
