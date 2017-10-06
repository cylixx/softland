package com.softland.example.comparator;

import java.util.Comparator;

public class Student  {
	public String firstName;
    public String lastName;
    public String rollNumber;
    public int marks;
    
	public Student(String firstName, String lastName, String rollNumber, int marks) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.rollNumber = rollNumber;
		this.marks = marks;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	
	/**
	 * Compare by firstName property
	 */
	public static Comparator<Student> firstNameComparator = new Comparator<Student>() {
		
		public int compare(Student student1, Student student2) {
			String firstName1 = student1.getFirstName().toUpperCase();
		      String firstName2 = student2.getFirstName().toUpperCase();

		      //ascending order
		      return firstName1.compareTo(firstName2);

		      //descending order
		      //return fruitName2.compareTo(fruitName1);
		}
	};
	
	/**
	 * Compare objects by 2 properties Marks and LastName
	 */
	public static Comparator<Student> marksAndLastNameComparator = new Comparator<Student>() {
		
		public int compare(Student student1, Student student2) {
			if( student1.getMarks() > student2.getMarks() )
	            return 1;
	        else if( student1.getMarks() == student2.getMarks() ){
	            return student1.getLastName().compareTo( student2.getLastName() );
	        } else {
	            return -1;
	        }
		}
	};

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", rollNumber=" + rollNumber + ", marks="
				+ marks + "]";
	}

}
