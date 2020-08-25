import com.qin_kai.springtest.advancedassemblies.condition.MyBean;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

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
