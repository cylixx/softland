package com.softland.example.crackingCodeInterview.StacksAndQueues;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.List;

public class MyStack<T> {
	private static class StackNode<T> {
		private T data;
		private StackNode<T> next;
		
		public StackNode(T data) {
			this.data = data;
		}
		
		public T getData() {
			return data;
		}
	}
	
	private StackNode<T> top;

	//Remove the top item from the stack.
	public T pop() {
		if (top == null) throw new EmptyStackException();
		T item = top.getData();
		top = top.next;
		return item;
	}

	//Add an item to the top of the stack
	public void push(T item) { 
		StackNode<T> t = new StackNode<T>(item);
		t.next = top;
		top = t;
	} 

	//Return the top of the stack.
	public T peek() {
		if (top == null) throw new EmptyStackException();
		return top.data;
	}
	
	//Return true if and only if the stack is empty.
	public boolean isEmpty() {
		return top == null;
	}
	
	
	public void printStack() {
		List<T> li = new LinkedList<T>();
		
		StackNode<T> n = top;
		if (n == null) System.out.println("[]");
		//System.out.printf("[");
		while(n != null) {
			li.add(n.data);
			//System.out.printf(n.data + ", ");
			n = n.next;
		}
		//System.out.printf(String.valueOf(n.data));
		//System.out.printf("]\n");
		Collections.reverse(li);
		System.out.println(li.toString());
	}
}