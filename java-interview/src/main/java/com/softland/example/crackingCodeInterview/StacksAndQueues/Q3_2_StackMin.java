package com.softland.example.crackingCodeInterview.StacksAndQueues;

/*
 * 
 * Stack Min: How would you design a stack which, in addition to push and pop, has a function min
3.2
which returns the minimum element? Push, pop and min should all operate in 0(1) time.

SOLUTION
One solution is to have just a single int value, minValue, that's a member of the Stack class. When
minValue is popped from the stack, we search through the stack to find the new minimum. Unfortunately,
this would break the constraint that push and pop operate in 0( 1) time.
To further understand this question, let's walk through it with a short example:
push(5); // stack is {5}, min is 5
push(6); // stack is {6, 5}, min is 5
push(3); // stack is {3, 6, 5}, min is 3
push(7); // stack is {7, 3, 6, 5}, min is 3
pop(); // pops 7. stack is {3, 6, 5}, min is 3
pop(); // pops 3. stack is {6, 5}. min is 5.
Observe how once the stack goes back to a prior state ( { 6, 5} ), the minimum also goes back to its prior
state (5). This leads us to our second solution.
If we kept track of the minimum at each state, we would be able to easily know the minimum. We can do
this by having each node record what the minimum beneath itself is. Then, to find the min, you just look at
what the top element thinks is the min.
When you push an element onto the stack, the element is given the current minimum. It sets its "local
min"to be the min.
 */
public class Q3_2_StackMin extends MyStack<Integer> {

	public static void main(String[] args) {
		StackWithMin2 s1 =  new StackWithMin2();
		s1.push(7);
		s1.push(5);
		s1.push(12);
		s1.push(4);
		s1.push(20);
		s1.push(36);
		s1.push(3);
		s1.printStack();
		System.out.println("Strack with min: ");
		s1.s2.printStack();
		System.out.println("Stack min =" + s1.min());
		System.out.println("Remove: ");
		s1.pop();
		s1.printStack();
		System.out.println("Strack with min: ");
		s1.s2.printStack();
		System.out.println("Stack min =" + s1.min());
		
	}

}

/*
 * we store just a few pieces of data: a second stack with one element
and the members within this stack.
 */
class StackWithMin2 extends MyStack<Integer> {
	MyStack<Integer> s2;

	public StackWithMin2() {
		s2 = new MyStack<Integer>();
	}

	public void push(int value) {
		if (value <= min()) {
			s2.push(value);
		}
		super.push(value);
	}

	public Integer pop() {
		int value = super.pop();
		if (value == min()) {
			s2.pop();
		}
		return value;
	}

	public int min() {
		if (s2.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return s2.peek();
		}
	}
}