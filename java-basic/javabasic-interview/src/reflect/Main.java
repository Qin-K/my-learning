package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Qin Kai
 * @date 2019-11-13
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Class<?> pc = Class.forName("reflect.People");
        System.out.println("class name is " + pc.getName());
        Constructor<?> paramConstructor = pc.getConstructor(String.class);
        People p1 = (People) paramConstructor.newInstance("qinkai");
        Method sayHi = pc.getMethod("sayHi", String.class);
        Object str = sayHi.invoke(p1, "hello");
        System.out.println(str);
        Method introduce = pc.getDeclaredMethod("introduce", String.class);
        introduce.setAccessible(true);
        Object obj = introduce.invoke(p1, "my name is ");
        System.out.println(obj);
        Object p2 = pc.newInstance();
        Field name = pc.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p2, "bob");
        Method introduce2 = pc.getDeclaredMethod("introduce", String.class);
        introduce2.setAccessible(true);
        Object obj2 = introduce2.invoke(p2,"my name is ");
        System.out.println(obj2);

        System.out.println(System.getProperty("java.ext.dirs"));;
        System.out.println(System.getProperty("java.class.path"));
    }
}
