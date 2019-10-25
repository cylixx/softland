package com.softland.example.crackingCodeInterview;

import java.util.Stack;

public class Q3_5_SortStack {

	public static void main(String[] args) {
		Stack<Integer> s =  new Stack<Integer>();
		s.push(7);
		s.push(10);
		s.push(5);
		s.push(7);
		s.push(12);
		s.push(8);
		s.push(3);
		s.push(1);
		System.out.println("Input: " + s.toString());
		sort(s);
		System.out.println("Output: " + s.toString());
		
	}

	static void sort(Stack<Integer> s) {
		Stack<Integer> r = new Stack<Integer>();
		while (!s.isEmpty()) {
			/* Insert each element in s in sorted order into r. */
			int tmp = s.pop();
			while (!r.isEmpty() && r.peek() > tmp) {
				s.push(r.pop());
			}

			r.push(tmp);
		}

		/* Copy the elements from r back into s. */
		while (!r.isEmpty()) {
			s.push(r.pop());
		}
	}

}
