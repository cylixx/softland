package com.softland.example.hackerrank.fb;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/*
 * Insertion Sort - Part 2
 * 
 * In Insertion Sort Part 1, you inserted one element into an array at its correct sorted position. Using the same approach repeatedly, can you sort an entire array?

Guideline: You already can place an element into a sorted array. How can you use that code to build up a sorted array, one element at a time? Note that in the first step, when you consider an array with just the first element, it is already sorted since there's nothing to compare it to.

In this challenge, print the array after each iteration of the insertion sort, i.e., whenever the next element has been inserted at its correct position. Since the array composed of just the first element is already sorted, begin printing after placing the second element.

For example, there are
elements in

. Working from left to right, we get the following output:

3 4 7 5 6 2 1
3 4 7 5 6 2 1
3 4 5 7 6 2 1
3 4 5 6 7 2 1
2 3 4 5 6 7 1
1 2 3 4 5 6 7

Function Description

Complete the insertionSort2 function in the editor below. At each iteration, it should print the array as space-separated integers on a separate line.

insertionSort2 has the following parameter(s):

    n: an integer representing the length of the array 

    arr: an array of integers

Input Format

The first line contains an integer,
, the size of .
The next line contains space-separated integers

.

Constraints


Output Format

On each line, output the entire array at every iteration.

Sample Input

6
1 4 3 5 6 2

Sample Output

1 4 3 5 6 2 
1 3 4 5 6 2 
1 3 4 5 6 2 
1 3 4 5 6 2 
1 2 3 4 5 6 

Explanation

Skip testing
against itself at position . It is sorted.
Test position against position : , no more to check, no change.
Print
Test position against positions and

:

, new position may be
. Keep checking.
, so insert at position

    and move others to the right.

Print

Test position against positions (as necessary): no change.
Print
Test position against positions : no change.
Print
Test position against positions , insert at position and move others to the right.
Print arr
 * 
 */
public class Q5_1_InsertionSortPart2 {

    // Complete the insertionSort2 function below.
    static void insertionSort2(int n, int[] arr) {

        for (int i = 1; i < n; i++) {
            int index = i;

            while(index > 0) {
                int curr = arr[index];
                if (arr[index - 1] > arr[index]) {
                    arr[index] = arr[index - 1];
                    arr[index - 1] = curr;
                }
                index--;
            }
            print(arr);
        }
    }

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(String.format("%s ", arr[i]));
        }
        System.out.println("");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        insertionSort2(n, arr);

        scanner.close();
    }
}
