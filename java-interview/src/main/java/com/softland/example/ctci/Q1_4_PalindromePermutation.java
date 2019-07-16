/*
 * 1.4
Palindrome Permutation: Given a string, write a function to check if it is a permutation of
a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A
permutation is a rearrangement of letters. The palindrome does not need to be limited to just
dictionary words.
EXAMPLE
Input: Tact Coa
Output: True (permutations: "taco cat'; "atc o eta·; etc.)
 * 
 */
package com.softland.example.ctci;

import java.util.Arrays;

public class Q1_4_PalindromePermutation {

	public static void main(String[] args) {
//		String input = "tact coa";
//		String s = "aoc tcat";
		String input = "rats live on no evil star";
		String s = "rats live on no evil star";
		System.out.println("Input: ");
		System.out.println("s1: " + input);
		System.out.println("s2: " + s);
		
		if (isPermutation(input, s)) {
			if(isPalindrome(input, s)) {
				System.out.println("Output: Palindrome");
			} else {
				System.out.println("Output: Permutation");
			}
		}

		
		System.out.println("//------------------------------------------------");
		String pali = "Rats live on no evil star";
		System.out.println("Input: " + pali);
		System.out.println("Output: " + isPermutationOfPalindrome(pali));
		
		
	}

	//------------------ Cylixx solution-------------------------------
	
	static boolean isPermutation(String s1, String s2) {
		int[] arr = new int[128];
		int index;
		
		for(int i=0; i<s1.length(); i++){
			index = s1.charAt(i);
			arr[index]++;
			//System.out.println(String.format("arr[%d]=%d", index, arr[index]));
		}
		for(int j=0; j<s2.length(); j++) {
			index = s2.charAt(j);
			arr[index]--;
			if(arr[index] < 0) {
				return false;
			}
		}
		return true;
	}
	
	static boolean isPalindrome(String s1, String s2) {
		if (!isPermutation(s1, s2)) return false;
		
		StringBuffer tem =  new StringBuffer(s2);
		
		return s1.equals( tem.reverse().toString() );
	}
	
	
	//-------------------------------- Solution#1 -------------------------------
	public static int getCharNumber(Character c) {
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		System.out.println(String.format("a=%d, z=%d", a, z));
		
		int val = Character.getNumericValue(c);
		if (a <= val && val <= z) {
			return val - a;
		}
		return -1;
	}
	
	public static int[] buildCharFrequencyTable(String phrase) {
		int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
		for (char c : phrase.toCharArray()) {
			int x = getCharNumber(c);
			if (x != -1) {
				table[x]++;
			}
		}
		return table;
	}
	
	public static boolean checkMaxOneOdd(int[] table) {
		boolean foundOdd = false;
		for (int count : table) {
			if (count % 2 == 1) {
				if (foundOdd) {
					return false;
				}
				foundOdd = true;
			}
		}
		return true;
	}
	
	public static boolean isPermutationOfPalindrome(String phrase) {
		int[] table = buildCharFrequencyTable(phrase);
		System.out.println("table hash: " + Arrays.toString(table));
		return checkMaxOneOdd(table);
	}

}
