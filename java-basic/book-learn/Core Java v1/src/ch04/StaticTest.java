package ch04;

public class StaticTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee1[] staff = new Employee1[3];
		
		staff[0] = new Employee1("Tom", 40000);
		staff[1] = new Employee1("Dick", 60000);
		staff[2] = new Employee1("Harry", 65000);
		
		for (Employee1 e : staff) {
			e.setId();
			System.out.println("name=" + e.getName() + ", id=" + e.getId() + ", salary=" + e.getSalary());
		}
		
		int n = Employee1.getNextId();
		System.out.println("Next available id=" + n);
	}

}
class Employee1{
	private static int nextId = 1;
	private String name;
	private double salary;
	private int id;
	
	public Employee1(String n, double s) {
		name = n;
		salary = s;
	}
	
	public String getName() {
		return name;
	}
	public double getSalary() {
		return salary;
	}
	public int getId() {
		return id;
	}
	public void setId() {
		id = nextId;
		nextId++;
	}
	
	public static int getNextId() {
		return nextId;
	}
	public static void main(String[] args) {
		Employee1 e = new Employee1("Harry", 50000);
		System.out.println(e.getName() + " " + e.getSalary());
	}
}


