package com.softland.example.comparator;

import java.util.Comparator;

public class MarkComparator implements Comparator<Student> {

	public int compare(Student student1, Student student2) {
		// descending order:  student2.getMarks() - student1.getMarks()
		// ascending order :  tudent1.getMarks() - student2.getMarks()
		
		// descending order
		return student2.getMarks() - student1.getMarks();
	}

}
