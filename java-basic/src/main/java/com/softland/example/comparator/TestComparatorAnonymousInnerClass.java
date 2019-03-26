package com.softland.example.comparator;

import java.util.Arrays;
import java.util.Comparator;

class Person2 {
	String name;
	int score;
	
	public Person2(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
}

public class TestComparatorAnonymousInnerClass {

	public static void main(String[] args) {
		Person2[] personList = {
				new Person2("Rosita", 9),
				new Person2("Marco", 9),	
				new Person2("Selene", 10),
				new Person2("Nancy", 8)
				};

		Comparator<Person2> personComparator = new Comparator<Person2>() {
			@Override
			public int compare(Person2 o1, Person2 o2) {
				if(o1.score < o2.score) {
					return 1;
				} else if (o1.score > o2.score) {
					return -1;
				}
				return o1.name.compareTo(o2.name); //cuando score es igual, entonces comparar por el nombre
			}
		};
		
		Arrays.sort(personList, personComparator);
		
		for (Person2 p : personList) {
			System.out.println(p.name + "=" + p.score);
		}

	}

}
