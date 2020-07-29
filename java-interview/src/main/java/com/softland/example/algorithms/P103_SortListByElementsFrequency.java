/*
 * Sorting of Array Depending on Frequency of Elements
 * 
 * Input: [4, 3, 1, 6, 4, 3, 6, 4]
 * Output: [4 4 4 3 3 6 6 1]
 * 
 * 
 */

package com.softland.example.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class P103_SortListByElementsFrequency {

	public static void main(String[] args) {
		
		int a[] =  {4, 3, 1, 6, 4, 3, 6, 4};
		System.out.println("Input: " + Arrays.toString(a));
		//Print: [4 4 4 3 3 6 6 1]

		System.out.println("-------------{Solution #1}-------------------------");
		System.out.println(Arrays.toString( sortByFrequency(a) ));
		
		System.out.println("-------------{Solution #2}-------------------------");
		System.out.println(Arrays.toString( sortByFreq(a) ));
		
		System.out.println("-------------{Solution #3}-------------------------");
		System.out.println(Arrays.toString( sortByFreq2(a) ));
		
	}

	public static int[] sortByFrequency(int a[]) {
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
		
		//System.out.println("Result: ");
		//print values accord with its frequency
		int ind = 0;
		int[] res = new int[b.length];
		for(int i=0; i<b.length; i++) {
			
			for (int k=0; k<b[i][1]; k++) {
				//System.out.printf(" %d", b[i][0]);
				res[ind] = b[i][0];
				ind++;
			}
		}
		
		return res;
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
	
	//-------------------------------------------------------
	//20200714 - Solution #2
	// Best solution
	// NOTA: esta solucion no toma en cuenta cuando 2 numeros tienen la misma frecuencia
	
	public static int[] sortByFreq(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int n: arr) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}
		
		System.out.println(map.toString());
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a) );
		pq.addAll(map.keySet());
		System.out.println(String.format("Piority Queue: %s, peek: %s", pq.toString(), pq.peek() ) ); 
		
		List<Integer> res = new ArrayList<Integer>();
		while (!pq.isEmpty()) {
			int n = pq.remove();
			for (int i=0; i < map.get(n); i++) {
				res.add(n);
			}
		}
		
		return res.stream().mapToInt(i -> i).toArray();
	}
	
	// 20200714 -  Solution #3
	// Esta soluciuon toma en cuenta cuando 2 numeros tienen la misma frecuencia.
	public static int[] sortByFreq2(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int n: arr) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}
		
		System.out.println(map.toString());
		PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
				(a, b) -> { 
					if ( a.getValue() < b.getValue() ) return 1;
					else if ( a.getValue() > b.getValue() ) return -1;
					return a.getKey().compareTo(b.getKey());
				});
		pq.addAll(map.entrySet());
		System.out.println(String.format("Piority Queue: %s, peek: %s", pq.toString(), pq.peek() ) ); 
		
		List<Integer> res = new ArrayList<Integer>();
		while (!pq.isEmpty()) {
			Map.Entry<Integer, Integer> n = pq.remove();
			for (int i=0; i < n.getValue(); i++) {
				res.add(n.getKey());
			}
		}
		
		return res.stream().mapToInt(i -> i).toArray();
	}
	
	
	
	
}
