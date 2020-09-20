import com.qin_kai.spring.core.advancedassemblies.condition.MyBean;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author qin kai
 * @Date 2020/8/25
 */

public class ConditionalTest extends BaseTest{

    @Autowired
    private MyBean myBean;

    @Test
    public void testConditional() {
        System.out.println(myBean);
    }

}
