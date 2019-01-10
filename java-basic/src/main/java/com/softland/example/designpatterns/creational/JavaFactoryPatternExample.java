/*
 * https://alvinalexander.com/java/java-factory-pattern-example
 * https://github.com/iluwatar/java-design-patterns/tree/master/factory-method
 * 
 * Intencion del Factory Method
 * Define an interface for creating an object, but let subclasses decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses.
 * 
 * Wikipedia says
 * In class-based programming, the factory method pattern is a creational pattern that uses factory methods to deal with 
 * the problem of creating objects without having to specify the exact class of the object that will be created. 
 * This is done by creating objects by calling a factory method—either specified in an interface and implemented by child 
 * classes, or implemented in a base class and optionally overridden by derived classes—rather than by calling a constructor.
 * 
 */
package com.softland.example.designpatterns.creational;

/**
 * A "driver" program to demonstrate our "dog factory".
 * @author alvin alexander, devdaily.com
 */
public class JavaFactoryPatternExample {
	
	public static void main(String[] args) {
		// create a small dog
		Dog dog = DogFactory.getDog("small");
		dog.speak();

		// create a big dog
		dog = DogFactory.getDog("big");
		dog.speak();

		// create a working dog
		dog = DogFactory.getDog("working");
		dog.speak();
	}
}

/**
 * Our Factory class.
 */
class DogFactory {
	public static Dog getDog(String criteria) {
		if (criteria.equals("small"))
			return new Poodle();
		else if (criteria.equals("big"))
			return new Rottweiler();
		else if (criteria.equals("working"))
			return new SiberianHusky();

		return null;
	}
}

/**
 * Our Dog interface.
 */
interface Dog {
	public void speak();
}

// Our concrete class implementations 

class Poodle implements Dog {
	public void speak() {
		System.out.println("The poodle says \"arf\"");
	}
}

class Rottweiler implements Dog {
	public void speak() {
		System.out.println("The Rottweiler says (in a very deep voice) \"WOOF!\"");
	}
}

class SiberianHusky implements Dog {
	public void speak() {
		System.out.println("The husky says \"Dude, what's up?\"");
	}
}