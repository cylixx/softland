package com.softland.example.poo;

public class Overloading {

	public static void main(String[] args) {

		//Overloading 
		//occurs when two or more methods in one class have the same method name but different parameters.
		
		System.out.println("same class 2 parameters: " + Overloading.add(1, 2) );
		System.out.println("same class 3 parameters: " + Overloading.add(1, 2, 3) );
		
	}
	
	
	public static int add(int a, int b) {
		return a + b;
	}

	//Overloading method add
	public static int add(int a, int b, int c) {
		return a + b + c;
	}

}
