/*
 * 1.2
	Check Permutation: Given two strings, write a method to decide if one is a permutation of the
	other.
	Hints: #7, #84, #722, #737
 */
package com.softland.example.ctci;

public class Q1_2_CheckPermutation {

	public static void main(String[] args) {
//		String s1 = "abcd";
//		String s2 = "cdeb";
		String s1 = "big dog";
		String s2 = "big God";

		System.out.println("Input: ");
		System.out.println(String.format("s1=%s, s2=%s", s1, s2));
		System.out.println("is a permutation of the other? " + isPermutation(s1, s2));
		
		System.out.println("1. is a permutation of the other? " + permutation(s1, s2));
		System.out.println("2. is a permutation of the other? " + permutation2(s1, s2));
		
		
	}
	
	/*
	 * Solution by Cylixx
	 * La solucion es usando un hash table, en este caso asumimos que la cadena contiene solo carecteres validos
	 * del codigo ascci (si quisieramos acotar mas serian solo los caracteres imprimibes)
	 * Entonces lo que hacemos es crear un array de tamaño 256 en donde se va asignar un true en indice del elemento encontrado
	 * De tal manera que si algun carcater de la cadena 2 no esta marcado con un true, entonces ese ya no es una permutacion
	 * porque contiene un caracter diferente y regresamos un false;
	 * 
	 * O(n) - n es el tamaño de la cadena
	 */
	static boolean isPermutation(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		
		int[] arr = new int[128];  //Assumption caracteres imprimibles 
		
		for(int i=0; i<s1.length(); i++) {
			int asc = s1.charAt(i);
			arr[asc]++;
		}
		for(int j=0; j<s2.length(); j++) {
			int c = s2.charAt(j);
			arr[c]--;
			
			if(arr[c] < 0) {
				return false;
			}
		}
		return true;
	}
	
	//---------------------- Solution #1: Sort the strings.------------------------------------
	/*
	 * If two strings are permutations, then we know they have the same characters, but in different orders. There­
	   fore, sorting the strings will put the characters from two permutations in the same order. We just need to
	   compare the sorted versions of the strings.
	 */
	static String sort(String s) {
		char[] content = s.toCharArray();
		java.util.Arrays.sort(content);
		return new String(content);
	}
	
	static boolean permutation(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		return sort(s).equals(sort(t));
	}
	
	//------------------- Solution #2: Check if the two strings have identical character counts. ---------------------------------------------
	/*
	 * We can also use the definition of a permutation-two words with the same character counts-to imple­
	ment this algorithm. We simply iterate through this code, counting how many times each character appears.
	Then, afterwards, we compare the two arrays.
	 */
	static boolean permutation2(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] letters = new int[128];  //Assumption
		
		char[] s_array = s.toCharArray();
		for (char c : s_array) { // II count number of each char in s.
			letters[c]++;
		}
		for (int i = 0; i < t.length(); i++) {
			int c = (int) t.charAt(i);
			letters[c]--;
			if (letters[c] < 0) {
				return false;
			}
		}
		return true;
	}
	

}
