package com.softland.example.collections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamExamples {

	public static void main(String[] args) {

		streamWithNumbers();
		streamWithtrings();
		flatMapExample();
		others();
	}
	
	static void streamWithNumbers() {
		List<Integer> list = Arrays.asList(3, 6, 7, 9, 12, 34, 2, 3, 6, 59, 23);
		System.out.println(list.toString());

		System.out.println("\n========[ Stream Map - pow elements]");
		list.stream().map(x -> x*x).forEach(y -> System.out.printf("%d ", y));
		
		System.out.println("\n========[ Stream forEach - delete duplicate values ]");
		list.stream().distinct().sorted().forEach(j -> System.out.printf("%d ", j));
		
		System.out.println("\n========[ Stream filter - obtanin elements less that 10]");
		list.stream().filter(x -> x<=10).forEach(j -> System.out.printf("%d ", j));
		
		int sum = list.stream().filter(x -> (x>=10 && x<=50)).map(y -> y-1).reduce(0, (element1, element2) -> element1 + element2);
		System.out.println("\nSum of number-1 between 10 and 50 = " + sum);
		
		System.out.println("\n========[ Stream to get even numbers ]");
		Set<Integer> evenNum = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toSet());
		System.out.println(evenNum);
	}
	
	
	static void streamWithtrings() {
		List<String> list = Arrays.asList("blue", "red", "green", "brown", "white", "red");
		System.out.println("List = " + list.toString());
		
		System.out.println("\n==========[ Sort");
		list.stream().sorted().forEach(x -> System.out.printf("%s ", x));
		
		System.out.println("\n==========[ Sort by the second letter or the word");
		Set<String> sl = 
		list.stream().sorted((o1, o2) -> { 
			    Character c1  = o1.charAt(1); 
			    Character c2  = o2.charAt(1);
//			    if (c1 == c2) {
//			    	//o1.charAt(1)
//			    }
			    System.out.println(String.format("(%s, %s) ==> [c1=%s, c2=%s] => %d", o1, o2, c1, c2, c2.compareTo(c1)));
			    return c2.compareTo(c1);
			  }).collect(Collectors.toSet());
		System.out.println(sl.toString());
		
		
		System.out.println("\n==========[ Concat list");
		String str = list.stream().distinct().sorted().reduce((s1, s2) -> s1 + "." + s2).get();
		System.out.println(str); 
		
		
		System.out.println("\n==========[ Sort object list by age");
		List<Person> persons = Arrays.asList(
					new Person("Marco", 40),
					new Person("Rosita", 72),
					new Person("Selene", 34),
					new Person("Alexis", 21),
					new Person("Beto", 21)
				);
		
		List<Person> sortl =
		//persons.stream().sorted( (o1, o2) -> o1.age.compareTo(o2.age) ).collect(Collectors.toList());
				persons.stream().sorted( 
						(o1, o2) -> { 
							
							if(o1.name == o2.name) {
								return o1.age.compareTo(o2.age);
							}
							return o1.name.compareTo(o2.name);
							
						 }).collect(Collectors.toList());
		System.out.println(sortl.toString());
		
	}
	
	
	static void flatMapExample() {
		Map<String, Set<String>> map = new HashMap<String, Set<String>>();
		map.put("Marco", new HashSet<String>( Arrays.asList("blue", "green", "black")));
		map.put("Rosita", new HashSet<String>( Arrays.asList("blue", "yellow", "black")));
		map.put("Selene", new HashSet<String>( Arrays.asList("white", "green", "black")));
		map.put("Marco", new HashSet<String>( Arrays.asList("blue", "black", "red")));
		
		//map.values().stream()
		System.out.println("\n============[FlatMap");
		List<String> list= 
		map.entrySet().stream()
				.map(x -> x.getValue())
				.flatMap(x -> x.stream())
				.distinct()
				.collect(Collectors.toList());
		System.out.println(list.toString());
		
		
		Set<String> inter = new HashSet<String>();
		inter.add("black");
		//map.values().retainAll(inter);
		//map.values().stream().reduce((s1, s2) -> s1.retainAll(s2)).get();
		map.entrySet().stream()
			.map(x -> x.getValue())
			.reduce((s1, s2) -> { s1.retainAll(s2); return s1; } ).get();
		System.out.println("\n" + map.toString());
		
	}
	
	
	static void others() {
		System.out.println("\n==========[ int[]  to  List<Integer>");
		int[] arr = {5, 4, 1, 7, 10, 2, 10, 1, 3};
		List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
		System.out.println("List<Integer> = " + list.toString());
		
		System.out.println("\n==========[ List<Integer>  to   int[] ");
		int[] newArr = list.stream().mapToInt(i -> i).toArray();
		System.out.println("int[] = " + Arrays.toString(newArr));
		
		System.out.println("\n==========[ Sort and remove duplicates from  int[] ");
		int[] newArr2 = Arrays.stream(arr).distinct().sorted().toArray();
		System.out.println("int[] = " + Arrays.toString(newArr2));
		
		int[] odd = Arrays.stream(arr).filter(x -> (x%2 > 0)).distinct().sorted().toArray();
		System.out.println("Odds int[] = " + Arrays.toString(odd));
		
	}
	
	

}


class Person {
	String name;
	Integer age;
	
	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return String.format("Person [name=%s, age=%d]", name, age);
	}
}


