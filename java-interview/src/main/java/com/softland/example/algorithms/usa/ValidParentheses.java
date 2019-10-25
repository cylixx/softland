/*
 * Valid parentheses
Given a string containing just the characters ‘(‘,’)’, ‘{‘,’}’, [‘and’]’, determine if the input string is valid.

An input string is valid if:

-Open brackets must be closed by the same type of brackets
-Open brackets must be closed in the correct order.
-Note that an empty string is also considered valid.

{{}}
{[]}
 */
package com.softland.example.algorithms.usa;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		String str = "[{[{}]}]{}";

		System.out.println(isValid(str));
	}
	
	
	static boolean isValid(String str) {
		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('{', '}');
		map.put('[', ']');

		Stack<Character> stack = new Stack<Character>();  //LILO - Last in first out
		
		for(int i=0; i<str.length(); i++) {
			char curr = str.charAt(i);
			
			if (map.containsKey(curr)) {
				stack.push(curr);
				
			} else if(map.containsValue(curr)) {
				if(!stack.empty() && map.get(stack.peek()) == curr) {
					stack.pop();
				} else {
					return false;
				}
			}
			System.out.println("stack: " + stack);
		}
	
		return stack.empty();
	}
	

}
