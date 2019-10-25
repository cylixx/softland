/*
 * Abstract class vs Interface
 * 
 * 1) Abstract class can have abstract and non-abstract methods.
 * 	  Interface can have only abstract methods. Since Java 8, it can have default and static methods also.
 * 
 * 2) Abstract class doesn't support multiple inheritance.
 *    Interface supports multiple inheritance.
 *     
 * 3) Abstract class can have final, non-final, static and non-static variables.	
 *    Interface has only static and final variables.   
 * 
 * 4) Abstract class can provide the implementation of interface.	
 *    Interface can't provide the implementation of abstract class.
 * 
 * 5) The abstract keyword is used to declare abstract class.	
 *    The interface keyword is used to declare interface.
 * 
 * 6) An abstract class can extend another Java class and implement multiple Java interfaces.	
 *    An interface can extend another Java interface only.
 * 
 * 7) An abstract class can be extended using keyword "extends".	
 *    An interface class can be implemented using keyword "implements".
 * 
 * 8) A abstract class can have class members like private, protected, etc.	
 *    Members of a Java interface are public by default. 
 * 
 */

/*
 * Abstract class vs Interface

 * Type of methods: 
      Interface can have only abstract methods. 
      Abstract class can have abstract and non-abstract methods. From Java 8, it can have default and static methods also.
    
 * Final Variables: 
      Variables declared in a Java interface are by default final. 
      An abstract class may contain non-final variables.
    
 * Type of variables: 
      Abstract class can have final, non-final, static and non-static variables. 
      Interface has only static and final variables.
    
 * Implementation: 
      Abstract class can provide the implementation of interface. 
      Interface can’t provide the implementation of abstract class.
    
 * Inheritance vs Abstraction: 
      A Java interface can be implemented using keyword “implements”. 
      An abstract class can be extended using keyword “extends”.
    
 * Multiple implementation: 
      An interface can extend another Java interface only, an abstract class can extend another Java class and implement multiple Java interfaces.
    
 * Accessibility of Data Members: 
      Members of a Java interface are public by default. 
      A Java abstract class can have class members like private, protected, etc.

 */

/*
 * We normally prefer to use an interface in real time:
 *  when we know what to do but don't know how to do it.
 *  
 *  
 *  Consider using interfaces if :

    1. You expect that unrelated classes would implement your interface. For example,many unrelated objects can implement Serializable interface.
    2. You want to specify the behaviour of a particular data type, but not concerned about who implements its behaviour.
    3. You want to take advantage of multiple inheritance of type.

	In simple terms, I would like to use

	interface: To implement a contract by multiple unrelated objects
 *  
 *  
 *  Reference:
 *  https://stackoverflow.com/questions/761194/interface-vs-abstract-class-general-oo/33963650#33963650
 *  https://stackoverflow.com/questions/18777989/how-should-i-have-explained-the-difference-between-an-interface-and-an-abstract
 */
package com.softland.example.oop.abstractVSinterface;

interface Flyable {
	void fly();
}

class Bird2 implements Flyable {

	@Override
	public void fly() {
		System.out.println("flying Bird");
	}
	
}

class Plane implements Flyable {

	@Override
	public void fly() {
		System.out.println("flying Plane");
	}
	
}

public class TestInterface {
	 
	public static void main(String[] args) {
		Flyable bird = new Bird2();
		bird.fly();
		
		Flyable plane = new Plane();
		plane.fly();
		
	}
}
