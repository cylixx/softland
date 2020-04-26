package com.softland.example.crackingCodeInterview.StacksAndQueues;

import java.util.Stack;
import java.util.stream.Collectors;

public class Q3_4_QueueViaStacks {

	public static void main(String[] args) {
		MyQueue2<Character> q = new MyQueue2<Character>();
		q.add('A');
		q.add('B');
		q.add('C');
		q.add('D');
		q.add('E');
		q.add('F');
		q.printStack();
		System.out.println("----------Remove:-----------");
		q.remove();
		q.printStack();
		System.out.println("----------Remove:-----------");
		q.remove();
		q.printStack();
	}

}

class MyQueue2<T> {

	Stack<T> stackNewest, stackOldest;

	public MyQueue2() {
		stackNewest = new Stack<T>();
		stackOldest = new Stack<T>();
	}

	public int size() {
		return stackNewest.size() + stackOldest.size();
	}

	public void add(T value) {
		/* Push onto stackNewest, which always has the newest elements on top */
		stackNewest.push(value);
	}

	/* Move elements from stackNewest into stackOldest. This is usually done so that
	* we can do operations on stackOldest. */
	private void shiftStacks() {
		if (stackOldest.isEmpty()) {
			while (!stackNewest.isEmpty()) {
				stackOldest.push(stackNewest.pop());
			}
		}
	}
	
	public T peek() {
		shiftStacks(); // Ensure stackOldest has the current elements
		return stackOldest.peek(); // retrieve the oldest item.
	}
	
	public T remove() {
		shiftStacks(); // Ensure stackOldest has the current elements
		return stackOldest.pop(); // pop the oldest item.
	}

	void printStack() {
		shiftStacks();
		//stackOldest.forEach(x ->  System.out.printf(x + ", ") );
		System.out.println(stackOldest.stream().collect(Collectors.toList())); 
	}
	
}
