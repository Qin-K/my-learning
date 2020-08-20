package com.demo.mapper;

import com.demo.model.User;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    /**
     * 分页查询User，Page包含分页信息
     * @return
     */
    Page<User> findAllUsers();
//    List<User> findAllUsers();
}
