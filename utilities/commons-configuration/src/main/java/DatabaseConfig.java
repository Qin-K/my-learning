import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

/**
 * @author qin kai
 * @date 2020/8/24
 */
public class DatabaseConfig {
    private static Configuration config;
    static {
        try {
            Configurations configs = new Configurations();
            config = configs.properties("database-config.properties");
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }

    public static final String HOST = config.getString("database.host");
    public static final int PORT = config.getInt("database.port");
    public static final String USER = config.getString("database.user");
    public static final String PASSWORD = config.getString("database.password");
    public static final String TIMEOUT = config.getString("database.timeout");

}
