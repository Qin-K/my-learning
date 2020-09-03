package com.demo.test;

import com.demo.mapper.UserMapper;
import com.demo.model.Order;
import com.demo.model.User;
import com.demo.util.SessionUtil;
import com.demo.vo.QueryVo;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Demo03_paramType {

    @Test
    // 通过POJO包装类作为参数查询
    public void testQueryVo() {
        SqlSession session = SessionUtil.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);

        QueryVo vo = new QueryVo();
        Order order = new Order();
        order.setNumber("1000010");
        vo.setOrder(order);
        String username = mapper.selectByQueryVo(vo);
        System.out.println(username);
    }

    @Test
    // 通过POJO包装类作为参数查询
    public void testMap() {
        SqlSession session = SessionUtil.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        Map<String, String> map = new HashMap<String, String>();
        map.put("id", "27");
        map.put("username", "qinkai");
        User user = mapper.selectByMap(map);
        System.out.println(user);
    }
}
