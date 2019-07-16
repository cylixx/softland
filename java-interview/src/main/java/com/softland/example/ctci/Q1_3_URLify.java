/*
 * 1.3
 * URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string
has sufficient space at the end to hold the additional characters, and that you are given the "true"
length of the string. (Note: if implementing in Java, please use a character array so that you can
perform this operation in place.)

EXAMPLE

Input: "Mr John Smith         ", 13
Output: "Mr%20John%20Smith"


Solution:

A common approach in string manipulation problems is to edit the string starting from the end and working
backwards. This is useful because we have an extra buffer at the end, which allows us to change characters
without worrying about what we're overwriting.

We will use this approach in this problem. The algorithm employs a two-scan approach. In the first scan, we
count the number of spaces. By tripling this number, we can compute how many extra characters we will
have in the final string. In the second pass, which is done in reverse order, we actually edit the string. When
we see a space, we replace it with %20. If there is no space, then we copy the original character.

 */
package com.softland.example.ctci;

public class Q1_3_URLify {

	public static void main(String[] args) {
		String s = "Mr John Smith             ";
		char[] c =s.toCharArray();
		
		System.out.println("Input: " + s);
		replaceSpaces(c, 13);
		System.out.println("Output: " + new String(c));  
		
	}

	
	static void replaceSpaces(char[] str, int trueLength) {
		int spaceCount = 0, index, i = 0;
		for (i = 0; i < trueLength; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}
		index = trueLength + spaceCount * 2;
		if (trueLength < str.length)  str[trueLength] = '\0';  //End array
		for (i = trueLength - 1; i >= 0; i--) {
			System.out.println(String.format("index=%d, srt[%d]=%s", index, i, str[i]));
			
			if (str[i] == ' ') {
				str[index - 1] = '0';
				str[index - 2] = '2';
				str[index - 3] = '%';
				index = index - 3;
			} else {
				str[index - 1] = str[i];
				index--;
			}
		}
	}
	
}
