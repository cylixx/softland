package com.softland.example.crackingCodeInterview;

public class Q1_5_OneAway {

	public static void main(String[] args) {
		String s1 = "pale";
		String s2 = "bake";
		System.out.println(String.format("s1: %s    s2: %s", s1, s2));
		System.out.println("Is One way? " + isOneAway(s1, s2));
		
	}

	//---------------------------[ Cylixx solution ]----------------------------------
	static int getCharIndex(Character c) {
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int val = Character.getNumericValue(c);
		
		if (a <= val && val <= z) {
			return val - a;
		}
		return -1;
	}
	

	static boolean isOneAway(String s1, String s2) {
		int size = Character.getNumericValue('z') - Character.getNumericValue('a') + 1;
		int[] arr = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
		int index, count=0;
		System.out.println(String.format("array size=%d", size));
		
		for(char c : s1.toCharArray()) {
			index = getCharIndex(c);
			arr[index]++;
		}
		for(char c : s2.toCharArray()) {
			index = getCharIndex(c);
			arr[index]--;
		}
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] > 0) {
				count++;
			}
			if(count > 1) {
				return false;
			}
		}
		
		return true;
	}
	
}
