package com.softland.example.comparator;

import java.util.Arrays;
import java.util.Comparator;

class Person {
	String name;
	int score;
	
	public Person(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
}

class PersonComparator implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		if(o1.score < o2.score) {
			return 1;
		} else if (o1.score > o2.score) {
			return -1;
		}
		return o1.name.compareTo(o2.name); //cuando score es igual, entonces comparar por el nombre
	}
	
}

public class TestComparator {

	public static void main(String[] args) {
		
		Person[] personList = {
				new Person("Rosita", 9),
				new Person("Marco", 9),	
				new Person("Selene", 10),
				new Person("Nancy", 8)
				};

		Arrays.sort(personList, new PersonComparator());
		for (Person p : personList) {
			System.out.println(p.name + "=" + p.score);
		}
	}

}
