/**
 * 
 * - It may or may not contain any abstract method.
 * - you can not create an instance of this class, and that’s it.
 */

/*
 * We choose an abstract class:
 *  when there are some features for which we know what to do, and other features that we know how to perform.
 *  
 *  
 *  Consider using abstract classes if :

    1. You want to share code among several closely related classes.
    2. You expect that classes that extend your abstract class have many common methods or fields, or require access modifiers other than public (such as protected and private).
    3. You want to declare non-static or non-final fields.

	In simple terms, I would like to use

	abstract class: To implement the same or different behaviour among multiple related objects 
 *  
 */
package com.softland.example.oop.abstractVSinterface;

abstract class Animal {
	public String name;
	private int id;
	
	abstract String eat(); //Having an abstract method in your class will force you to declare your class as abstract itself
	public void normalMethod() { //we can have another method definitions with another acces modify
        //method body
    }
}

class Bird extends Animal {
	@Override
	String eat() {
		return "Bird eaten";
	}
}

class Cat extends Animal {
	@Override
	String eat() {
		return "cat eaten";
	}
}

public class TestAbstractClass {
	
	public static void main(String[] args) {
		Animal bird = new Bird();
		System.out.println(bird.eat());
		
		Animal cat = new Cat();
		System.out.println(cat.eat());
		
		// el siguiente codigo da error porque:
		// las clases abstractas no se pueden instanciar
		// Animal animal = new Animal();

	}

}
