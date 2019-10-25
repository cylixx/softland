/*
 * You are given a list of (website, user) pairs that represent users visiting websites. Come up with a program that identifies the top k pairs of websites with the greatest similarity.
For example, suppose k = 1, and the list of tuples is:
[('a', 1), ('a', 3), ('a', 5),
 ('b', 2), ('b', 6),
 ('c', 1), ('c', 2), ('c', 3), ('c', 4), ('c', 5),
 ('d', 4), ('d', 5), ('d', 6), ('d', 7),
 ('e', 1), ('e', 3), ('e', 5), ('e', 6)]
Then a reasonable similarity metric would most likely conclude that a and e are the most similar, so your program should return [('a', 'e')].
 */
package com.softland.example.algorithms.usa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class WebsiteUser2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<char[]> list = 
		Arrays.asList(
				new char[] {'a', '1'},
				new char[] {'a', '3'},
				new char[] {'a', '5'},
				
				new char[] {'b', '2'},
				new char[] {'b', '6'},
				
				new char[] {'c', '1'},
				new char[] {'c', '2'},
				new char[] {'c', '3'},
				new char[] {'c', '4'},
				new char[] {'c', '5'},
				
				new char[] {'d', '4'},
				new char[] {'d', '5'},
				new char[] {'d', '6'},
				new char[] {'d', '7'},
				
				new char[] {'e', '1'},
				new char[] {'e', '3'},
				new char[] {'e', '5'},
				new char[] {'e', '6'}
				);
		
		printList(list);
		
		List<char[]> res = websitesSimilarity(list, 1);
		
		printList(res);
		
	}
	
	
	static List<char[]> websitesSimilarity(List<char[]> list, int k) {
		
		Map<Character, Set<Character>> map = new HashMap<Character, Set<Character>>();
		Set<Character> pair = new HashSet<Character>();
		
		
		for(char[] c : list) {
			char key = c[0];
			char value = c[1];
			if (map.containsKey(key)) {
				pair = map.get(key);
				
			} else {
				pair = new HashSet<Character>();
			}
			pair.add(value);
			map.put(key, pair);
		}
		System.out.println("map: " + map.toString());
	
		
		Character[] keys = map.keySet().toArray( new Character[map.keySet().size()]);
		System.out.println("keys map: " +Arrays.toString(keys));
		
		
		List<Website2> websiteList = new ArrayList<Website2>();
		for (int i=0; i<keys.length; i++) {
			for (int j=i+1; j<keys.length; j++) {
				websiteList.add(
						new Website2(
								keys[i], 
								keys[j], 
								getSimilarity(map.get(keys[i]), map.get(keys[j]))
								)
						);
				
			}
		}
		
		
//		map.entrySet().stream()
//		    //.flatMap(null) 
//		     .sorted(
//				//(p1, p2) -> p2.similarity.compareTo(p1.similarity)
//	    		 (p1, p2) -> {
//	    			 //Double a = 
//	    			 
//	    			 Set<Character> setA = new HashSet<Character>(p1.getValue());
//	    			 Set<Character> setB = new HashSet<Character>(p2.getValue());
//	    			 setA.retainAll( setB);
//	    			 Integer inters = setA.size();
//	    			 
//	    			 Set<Character> unionA = new HashSet<Character>(p1.getValue());
//    				 Set<Character> unionB = new HashSet<Character>(p2.getValue());
//    				unionA.addAll(unionB);
//    				Integer union = unionA.size();
////	    				System.out.println(String.format("Union: %d, Inters: %d", union, inters));
//    				
//    				
//    				return (double) (inters.doubleValue() / union.doubleValue());
//	    		 }
//				);
		
		
		//System.out.println("map: " + map.toString());
		List<char[]> res = new ArrayList<char[]>();
		
		websiteList.stream().sorted(
				//Comparator.comparingDouble(Website2::getSimilarity).reversed()
				(p1, p2) -> p2.similarity.compareTo(p1.similarity)
				)
		//.forEach(System.out::println); 
		.limit(k) 
		.forEachOrdered(
				x -> {
					System.out.println(x.toString()); 
					res.add( new char[] {x.a, x.b} );
				}
				);
		
		return res;
	}
	
	
	static Double getSimilarity(Set<Character> a, Set<Character> b) {
		Set<Character> setA = new HashSet<Character>(a);
		Set<Character> setB = new HashSet<Character>(b);
		
		//setA.stream().filter(f -> setB.contains(f)).collect(Collectors.toSet());
		setA.retainAll(setB);
		Integer inters = setA.size();
		
		Set<Character> unionA = new HashSet<Character>(a);
		Set<Character> unionB = new HashSet<Character>(b);
		unionA.addAll(unionB);
		Integer union = unionA.size();
//		System.out.println(String.format("Union: %d, Inters: %d", union, inters));
		
		return (double) (inters.doubleValue() / union.doubleValue());
	}
	
	
	static void printList(List<char[]> list) {
		for(char[] arr : list) {
			System.out.printf(Arrays.toString(arr) + ", ");
		}
		System.out.println("");
	}
	
}

class Website2 {
	 Character a;
	 Character b;
	 Double similarity;
	
	public Website2(Character a, Character b, Double similarity) {
		super();
		this.a = a;
		this.b = b;
		this.similarity = similarity;
	}

	@Override
	public String toString() {
		return String.format("website [a=%s, b=%s, similarity=%f]", a, b, similarity);
	}
}
