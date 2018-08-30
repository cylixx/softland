package com.softland.example;

public class Util {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String output_path = System.getenv("OUTPUT_PATH"); 
		System.out.println("output_path=" + output_path);
		System.out.println("PATH=" + System.getenv("PATH"));
		System.out.println("PATH=" + System.getenv("HOME"));
		System.out.println("System.getenv()=" + System.getenv());
		
		
	}

}
