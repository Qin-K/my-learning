import model.User;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class JsonUtilTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtilTest.class);
    private User user = new User("zhangsan", 18, "man");

    @Test
    public void serialize() {
        String json = JsonUtil.serialize(user);
        System.out.println(json);
    }

    @Test
    public void parse() {
        String json = "{\"username\":\"zhangsan\",\"age\":18,\"gender\":\"man\"}";
        User user = JsonUtil.parse(json, User.class);
        System.out.println(user);
    }

    @Test
    public void parseList() {
        List<User> userList = new ArrayList<>();
        userList.add(user);
        String json = JsonUtil.serialize(userList);
        List<User> users = JsonUtil.parseList(json, User.class);
        Assert.assertEquals(userList, users);
    }

    @Test
    public void parseMap() {
        Map<String, User> userMap = new HashMap<>();
        userMap.put(user.getUsername(),user);
        String json = JsonUtil.serialize(userMap);
        Map<String, User> userMap1 = JsonUtil.parseMap(json, String.class, User.class);
        Assert.assertEquals(userMap, userMap1);
    }
}