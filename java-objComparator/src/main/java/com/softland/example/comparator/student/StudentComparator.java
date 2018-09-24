package com.softland.example.comparator.student;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {

	// descending order:  o2.getMarks() - o1.getMarks()
	// ascending  order:  o1.getMarks() - o2.getMarks()
	public int compare(Student o1, Student o2) {
		return o1.getAge() - o2.getAge();
	}

}
