package com.softland.example.hackerrank.fb;
/*

Question 1: 2D Spiral Array
Find the pattern and complete the function:
int[][] spiral(int n);
where n is the size of the 2D array.
Sample Result
input = 3
123
894
765

input = 4
01 02 03 04
12 13 14 05
11 16 15 06
10 09 08 07

input = 8
1 2 3 4 5 6 7 8
28 29 30 31 32 33 34 9
27 48 49 50 51 52 35 10
26 47 60 61 62 53 36 11
25 46 59 64 63 54 37 12
24 45 58 57 56 55 38 13
23 44 43 42 41 40 39 14
22 21 20 19 18 17 16 15


https://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/

*/
public class _2DSpiralArray {

	public static void main(String[] args) {

		int[][] m = genSpiral(5); 
		printMatrix(m);
		System.out.println("----------------[Solution # iterative]----------------------");
		int[][] m2 = genSpiral2(5); 
		printMatrix(m2);
		System.out.println("----------------[Solution # facebook]----------------------");
		int[][] m3 = genSpiral2(5); 
		printMatrix(m3);
	}
	
	/*
	 *  Complexity Analysis:

	    Time Complexity: O(m*n).
	    To traverse the matrix O(m*n) time is required.
	    Space Comepxlity:O(1).
	    No extra space is required.

	 */
	public static int[][] genSpiral(int n) {
		int[][] m = new int[n][n];
		/*
		 ri - row initial
		 rf - fow final
		 ci - column initial
		 cf - column final
		 count - counter to put in matrix
		 
		 */
		int ri=0, rf=n;
		int ci=0, cf=n;
		int count=1;
		
		while(ri < rf && ci < cf) {
			
			// first row from the remaining rows
			for(int i=ci; i < cf; i++ ) {
				m[ri][i] = count;
				count++;
			}
			ri++;
			
			// last column from the remaining columns
			for(int i=ri; i < rf; i++) {
				m[i][cf - 1] = count;
				count++;
			}
			cf--;
			
			// last row from the remaining rows
			if (ri < rf) {
				for (int i=cf-1; i > ci; i--) {
					m[rf - 1][i] = count;
					count++;
				}
				rf--;
			}
			
			// first column from the remaining columns
			if (ci < cf) {
				for (int i=rf; i >= ri; i--) {
					m[i][ci] = count;
					count++;
				}
				ci++;
			}
		}
		
		return m;
	}
	
	/*
	 * Iterative solution
	 */
	public static int[][] genSpiral2(int n) {
		int[][] m = new int[n][n];
		
		loopSpiral(m, 0, n, 0, n, 1);
		return m;
	}
	/*
	 ri - row initial
	 rf - fow final
	 ci - column initial
	 cf - column final
	 count - counter to put in matrix
	 
	 */
	public static void loopSpiral(int[][] m, int ri, int rf, int ci, int cf, int count) {
		
		if (ri >= rf || ci >= cf) return;
		
			
		// first row from the remaining rows
		for(int i=ci; i < cf; i++ ) {
			m[ri][i] = count;
			count++;
		}
		ri++;
		
		// last column from the remaining columns
		for(int i=ri; i < rf; i++) {
			m[i][cf - 1] = count;
			count++;
		}
		cf--;
		
		// last row from the remaining rows
		if (ri < rf) {
			for (int i=cf-1; i > ci; i--) {
				m[rf - 1][i] = count;
				count++;
			}
			rf--;
		}
		
		// first column from the remaining columns
		if (ci < cf) {
			for (int i=rf; i >= ri; i--) {
				m[i][ci] = count;
				count++;
			}
			ci++;
		}
		
		
		loopSpiral(m, ri, rf, ci, cf, count);
		
	}
	
	/*
	 * Solution - recommended by facebook
	 * Another way to solve this problem is to greedily traverse in each direction until you must stop, 
	 * then turn around and head in the other direction. The sample code below follows this approach and is 
	 * generally the best way to solve this problem. 
	 * 
	 */
	public static int[][] genSpiral3(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException("N must be >0");
		}
		int[] dc = new int[] { 1, 0, -1, 0 };
		int[] dr = new int[] { 0, 1, 0, -1 };
		int dir = 0, val = 0, r = 0, c = 0, limit = n * n;
		int[][] matrix = new int[n][n];
		while (val++ < limit) {
			matrix[r][c] = val;
			r += dr[dir];
			c += dc[dir];
			if (isInvalid(matrix, r, c)) {
				r -= dr[dir];
				c -= dc[dir];
				dir = (dir + 1) % 4;
				r += dr[dir];
				c += dc[dir];
			}
		}
		return matrix;
	}

	private static boolean isInvalid(int[][] m, int r, int c) {
		return r < 0 || c < 0 || r >= m.length || c >= m.length || m[r][c] != 0;
	}
	
	static void printMatrix(int[][] m) {
		for (int i=0; i < m.length; i++) {
			for (int j=0; j < m.length; j++) {
				System.out.print(m[i][j] < 10? "0" + m[i][j] + " " : m[i][j] + " ");
			}
			System.out.println("");
		}
	}

}
