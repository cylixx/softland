package com.softland.example.crackingCodeInterview.StacksAndQueues;

public class MyStackTest {

	public static void main(String[] args) {

		MyStack<Integer> s1 =  new MyStack<Integer>();
		
		s1.push(7);
		s1.push(3);
		s1.push(12);
		s1.push(21);
		s1.printStack();
		
		System.out.println("pop ( ) : Remove the top item from the stack.");
		s1.pop();
		s1.printStack();
		System.out.println("pop ( ) : Remove the top item from the stack.");
		s1.pop();
		s1.printStack();

		System.out.println("\nPeek = " + s1.peek());
		System.out.println("is empty? " + s1.isEmpty());
		
	}

}

