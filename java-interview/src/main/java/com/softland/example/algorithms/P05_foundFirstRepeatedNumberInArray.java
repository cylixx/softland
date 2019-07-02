/**
 * Dado un array con los siguientes numeros
 * [1,2,3,1,2,3]
 * encontrar cual es el primer numero que se repite en el arreglo?
 * 
 */
package com.softland.example.algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class P05_foundFirstRepeatedNumberInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] numbers = { 1, 5, 23, 2, 1, 6, 3, 1, 8, 12, 3 };
		
		System.out.println("1. Ordenando los valores del areglo y comparando el primero con el segundo");
		int first = getFirstDuplicate(numbers);
		System.out.println("First repeated number = " + first);
		

		System.out.println("This is almost the easiest way! hashSet returns false whenever a duplicate number is added to it.");
		first = getFirstDuplicate2(numbers);
		System.out.println("First repeated number = " + first);
		
		
		Integer[] repeats = getDuplicates(numbers);
		System.out.println("Areglo de numeros repetidos: ");
		for(int i=0; i<repeats.length; i++) {
			System.out.printf(repeats[i] + " ");
		}
		
		//Java 8
		System.out.println("\nJava 8 - Numeros repetidos: ");
		List<Integer> listInteger = Arrays.stream(numbers).boxed().collect(Collectors.toList()); //Convierte Array to List
		listInteger.stream().filter(i -> Collections.frequency(listInteger, i) >1).collect(Collectors.toSet()).forEach(System.out::println);
	}
	
	//1. Ordenando los valores del areglo y comparando el segundo con el primero
	public static int getFirstDuplicate(int[] array) {
		Arrays.sort(array);
		
		for(int i=1; i < array.length; i++) {
			if (array[i] == array[i-1]) {
				return array[i]; 
			}
		}
		return 0;
	}
	
	//This is almost the easiest way! hashSet returns false whenever a duplicate number is added to it.
	public static int getFirstDuplicate2(int[] array) {
		Set<Integer> hashSet = new HashSet<Integer>();
		
		for(int i=0; i < array.length; i++) {
			boolean unique = hashSet.add(array[i]); //Set regresa true si no contiene el elemento
	        if(!unique)
	        	return array[i];  //duplicado
		}
		return 0;
	}
	
	// Obtiene todos los repetidos 
	public static Integer[] getDuplicates(int[] array) {
		Set<Integer> temp = new HashSet<Integer>();
		Arrays.sort(array);
		System.out.println("Ordenamos array: " + Arrays.toString(array));
		
		for(int i=1; i < array.length; i++) {
			if (array[i] == array[i-1]) {
				temp.add( array[i] ); 
			}
		}
		return temp.toArray(new Integer[temp.size()]);
	}
	

}
