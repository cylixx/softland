/*
 * Reference
 * https://howtodoinjava.com/java8/using-comparator-becomes-easier-with-lambda-expressions-java-8/
 * 
 */
package com.softland.example.comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Person3 {
	String name;
	int score;
	
	public Person3(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return " [" + (name != null ? "name=" + name + ", " : "") + "score=" + score + "]";
	}
}


public class TestComparatorWithLambda {

	private static List<Person3> getPerson3(){
	    List<Person3> Person3  = new ArrayList<>();
	    Person3.add(new Person3("Yash", 25));
	    Person3.add(new Person3("Aman", 28));
	    Person3.add(new Person3("Aakash", 52));
	    Person3.add(new Person3("David", 28));
	    Person3.add(new Person3("James", 72));
	    Person3.add(new Person3("Balaji", 88));
	    Person3.add(new Person3("Karan", 59));
	    Person3.add(new Person3("Lokesh", 32));
	    Person3.add(new Person3("Vishu", 33));
	    Person3.add(new Person3("Lokesh", 60));
	    return Person3;
	}
	
	public static void main(String[] args) {
		List<Person3> employees  = getPerson3();
	     
	    //Sort all employees by first name
//	    employees.sort(Comparator.comparing(e -> e.getName()));
	    
	    //OR you can use below
//	    employees.sort(Comparator.comparing(Person3::getName));
	    
	  //Sort all employees by first name; And then reversed
//	    Comparator<Person3> comparator = Comparator.comparing(e -> e.getName());
//	    employees.sort(comparator.reversed());
		
		//Sorting on multiple fields; Group by.
		Comparator<Person3> groupByComparator = Comparator.comparing(Person3::getScore).thenComparing(Person3::getName);
		employees.sort(groupByComparator);
	    
	    //Let's print the sorted list
	    System.out.println(employees);
	}
	
}
