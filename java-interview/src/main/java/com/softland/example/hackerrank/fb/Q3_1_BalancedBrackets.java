package com.softland.example.hackerrank.fb;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/*
 * Balanced Brackets
 * A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].

Two brackets are considered to be a matched pair if the an opening bracket (i.e., (, [, or {) occurs to the left of a closing bracket (i.e., ), ], or }) of the exact same type. There are three types of matched pairs of brackets: [], {}, and ().

A matching pair of brackets is not balanced if the set of brackets it encloses are not matched. For example, {[(])} is not balanced because the contents in between { and } are not balanced. The pair of square brackets encloses a single, unbalanced opening bracket, (, and the pair of parentheses encloses a single, unbalanced closing square bracket, ].

By this logic, we say a sequence of brackets is balanced if the following conditions are met:

    It contains no unmatched brackets.
    The subset of brackets enclosed within the confines of a matched pair of brackets is also a matched pair of brackets.

Given

strings of brackets, determine whether each sequence of brackets is balanced. If a string is balanced, return YES. Otherwise, return NO.

Function Description

Complete the function isBalanced in the editor below. It must return a string: YES if the sequence is balanced or NO if it is not.

isBalanced has the following parameter(s):

    s: a string of brackets

Input Format

The first line contains a single integer
, the number of strings.
Each of the next lines contains a single string

, a sequence of brackets.

Constraints

, where

    is the length of the sequence.
    All chracters in the sequences ∈ { {, }, (, ), [, ] }.

Output Format

For each string, return YES or NO.

Sample Input

3
{[()]}
{[(])}
{{[[(())]]}}

Sample Output

YES
NO
YES

Explanation

    The string {[()]} meets both criteria for being a balanced string, so we print YES on a new line.
    The string {[(])} is not balanced because the brackets enclosed by the matched pair { and } are not balanced: [(]).
    The string {{[[(())]]}} meets both criteria for being a balanced string, so we print YES on a new line.

 * 
 */
public class Q3_1_BalancedBrackets {
   


    // Complete the isBalanced function below.
	static String isBalanced(String s) {
        LinkedList<Character> st = new LinkedList<Character>();
        
        if (s == null || s.length()==0)  return "NO";

        char[] tmp = s.toCharArray();
        if ((tmp.length % 2) > 0)  return "NO";

        if (dictionary().containsValue(tmp[0])) return "NO";

        for (int i=0; i < tmp.length; i++) {
            if (dictionary().containsKey(tmp[i])) {
                st.push(dictionary().get(tmp[i]));

            } else {
                if (!st.isEmpty()) {
                    char r = st.pop();
                    if ( r != tmp[i]) return "NO";
                }
            }
        }
        if (!st.isEmpty()) return "NO";

        return "YES";
    }

    static HashMap<Character, Character> dictionary() {
        HashMap<Character, Character> dc = new HashMap<Character, Character>();
        dc.put('{', '}');
        dc.put('(', ')');
        dc.put('[', ']');
        return dc;
    }



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int t = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int tItr = 0; tItr < t; tItr++) {
//            String s = scanner.nextLine();
//
//            String result = isBalanced(s);
//
//            bufferedWriter.write(result);
//            bufferedWriter.newLine();
//        }
//
//        bufferedWriter.close();
//
//        scanner.close();
//        
        
    	String[] arr =  new String[]{"{[()]}", "{[(])}", "{{[[(())]]}}"}; 
    	for (String s: arr ) {
    		String result = isBalanced(s);
    		System.out.println(result); 
    	}
    	
    	//Exception e = null;
    	//e.printStackTrace();
    	
    }
}
