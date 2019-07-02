/**
 * Given a string comprised of lower letters in the tange ascci[a-z], determine the length of the smallest substring
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
 *  REFERENCES
 *  https://www.geeksforgeeks.org/smallest-window-contains-characters-string/
 *  https://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/
 * 
 */
package com.softland.example.algorithms;

public class P07_ShortestSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Input String 
//        String str = "AABBBCBB"; 
		String str = "dabbcabcd";
        
  
        int len = shortestSubstring(str); 
        System.out.println(" The length of the smallest substring consisting of maximum distinct "
                + "characters : "+len); 
	}
	
//	public static int shortestSubstring(String s) {
//    // Write your code here
//        char[] str = s.toCharArray();
////        List<Character> charList = Arrays.asList(str);
////        Set<T> myset = new HashSet<T>(Arrays.asList(str));
//
//        Set<Character> temp = new HashSet<Character>();  
//        
//        //return myset.size();
//        return 0;
//    }

	
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

}
