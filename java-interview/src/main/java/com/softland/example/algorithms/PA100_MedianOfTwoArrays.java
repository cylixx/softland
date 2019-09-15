/*
 * Median of two arrays, diferent size
 * 
 * Example 1:
 * nums1 = [1, 5]
 * nums2 = [2]
 * merged = [1, 2, 5]   <--   median = 2.0 
 * 
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 * 
 * 
 */
package com.softland.example.algorithms;

import java.util.Arrays;

public class PA100_MedianOfTwoArrays {

	public static void main(String[] args) {
		int a1[] = {1, 5};
		int a2[] = {2};

		System.out.println("Input: ");
		System.out.println(Arrays.toString(a1));
		System.out.println(Arrays.toString(a2));
		System.out.println("output: " + media(a1, a2));
		
		System.out.println("-----------------Example 2---------------------");
		int a3[] = {-5, 3, 6, 12, 15};
		int a4[] = {-12, -10, -6, -3, 4, 10};
		System.out.println("Input: ");
		System.out.println(Arrays.toString(a3));
		System.out.println(Arrays.toString(a4));
		System.out.println("output: " + media(a3, a4));
	}
	
	/*
	 * Cylixx solution
	 */
	static double  media(int a1[], int a2[]) {
		
		int na[] = new int[a1.length + a2.length];
		int ind = 0;
		
		for(int i=0; i<a1.length; i++) {
			na[ind] = a1[i];
			ind++;
		}
		
		for(int i=0; i<a2.length; i++) {
			na[ind] = a2[i];
			ind++;
		}
		
		Arrays.sort(na);
		System.out.println("merge array: " + Arrays.toString(na)); 
		
		int m = na.length / 2;
		
		System.out.println(String.format("%d / 2 = %d     %d mod 2 = %d", na.length, m, na.length, na.length % 2));
		
		if (na.length % 2 == 1) {
			return (double) na[m];
		}
		
		double median = (double) (na[m-1] + na[m]) / 2; 
		return median;
	}
	

}
