package com.softland.example.thread;

public class ImplementsRunnableAnonymousInnerClass {

	public static void main(String[] args) {

		//Here we are using Anonymous Inner class 
        //that implements a interface i.e. Here Runnable interface 
        Runnable r = new Runnable() { 
            public void run() { 
            	System.out.println("MyClass running"); 
            } 
        }; 
        Thread t = new Thread(r); 
        t.start(); 
        System.out.println("Main Thread"); 
	}

}
