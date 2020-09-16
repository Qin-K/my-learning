import com.sun.javafx.binding.StringFormatter;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

/**
 * @author qin kai
 * @Date 2020/8/18
 */
public class PipelineTest {
    public static void main(String[] args) {
        try(Jedis jedis = new Jedis(JedisConstant.HOST, JedisConstant.PORT)) {
            Pipeline pipeline = jedis.pipelined();
            for (int userId = 0; userId < 10000; userId++) {
                String userPageViewKey = StringFormatter.format("%d:pageview",userId).getValue();
                pipeline.set(userPageViewKey, "0");
            }
            pipeline.sync();
        }
    }
}
