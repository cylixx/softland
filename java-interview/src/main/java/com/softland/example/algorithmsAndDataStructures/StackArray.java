package com.softland.example.algorithmsAndDataStructures;

public class StackArray {

	private int stack[] = new int[10];
	private int top = 0;
	
	public void push(int data) {
		stack[top] = data;
		top++;
	}
	
	public int pop() {
		top--;
		int data = stack[top];
		stack[top] = 0;
		return data;
	}
	
	public int peek() {
		if (top <= 0) return 0;
		return stack[top-1];
	}
	
	
	public void prinStack() {
		//for(int i=0; i<top; i++) {
		for(int i=0; i<stack.length; i++) {
			System.out.printf(stack[i] + " ");
		}
		System.out.println("");
	}
	
}
