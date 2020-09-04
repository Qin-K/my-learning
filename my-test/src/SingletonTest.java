/**
 * @author Qin Kai
 * @date 2019-11-29
 */
public class SingletonTest {
    private static SingletonTest instance = new SingletonTest();

    private SingletonTest() {}

    public static SingletonTest getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        SingletonTest test = getInstance();
        System.out.println(test);
        test = null;
        System.out.println(getInstance());
    }
}
