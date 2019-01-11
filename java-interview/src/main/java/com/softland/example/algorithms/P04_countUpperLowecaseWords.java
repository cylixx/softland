package com.softland.example.algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class P04_countUpperLowecaseWords {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Give me frase:");
		
		String input = scan.nextLine();
		String[] words = input.split(" ");
		
		long upper = 0;
		long lower = 0;
		String w;
		
		// 1. algoritmo busqueda lineal O(n)
		for(int i=0; i<words.length; i++) {
			w = words[i];
			if(words[i].equals(w.toUpperCase())) {
				upper++;
			} else if(words[i].equals(w.toLowerCase())) {
				lower++;
			}
		}
		System.out.println("1. algoritmo busqueda lineal O(n)");
		System.out.println("UpperCase=" + upper);
		System.out.println("Lower Case=" + lower);
		

		//2. Con Java 8
		words = input.split(" ");
		//List<String> list = Arrays.stream(words).collect(Collectors.toList());
		lower = Arrays.stream(words).filter( wo -> wo.equals(wo.toLowerCase()) ).count();
		upper = Arrays.stream(words).filter( wo -> wo.equals(wo.toUpperCase()) ).count();
		System.out.println("2. Con Java 8");
		System.out.println("UpperCase=" + upper);
		System.out.println("Lower Case=" + lower);
		
		scan.close();
	}
		
}
