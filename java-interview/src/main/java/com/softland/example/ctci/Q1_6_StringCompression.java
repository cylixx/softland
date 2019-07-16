package com.softland.example.ctci;

import java.util.Arrays;

public class Q1_6_StringCompression {

	public static void main(String[] args) {
		String s1 = "aabcccccaaa";
		//String s1 = "cdabc";
		System.out.println("Input: " + s1);
		System.out.println("Output: " + compression(s1));
		
		System.out.println("//--------------Solution B----------------------------");
		String str = "aabcccccaaa";
		System.out.println("Input: " + str);
		System.out.println("Output: " + compress(str));
		
		System.out.println("//--------------Solution C----------------------------");
		String str2 = "aabcccccaaa";
		System.out.println("Input: " + str2);
		System.out.println("Output: " + compress2(str2));
		
	}
	
	
//	static void sort(String s) {
//		char[] arr = s.toCharArray();
//		java.util.Arrays.sort(arr);
//		//return new String(arr);
//	}
	/*
	 * Cylixx
	 */
	static String compression(String s) {
		int letter=1;
		int j=0;
		//int cont=1;
		//char[] newArr = new char[s.length()];
		StringBuilder sb = new StringBuilder();
		
		char[] arr = s.toCharArray();
		java.util.Arrays.sort(arr);
		System.out.println("Array sort: " + Arrays.toString(arr));
		
		//sb.append(arr[0]);
		for (int i=1; i<arr.length; i++) {
			j = i-1;
			if(arr[i] == arr[j]) {
				letter++;
				//cont++;
			} else {
				sb.append(arr[j]);
				sb.append(letter);
				letter=1;
			}
		}
		
		sb.append(arr[arr.length-1]);
		sb.append(letter);
		
		if (sb.length() > s.length()) return s; 
		
		return sb.toString();
	}
	
	//----------------------Solucion B----------------------------------
	
	public static String compress(String str) {
		StringBuilder compressed = new StringBuilder();
		int countConsecutive = 0;
		for (int i = 0; i < str.length(); i++) {
			countConsecutive++;
			
			/* If next character is different than current, append this char to result.*/
			if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
				compressed.append(str.charAt(i));
				compressed.append(countConsecutive);
				countConsecutive = 0;
			}
		}
		return compressed.length() < str.length() ? compressed.toString() : str;
	}
	
	//----------------------Solucion C----------------------------------
	public static String compress2(String str) {
		int finalLength = countCompression(str);
		if (finalLength >= str.length()) return str;
		
		StringBuffer compressed = new StringBuffer(finalLength); // initialize capacity
		int countConsecutive = 0;
		for (int i = 0; i < str.length(); i++) {
			countConsecutive++;
			
			/* If next character is different than current, append this char to result.*/
			if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
				compressed.append(str.charAt(i));
				compressed.append(countConsecutive);
				countConsecutive = 0;
			}
		}
		return compressed.toString();
	}
	
	public static int countCompression(String str) {
		int compressedLength = 0;
		int countConsecutive = 0;
		for (int i = 0; i < str.length(); i++) {
			countConsecutive++;
			
			/* If next character is different than current, append this char to result.*/
			if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
				compressedLength += 1 + String.valueOf(countConsecutive).length();
				countConsecutive = 0;
			}
		}
		return compressedLength;
} 
	
	
}
