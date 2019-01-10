/**
 * https://stackoverflow.com/questions/5739611/differences-between-abstract-factory-pattern-and-factory-method
 *  
 * Differences between Abstract Factory Pattern and Factory Method 
 * 
 */
package com.softland.example.designpatterns.creational;

public class Client {
	public static void main(String[] args) {
		ZooFactory zooFactory = new HerbivoreZooFactory();
		Animal animal1 = zooFactory.animal1();
		Animal animal2 = zooFactory.animal2();
		animal1.sound();
		animal2.sound();

		System.out.println();

		AnimalFactory animalFactory = new CowAnimalFactory();
		Animal animal = animalFactory.createAnimal();
		animal.sound();
	}
}

interface Animal {
	public void sound();
}

class Cow implements Animal {

	@Override
	public void sound() {
		System.out.println("Cow moos");
	}
}

class Deer implements Animal {

	@Override
	public void sound() {
		System.out.println("Deer grunts");
	}
}

class Hyena implements Animal {

	@Override
	public void sound() {
		System.out.println("Hyena.java");
	}
}

class Lion implements Animal {

	@Override
	public void sound() {
		System.out.println("Lion roars");
	}
}


interface ZooFactory {
	Animal animal1();
	Animal animal2();
}

class CarnivoreZooFactory implements ZooFactory {

	@Override
	public Animal animal1() {
		return new Lion();
	}

	@Override
	public Animal animal2() {
		return new Hyena();
	}
}

class HerbivoreZooFactory implements ZooFactory {

	@Override
	public Animal animal1() {
		return new Cow();
	}

	@Override
	public Animal animal2() {
		return new Deer();
	}
}

interface AnimalFactory {
	public Animal createAnimal();
}

class CowAnimalFactory implements AnimalFactory {

	@Override
	public Animal createAnimal() {
		return new Cow();
	}
}

class DeerAnimalFactory implements AnimalFactory {

	@Override
	public Animal createAnimal() {
		return new Deer();
	}
}

class HyenaAnimalFactory implements AnimalFactory {

	@Override
	public Animal createAnimal() {
		return new Hyena();
	}
}

class LionAnimalFactory implements AnimalFactory {

	@Override
	public Animal createAnimal() {
		return new Lion();
	}
}