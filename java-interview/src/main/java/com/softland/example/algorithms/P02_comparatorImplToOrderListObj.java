/**
 * @author Marco Hinojosa
 * 
 * Ordenar lista
 * Ordenar la siguiente lista de personas segun su score
 * 
 */
package com.softland.example.algorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Person {
	String name;
	int score;
	
	public Person(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
}

// Write your Checker class here
class ScoreComparator implements Comparator<Person> {

	public int compare(Person o1, Person o2) {
		if (o1.score < o2.score) {
			return 1;
		} else if (o1.score > o2.score) {
			return -1;
		} 
		return o1.name.compareTo(o2.name); //cuando score es igual, entonces comparar por el nombre
	}
	
}


public class P02_comparatorImplToOrderListObj {
	
	public static void main( String[] args ) {
		Scanner scan = new Scanner(System.in); 
		
		System.out.println("Dame el total de personas:");
		int total = scan.nextInt();
		Person[] people = new Person[total];
		
		for(int i=0; i<total; i++) {
			System.out.println("Nombre y score:");
			people[i] = new Person(scan.next(), scan.nextInt());
		}
		scan.close();
		
		System.out.println("=============[RESULTADO]===================");
		Arrays.sort(people, new ScoreComparator());
		for(int i=0; i<people.length; i++) {
			System.out.printf("%s %s\n", people[i].name, people[i].score);
		}
		
	}
}
