package com.softland.example.algorithms;

public class P105_CalculateIntersectionAreaOfRectangles {

	public static void main(String[] args) {
		int[][] rect1 = {{2,1}, {5,5}}; 
		int[][] rect2 = {{3,2}, {5,7}};
		//System.out.println("Rect1: " + Arrays.toString(rect1));
		//System.out.println("Rect2: " + Arrays.toString(rect2));
		printMatrix(rect1);
		printMatrix(rect2);
	}
	
	static int[][] getIntersectionRectangle(int[][] rect1, int[][] rect2) {
		int x1, y1, x2, y2; 
		int r1x1=rect2[0][0];
		
		//getX
		if(rect2[0][0] >= rect1[0][0] && rect2[0][0] <= rect1[1][0]) {
			
		}
		
		
		return null;
	}
	

	//Print matrix
	public static void printMatrix(int b[][]) {
		for (int i=0; i<b.length; i++) {
			System.out.printf(" [%d,%d]", b[i][0], b[i][1]);
		}
		System.out.println("");
	}
}
