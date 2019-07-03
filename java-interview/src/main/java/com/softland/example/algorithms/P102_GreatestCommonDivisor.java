package com.softland.example.algorithms;

import java.util.Arrays;

public class P102_GreatestCommonDivisor {

	public static void main(String[] args) {

		int[] arr = {2, 3, 4, 5, 6};
		System.out.println("Test 1: " + Arrays.toString(arr));
		// output = 1
		System.out.println("Output 1: " + generalizedGDC(arr.length, arr));
		System.out.println("Output 2: " + generalizedGDC2(arr.length, new int[] {2, 3, 4, 5, 6}));
		
		int[] arr2 = {2, 4, 6, 8, 10};
		System.out.println("\nTest 2: " + Arrays.toString(arr2));
		// output = 2
		System.out.println("Output 1: " + generalizedGDC(arr2.length, arr2));
		System.out.println("Output 2: " + generalizedGDC2(arr2.length, new int[] {2, 4, 6, 8, 10}));
		
	}

	//Solution Cylixx
	static int generalizedGDC(int num, int[] arr) {
		
		Arrays.sort(arr);
		int gdc = arr[0];
		
		boolean correct = Arrays.stream(arr).allMatch(c -> c % arr[0] == 0);
		
		if (!correct) {
			gdc = 1;
		}
		return gdc;
	}
	
	
	static int generalizedGDC2(int num, int[] arr) {
		int result = arr[0];
		int i = 1;
		
		while (i < num) {
			if (arr[i] % result == 0) {
				i++;
			} else {
				result = arr[i] % result;
				i++;
			}
		}

		return result;
	}
	
	
}
