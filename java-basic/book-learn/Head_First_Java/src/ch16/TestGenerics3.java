package ch16;
import java.util.*;

public class TestGenerics3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestGenerics3().go();
	}
	public void takeAnimals(ArrayList<? extends Animal> animals) {
		for(Animal a: animals) {
			a.eat();
		}
	}
	public void go() {
		ArrayList<Animal> animals = new ArrayList<Animal>();
		animals.add(new Dog());
		animals.add(new Cat());
		animals.add(new Dog());
		
		ArrayList<Dog> dogs = new ArrayList<Dog>();
		dogs.add(new Dog());
		dogs.add(new Dog());
		dogs.add(new Dog());
		
		takeAnimals(animals);
		takeAnimals(dogs);
		
	}
	public void test() {
		// ArrayList<Dog> dogs1 = new ArrayList<Animal>();错误
		// ArrayList<Animal> animals1 =new ArrayList<Dog>();错误
		// List<Animal> list = new ArrayList<Animal>();正确
		// ArrayList<Dog> dogs = new ArrayList<Dog>();正确
		ArrayList<Dog> dogs = new ArrayList<Dog>();
		// ArrayList<Animal> animals = dogs;错误
		// List<Dog> dogList = dogs;正确
	}
	

}

