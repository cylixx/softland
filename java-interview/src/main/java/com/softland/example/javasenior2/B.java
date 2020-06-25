package com.softland.example.javasenior2;

public class B extends Thread {
	
	public static void main(String argv[]) {
		B b = new B();
		
		b.start();
		b.run();
	}

	public void start() {
		
		for (int i = 0; i < 10; i++) {
			System.out.println("Value of i = " + i);
		}
	}
}