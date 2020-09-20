import com.qin_kai.spring.core.advancedassemblies.conflict.Dessert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author qin kai
 * @Date 2020/8/25
 */
public class ConflictTest extends BaseTest{

    @Autowired
    // qualifier 指定 bean id解决冲突
//    @Qualifier("myIceCream")
//    @Resource 使用Resource属性名改为bean id
    private Dessert myIceCream;

    @Test
    public void testConflict() {
        System.out.println(myIceCream.getClass());
    }

}
