package com.qin_kai.springtest;

import com.qin_kai.springtest.hello.SpringConfig;
import com.qin_kai.springtest.hello.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author qin kai
 * @Date 2020/8/24
 */
@ComponentScan
public class SpringTest {
    public static void main(String[] args) {
        // 获取注解ApplicationContext
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserDao userDao = context.getBean(UserDao.class);
        System.out.println(userDao);
    }
}
