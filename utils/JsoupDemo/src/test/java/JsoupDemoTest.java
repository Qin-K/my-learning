import org.junit.Test;

public class JsoupDemoTest {

    private JsoupDemo jsoupDemo = new JsoupDemo();

    @Test
    public void helloJsoup() {
        jsoupDemo.helloJsoup();
    }

    @Test
    public void headerDemo() {
        jsoupDemo.headerDemo();
    }

    @Test
    public void parseHtmlDemo() {
        jsoupDemo.parseHtmlDemo();
    }
}