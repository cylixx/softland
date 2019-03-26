package com.softland.example.sortAlgorithms;

public class SelectionSort {

	public static void main(String[] args) {
		int arr[] = { 5, 3, 6, 2, 10 };
		int newArr[] = executeSelectionSort(arr);
		 System.out.println("Sorted array: ");
		printArray(newArr);
		
	}

	public static int findSmallest(int arr[], int index) {
		int smallest = arr[index];  //stores the smallest value
		int smallest_index = index; //stores the index of the smallest value
		
		for (int i=index+1; i<arr.length; i++) {
			if (arr[i] < smallest) {
				smallest = arr[i];
				smallest_index = i;
			}
		}
		return smallest_index;
	}
	
	public static int[] executeSelectionSort(int arr[]) {
		int smallest = 0;
		int newArr[] = new int[arr.length];
		for (int i=0; i<arr.length; i++) {
			smallest = findSmallest(arr, i); //find the smallest element in the array, and adds it to the new array
			newArr[i] = arr[smallest];
		}
		return newArr;
	}
	
	// Function to print an array 
    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
	
}
