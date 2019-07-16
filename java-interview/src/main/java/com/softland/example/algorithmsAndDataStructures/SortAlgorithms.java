/**
 * Explanation
 * https://www.cs.cmu.edu/~adamchik/15-121/lectures/Sorting%20Algorithms/sorting.html
 * 
 */
package com.softland.example.algorithmsAndDataStructures;

import java.util.Arrays;

public class SortAlgorithms {

	public static void main(String[] args) {
		int a[] = {20, 5, 1, 16, 8, 10, 5};
		System.out.println("Input array: " + Arrays.toString(a));
		
		//System.out.println("Output selectionSort: " + Arrays.toString(selectionSort(a)));
		selectionSort(a);
		System.out.println("Output selectionSort: " + Arrays.toString(a));
		
		System.out.println("//--------------------- Insertion Sort -------------------------");
		int b[] = {20, 5, 1, 16, 8, 10, 5};
		System.out.println("Input array: " + Arrays.toString(b));
		insertionSort(b);
		System.out.println("Output selectionSort: " + Arrays.toString(b));
		
	}

	/*
	 * Selection sort is an in-place comparison sort. It loops and find the first smallest value, 
	 * swaps it with the first element; loop and find the second smallest value again, swaps it 
	 * with the second element, repeats third, fourth, fifth smallest values and swaps it, until 
	 * everything is in correct order.
	 * 
	 * Algorithm complexity
	 * O(n^2)
	 * 
	 */
	static void selectionSort(int arr[]) {
		int min;
		// recorremos el array completo
		for(int i=0; i<arr.length-1; i++) {
			System.out.println(Arrays.toString(arr));
			//recorremos sublist en busca del minimo valor y lo ponemos en el inicio del subarray
			for(int j=i+1; j<arr.length; j++) {
				if (arr[i] > arr[j]) { //orden ascendente, hacemos un intercambio (swaps the smallest value)
					min = arr[i];
					arr[i] = arr[j];
					arr[j] = min;
				}
			}
		}
		//return arr;
	}
	
	/*
	 * To sort unordered list of elements, we remove its entries one at a time and then insert each of them into a sorted part (initially empty): 
	 * 
	 * The worst-case runtimecomplexity is O(n^2).What is the best-case runtime complexity? O(n). 
	 * The advantage of insertion sort comparing it to the previous two sorting algorithm is that 
	 * insertion sort runs in linear time on nearly sorted data. 
	 * 
	 * 
	 */
	static void insertionSort(int[] ar) {
		for (int i = 1; i < ar.length; i++) {

			int index = ar[i];
			int j = i;
			System.out.println(String.format("i=%d, index=%d, j=%d, ar[%d - 1]=%s", i, index, j, j, ar[j - 1]));
			while (j > 0 && ar[j - 1] > index) {
				ar[j] = ar[j - 1];
				j--;
			}
			ar[j] = index;
			//System.out.println(Arrays.toString(ar));
		}
	}

}
