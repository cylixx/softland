package com.softland.example.thread.naveen;

//class Task {
//	
//	public void run() {
//		for(int i=0; i<10; i++) {
//			System.out.println(String.format("@@Documents # %d from printer_2@@", i));
//		}
//	}
//}
class Task2 implements Runnable {

	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println(String.format("@@Documents # %d from printer_2@@", i));
		}
	}
	
}

public class ThreadsInterface {

	public static void main(String[] args) {
		
		//job 1
		System.out.println("===Application started===");
		
		
		//job 2
		Thread t = new Thread(new Task2());
		//tast.run();
		 t.start();
		
		
		//job 3
		for(int i=0; i<10; i++) {
			System.out.println(String.format("^^Document # %d from printe_1^^", i));
		}
		
		//job 4
		System.out.println("===Application finished===");
		
	}
}
