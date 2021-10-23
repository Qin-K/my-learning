import com.qin_kai.spring.core.advancedassemblies.profile.MyDataSource;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ActiveProfiles;

/**
 * @author qin kai
 * @Date 2020/8/25
 */
//@ActiveProfiles("dev")
@ActiveProfiles("prod")
public class ProfileTest extends BaseTest {

    @Autowired
    @Qualifier("dataSource")
    private MyDataSource myDataSource;

    @Test
    public void testProfile() {
        System.out.println(myDataSource.getName());
    }

}
