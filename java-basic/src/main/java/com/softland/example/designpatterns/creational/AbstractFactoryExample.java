/*
 * Abstract Factory Pattern in Java
 * https://www.baeldung.com/java-abstract-factory-pattern
 * 
 *  Abstract Factory 
 *  “provides an interface for creating families of related or dependent objects without specifying their concrete classes”.
 *  
 *  
 *  When to Use Abstract Factory Pattern:

    The client is independent of how we create and compose the objects in the system
    The system consists of multiple families of objects, and these families are designed to be used together
    We need a run-time value to construct a particular dependency

    While the pattern is great when creating predefined objects, adding the new ones might be challenging. 
    To support the new type of objects will require changing the AbstractFactory class and all of its subclasses.
 *  
 *  
 *  In this example, we'll create two implementations of the Factory Method Design pattern: AnimalFactory and ColorFactory.

	After that, we'll manage access to them using an Abstract Factory AbstractFactory:

 * 
 */
package com.softland.example.designpatterns.creational;

public class AbstractFactoryExample {

	public static void main(String[] args) {
		AbstractFactory abstractFactory;
        
        //creating a brown toy dog
        abstractFactory = FactoryProvider.getFactory("Toy");
        Animal toy =(Animal) abstractFactory.create("Dog");
        
        abstractFactory = FactoryProvider.getFactory("Color");
        Color color =(Color) abstractFactory.create("Brown");
        
        String result = "A " + toy.getAnimal() + " with " + color.getColor() + " color " + toy.makeSound();
        
        System.out.println(result);
	}

}

//-------------------[Animal Family]-----------------------

interface Animal {
    String getAnimal();
    String makeSound();
}

// First, we'll create a family of Animal class
class Duck implements Animal {
	 
    @Override
    public String getAnimal() {
        return "Duck";
    }
 
    @Override
    public String makeSound() {
        return "cuack cuack";
    }
}

class Dog2 implements Animal {
	 
    @Override
    public String getAnimal() {
        return "Dog";
    }
 
    @Override
    public String makeSound() {
        return "woof woof";
    }
}


//----------------[Color family]---------------------------------------
interface Color {
    String getColor();
}

class Brown implements Color {

    @Override
    public String getColor() {
        return "brown";
    }
}
class White implements Color {

    @Override
    public String getColor() {
        return "White";
    }
}

//----------------------[Abstract Factory]---------------------------

//The Abstract Factory deals with families of dependent objects.
interface AbstractFactory<T> {
    T create(String type) ;
}

//Next, we'll implement an AnimalFactory using the Factory Method design pattern 
class AnimalFactory implements AbstractFactory<Animal> {
	 
    @Override
    public Animal create(String animalType) {
        if ("Dog".equalsIgnoreCase(animalType)) {
            return new Dog2();
        } else if ("Duck".equalsIgnoreCase(animalType)) {
            return new Duck();
        }
 
        return null;
    }
 
}

class ColorFactory implements AbstractFactory<Color> {

    @Override
    public Color create(String colorType) {
        if ("Brown".equalsIgnoreCase(colorType)) {
            return new Brown();
        } else if ("White".equalsIgnoreCase(colorType)) {
            return new White();
        }

        return null;
    }

}

class FactoryProvider {
    public static AbstractFactory getFactory(String choice){
        
        if("Toy".equalsIgnoreCase(choice)){
            return new AnimalFactory();
        }
        else if("Color".equalsIgnoreCase(choice)){
            return new ColorFactory();
        }
        
        return null;
    }
}


