/*

Problem Statement

A colony of eight houses, represented as cells, are arranged in a straight line. Each day evry cell competes with its adjacent cells (neighbours). An integer value of 1 represents an active cell and value of 0 represents as inactive cell. If both the neighbours are either active or inactive, the cell becomes inactive the next day, otherwise it becomes active on the next day. 

The two cells on the ends have a single adjacent cell, so the other adjacent cell can be assumed to be always inactive. 
Even after updating the cell state, its previous state is considered for updating the state of other cells. 
The cell information of all cells should be updated simultatiously. 

Write an algorithm to output the state of the cells after the given number of days. 

Input

The input to the function consists of two arguments:

    states, a list of integers representing the current state of cells. 
    days, an integer representing the number of days. 

Output

Return a list of integers representing the state of the cells after the given number of days.

Note:

The elements of the list states contains 0s and 1st only.


>> Approach <<
We are not using any extra memory in the given solution (except few local variables), 
so the space complexity is O(n) where n is the number of cells. 
Here it is 8.

Time complexity is O(n x m) where n is the number of cells and m is the number of days.

*/
package com.softland.example.algorithms;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PA101_AColonyOf8House {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 int[] arr = { 1, 0, 0, 0, 0, 1, 0, 0 };
		 System.out.println("Array 1: " + Arrays.toString(arr));
		 System.out.println("Output 1: " + cellCompete(arr, 1));
		 System.out.println("Output 2: " + cellCompete2(new int[] { 1, 0, 0, 0, 0, 1, 0, 0 }, 1));
		 
		 int[] arr2 = { 1, 1, 1, 0, 1, 1, 1, 1 };
		 System.out.println("\nArray 2: " + Arrays.toString(arr2));
		 System.out.println("Output 1: " + cellCompete(arr2, 2));
		 System.out.println("Output 2: " + cellCompete2(new int[] { 1, 1, 1, 0, 1, 1, 1, 1 }, 2));
		
	}
	
	/// <summary>
    /// Method to get the state pf the cells after given number of days.
    /// </summary>
    /// <param name="states">current state of the cells</param>
    /// <param name="days">number of days</param>
    /// <returns>state of cells after given number of days</returns>
	static List<Integer> cellCompete(int[] states, int days) {
		
		int index, prev, next;
		
		// loop for each day
		for(int i=0; i<days; i++) {
			index=0;  // index of current cell
			prev=0;   // value of the previous cell
			next=0;   // value of the next cell
			
			// loop for each cell in the array 
			while(index < states.length) {
				
				// if the current index is not last index of the given array,
                // set the value of nextValue, else it would remain 0.
				if(index < states.length-1) {
					next = states[index + 1];
				
				} else if(index == states.length -1) {
					 next = 0;
				 }
				
				// if nextValue is same as previousValue
				if(next == prev) {
					// save the current index value for next iteration of loop
					prev = states[index];
					// set current index value
					states[index] = 0;
				
				} else {
					// save the current index value for next iteration of loop
					prev = states[index];
					// set current index value
					states[index] = 1;
				}
				
				// next item in the loop
				index++;
			}
		}
		return Arrays.stream(states).boxed().collect(Collectors.toList());
	}
	
	
	// Solution cylixx
	static List<Integer> cellCompete2(int[] states, int days) {
		System.out.println("Array input: " + Arrays.toString(states));
		
		int prev, next, index;
		
		for(int i=0; i<days; i++) {
			prev = 0;  // previous cell
			next = 0;  // next cell
			index = 0;  // current cell (storage before override)
			
			// for each cell
			for(int j=0; j<states.length; j++) {
				
				prev = j-1 < 0 ? prev=0 : index;  // si es el primer elemento previo= 0, otro asignar el valor original 
				next = j + 1 >= states.length ? next=0 : states[j+1]; //si es el final de areglo next=0, otro asignar el valor del actual+1
				
				index = states[j];
				if (prev == next)  {  // si anterior y siguiente igual a activo o inactivo => asignar inactivo
					states[j] = 0; 
				} else {
					states[j] = 1;  // si anterior y siguiente son diferentes => asignar activo
				}
				
//				System.out.printf("\n prev=%s  next=%s  states[%s]=%s", prev, next, j, states[j]);
			}
		}
		return Arrays.stream(states).boxed().collect(Collectors.toList());
	}
	

}
