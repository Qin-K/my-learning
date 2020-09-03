package com.demo.test;

import com.demo.model.User;
import com.demo.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class Demo01_first {

    SqlSession session = SessionUtil.openSession();

    @Test
    // 查询
    public void testSelect() {

        // 执行SqlSession方法处理数据库
        // 查询一条记录
        // User user = session.selectOne("selectUserById", 10);
        // System.out.println(user);
        // 模糊查询查询多条记录封装到List
        List<User> users = session.selectList("selectUserByName", "张");
        System.out.println(users);
        // 关闭session
        session.close();
    }

    @Test
    // 插入
    public void testInsert() {
        // 创建要插入的User对象
        User user = new User("qinkai", "1", new Date(), "四川");
        session.insert("insertUser", user);
        session.commit();
    }

    @Test
    // 插入后返回主键
    public void testInsert2() {
        // 创建要插入的User对象
        User user = new User("qinkai", "1", new Date(), "四川");
        session.insert("insertUser2", user);
        session.commit();

        System.out.println(user.getId());
    }

    @Test
    // 删除
    public void testDelete() {
        session.delete("deleteUser", 27);
        session.commit();
    }

    @Test
    // 更新
    public void testUpdate() {
        User user = session.selectOne("selectUserById", 27);
        user.setAddress("上海");
        user.setBirthday(new Date());
        session.update("updateUser", user);
        session.commit();
    }
}
