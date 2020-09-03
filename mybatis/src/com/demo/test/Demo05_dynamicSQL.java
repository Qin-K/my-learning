package com.demo.test;

import com.demo.mapper.UserMapper;
import com.demo.model.User;
import com.demo.util.SessionUtil;
import com.demo.vo.QueryVo;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo05_dynamicSQL {
    @Test
    // 测试返回值的不同类型
    public void testWhereIf() {
        SqlSession session = SessionUtil.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);

        QueryVo vo = new QueryVo();
        User user = new User();
        user.setSex("2");
        user.setUsername("张");
        vo.setUser(user);
        List<User> users = mapper.findUserByConditions(vo);
        System.out.println(users);
    }

    @Test
    // 对传入参数中属性为集合类型如List 使用Foreach遍历 拼接Sql
    public void testForeach() {
        SqlSession session = SessionUtil.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);

        QueryVo vo = new QueryVo();
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(10);
        ids.add(27);
        vo.setIds(ids);
        List<User> users = mapper.findUserByIds(vo);
        System.out.println(users);
    }

    @Test
    // 传入参数为集合类型如List 使用Foreach遍历 拼接Sql
    public void testList() {
        SqlSession session = SessionUtil.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);

        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(10);
        ids.add(27);
        List<User> users = mapper.findUserByList(ids);
        System.out.println(users);
    }

}
