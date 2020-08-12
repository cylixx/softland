package com.softland.example.algorithms;

import java.util.Arrays;

/*
 
 Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.

Example 1:

Input:
A: [1,2,3,2,1]
B: [3,2,1,4,7]
Output: 3

Explanation: 
The repeated subarray with maximum length is [3, 2, 1].
 

Note:

1 <= len(A), len(B) <= 1000
0 <= A[i], B[i] < 100
 
 */
public class L718_MaximumLengthRepeatedSubarray {

	public static void main(String[] args) {
		int[] a = {1,2,3,2,1};
		int[] b = {3,2,1,4,7};
		int res = findLength(a, b);
		System.out.println(Arrays.toString(a)); 
		System.out.println(Arrays.toString(b)); 
		System.out.println("maximum length of an subarray = " + res); 
	}
	
	/*
	 * Approach #3: Dynamic Programming [Accepted]
Intuition and Algorithm

Since a common subarray of A and B must start at some A[i] and B[j], let dp[i][j] be the longest common prefix 
of A[i:] and B[j:]. Whenever A[i] == B[j], we know dp[i][j] = dp[i+1][j+1] + 1. 
Also, the answer is max(dp[i][j]) over all i, j.

We can perform bottom-up dynamic programming to find the answer based on this recurrence. 
Our loop invariant is that the answer is already calculated correctly and stored in dp for any larger i, j.
	 */
	public static int findLength(int[] A, int[] B) {
		int max = 0;
		
		int mem[][] = new int[A.length + 1][B.length + 1];
		for (int i = A.length-1; i >= 0; i--) {
			for (int j = B.length-1; j >=0; j--) {
				if (A[i] == B[j]) {
					mem[i][j] = mem[i+1][j+1] + 1;
					System.out.println(String.format("mem[%s]%s] = %s",i,j, mem[i][j]));
					if (max < mem[i][j]) max = mem[i][j];
				}
			}
		}
		
		return max;
	}
	
	
//	//sliding window algorith
//	public int findLength2(int[] A, int[] B) {
//        
//        int max=0, tmp=1;
//        int bi=0, bj=1;
//        for(int i=0, j=1; j<A.length; i++, j++) {
//            //bi = i;
//            //bj = j;
//            
//            if (A[i] == B[bi] && A[j] == B[bj]) {
//                //tmp++;
//                 while(A[j] == B[bj]) {
//                    tmp++;    
//                    j++;
//                    bj++;
//                }
//                if(tmp > max) max = tmp;
//                
//                i = j;
//                j = j + 1;
//                bi = i;
//                bj = j;
//                
//            } else {
//                bi++;
//                bj++;
//            }
//           
//        }
//    }

}
