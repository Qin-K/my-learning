package com.example;

import com.example.mapper.test1.UserMapper1;
import com.example.mapper.test2.UserMapper2;
import com.example.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author qin kai
 * @Date 2020/8/27
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MapperTest {

    @Autowired
    private UserMapper1 mapper1;

    @Autowired
    private UserMapper2 mapper2;

    @Test
    public void test() {
        User user1 = new User("test1");
        User user2 = new User("test2");
        mapper1.insert(user1);
        mapper2.insert(user2);
    }

}
