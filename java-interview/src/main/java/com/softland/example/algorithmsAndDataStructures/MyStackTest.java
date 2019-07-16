package com.softland.example.algorithmsAndDataStructures;

public class MyStackTest {

	public static void main(String[] args) {

		MyStack<Integer> s1 =  new MyStack<Integer>();
		
		s1.push(7);
		s1.push(3);
		s1.push(12);
		s1.push(21);
		s1.printStack();
		
		s1.pop();
		s1.printStack();
		s1.pop();
		s1.printStack();

		System.out.println("\nPeek = " + s1.peek());
		System.out.println("is empty? " + s1.isEmpty());
	
		System.out.println("//-------------- Stack implement with array --------------------");
		StackArray s2 = new StackArray();
		s2.push(6);
		s2.push(1);
		s2.push(15);
		s2.push(80);
		s2.prinStack();
		
		s2.pop();
		s2.pop(); 
		s2.prinStack();
		
		System.out.println("Peek = " + s2.peek());
		
	}

}

