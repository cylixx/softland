/*
 * 2019/09/18
 * Dada una cadena ordenar de acuerdo a su frecuencia, si la ferecuena es la misma entonces usar orden natural.
 * 
 *  input:	    ccbbbaa
	
	output:  	bbbaacc

 */
package com.softland.example.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P10_SortStringByFreqAndValue {

	public static void main(String[] args) {
		
		String input = "ccbbbaa";
		System.out.println("input: " + input);

		sortByFreq1(input);
		System.out.println("-----------------------------------------------");
		sortByFreq2(input); 
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
