package ch03;

public class Dog {
	String name;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog dog1 = new Dog();
		dog1.bark();
		dog1.name = "Bart";
		
		// 创建Dog数组
		Dog[] myDogs = new Dog[3];
		
		// 关门放狗
		myDogs[0] = new Dog();
		myDogs[1] = new Dog();
		myDogs[2] = dog1;
		
		// 通过数组引用存取Dog
		myDogs[0].name = "Fred";
		myDogs[1].name = "Marge";
		
		// myDogs[2]的名字是？
		System.out.print("last dag's name is ");
		System.out.println(myDogs[2].name);
		
		//逐个对Dog进行bark()
		int x = 0;
		while (x < myDogs.length) {
			myDogs[x].bark();
			x = x + 1;
		}
	}
	public void bark() {
		System.out.println(name + " says Ruff!");
	}
	public void eat() {}
	public void chaseCat() {}

}
