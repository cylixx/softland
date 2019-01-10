package com.softland.example.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class CollectionComparison {

	public static void main(String[] args) {
		String[] coins = { "Pancracia", "nickel", "dime", "Quarter", "dollar" };
		Set <String> set = new TreeSet<String>();

		for (int i = 0; i < coins.length; i++) {
			set.add( coins[i] );
		}
		System.out.println("lista de objetos en el SET: " + set.toString());
		System.out.println("min = " + Collections.min(set) );
		System.out.println("min CASE_INSENSITIVE_ORDER = " + Collections.min(set, String.CASE_INSENSITIVE_ORDER) );

//		for (int i = 0; i <= 10; i++) {
//			System.out.print('-');
//		}
		System.out.println("----------------------------"); 
		System.out.println("max = " + Collections.max(set) );
		System.out.println("min CASE_INSENSITIVE_ORDER = " + Collections.max(set, String.CASE_INSENSITIVE_ORDER) );
		
		System.out.println("-------------[Otra forma de ordenamiento]---------------");
		Arrays.sort(coins);
		for (int i = 0; i < coins.length; i++) {
			System.out.print(coins[i] +  "  ");
		}
	}

}
