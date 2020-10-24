import redis.clients.jedis.Jedis;

/**
 * @author qin kai
 * @date 2020/8/18
 */
public class JedisTest {
    public static void main(String[] args) {
        try (Jedis jedis = new Jedis(JedisConstant.HOST, JedisConstant.PORT)) {
            String recv = jedis.ping();
            System.out.println("ping receive server info " + recv);
            String s = jedis.get("1:pageview");
            System.out.println("user 1 pageview " + s);
        }
    }
}
