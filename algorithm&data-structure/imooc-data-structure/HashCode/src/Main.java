import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Qin Kai
 * @date 2019-11-05
 */
public class Main {
    public static void main(String[] args) {
        int a = 42;
        System.out.println(Integer.valueOf(a).hashCode());
        int b = -42;
        System.out.println(Integer.valueOf(b).hashCode());
        double c = 3.1415926;
        System.out.println(Double.valueOf(c).hashCode());
        String d = "imooc";
        System.out.println(d.hashCode());

        Student student = new Student(3, 2, "bobo", "liu");
        System.out.println(student.hashCode());

        Set<Student> set = new HashSet<>();
        set.add(student);
        Map<Student, Integer> scores = new HashMap<>();
        scores.put(student, 100);

        Student student2 = new Student(3, 2, "bobo", "liu");
        System.out.println(student2.hashCode());
    }
}
