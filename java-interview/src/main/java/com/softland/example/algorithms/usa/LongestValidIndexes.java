/*
 * Find the longest valid indexes in the string whose differences equal to 1
Difference of the elements should equal to N
[1,1,2,3,4,5,6,1]
N=1

Answer: 2,7
 */
package com.softland.example.algorithms.usa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestValidIndexes {

	public static void main(String[] args) {
		int[] arr = {1,1,2,3,4,5,6,1};
		int n = 1;
		//Answer: 2,7
		
		int[] res = getLongestValidIndex(arr, n);
		System.out.println(Arrays.toString(res));
		
	}

	/*
	 * 1. crear un mapa de los elementos donde el valor es el indice mas alto
	 * 2. Recorremos de nuevo el areglo en busca del segundo elemento
	 * 3. Deducimos que a partir del numero actual el numero a buscar es el actual más la diferencia N
	 *    Por ejemplo: 
	 *         Dado  N=1, current=1 ==> el otro par a buscar es 1 + N = 1+1 = 2
	 *    Entonces buscamos en el mapa la llave igual a 2 y el valor nos dara el indice
	 *    de aqui es necesario asegurarnos que el indice sea menor al del actual porque si no,
	 *    nos dara negativo.     
	 * 
	 */
	static int[] getLongestValidIndex(int[] arr, int n) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] res = new int[2];
		
		for(int i=0; i<arr.length; i++) {
			map.put(arr[i], i);   //creamos array de elementos con el max indice
		}
		System.out.println(map.toString()); 
		
		for(int j=1; j<arr.length; j++) {
			int curr = arr[j];
			int second = curr + n;
			
			if (map.containsKey(second)) {  //validamos que exista la llave a buscar
				int indexUp = map.get(second);
				
				if (indexUp < j) {
					res[0] = indexUp;
					res[1] = j;
				}
			}
		}
		return res;
	}
	
	
}
