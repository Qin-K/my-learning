package com.qin_kai.mongo;

import java.util.List;

/**
 * @author qin kai
 * @date 2020/8/28
 */
public interface UserDao {

    /**
     * 添加用户
     * @param user
     * @return
     */
    void insert(User user);

    /**
     * 修改用户
     * @param user
     * @return
     */
    int update(User user);

    /**
     * 通过userId查询用户信息
     * @param userId
     * @return
     */
    User findUserById(String userId);

    /**
     * 删除用户
     * @param userId
     * @return
     */
    int remove(String userId);

    /**
     * 查询用户列表 支持分页
     * @return
     */
    List<User> findUserList(int pageNum, int pageSize);

}
