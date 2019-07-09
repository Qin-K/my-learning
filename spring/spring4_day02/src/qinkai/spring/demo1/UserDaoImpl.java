package qinkai.spring.demo1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("userDao")
public class UserDaoImpl implements UserDao {
    @Value("张三")
    private String name;

    @Override
    public void save() {
        System.out.println("UserDao:" + name);
    }

}
