package reflect;

/**
 * @author Qin Kai
 * @date 2019-11-14
 */
public class LoadDifference {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader cl = People.class.getClassLoader();
        cl.loadClass("reflect.People");

        System.out.println(cl);
        Class.forName("reflect.People");
    }
}
