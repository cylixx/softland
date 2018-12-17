/*
 * 1. Anonymous Inner class that extends a class : We can have an anonymous inner class that extends 
 * 	  a class.For example,we know that we can create a thread by extending a Thread class. Suppose we 
 * 	  need an immediate thread but we don’t want to create a class that extend Thread class all the time. 
 * 	  By the help of this type of Anonymous Inner class we can define a ready thread as follows:
 * 
 */
package com.softland.example.anonymousInnerClass;

//1. Java program to illustrate creating an immediate thread 
//   Using Anonymous Inner class that extends a Class 
public class AnonymousInnerClassExtends {

	public static void main(String[] args) { 
        //Here we are using Anonymous Inner class 
        //that extends a class i.e. Here a Thread class 
        Thread t = new Thread() { 
			public void run() {
				System.out.println("Child Thread");
			}
        }; 
        t.start(); 
        System.out.println("Main Thread"); 
    } 
}
