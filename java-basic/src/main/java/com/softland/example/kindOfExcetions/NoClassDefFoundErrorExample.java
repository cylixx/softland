/*
 * NoClassDefFoundError
 * Above program will be successfully compiled and generate two classes GeeksForGeeks.class and G4G.class .
 * Now remove GeeksForGeeks.class file and run G4G.class.
 * At Java runtime NoClassDefFoundError will be thrown.
 * 
 */
package com.softland.example.kindOfExcetions;

//Java program to illustrate 
//NoClassDefFoundError 
class AnotherClass {
	void greeting() {
		System.out.println("hello!");
	}
}

public class NoClassDefFoundErrorExample {
	
	public static void main(String args[]) {
		AnotherClass geeks = new AnotherClass();
		geeks.greeting();
	}
}
