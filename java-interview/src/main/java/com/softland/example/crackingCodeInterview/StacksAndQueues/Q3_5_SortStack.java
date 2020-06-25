package com.softland.example.crackingCodeInterview.StacksAndQueues;

import java.util.Stack;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 *
 *3.5
Sort Stack: Write a program to sort a stack such that the smallest items are on the top. You can use
an additional temporary stack, but you may not copy the elements into any other data structure
(such as an array). The stack supports the following operations: push, pop, peek, and is Empty.

 */
public class Q3_5_SortStack {

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(7);
		s.push(5);
		s.push(1);
		s.push(8);
		s.push(3);
		s.push(2);
		System.out.println(s.stream().collect(Collectors.toList()));
		System.out.println("--------Sort:--------");
		sort(s);
		System.out.println(s.stream().collect(Collectors.toList()));
		System.out.println("Peak = " + s.peek());
	}

	/*
	 * This algorithm is O( N^2 ) time and O( N) space.
	 */
	static void sort(Stack<Integer> s1) {
		Stack<Integer> s2 = new Stack<Integer>();

		while (!s1.isEmpty()) {
			/* Insert each element in s in sorted order into r. */
			int tmp = s1.pop();
			while (!s2.isEmpty() && s2.peek() > tmp) {
				s1.push(s2.pop());
			}
			s2.push(tmp);
		}

		/* Copy the elements from r back into s. */
		while(!s2.isEmpty()) {
			s1.push(s2.pop());
		}
	}

}
