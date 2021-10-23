import com.qin_kai.spring.core.assemblebean.CDPlayer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author qin kai
 * @Date 2020/8/24
 */
public class AssembleBeanTest extends BaseTest {

    @Autowired
    private CDPlayer cdPlayer;

    @Test
    public void testAssemble() {
        cdPlayer.play();
    }
}
