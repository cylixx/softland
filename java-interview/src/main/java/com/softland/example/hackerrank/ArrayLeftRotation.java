package com.softland.example.hackerrank;

import java.util.Scanner;

public class ArrayLeftRotation {

	
//	static int[] rotLeft(int[] arr, int d) {
//		
//		for (int i = 0; i < d; i++) {
//			
//			int j, temp;
//	        temp = arr[0];
//	        for (j = 0; j < arr.length - 1; j++) {
//	        	arr[j] = arr[j + 1];
//	        }
//	        arr[i] = temp;
//			
//		}
//		return arr;
//	}
	
	/**
	 * @param data array data
	 * @param d number of lect rotations
	 * @return
	 */
	static int[] rotLeft(int[] data, int d) {
		
		int[] result = new int[data.length];
		for (int i = 0; i < data.length; i++) {
		    result[(i + (data.length - d)) % data.length] = data[i];
		}
		return result;
	}
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();   //size
		int d = in.nextInt();   //number of left rotations
		int[] data = new int[n];
		
		for(int i=0; i<n; i++) {
			data[i] = in.nextInt();
		}
		
//		int[] result = new int[data.length];
//		for (int i = 0; i < data.length; i++) {
//		    result[(i + (data.length - n)) % data.length] = data[i];
//		}
		
		
		int[] result = rotLeft(data, d);

		for (int i : result) {
		    System.out.print(i + "  ");
		}
		in.close();
	}

}
