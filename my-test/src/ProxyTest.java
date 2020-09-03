import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Qin Kai
 * @date 2019-12-16
 */
public class ProxyTest {
    public class ConnectionHandler implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return null;
        }
    }

    public static void main(String[] args) throws SQLException {
        ProxyTest test = new ProxyTest();
        Connection conn = (Connection)Proxy.newProxyInstance(Connection.class.getClassLoader(), new Class[]{Connection.class},
                test.new ConnectionHandler());
        conn.commit();
    }
}
