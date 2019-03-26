package com.softland.example.objectToFile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectIOExample {

	public static void main(String[] args) {

        Student student = new Student("Marco","Antonio",30);
		try {
			
			FileOutputStream fileOut = new FileOutputStream("/root/Descargas/temporal/obj.txt");
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut); //An ObjectOutputStream writes primitive data types and graphs of Java objects to an OutputStream.
			objectOut.writeObject(student); // Write the specified object to the ObjectOutputStream.
	        objectOut.close();
	        System.out.println("The Object  was succesfully written to a file");
	            
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}

}

// implementar Serializable es necesario para poder escribir el objeto
class Student implements Serializable {
    //default serialVersion id
    private static final long serialVersionUID = 1L;
 
    private String first_name;
    private String last_name;
    private int age;
 
    public Student(String fname, String lname, int age){
        this.first_name = fname;
        this.last_name  = lname;
        this.age        = age;
    }
    public void setFirstName(String fname) {
        this.first_name = fname;
    }
    public String getFirstName() {
        return this.first_name;
    }
    public void setLastName(String lname) {
        this.first_name = lname;
    }
    public String getLastName() {
        return this.last_name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return this.age;
    }
    @Override
    public String toString() {
        return new StringBuffer(" First Name: ").append(this.first_name)
                .append(" Last Name : ").append(this.last_name).append(" Age : ").append(this.age).toString();
    }
}
