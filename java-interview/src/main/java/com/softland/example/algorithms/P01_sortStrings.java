package com.softland.example.algorithms;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/*
 * @author Marco Hinojosa
 * 
 * Ordena una lista de nombres
 * 
 */
public class P01_sortStrings {

	public static void main(String[] args) {
		Scanner in =  new Scanner(System.in);
		System.out.println("Dame el total de elementos");
		int n = in.nextInt();
		
		String[] names =  new String[n];
		for (int i=0; i<n; i++) {
			System.out.println("Nombre: ");
			names[i] = in.next();
		}
		in.close();

		// convert list to array
		//String[] s1 = list.toArray(new String[0]);  
		
		//1. Ordenamiento por Arrays utility 
		Arrays.sort(names);
		
		//2. metiendo los elementos en un TreeSet
//		Set <String> set = new TreeSet<String>();
//		for (int i = 0; i < names.length; i++) {
//			set.add( names[i] );
//		}

		
		System.out.println("Resultado: ");
		for (int i=0; i<names.length; i++) {
			System.out.printf("%s  ", names[i]);
		}
		
	}
}
