package map;
import java.util.*;

public class MapTest {

	public static void main(String[] args) {
	Map<String, Employee> staff = new HashMap<>();
	staff.put("144-25-5464", new Employee("Amy Lee"));
	staff.put("567-24-2546", new Employee("Harry Hacker"));
	staff.put("157-62-7935", new Employee("Gary Cooper"));
	staff.put("456-62-5527", new Employee("Francesca Cruz"));
	// 打印所有值
	System.out.println(staff);
	// 删除一个值
	staff.remove("567-24-2546");
	// 替换一个值
	staff.put("456-62-5527", new Employee("Francesca Miller"));
	
	System.out.println(staff.get("157-62-7935"));
	
	// 迭代所有值
	staff.forEach((k, v) ->
		System.out.println("key=" + k + ", value=" + v));
	
	}

}
