/**
 * Anonymous inner class version of the above Program <AnonymousDemo.java>
 * 
 */
package com.softland.example.anonymousInnerClass;


//Java program to demonstrate Anonymous inner class 
interface Age2 {
	int x = 21;

	void getAge();
}

class AnonymousInnerClass {
	public static void main(String[] args) {

		// Myclass is hidden inner class of Age2 interface
		// whose name is not written but an object to it
		// is created.
		Age2 oj1 = new Age2() {
			@Override
			public void getAge() {
				// printing age
				System.out.print("Age2 is " + x);
			}
		};
		oj1.getAge();
	}
}

