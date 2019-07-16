package com.softland.example.algorithmsAndDataStructures;

import java.util.EmptyStackException;

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

	public T pop() {
		if (top == null) throw new EmptyStackException();
		T item = top.getData();
		top = top.next;
		return item;
	}

	public void push(T item) { 
		StackNode<T> t = new StackNode<T>(item);
		t.next = top;
		top = t;
	} 

	public T peek() {
		if (top == null) throw new EmptyStackException();
		return top.data;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
	
	public void printStack() {
		StackNode<T> n = top;
		System.out.printf("\n[");
		while(n.next != null) {
			System.out.printf(n.data + ", ");
			n = n.next;
		}
		System.out.printf(String.valueOf(n.data));
		System.out.printf("]");
	}
}