package com.softland.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.softland.example.comparator.MarkComparator;
import com.softland.example.comparator.Student;

/**
 * Hello world!
 *
 */
public class AppComparator 
{
    public static void main( String[] args ) {
    	List<Student> studentsList = new ArrayList<Student>();

		studentsList.add(new Student("Marco", "Hinojosa", "A1", 100));
		studentsList.add(new Student("Julia", "B", "A2", 70));
		studentsList.add(new Student("Paco", "Paquito", "B", 50));
		studentsList.add(new Student("Hugo", "Huguito", "A3", 10));
		studentsList.add(new Student("Enya", "A", "B2", 70));

		//print original list
		for (Student student : studentsList) {
			System.out.println(student.toString());
		}
		

		// convert List to Array
		Student[] studentarray = studentsList.toArray(new Student[studentsList.size()]);

		// order by propertie Mark
		System.out.println("-----------[Order by marks (descending order)]------------");
		Arrays.sort(studentarray, new MarkComparator());
		for (Student student : studentarray) {
			System.out.println(student.toString());
		}

		// order by property firstName
		System.out.println("-----------[Order by firstName (ascending order)]------------");
		Arrays.sort(studentarray, Student.firstNameComparator);
		for (Student student : studentarray) {
			System.out.println(student.toString());
		}

		// order by marks and lastName
		System.out.println("-----------[Order by marks and lastName]------------");
		Arrays.sort(studentarray, Student.marksAndLastNameComparator);
		for (Student student : studentarray) {
			System.out.println(student.toString());
		}
		
		
		// order by marks and lastName  (with sort function in List)
		System.out.println("-----------[Order by marks and lastName (with sort function in List)]------------");
		studentsList.sort( Student.marksAndLastNameComparator );  // List.sort
		for (Student student : studentsList) {
			System.out.println(student.toString());
		}
    }
}
