package reflect;

/**
 * @author Qin Kai
 * @date 2019-11-13
 */
public class People {
    private String name;
    public People() {}

    public People(String name) {
        this.name = name;
    }

    public String sayHi(String str) {
        return str;
    }

    private String introduce(String str) {
        return str + name;
    }

    static {
        System.out.println("hello world");
    }
}
