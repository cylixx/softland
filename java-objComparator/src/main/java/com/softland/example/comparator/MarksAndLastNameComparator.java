package com.softland.example.comparator;

import java.util.Comparator;

public class MarksAndLastNameComparator implements Comparator<Student> {

	public int compare(Student student1, Student student2) {
		if( student1.getMarks() > student2.getMarks() )
            return 1;
        else if( student1.getMarks() == student2.getMarks() ){
            return student1.getLastName().compareTo( student2.getLastName() );
        } else {
            return -1;
        }
	}

}
