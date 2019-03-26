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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class P06_findElementInCommon {

//	Otra forma buscando si el SET contiene el elemento de b
//	public static List<Integer> findCommon(int[] a, int[] b) {
//	    final Set<Integer> set = new HashSet<>(Arrays.stream(a).boxed().collect(Collectors.toList()));
//	    final List<Integer> result = new LinkedList<>();
//	    for (int element : b) {
//	       if (set.contains(element)) {
//	          result.add(element);
//	       }
//	    }
//	    return result;
//	}
	
	static List<Integer> findCommon(int[] a, int[] b) {
//		final Set<Integer> set = new HashSet<>(Arrays.stream(a).boxed().collect(Collectors.toList()));
		Set<Integer> aSet = Arrays.stream(a).boxed().collect(Collectors.toSet());
		aSet.retainAll( Arrays.stream(b).boxed().collect(Collectors.toSet()) );
		
		return new ArrayList<>(aSet);
	}
	
	public static void main(String[] args) {

		int[] a = { 1, 5, 12, 3, -15, 52 };
		int[] b = { 3, 1, 6, 5, 57, 13, 17 };

		List<Integer> res = findCommon(a, b);
		System.out.println("aSet=" + res.toString());
	}

}
