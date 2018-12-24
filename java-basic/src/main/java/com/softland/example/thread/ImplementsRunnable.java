package com.softland.example.thread;

/**
 * Implementando la interfaz Runnable
 */
class MyClass implements Runnable {

	@Override
	public void run() {
		System.out.println("MyClass running");
	}

}

public class ImplementsRunnable {

	public static void main(String[] args) {
		Thread t1 = new Thread(new MyClass ());
		t1.start();
	}

}
