/*
 * 1.1
Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
cannot use additional data structures?
Hints: #44, #7 7 7, #732
 */
package com.softland.example.ctci;

import java.util.HashSet;
import java.util.Set;

public class Q1_1_IsUnique {

	public static void main(String[] args) {
		String s = "cbafdbe";
		boolean b = isUnique(s);
		System.out.println("1. Is unique? " + b);
		
		System.out.println("2. Is unique? " + isUnique2(s));
		
		System.out.println("3. CORRECT ANSWER. Is unique? " + isUniqueChars(s));
		
		
	}
	
	/*
	 *  Compare every character of the string to every other character of the string. 
	 *  This will take 0(n^2) time and 0(1) space.
	 */
	static boolean isUnique(String s) {
		char[] arr = s.toCharArray();
		
		for (int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				 if (i != j && arr[i] == arr[j]) {
					 return false;
				 }
			}
		}
		return true;
	}
	
	
	static boolean isUnique2(String s) {
		Set<Character> set =  new HashSet<Character>();
		boolean b;
		
		for (char c : s.toCharArray()) {
			 b = set.add(c);
			 if (!b) {
				 return false;
			 }
		}
		return true;
	}

	/*
	 * One solution is to create an array of boolean values, where the flag at index i indicates whether character
       i in the alphabet is contained in the string. The second time you see this character you can immediately
       return false.
	 * 
	 * The time complexity for this code is O( n ), where n is the length of the string. 
	 * The space complexity isO(l ).
	 */
	static boolean isUniqueChars(String str) {
		if (str.length() > 128) return false;
		
		boolean[] char_set = new boolean[128];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			System.out.println(String.format("str.charAt(%d) = %d", i, val));
			if (char_set[val]) {// Already found this char in string
				return false;
			}
			char_set[val] = true;
		}
		return true;
	}
	
}
