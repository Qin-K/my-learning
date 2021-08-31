package ch04;

import java.util.Random;

public class ConstructorTest {
	public static void main(String[] args) {
		Employee3[] staff = new Employee3[3];
		
		staff[0] = new Employee3("Harry", 40000);
		staff[1] = new Employee3(60000);
		staff[2] = new Employee3();
		
		for (Employee3 e : staff) {
			System.out.println("name=" + e.getName() + ",id=" + e.getId() + ",salary=" + e.getSalary());
		}
	}
}
class Employee3{
	private static int nextId;
	
	private int id;
	private String name = ""; // ��ʼ��ʵ��
	private double salary;
	
	// ��̬��ʼ����
	static
	{
		Random generator = new Random();
		nextId = generator.nextInt(1000);
	}
	
	// �����ʼ����
	{
		id = nextId;
		nextId++;
	}
	// ���캯��������
	public Employee3(String n, double s) {
		name = n;
		salary = s;
	}
	
	public Employee3(double s) {
		// ������һ��������
		this("Employee #" + nextId, s);
	}
	// Ĭ���޲ι��캯��
	public Employee3() {
		// name -> ""
		// salary -> 0
		// id ͨ����ʼ�����ʼ��
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
}
