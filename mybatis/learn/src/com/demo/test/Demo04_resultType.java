package com.demo.test;

import com.demo.mapper.UserMapper;
import com.demo.model.User;
import com.demo.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class Demo04_resultType {
    @Test
    // 测试返回值的不同类型
    public void testReturn() {
        SqlSession session = SessionUtil.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
//        List<User> users = mapper.findAll(); 查询所有用户返回List集合
//        System.out.println(users);

        User user = mapper.findUserReturnMap(27);
        System.out.println(user);
    }
}
