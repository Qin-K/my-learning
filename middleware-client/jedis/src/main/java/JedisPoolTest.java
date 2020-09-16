import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Set;

/**
 * @author qin kai
 * @Date 2020/8/18
 */
public class JedisPoolTest {
    private static GenericObjectPoolConfig config = new GenericObjectPoolConfig();
    private static JedisPool jedisPool;
    static {
        config.setMaxIdle(20);
        config.setMaxTotal(20);
        jedisPool= new JedisPool(config, JedisConstant.HOST, JedisConstant.PORT);
    }
    public static void main(String[] args) {
        try (Jedis jedis = jedisPool.getResource()) {
            Set<String> members = jedis.smembers("user:1:follow");
            System.out.println(members);
        }
        jedisPool.close();
    }
}
