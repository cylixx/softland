/*
 * Dada una cadena, encontrar el primer caracter que aparezca menos veces en una cadena.
 * Ejemplo:
 * 		Inpit = "Hello world How are you"
 * 		Outout = d
 * 
 */
package com.softland.example.algorithms.usa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class FirstNotRepeated { 

	public static void main(String[] args) {

		String str =  "Hello world How are you";
		System.out.println("Input: " + str);
		
//		char c = getCharacter(str); 
//		System.out.println("First character not repited: " + c);
		
		System.out.println("First character not repited: " + getCharacter3(str));
		
		
	}
	
	static char getCharacter3(String str) {
		Map<Character, List<Integer>> map = new HashMap<Character, List<Integer>>();
		List<Integer> listNum = new ArrayList<Integer>();
		int minSize = 0;  //para obtener el minimo tamano de array
		
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			
			if ( map.containsKey(c) ){
				map.get(c).add(i);
				if (minSize > map.get(c).size()) { 
					minSize = map.get(c).size();
				}
				
			} else {
				listNum = new ArrayList<Integer>();
				listNum.add(i);
				map.put(c, listNum);
				minSize = 1;
			}
		}
		System.out.println(map);
		System.out.println("Min size array = " + minSize);
			
//		Integer minSize = str.length();
//		for(Entry<Character, List<Integer>> val : map.entrySet()) {
//			
//			if (minSize > val.getValue().size()) {
//				minSize = val.getValue().size();
//			}
//		}
		int min = minSize;  //minimo tamano de array encontrado
		
		
		Integer minIndex =
		map.entrySet().stream()
					.filter(x -> x.getValue().size() == min)  //filtro para obtener solo los valores con tamano de array 1
		  			.flatMap(x -> x.getValue().stream())  //obtenemos un solo stream con los valores de todos los arrays
					.sorted().findFirst().get();   //ordenamos el minimo valor.
		
		System.out.println(String.format("Char=%s, Index=%d", str.charAt(minIndex), minIndex));
		return str.charAt(minIndex);
	}
	
	
	
//	//No esta bien porque regresa el rimero en orden alfabetico y debe ser el primero en aparicion
//	static char getCharacter(String str) {
//		Map<Character, Integer> map = new HashMap<Character, Integer>();
//		int count = 0;
//		
//		for(char c : str.toCharArray()) {
//			count = 0;
//			if (map.containsKey(c)) {
//				count = map.get(c) + 1;
//			} else {
//				count = 1;
//			}
//			map.put(c, count);
//		}
//		System.out.println(map);
//		
//		Character c =
//		map.entrySet().stream().sorted((o1, o2) -> {
//			if(o1.getValue().equals(o2.getValue())) {
//				return o1.getKey().compareTo(o2.getKey());
//			} 
//			return o1.getValue() - o2.getValue();
//		//}).forEach(x -> System.out.println(String.format("key=%s, value=%s", x.getKey(), x.getValue())));
//		}).findFirst().map(x ->x.getKey()).get();
//		
//		return c;
//	}
	
	
//	static char getCharacter2(String str) {
//		Map<Character, List<Integer>> map = new HashMap<Character, List<Integer>>();
//		List<Integer> listNum = new ArrayList<Integer>();
//		
//		for(int i=0; i<str.length(); i++) {
//			char c = str.charAt(i);
//			
//			if ( map.containsKey(c) ){
//				map.get(c).add(i);
//				
//			} else {
//				listNum = new ArrayList<Integer>();
//				listNum.add(i);
//				map.put(c, listNum);
//			}
//		}
//		System.out.println(map);
//		
//		
//		int min =
//		map.entrySet().stream().sorted(
//				(o1, o2) ->{
//					return o1.getValue().size() - o2.getValue().size();
//				//}).forEach(x ->System.out.println(String.format("key=%s, value=%s", x.getKey(),x.getValue().toString())));
//				}).findFirst().get().getValue().size();
//		
//		
//		Integer minIndex =
//		map.entrySet().stream().sorted(
//				(o1, o2) ->{
//					return o1.getValue().size() - o2.getValue().size();
//				}).filter(x -> x.getValue().size() == min).flatMap(x -> x.getValue().stream())
//					.sorted().findFirst().get();
//		
//		System.out.println(String.format("Char=%s, Index=%d", str.charAt(minIndex), minIndex));
//		
//		
//		return str.charAt(minIndex);
//	}

}
