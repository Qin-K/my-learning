package com.qin_kai.h2.mapper;

import com.qin_kai.h2.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author qinkai
 * @date 2020/10/24
 */
@Repository
public interface UserMapper {

    @Insert("insert into user(name, age) values(#{name}, #{age})")
    int insertUser(User user);

    @Select("select * from user where userId = #{userId}")
    User selectUserById(Integer userId);
}

