/**
 * Given a string comprised of lower letters in the range ascci[a-z], determine the length of the smallest substring
 * that contains all of the letters present in the string.
 * 
 * For example, given the string s=dabbcabcd, the list of all characters in the string is [a, b, c, d].
 * Two of the substrings that contain all letters are dabbc and abcd. The shortest substring containing
 * all the letters is 4 characters long, abcd.
 * 
 * Function Description
 * Complete the function shortestSubstring in the editor below. The function must return the length of the
 * shortest substring that contains all of the characters within s.
 * 
 * shortestSubstring has the following parameter:
 *  s: a string
 *  
 *  Example:
 *  Sample Input For Custom Testing
 *    bab
 *  Sample Output
 *    2
 *  Explanation  
 *    "ba" is a substring that contains all thecharacterers in s.
 *  
 *  -------------------------
 *  
 *  SOLUTION:
 *  
 *  Method 2: Here we have used Sliding Window technique to arrive at the solution. This technique shows how a nested for loop in few problems can be converted to single for loop and hence reducing the time complexity.

    Approach: Basically a window of characters is maintained by using two pointers namely start and end. These start and end pointers can be used to shrink and increase the size of window respectively. Whenever the window contains all characters of given string, the window is shrinked from left side to remove extra characters and then its length is compared with the smallest window found so far.
    If in the present window, no more characters can be deleted then we start increasing the size of the window using the end until all the distinct characters present in the string are also there in the window. Finally, find the minimum size of each window.
 *  
 *  REFERENCES
 *  https://www.geeksforgeeks.org/smallest-window-contains-characters-string/
 *  https://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/
 * 
 */
package com.softland.example.algorithms;

import java.util.Arrays;

public class P07_ShortestSubstring {

	public static void main(String[] args) {
		String str = "dabbcabcd";
  
//        int len = shortestSubstring(str); 
//        System.out.println(" The length of the smallest substring consisting of maximum distinct "
//                + "characters : "+len); 
        
        String f = findSubString(str);
        System.out.printf("\nSubstring that contain all characters: %s, size: %s", f, f.length());
	}
	
	/*
	 * 
	Algorithm :
	    1. Maintain an array (visited) of maximum possible characters (256 characters) and as soon as we find any in the string, mark that index in the array (this is to count all distinct characters in the string).
	    2. Take two pointers start and end which will mark the start and end of window.
	    3. Take a counter=0 which will be used to count distinct characters in the window.
	    4. Now start reading the characters of the given string and if we come across a character which has not been visited yet increment the counter by 1.
	    5. If the counter is equal to total number of distinct characters, Try to shrink the window.
	    6. For shrinking the window -:
        	a. If the frequency of character at start pointer is greater than 1 increment the pointer as it is redundant.
        	b. Now compare the length of present window with the minimum window length.

	Complexiy Analysis:
	    Time Complexity: O(N).
	    As the string is traversed using two pointers only once.
	    Space Complexity: O(N).
	    As a hash_map is used of size N.

	 */
	 static String findSubString(String str) {
	    	final int MAX_CHARS = 256;
	    	
	    	int n = str.length();
	    	
	    	// count distinct characters
	    	int dist_count = 0;
	    	boolean[] visited = new boolean[MAX_CHARS];
	    	Arrays.fill(visited, false);
	    	for (int i=0; i < n; i++) {
	    		if (visited[str.charAt(i)] == false) {
	    			visited[str.charAt(i)] = true;
	    			dist_count++;
	    		}
	    	}
	    	//System.out.printf("\nDistinct characters = %s", dist_count);
	    	
	    	
	    	int start = 0, start_index = -1;
	    	int min_len = Integer.MAX_VALUE;
	    	
	    	int count = 0;
	    	int[] curr_count = new int[MAX_CHARS];
	    	for (int j=0; j < n; j++) {
	    		curr_count[str.charAt(j)]++;   //count occurrence of characters of string
	    		
	    		if (curr_count[str.charAt(j)] == 1) count++; //if distinct character, then we count
	    		
	    		if (count == dist_count) { //if all the characters are matched
	    			
	    			//Try to minimize the window
	    			while(curr_count[str.charAt(start)] > 1) {
	    				if (curr_count[str.charAt(start)] > 1) {
	    					curr_count[str.charAt(start)]--;
	    				}
	    				start++;
	    			}
	    			
	    			// update window size
	    			int len_window = j - start + 1;
	    			if (min_len > len_window) {
	    				min_len = len_window;
	    				start_index = start;
	    			}
	    			
	    		}
	    	}
	    	
	    	return str.substring(start_index, start_index + min_len);
	    }

	 
	/*
	public static int shortestSubstring(String s) {
	    // Write your code here
	        int n = s.length();

	        int maximusDistinct = maxDistinct(s, n);
	        int res = n;

	        for(int i=0; i<n; i++) {
	            for(int j=0; j<n; j++) {
	                String substr = null;
	                if(i<j) { 
	                    substr = s.substring(i,j);
	                } else {
	                    substr = s.substring(j, i);
	                }    
	                int substrSize = substr.length();
	                int substrDistinct = maxDistinct(substr, substrSize);

	                if (substrSize < res && maximusDistinct == substrDistinct) {
	                    res = substrSize;
	                }	
	            }
	        }
	        return res;
	    }

	    static int maxDistinct(String str, int n) {
	        int count[] = new int[256];

	        for(int i=0; i<n; i++) {
	            count[str.charAt(i)]++;
	        }

	        int res = 0;
	        for(int i=0; i<256; i++) { 
	            if(count[i] !=0) {
	                res++;
	            }
	        }
	        return res;
	    }
	    */

}
