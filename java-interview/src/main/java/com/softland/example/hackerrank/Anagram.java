/*
 https://www.hackerrank.com/challenges/anagram/problem
 
Two words are anagrams of one another if their letters can be rearranged to form the other word.
In this challenge, you will be given a string. You must split it into two contiguous substrings, then determine 
the minimum number of characters to change to make the two substrings into anagrams of one another.
For example, given the string 'abccde', you would break it into two parts: 'abc' and 'cde'. Note that all 
letters have been used, the substrings are contiguous and their lengths are equal. Now you can change 'a' and 'b' 
in the first substring to 'd' and 'e' to have 'dec' and 'cde' which are anagrams. Two changes were necessary.

Function Description
Complete the anagram function in the editor below. It should return the minimum number of characters to change 
to make the words anagrams, or if it's not possible.
anagram has the following parameter(s):

    s: a string

Input Format

-The first line will contain an integer, , the number of test cases.
-Each test case will contain a string which will be concatenation of both the strings described above in the problem.
-The given string will contain only characters in the range ascii[a-z].

Constraints

    consists only of characters in the range ascii[a-z].

Output Format

For each test case, print an integer representing the minimum number of changes required to make an anagram. Print if it is not possible.

Sample Input

6
aaabbb
ab
abc
mnop
xyyx
xaxbbbxx

Sample Output

3
1
-1
2
0
1

Explanation

Test Case #01: We split into two strings ='aaa' and ='bbb'. We have to replace all three characters from the first string with 'b' to make the strings anagrams.

Test Case #02: You have to replace 'a' with 'b', which will generate "bb".

Test Case #03: It is not possible for two strings of unequal length to be anagrams of one another.

Test Case #04: We have to replace both the characters of first string ("mn") to make it an anagram of the other one.

Test Case #05: and are already anagrams of one another.

Test Case #06: Here S1 = "xaxb" and S2 = "bbxx". You must replace 'a' from S1 with 'b' so that S1 = "xbxb".
  
 */
package com.softland.example.hackerrank;

import java.io.IOException;
import java.util.ArrayList;

public class Anagram {

		
	 static int anagram(String s) {
	       int result = 0;
	        
	        if ( (s.length()%2) == 0 ) {
	            String temp1 = s.substring(0, s.length()/2 );
	            String temp2 = s.substring(s.length()/2);
	            
	            ArrayList<Character> list1 = new ArrayList<Character>();
	            for (char a : temp1.toCharArray()) {
	                list1.add(a);
	            }
	            
	            int index = 0;
	            for (char c : temp2.toCharArray()) {
	                index = list1.indexOf(c);
	                if (index >= 0) {
	                    list1.remove(index);
	                } else {
	                    result++;
	                }
	            }
	            
	        } else {
	            result = -1;
	        }
	        return result;
	    }
	 
	 
	 /*
	  * This solution is better because we save space 
	  * since only need to define an array of 26 positions 
	  * that are the letters of the alphabet (26 lowercase alphabets).
	  * But this solution is only valid for letters if you include any other 
	  * character you need to implement a hashtable.
	  */
	 static int anagram2(String s) {
		 if (s.length() % 2 > 0) return -1;
		 
		 String s1 = s.substring(0, s.length()/2);
		 String s2 = s.substring(s.length()/2);
		 
		 
		 int[] arr = new int[26];
		 
		 for(int i=0; i < s1.length(); i++) {
			 arr[s1.charAt(i) - 'a']++;
			 arr[s2.charAt(i) - 'a']--;
		 }
		 //System.out.println(Arrays.toString(arr));
		 
		 int count = 0;
		 for(int c: arr) {
			 if (c > 0) {
				 count = count + c;
			 } 
		 }
		 return count;
	 }
	 

	
	public static void main(String[] args) throws IOException {
		
		String[] arr = new String[] {"aaabbb", "ab", "abc", "mnop", "xyyx", "xaxbbbxx"}; 
		for (String s: arr) {
			System.out.println(anagram(s) + ": " + s);
		}
		
		System.out.println("--------------------[Solution 2]-----------------------------");
		for (String s: arr) {
			System.out.println(anagram2(s) + ": " + s);
		}
		
	}
	
}
