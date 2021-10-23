package com.qin_kai.spring.core;

import com.qin_kai.spring.core.hello.SpringConfig;
import com.qin_kai.spring.core.hello.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author qin kai
 * @Date 2020/8/24
 */
@ComponentScan
@EnableAspectJAutoProxy
public class SpringTest {
    public static void main(String[] args) {
        // 获取注解ApplicationContext
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserDao userDao = context.getBean(UserDao.class);
        System.out.println(userDao);
    }
}
