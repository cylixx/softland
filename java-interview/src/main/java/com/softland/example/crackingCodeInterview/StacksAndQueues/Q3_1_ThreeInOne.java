package com.softland.example.crackingCodeInterview.StacksAndQueues;

import java.util.EmptyStackException;

/*
 * 3.1
Three in One: Describe how you could use a single array to implement three stacks.

SOLUTION
--------·······----
Like many problems, this one somewhat depends on how well we'd like to support these stacks. If we're
okay with simply allocating a fixed amount of space for each stack, we can do that. This may mean though
that one stack runs out of space, while the others are nearly empty.
Alternatively, we can be flexible in our space allocation, but this significantly increases the complexity of
the problem.

 */
public class Q3_1_ThreeInOne {

	public static void main(String[] args) {
		FixedMultiStack ms = new FixedMultiStack(5);
		try {
			ms.push(1, 3);
			ms.push(1, 7);
			ms.push(1, 5);
			
			//ms.push(3, 5);
			//ms.push(3, 1);
			//ms.push(3, 8);
			ms.push(3, 10);
			
		} catch (FullStackException e) {
			e.printStackTrace();
		}

	}

}

class FixedMultiStack {
	private int numberOfStacks = 3;
	private int stackCapacity;
	private int[] values;
	private int[] sizes;

	public FixedMultiStack(int stackSize) {
		stackCapacity = stackSize;
		values = new int[stackSize * numberOfStacks];
		sizes = new int[numberOfStacks];
	}

	/* Push value onto stack. */
	public void push(int stackNum, int value) throws FullStackException {
		/* Check that we have space for the next element */
		if (isFull(stackNum)) {
			throw new FullStackException();
		}
		/* Increment stack pointer and then update top value. */
		sizes[stackNum]++;
		values[indexOfTop(stackNum)] = value;
	}

	/* Pop item from top stack. */
	public int pop(int stackNum) {
		if (isEmpty(stackNum)) {
			throw new EmptyStackException();
		}
		int topIndex = indexOfTop(stackNum);
		int value = values[topIndex]; // Get top
		values[topIndex] = 0; // Clear
		sizes[stackNum]--; // Shrink
		return value;
	}

	/* Return top element. */
	public int peek(int stackNum) {
		if (isEmpty(stackNum)) {
			throw new EmptyStackException();
		}
		return values[indexOfTop(stackNum)];
	}

	/* Return if stack is empty. */
	public boolean isEmpty(int stackNum) {
		return sizes[stackNum] == 0;
	}

	/* Return if stack is full. */
	public boolean isFull(int stackNum) {
		return sizes[stackNum] == stackCapacity;
	}

	/* Returns index of the top of the stack. */
	private int indexOfTop(int stackNum) {
		int offset = stackNum * stackCapacity;
		int size = sizes[stackNum];
		return offset + size - 1;
	}

}
