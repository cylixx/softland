package com.softland.example.hackerrank;

public class RecursionFunction {

	static void printFun(int test) {
		if (test < 1)
			return;
		else {
			System.out.printf("%d ", test);
			printFun(test - 1); // statement 2
			System.out.printf("%d ", test);
			return;
		}
	}

	public static void main(String[] args) {
		int test = 3;
		printFun(test);
	}

}
