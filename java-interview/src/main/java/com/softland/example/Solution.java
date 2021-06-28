package com.softland.example;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	// Complete the primality function below.
	static String primality(int n) {

		return "Test result!";
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// Escribe el resultado en un archivo
		//BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
		String output_path = System.getenv("HOME") + "/Downloads/temp" + "/Solution.txt";
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(output_path));

		int p = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int pItr = 0; pItr < p; pItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			String result = primality(n);

			bufferedWriter.write(result);
			bufferedWriter.newLine();
		}

		bufferedWriter.close();
		scanner.close();
	}
}
