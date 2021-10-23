import com.qin_kai.spring.core.advancedassemblies.valueinjection.SpEL;
import com.qin_kai.spring.core.advancedassemblies.valueinjection.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * @author qin kai
 * @Date 2020/8/25
 */
public class ValueInjectionTest extends BaseTest {

    @Resource
    private User user;

    @Resource
    private User user2;

    @Autowired
    private SpEL spEL;

    @Test
    public void test() {
        System.out.println(user);
        System.out.println(user2);
    }

    @Test
    public void testSpEL() {
        System.out.println(spEL);
    }

}
