package textFile;
import java.io.*;
import java.time.*;
import java.util.*;

public class TextFileTest {
	public static void main(String[] args) throws IOException {
		Employee[] staff = new Employee[3];
		
		staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
		staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
		staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 14);
		
		try(PrintWriter out = new PrintWriter("employee.dat", "UTF-8")){
			writeData(staff, out);
		}
		
		try (Scanner in = new Scanner(new FileInputStream("employee.dat"), "UTF-8")){
			Employee[] newStaff = readData(in);
			for (Employee e : newStaff) {
				System.out.println(e);
			}
		}
		
		
	}
	
	/**
	 * 将数组中的所有Employee对象写入
	 * @param employees Employee数组
	 * @param out a PrintWriter
	 */
	private static void writeData(Employee[] employees, PrintWriter out) {
		// 输出数组长度
		out.println(employees.length);
		
		// 将数组中的所有employee写入
		for (Employee e : employees) {
			writeEmployee(out, e);
		}
	}
	/**
	 * 从Scanner中读入所有Employee对象并储存到数组中返回
	 * @param in the Scanner
	 * @return the array of employees 
	 */
	private static Employee[] readData(Scanner in) {
		// 获取数组长度
		int n = in.nextInt();
		in.nextLine(); // 跳过换行
		
		Employee[] employees = new Employee[n];
		for (int i = 0; i < n; i++) {
			employees[i] = readEmployee(in);
		}
		
		return employees;
	}
	/**
	 * 将Employee的数据写入
	 * @param out the print writer
	 */
	public static void writeEmployee(PrintWriter out, Employee e) {
		out.println(e.getName() + "|" + e.getSalary() + "|" + e.getHireDay());
	}
	/**
	 * 从bufferdreader中读取一个Employee信息并返回
	 * @param in the scanner
	 */
	public static Employee readEmployee(Scanner in) {
		String line = in.nextLine();
		String[] tokens = line.split("\\|");
		String name = tokens[0];
		double salary = Double.parseDouble(tokens[1]);
		LocalDate hireDate = LocalDate.parse(tokens[2]);
		int year = hireDate.getYear();
		int month = hireDate.getMonthValue();
		int day = hireDate.getDayOfMonth();
		
		return new Employee(name, salary, year, month, day);
	}
}
