package ch16;
import java.util.*;

public class TestGenerics2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestGenerics2().go();
	}
	public void takeAnimals(ArrayList<Animal> animals) {
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
		//takeAnimals(dogs);
		
	}
	

}

