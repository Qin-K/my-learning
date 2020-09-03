package com.demo.test;

import com.demo.mapper.UserMapper;
import com.demo.model.User;
import com.demo.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class Demo02_mapper {
    @Test
    // 使用Mapper代理(Dao)
    public void testMapper() {
        SqlSession session = SessionUtil.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);

        User user = mapper.select(27);
        System.out.println(user);
//        User user = new User("qinkai", "1", new Date(), "上海");
//        mapper.save(user);
//        mapper.delete(30);
        session.commit();
        session.close();
    }
}
