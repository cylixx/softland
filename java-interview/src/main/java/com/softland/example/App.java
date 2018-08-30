package com.softland.example;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args )  {
    	String s = "xulkowreuowzxgnhmiqekxhzistdocbnyozmnqthhp";
    	
    	System.out.println("anagram=" + anagram(s));
    }
    
    
    static int anagram(String s) {
		int result = 0;
		
		if ( (s.length()%2) == 0 ) {
			String temp1 = s.substring(0, s.length()/2 );
			String temp2 = s.substring(s.length()/2);
			System.out.println("temp1=" + temp1);
    		System.out.println("temp2=" + temp2);
//			ArrayList<Character> chars = new ArrayList<>(
//	                 temp1.chars().mapToObj(e -> (char) e).collect(Collectors.toList()	                )
//	        );
			ArrayList<Character> list1 = new ArrayList<Character>();
			for (char a : temp1.toCharArray()) {
				list1.add(a);
			}
			
			int index = 0;
			for (char c : temp2.toCharArray()) {
				index = list1.indexOf(c);
				if (index >= 0) {
					list1.remove(index);
				} else {
					result++;
				}
				System.out.println("result=" + result);
				System.out.println("list1=" + list1.toString());
			}
			
		} else {
			result = -1;
		}
		return result;
	}
    
    
    
}
