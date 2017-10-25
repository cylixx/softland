package com.softland.example.poo;

public class Overriding {

	public static void main(String[] args) {

		//Overriding   (Polymorphism)
		// means having two methods with the same method name and parameters
		// One of the methods is in the parent class and the other is in the child class. 
		// Overriding allows a child class to provide a specific implementation of a method that is already provided its parent class.
		Animal animal = new Dog();
		animal.eat();
	}

}

class Animal {
	void eat() {
		System.out.println("eating...");
	}
}

class Dog extends Animal {
	//Overriding parent method
	void eat() {
		System.out.println("Dog eating bread...");
	}
}
