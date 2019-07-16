/*
 * Hacer un algoritmo que dado un array le sumes uno y el resultado lo devuelvas como array
 * Input: [1, 2, 9, 9]
   Output: [1, 3, 0, 0] 
 * 
 * Input: [9, 9, 9, 9]
   Output: [1, 0, 0, 0, 0]
 * 
 */
package com.softland.example.algorithms;

import java.util.Arrays;

public class P104_AddOneToArray {

	public static void main(String[] args) {
		int[] arr = {1, 2, 9, 9};
		//int[] arr = {9, 9, 9, 9};
		System.out.println("Input: " + Arrays.toString(arr));
		
		int[] res = addToArray(arr);
		System.out.println("Output: " + Arrays.toString(res));
		
		
	}

	static int[] addToArray(int[] arr) {
		int carry = 1;
		int total;
		
		for(int i=arr.length-1; i>=0; i--) {
			total = arr[i] + carry;
			if (total == 10) carry=1;
			else carry = 0;

			arr[i] = total % 10;
		}
		if (carry == 1) {
			int nArr[] = new int[arr.length + 1];
			nArr[0] = 1;
			for (int j=0; j<=arr.length-1; j++) {
				nArr[j+1] = arr[j];
			}
			return nArr;
		}
		
		return arr;
	}
	
}
