/*
 * Sorting of Array Depending on Frequency of Elements
 * 
 * Input: [4, 3, 1, 6, 4, 3, 6, 4]
 * Output: [4 4 4 3 3 6 6 1]
 * 
 * 
 */

package com.softland.example.algorithms;

import java.util.Arrays;

public class P103_SortListByElementsRequency {

	public static void main(String[] args) {
		
		int a[] =  {4, 3, 1, 6, 4, 3, 6, 4};
		System.out.println("Input: " + Arrays.toString(a));
		//Print: [4 4 4 3 3 6 6 1]

		sort(a); //ordered array in ascending order
		//Arrays.sort(a);
		System.out.println("Sort array: " + Arrays.toString(a));
		
		int b[][] = new int[a.length][2]; //To storage the values and its frequency
		int index=0, j;
		
		b[index][0] = a[0];
		b[index][1] = 1;
		for (int i=1; i<a.length; i++) {
			j = i-1;
			
			if (a[i] == a[j]) {
				b[index][1] = b[index][1] + 1; 
			} else {
				index++;
				b[index][0] = a[i];
				b[index][1] = 1;
			}
		}
		System.out.println("Matrix frequency: ");
		printMatrix(b);
		
		sortByFreq(b);  //Sort matrix by its frequency
		System.out.println("Sort matrix by frequency elements: ");
		printMatrix(b); 
		
		System.out.println("Result: ");
		//print values accord with its frequency
		for(int i=0; i<b.length; i++) {
			
			for (int k=0; k<b[i][1]; k++) {
				System.out.printf(" %d", b[i][0]);
			}
		}
		
	}

	//Sort matrix by frequency (second element in the array)
	public static void sortByFreq(int arr[][]) {
		int minVal, minFreq;
		
		for(int i=0; i<arr.length-1; i++) {
			if (arr[i][1] == 0) break; 
			
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i][1] < arr[j][1]) {
					minVal = arr[i][0];
					minFreq = arr[i][1];
					arr[i][0] = arr[j][0];
					arr[i][1] = arr[j][1];
					
					arr[j][0] = minVal;
					arr[j][1] = minFreq;
				}
			}
		}
	}
	
	//Sort array
	public static void sort(int arr[]) {
		int min;
		for (int i=0; i<arr.length-1; i++) {
			for (int j=i+1; j<arr.length; j++) {
				if (arr[i] > arr[j]) {
					min = arr[i];
					arr[i] = arr[j];
					arr[j] = min;
				}
			}
		}
	}
	
	//Print matrix
	public static void printMatrix(int b[][]) {
		for (int i=0; i<b.length; i++) {
			System.out.printf(" [%d,%d]", b[i][0], b[i][1]);
		}
		System.out.println("");
	}
	
	
}
