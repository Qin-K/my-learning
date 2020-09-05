import org.junit.Test;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

public class UserServiceTest {

    private UserService userService = UserService.getInstance();

    @Test
    public void addUser() {
        User user = new User();
        user.setUserId("123456");
        user.setUsername("hello");
        user.setAge(20);
        userService.addUser(user);
    }

    @Test
    public void removeUser() {
        userService.removeUser("AXOkJjiz1lyoMPyk7o-L");
    }

    @Test
    public void updateUser() throws ExecutionException, InterruptedException {
        User user = new User();
        user.setUserId("123456");
        user.setUsername("hello");
        user.setAge(25);
        userService.updateUser(user);
    }


    @Test
    public void getUser() {
        User user = userService.getUser("123456");
        System.out.println(user);
    }
}