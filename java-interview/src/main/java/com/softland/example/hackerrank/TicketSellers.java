package com.softland.example.hackerrank;

import java.util.Arrays;
import java.util.Collections;

/*
 * https://practice.geeksforgeeks.org/problems/ticket-sellers/0
 * There are N ticket sellers each of whom has a certain amount of tickets. The price of a ticket is the number of tickets remaining with the ticket seller. They can sell a total of K tickets. Find the maximum amount they can earn by selling K tickets.

Input:
The first line of the input consists of a single integer T denoting the number of test cases. Each of the test case consists of two lines. First line of each test case consists of two integers N and K. The next line contains space separated N integers A[0], A[1], …, A[N-1] where A[i] denotes the number of ticket with ith ticket seller.

Output:
For each test case, print in a new line, the maximum amount they can earn by selling K tickets. Print your answer modulo 109 + 7​

Constraints:
1 <= T <= 103
1 <= N <= 105
1 <= Ai, K <= 106

Example:
Input:
2
5 3
4 3 6 2 4
6 2
5 3 5 2 4 4
Output:
15
10

Explanation:
Assume 0-based indexing
Testcase 1:
Firstly, 2nd ticket seller can sell his one ticket at price = 6. Then, he will have 5 tickets with price = 5. He can again sell one ticket with price = 5. Now, he will have 4 tickets with price = 4. At last, any of the 0th, 2nd or 4th ticket seller can sell one ticket as all of them are priced at 4. Hence, the total amount after selling 3 tickets = 6 + 5 + 4 = 15.

Testcase 2:
Firstly, 0th or 2nd ticket seller can sell his one ticket at price = 5. Let us assume that 2nd ticket seller sells his ticket. Now, he would be left with 4 tickets each with price = 4. Now, 0th ticket seller will sell his one ticket at price = 5 and now he will have 4 tickets each with price = 4. Hence, the total amount after selling 2 tickets = 5 + 5 = 10.

 */
public class TicketSellers {

	/*
	 * Esta solucion no resulta tan optima porque por cada iteracion
	 * se necesita reordenar el areglo.
	 */
	public static long times(int[] tickets, int p) {
		int size = tickets.length;
		long amount = 0;
		int i = 1;
		while (i <= p) {
			Arrays.sort(tickets);
			amount += tickets[size-1];
			tickets[size-1]--;
			i++;
		}
		
		return amount;
	}
	
	public static long times2(Integer[] tickets, int p) {
		Arrays.sort(tickets, Collections.reverseOrder());
		
		int i = 1;
		long amount = 0;
		while(i <= p) {
			amount = amount + tickets[0];
			tickets[0]--;
			i++;
			
			//int fa = tickets[0];
			boolean move = true;
			int j=0, k=1;
			while(move && i<p) {
				if ( tickets[j] < tickets[k]) {
					int tmp = tickets[j];
					tickets[j] = tickets[k];
					tickets[k] = tmp;
					j = k;
				} else {
					//break;
					move = false;
				}
				k++;
			}
		}
		return amount;
	}
	
	
	public static void main(String[] args) {
		//int[] arr = {4, 3, 6, 2, 4};
//		int d = 3;
		int[] arr = {5, 3, 5, 2, 4, 4};
		int d = 2;
		
		System.out.println(Arrays.toString(arr));
		System.out.println(String.format("total amount after selling %s tickets = %s", d, times(arr, d)));

		System.out.println("//------------------[Solution 2]---------------------------");
//		Integer[] arr2 = {4, 3, 6, 2, 4};
//		int d2 = 3;
		Integer[] arr2 = {5, 3, 5, 2, 4, 4};
		int d2 = 2;
		
		System.out.println(Arrays.toString(arr2));
		System.out.println(String.format("total amount after selling %s tickets = %s", d2, times2(arr2, d2)));
		
	}

}
