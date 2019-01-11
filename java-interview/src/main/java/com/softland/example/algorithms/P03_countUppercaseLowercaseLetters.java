package com.softland.example.algorithms;

import java.util.Scanner;

public class P03_countUppercaseLowercaseLetters {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Give me a string: ");
		String input = scan.nextLine();
		
		//1. Con stream in Java 8
		long uppercaseLetters = input.chars().filter(c -> Character.isUpperCase(c)).count();
		long lowercaseLetters = input.chars().filter(c -> Character.isLowerCase(c)).count();
		System.out.println("1. stream in Java 8");
		System.out.println("Uppercase Letters=" + uppercaseLetters);
		System.out.println("Lowercase Letters=" + lowercaseLetters);
		
		
		uppercaseLetters = 0;
		lowercaseLetters = 0;
		//2. recorriendo la cadena y contando letras
		for(int i=0; i<input.length(); i++) {
			if (Character.isUpperCase(input.charAt(i))) {
				uppercaseLetters++;
			
			} else if (Character.isLowerCase(input.charAt(i))) {
				lowercaseLetters++;
			}
		}
		System.out.println("2. recorriendo la cadena y contando letras");
		System.out.println("Uppercase Letters=" + uppercaseLetters);
		System.out.println("Lowercase Letters=" + lowercaseLetters);
		scan.close();
		
	}

}
