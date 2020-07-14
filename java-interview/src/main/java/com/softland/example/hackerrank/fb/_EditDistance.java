package com.softland.example.hackerrank.fb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Question 3: Edit Distance
Write a function that returns whether two words are exactly "one edit" away using the following signature:
bool OneEditApart(string s1, string s2);
An edit is:

    Inserting one character anywhere in the word (including at the beginning and end)
    Removing one character
    Replacing one character

Examples:
OneEditApart("cat", "dog") = false
OneEditApart("cat", "cats") = true
OneEditApart("cat", "cut") = true
OneEditApart("cat", "cast") = true
OneEditApart("cat", "at") = true
OneEditApart("cat", "act") = false

Solution
There are many solutions to this problem. One optimal solution is to walk each string in unison, tracking if a 
difference has been encountered. If a second difference is encountered, return false. If one string is longer 
than the other, then the difference must mean it is an insertion, so skip a character in the longer string and continue. 
Additionally, there are symmetry and short circuit opportunities. 
 */
public class _EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String[]> arr = new ArrayList<String[]>();
		arr.add(new String[] {"cat", "dog"});
		arr.add(new String[] {"cat", "cats"});
		arr.add(new String[] {"cat", "cut"});
		arr.add(new String[] {"cat", "cast"});
		arr.add(new String[] {"cat", "at"});
		arr.add(new String[] {"cat", "act"});
		
		for (String[] a: arr) {
			System.out.println(String.format("(%s, %s) = %s", a[0], a[1], OneEditApart(a[0], a[1])));
		}
		
		System.out.println("---------------------[Solution #2]---------------------------------"); 
		for (String[] a: arr) {
			System.out.println(String.format("(%s, %s) = %s", a[0], a[1], OneEditApart2(a[0], a[1])));
		}
		
		System.out.println("---------------------[Solution #3]---------------------------------"); 
		for (String[] a: arr) {
			System.out.println(String.format("(%s, %s) = %s", a[0], a[1], editDist(a[0], a[1])));
		}
		

	}

	// XXX esta mal
	public static boolean OneEditApart(String s1, String s2) {
		
		if (s1.length() > s2.length()) {
			if (s1.startsWith(s2)) s1 = s1.substring(0, s1.length()-1);
			else  s1 = s1.substring(1);
			
		} else 	if (s1.length() < s2.length()) {
			if (s2.startsWith(s1)) s2 = s2.substring(0, s2.length()-1);
			else  s2 = s2.substring(1);
		}
		System.out.println(s1 + "  " + s2); 
		
		int count = 0;
		for (int i=0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				count++;
			}
			if (count > 1) return false;
		}
		
		return true;
	}
	
	/*
	 * Solution # cylixx
	 * Usando un diccionario para almacenar las repeticiones de los caracteres
	 */
	public static boolean OneEditApart2(String s1, String s2) {
		int[] arr = new int[27];
		
		int size = s1.length() > s2.length() ? s1.length() : s2.length();
		
		for (int i = 0; i < size; i++) {
			if (i < s1.length()) arr[s1.charAt(i) - 'a']++;
			if (i < s2.length()) arr[s2.charAt(i) - 'a']--;
		}
		
		
		int insert=0, delete=0;
		for(int n: arr) {
			if (n > 0) insert++;
			if (n < 0) delete++;
		}
		//System.out.println(Arrays.toString(arr));
		return insert == 1 || delete == 1;
	}
	
	
	public static int editDist(String s1, String s2) {
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
 
		/* this is the last column of the matrix which 
		 *  represents the result of empty string1
		 *  and string2 starting from current row.
		 */
		for (int row = s2.length(); row >= 0; row--) {
			dp[row][s1.length()] = s2.length() - row;
		}
 
		/* this is the last row of the matrix which
		* represents the result of empty string2
		*  and string1 starting from current col.
	    */
		for (int col = s1.length(); col >= 0; col--) {
			dp[s2.length()][col] = s1.length() - col;
		}
 
		for (int col = s1.length() - 1; col >= 0; col--) {
			for (int row = s2.length() - 1; row >= 0; row--) {
				
				/* If characters are same, then the solution will be without 
				 * these characters */
				if (s1.charAt(col) == s2.charAt(row)) {
					dp[row][col] = dp[row + 1][col + 1];
				} else {
			    /* else it will be minimum of these three operations
				*/
				dp[row][col] = 1 + Math.min(dp[row + 1][col + 1], // replace
                                Math.min(dp[row][col + 1]  // 	removal
                                , dp[row + 1][col]));   // insertion
				}
			}
		}
 
		return dp[0][0];
	}
	
	
}
