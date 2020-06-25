package com.softland.example.crackingCodeInterview.StacksAndQueues;

import java.util.ArrayList;
import java.util.EmptyStackException;

/*
 * 
 * 3.3
Stack of Plates:
Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
Therefore, in real life, we would likely start a new stack when the previous stack exceeds some
threshold. Implement a data structure SetOfStacks that mimics this. SetOfStacks should be
composed of several stacks and should create a new stack once the previous one exceeds capacity.
SetOfStacks. push() and SetOfStacks. pop() should behave identically to a single stack
(that is, pop () should return the same values as it would if there were just a single stack).

 */
public class Q3_3_StackOfPlates {

	public static void main(String[] args) {
		
		SetOfStacks ss = new SetOfStacks(5); // 5 indicate the size of each stack into the array
		ss.push(2);
		ss.push(4);
		ss.push(5);
		ss.push(10);
		ss.push(1);
		ss.push(65);
		ss.push(22);
		ss.push(9);
		ss.printStacks();
		System.out.println("----- Remove: -----");
		ss.pop();
		ss.printStacks();
		System.out.println("----- Remove: -----");
		ss.pop();
		ss.printStacks();
		System.out.println("----- Remove: -----");
		ss.pop();
		ss.printStacks();
		System.out.println("----- Remove: -----");
		ss.pop();
		ss.printStacks();
	}

}

class SetOfStacks extends StackArray{
	ArrayList<StackArray> stacks = new ArrayList<StackArray>(); 
	
	SetOfStacks(int sizeStack) {
		super(sizeStack);
	}
	
	// if the last stack is at capacity, we need to create a new stack.
	public void push(int v) {
		StackArray last = getlastStack();
		if (last!= null && !last.isFull()) { //add to last stack
			last.push(v);
		} else { //must create new stack
			StackArray stack = new StackArray(this.stackCapacity);
			stack.push(v);
			stacks.add(stack);
		}
	}
	
	// If the last stack is empty (after popping), then we should remove 
	// the stack from the list of stacks.
	public int pop() {
		StackArray last = getlastStack();
		if (last == null) throw new EmptyStackException();
		int v = last.pop();
		if(last.isEmpty()) stacks.remove(stacks.size() -1);
		return v;
	}
	
	StackArray getlastStack() {
		if (stacks == null || stacks.isEmpty()) return null;
		return stacks.get(stacks.size() - 1);
	}
		
	
	void printStacks() {
		int i = 1;
		for(StackArray s: stacks) {
			System.out.printf("Stack " + i + ": ");
			s.prinStack();
			System.out.println("");
			i++;
		}
	}
}


/*
 * Implementation of stack using an Array
 */
class StackArray {
	private int stack[];
	private int top = -1;
	protected int stackCapacity = 0;
	
	StackArray(int sizeStack) {
		stackCapacity = sizeStack;
		stack = new int[sizeStack];
	}
	
	public void push(int data) {
		top++;
		stack[top] = data;
	}
	
	public int pop() {
		int data = -1;
		
		if (top >= 0) {
			data = stack[top];
			stack[top] = 0;
			top--;
		} else {
			top = -1;
		}
		return data;
	}
	
	public int peek() {
		if (top <= 0) return 0;
		//return stack[top-1];
		return stack[top];
	}
	
	/* Return true if stack is full. */
	public boolean isFull() {
		return (top == stackCapacity-1);
	}
	
	public boolean isEmpty() {
		return top < 0;
	}
	
	public void prinStack() {
		if(top < 0) System.out.println("[]");
		int i = 0;
		System.out.printf("[");
		while(i < stackCapacity) {
			System.out.printf(String.format("%s, ", stack[i]));
			i++;
			//if(stack[i] > 0)  System.out.printf(", ");
		}
		System.out.printf("]");
	}
	
}

