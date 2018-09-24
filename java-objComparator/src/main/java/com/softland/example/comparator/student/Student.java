/*
 * Expedia examen java
 */
package com.softland.example.comparator.student;

import java.util.*;
import java.io.*;

public class Student {  
    int rollno;  
    String name;  
    int age;  
    
    Student(int rollno, String name, int age){  
        this.rollno=rollno;  
        this.name=name;  
        this.age=age;
    }
    public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

//	public static void main(String args[]){
//        ArrayList<Student> studentList = new ArrayList<Student>();
//        studentList.add(new Student(201, "Aldo", 29));
//        studentList.add(new Student(202, "Luis", 34));
//        studentList.add(new Student(203, "Samuel", 27));
//        Collections.sort(studentList, new StudentComparator());
//        
//        for(Student student : studentList){
//            System.out.println(student.name);
//        }
//    }
	
}

//public class StudentComparator implements Comparator<Student> {
//
//	public int compare(Student s1, Student s2) {
//		return s1.getAge() - s2.getAge();
//	}
//    
//}


