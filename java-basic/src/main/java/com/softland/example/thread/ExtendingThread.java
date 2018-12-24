package com.softland.example.thread;

/**
 * Extendiendo e la clase Thread
 */
class MyClass2 extends Thread {
	public void run() {
		System.out.println("MyClass running");
	}
}

public class ExtendingThread {
	
	public static void main(String[] args) {
		MyClass2 t1 = new MyClass2();
		t1.start();
	}

}




