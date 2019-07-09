package com.demo.test;

import com.demo.mapper.OrderMapper;
import com.demo.model.Order;
import com.demo.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class Demo07_lazyAndCache {
    /**
     * 懒加载
     */
    @Test
    public void testLazy() {
        SqlSession session = SessionUtil.openSession();
        OrderMapper orderMapper = session.getMapper(OrderMapper.class);
        List<Order> orders = orderMapper.findOrderAndUserLazy();
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
