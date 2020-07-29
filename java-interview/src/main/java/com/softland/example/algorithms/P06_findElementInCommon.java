/**
 * Find elements in common
 * Encuentra los numeros en comun entre 2 arrays
 * 
 * 
 * Para resolver este problema podemos hacer lo siguiente:
 * 1. Brute force   O(A x B)
 *    Usar la fuerza bruta para romper el algoritmo
 *    comparando uno a uno los elemntos de los arrays,
 *    Ok en este caso debemos identificar el cuello de botella
 *    osea esa comparativa de 
 *    contains(x) is O(B)
 *    
 *    Lo ideal es usar un Hashset para asi tener una compejidad de
 *    O(A + B)
 * 
 * 
 */
package com.softland.example.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class P06_findElementInCommon {

	
	static List<Integer> findCommon(int[] a, int[] b) {
//		final Set<Integer> set = new HashSet<>(Arrays.stream(a).boxed().collect(Collectors.toList()));
		Set<Integer> aSet = Arrays.stream(a).boxed().collect(Collectors.toSet());
		aSet.retainAll( Arrays.stream(b).boxed().collect(Collectors.toSet()) );
		
		return new ArrayList<>(aSet);
	}
	
	/*
	 *Naive approach:

    First create two ArrayList and add values of list.
    Create a temporary ArrayList to contain common elements.
    Iterate through the list1 and check if that element is present in the list2 using ArrayList.contains() method.
    If found, add it to the list3
    Print the common elements from list3

	 */
	static List<Integer> findCommon2(int[] a, int[] b) {
		List<Integer> la =  Arrays.stream(a).boxed().collect(Collectors.toList());
		List<Integer> lb = Arrays.stream(b).boxed().collect(Collectors.toList());
		List<Integer> res = new LinkedList<Integer>();
		
		for (Integer n: la) {
			if (lb.contains(n)) {
				res.add(n);
			}
		}
		return res;
	}
	
	
	/*
	BEST SOLUTION
	
	Using Collections.retainAll() method

	Syntax:
	
	Collections1.retainAll(Collections2)
	
	This method keeps only the common elements
	of both Collection in Collection1.

---

    Get the two ArrayLists.
    Find the common elements in both the Lists using Collection.retainAll() method. This method keeps only the common elements of both Collection in Collection1.
    The List 1 now contains the common elements only.
	 
	 */
	static List<Integer> findCommon3(int[] a, int[] b) {
		List<Integer> la =  Arrays.stream(a).boxed().collect(Collectors.toList());
		List<Integer> lb = Arrays.stream(b).boxed().collect(Collectors.toList());
		
		la.retainAll(lb);
		
		return la;
	}
	
	
	
	public static void main(String[] args) {

		int[] a = { 1, 5, 12, 3, -15, 52 };
		int[] b = { 3, 1, 6, 5, 57, 13, 17 };

		List<Integer> res = findCommon(a, b);
		System.out.println("aSet=" + res.toString());
		
		System.out.println("---------------[Solution #2 - Naive approach]-----------------");
		System.out.println("common elements: " + findCommon2(a, b));
		
		System.out.println("---------------[Solution #3 - Collections1.retainAll(Collections2)]-----------------");
		System.out.println("common elements: " + findCommon3(a, b));
	}

}
