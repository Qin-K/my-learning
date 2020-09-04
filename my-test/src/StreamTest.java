import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Qin Kai
 * @date 2020-01-03
 */

class Person {
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " is " + age + " years old.";
    }
}
public class StreamTest {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("张三", 18));
        list.add(new Person("李四", 20));
        list.add(new Person("王五", 25));
        List<Person> collect = list.stream()
                .filter(person -> person.getAge() > 20)
                .collect(Collectors.toList());
        System.out.println(collect);
    }
}
