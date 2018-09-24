package com.softland.example.comparator.student;

import java.util.ArrayList;
import java.util.Collections;

public class mainStudent {

	public static void main(String args[]){
        ArrayList<Student> studentList = new ArrayList<Student>();
        studentList.add(new Student(201, "Aldo", 29));
        studentList.add(new Student(202, "Luis", 34));
        studentList.add(new Student(203, "Samuel", 27));
        Collections.sort(studentList, new StudentComparator());
        
        for(Student student : studentList){
            System.out.println(student.name);
        }
    }  
	
}
