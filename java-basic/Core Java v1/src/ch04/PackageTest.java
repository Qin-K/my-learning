package ch04;
import com.horstmann.corejava.*;
public class PackageTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee harry = new Employee("Harry Hacker", 50000, 1989, 10, 1);
		
		harry.raiseSalary(5);
		
		System.out.println("name=" + harry.getName() + ",salary=" + harry.getSalary());
	}

}
