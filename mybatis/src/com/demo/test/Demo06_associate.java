package com.demo.test;

import com.demo.mapper.OrderMapper;
import com.demo.mapper.UserMapper;
import com.demo.model.Order;
import com.demo.model.User;
import com.demo.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class Demo06_associate {

    /**
     * 一对多的情况中，查询多的一方单一数据，包含一的一方的数据
     * 通过多的一方的模型添加一的对象
     */
    @Test
    public void testModelInModel() {
        SqlSession session = SessionUtil.openSession();
        OrderMapper mapper = session.getMapper(OrderMapper.class);
        Order order = mapper.selectOrderById(3);
        System.out.println(order);
    }

    /**
     * 一对多的情况中，查询一的一方单一数据，包含多的一方的所有数据
     * 通过一的一方的模型添加一的集合
     */
    @Test
    public void testListInModel() {
        SqlSession session = SessionUtil.openSession();
        OrderMapper mapper = session.getMapper(OrderMapper.class);
        Order order = mapper.selectOrderById3(3);
        System.out.println(order);
    }

    /**
     * 测试多对多
     */
    @Test
    public void testManytoMany() {
        SqlSession session = SessionUtil.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<User> users = userMapper.findUserAndOrders();
        System.out.println(users);
    }
}
