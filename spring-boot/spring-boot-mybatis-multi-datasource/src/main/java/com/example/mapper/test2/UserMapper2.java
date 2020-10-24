package com.example.mapper.test2;

import com.example.model.User;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

/**
 * @author qin kai
 * @date 2020/8/27
 */
@Repository
public interface UserMapper2 {
    @Insert("INSERT INTO user(name) values(#{name})")
    int insert(User user);
}
