package com.softland.example.crackingCodeInterview.StacksAndQueues;

/*
 * One place where queues are often used is in breadth-first search or in implementing a cache.
 * 
 */
public class MyQueueTest {

	public static void main(String[] args) {
		MyQueue<Integer> queue = new MyQueue<Integer>();
		queue.add(3);
		queue.add(6);
		queue.add(1);
		queue.add(8);
		queue.add(4);
		queue.printQueue();
		System.out.println("Peek = " + queue.peek());
		System.out.println("Remove 2 times:");
		queue.remove();
		queue.remove();
		queue.printQueue();
		System.out.println("Added node 7");
		queue.add(7);
		queue.printQueue();
		System.out.println("Remove 1 times:");
		queue.remove();
		queue.printQueue();
		System.out.println("Peek = " + queue.peek());
		System.out.println("Is empty? " + queue.isEmpty());
	}

}
