/*
 * 
 * Matrix Cleanup
 * Whrite the algorithm cleanup(matrix x) such that if an element in an MxN matrix is 0,
 * its entire row and column are set to 0.
 * 
 * Sample Input
 * 3 - rows
 * 5 - columns
 * 
 * 2, 1, 0,  3, 33
 * 1, 0, 1,  3, 4
 * 8, 9, 10, 3, 1
 * 
 * Sample Output
 * [0, 0, 0, 0, 0] 
 * [0, 0, 0, 0, 0] 
 * [8, 0, 0, 3, 1]
 * 
 */
package com.softland.example.algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P101_MatrixCleanup {
	
	public static void main(String[] args) {
		List<List<Integer>> input = Arrays.asList(
					Arrays.asList(2, 1, 0,  3, 33),
					Arrays.asList(1, 0, 1,  3, 4),
					Arrays.asList(8, 9, 10, 3, 1)
				);
		
		System.out.println("Input: " + input.toString());
		System.out.println("Output: " + cleanup(input));
	}
	
	
	/*
	   Algorithm complexity
	   O(n) - rows
	   O(m) - columns
	   O(n) - rows
	   O(l) - new columns (0...m)
	   
	   = O(n) + O(m) + O(n) + O(l)
	   = O(n*n*m*l)
	   = O(n^2*m * l)
	  
	*/
	static List<List<Integer>> cleanup(List<List<Integer>> matrix) {
		Set<Integer> ren =  new HashSet<Integer>();
		Set<Integer> col =  new HashSet<Integer>();
		
		//Recorremos la matriz completa en busca de 0
		for(int i=0; i<matrix.size(); i++) {  //O(n) - rows 
			for(int j=0; j<matrix.get(i).size(); j++) {  //O(m) - columns
				
				//Cuando se encuentra un 0, guardamos su renglon y columna
				if(matrix.get(i).get(j) == 0) {
					ren.add(i);
					col.add(j);
				} 
			}
		}
		System.out.println("Index Rows: " + ren.toString());
		System.out.println("Index Colums: " + col.toString());
		
		//Si ningun renglon contiene 0 entonces regresamos la misma matrix
		if(ren.isEmpty()) {
			return matrix;
		}
		
		//Recorremos los renglones de la matriz
		for(int i=0; i<matrix.size(); i++) {  //O(n) - rows 
			
			//si se encontro el indice del renglon en nuestra variable entonces 
			//el renglon actual debe ser cero todos sus elementos
			if(ren.contains(i)) {   //O(1)
				Collections.fill(matrix.get(i), 0);
				
			} else {
				//Para todas las columnas de nuestra variable
				//reemplazamos por 0 en el indice indicado por la variable
				for(Integer j: col) {  //O(l) - column indexes 
					matrix.get(i).set(j, 0);
				}
				
			}
		}
		return matrix;
	}
	
	
}
