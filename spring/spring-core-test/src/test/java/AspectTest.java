import com.qin_kai.springtest.aop.NumberCounter;
import com.qin_kai.springtest.aop.NumberReporter;
import com.qin_kai.springtest.aop.Performer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author qin kai
 * @Date 2020/8/25
 */
public class AspectTest extends BaseTest {

    @Autowired
    private Performer performer;

    @Autowired
    private NumberReporter numberReporter;

    @Autowired
    private NumberCounter numberCounter;

    @Test
    public void testAspect() {
        performer.perform();
    }

    @Test
    public void testAspectWithParam() {
        numberReporter.report(1);
        numberReporter.report(1);
        numberReporter.report(1);
        numberReporter.report(2);
        numberReporter.report(3);
        numberReporter.report(3);

        System.out.printf("1 is reported %s times\n", numberCounter.getCount(1));
        System.out.printf("2 is reported %s times\n", numberCounter.getCount(2));
        System.out.printf("3 is reported %s times\n", numberCounter.getCount(3));
    }


}
