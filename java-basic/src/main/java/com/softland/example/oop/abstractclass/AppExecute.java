package com.softland.example.oop.abstractclass;

public class AppExecute {

	public static void main(String[] args) {
		
		Animal animal = new Cat();
		System.out.println(animal.eat() + ", " + animal.howMove() );
		if (animal instanceof Cat) {
			Cat cat = (Cat) animal;
			System.out.println(cat.name());
		}
		
		animal = new Bird();
		System.out.println(animal.eat() + ", " + animal.howMove());
		if (animal instanceof Bird) {
			Bird bird = (Bird) animal;
			System.out.println(bird.name());
			
		}
		
		// el siguiente codigo da error porque:
		// las clases abstractas no se pueden instanciar
		// Animal animal2 = new Animal();
		
	}

}
