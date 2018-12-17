/**
 * 2. Anonymous Inner class that implements a interface : We can also have an anonymous inner class 
 *    that implements an interface.For example, we also know that by implementing Runnable interface 
 *    we can create a Thread. Here we use anonymous Inner class that implements an interface. 
 */
package com.softland.example.anonymousInnerClass;

//2. Java program to illustrate defining a thread 
//   Using Anonymous Inner class that implements an interface 
public class AnonymousInnerClassImplementsInterface {

	public static void main(String[] args) { 
        //Here we are using Anonymous Inner class 
        //that implements a interface i.e. Here Runnable interface 
        Runnable r = new Runnable() { 
            public void run() { 
                System.out.println("Child Thread"); 
            } 
        }; 
        Thread t = new Thread(r); 
        t.start(); 
        System.out.println("Main Thread"); 
    } 
}
