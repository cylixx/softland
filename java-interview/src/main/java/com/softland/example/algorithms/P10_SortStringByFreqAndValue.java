/*
 * 2019/09/18
 * Dada una cadena ordenar de acuerdo a su frecuencia, si la ferecuena es la misma entonces usar orden natural.
 * 
 *  input:	    ccbbbaa
	
	output:  	bbbaacc

 */
package com.softland.example.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class P10_SortStringByFreqAndValue {

	public static void main(String[] args) {
		
		//String input = "ccbbbaa";
		String input = "ccbbbaa";
		System.out.println("input: " + input);

		System.out.println("---------------------[Solution #1]--------------------------");
		sortByFreq1(input);
		
		System.out.println("---------------------[Solution #2]--------------------------");
		sortByFreq2(input); 
		
		System.out.println("\n--------------------[Solution #3]---------------------------");
		frequencySort(input);
		
		System.out.println("\n--------------------[Solution #4]---------------------------");
		System.out.println(frequencySort2(input));
	}
	
	
	static void  sortByFreq1(String input) {
		Map<Character, Integer> freqMap = new HashMap<Character, Integer>();
		List<Character> tmp = new ArrayList<Character>();
		
		char[] arr =  input.toCharArray();
		for(Character c : arr) {
			freqMap.compute(c, (k, v) -> (v == null) ? 1 : v + 1); //compute a mapping for the specified key and its current mapped value
			tmp.add(c);
		}
		System.out.println("freqMap: " + freqMap.toString());
		
		
		//Sorts the specified list according to the order induced by the specified comparator. 
		Collections.sort(tmp, new Comparator<Character>() {

			@Override
			public int compare(Character o1, Character o2) {
				
				int freq = freqMap.get(o2).compareTo(freqMap.get(o1));
				
				int value = o1.compareTo(o2);
				
				if (freq == 0) {
					return value;
				} else {
					return freq;
				}
				
			}
		});
		
		System.out.println("output: " + tmp.toString()); 
		
	}
	
	
	static void sortByFreq2(String s) {
		Map<Character, Integer> map  = new HashMap<Character, Integer>();
		List<Character> output = new ArrayList<>();
		
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
				
			} else {
				map.put(c, 1);
			}
			output.add(c);
		}
		System.out.println(map);
		
		
		// Compare the map by value 
        SortComparator comp = new SortComparator(map); 
  
        // Sort the map using Collections CLass 
        Collections.sort(output, comp); 
  
        // Final Output 
        for (Character i : output) { 
            System.out.print(i + " "); 
        } 
		
	}
	
	/* 
	 * 2020/07/12
	 * Esta solucion es usando un Tabla hash para almacenar la precuencia de los caracteres
	 * 
	 */
	public static void frequencySort(String s) {
		int n = s.length();
		List<Character>[] res = new ArrayList[n + 1];  // arreglo de listas
		int[] cntArr = new int[27]; // total alphabet characters
		
		// we count number of occurrences
		for (int i = 0; i < n; ++i) {
			cntArr[s.charAt(i) - 'a']++; 
			res[i + 1] = new ArrayList<>();
		}
		
		for (int i = 0; i < cntArr.length; ++i) {
			if (cntArr[i] != 0) {
				System.out.printf("cnt[%s] = %s \n", i, cntArr[i]); 
				res[cntArr[i]].add((char) (i + 'a')); // add character to the array of list
			}
		}

		StringBuilder sb = new StringBuilder();
		System.out.println(Arrays.toString(res));
		for (int i = n; i > 0; --i) {  // loop array starting by the end
			if (!res[i].isEmpty()) {
				for (char c : res[i]) {
					//System.out.println("input has " + i + " " + c);
					for (int j=0; j<i; j++) {
						sb.append(c);
					}
				}
			}
		}
		System.out.println("Order by frequency: " + sb.toString()); 
	}
	
	
	/*
	 * 2020/07/12
	 * BEST solution
	 * Using a PriorityQueue
	 * 
	 * .I believe time complexity would be O(n log m) where n is the length of the string and m is the number of distinct characters in the string. 
	 *  I think memory complexity would be O(m) where m is again the number of distinct characters in the string

	 */
	static String frequencySort2(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		
		for (char c: s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		System.out.println(map);
		
		PriorityQueue<Character> maxHeap = new PriorityQueue<>( (a, b) -> map.get(b) - map.get(a) ); 
		maxHeap.addAll(map.keySet());
		System.out.println(maxHeap); 
		
		StringBuilder sb = new StringBuilder();
		while(!maxHeap.isEmpty()) {
			char c = maxHeap.remove();
			for (int i=0; i < map.get(c); i++) {
				sb.append(c);
			}
		}
		
		return sb.toString();
	}

	
}


class SortComparator implements Comparator<Character> {
	private final Map<Character, Integer> freqMap;
	
	SortComparator(Map<Character, Integer> map) {
		this.freqMap = map;
	}

	@Override
	public int compare(Character o1, Character o2) {
		 // Compare value by frequency 
		int freqCompare = freqMap.get(o2).compareTo(freqMap.get(o1));
		
		// Compare value if frequency is equal 
        int valueCompare = o1.compareTo(o2); 
		
     // If frequency is equal, then just compare by value, otherwise - 
        // compare by the frequency. 
        if (freqCompare == 0) 
            return valueCompare; 
        else
            return freqCompare; 
        
	}
	
}
