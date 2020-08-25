import com.qin_kai.springtest.SpringTest;
import com.qin_kai.springtest.advancedassemblies.scope.PrototypeBean;
import com.qin_kai.springtest.advancedassemblies.scope.SingletonBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author qin kai
 * @Date 2020/8/25
 */
public class ScopeTest extends BaseTest {

    @Test
    public void testScope() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringTest.class);
        SingletonBean singletonBean1 = context.getBean(SingletonBean.class);
        SingletonBean singletonBean2 = context.getBean(SingletonBean.class);
        System.out.println("两次获取 SingletonBean 是否相等？" + (singletonBean1 == singletonBean2));

        PrototypeBean prototypeBean1 = context.getBean(PrototypeBean.class);
        PrototypeBean prototypeBean2 = context.getBean(PrototypeBean.class);
        System.out.println("两次获取 PrototypeBean 是否相等？" + (prototypeBean1 == prototypeBean2));

    }

}
