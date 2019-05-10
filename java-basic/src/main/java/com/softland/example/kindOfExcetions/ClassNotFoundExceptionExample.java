/*
 * ClassNotFoundException
 * Is a runtime exception that is thrown when an application tries to load a class at runtime using the 
 * Class.forName() or loadClass() or findSystemClass() methods ,and the class with specified name are not 
 * found in the classpath. 
 * 
 */
package com.softland.example.kindOfExcetions;

public class ClassNotFoundExceptionExample {

	public static void main(String[] args) {

		try {
			//this exception occurs when you try to run an application without updating the classpath with required JAR files
			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
