package com.example.mapper.test1;

import com.example.model.User;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

/**
 * @author qin kai
 * @date 2020/8/27
 */
@Repository
public interface UserMapper1 {
    @Insert("INSERT INTO user(name) values(#{name})")
    int insert(User user);
}
