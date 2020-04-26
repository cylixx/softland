package com.softland.example.crackingCodeInterview.LinkedLists;

/*
 * 
 * Sum Lists: You have two numbers represented by a linked list, where each node contains a single
digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a
function that adds the two numbers and returns the sum as a linked list.
2.5
EXAMPLE
Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is,617 + 295.
Output: 2 -> 1 -> 9. That is, 912.
FOLLOW UP
Suppose the digits are stored in forward order. Repeat the above problem.
Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).That is,617 + 295.
Output: 9 -> 1 -> 2. That is, 912.


SOLUTION:
It's useful to remember in this problem how exactly addition works. Imagine the problem:
6 1 7
+ 2 9 5
First, we add 7 and 5 to get 12. The digit 2 becomes the last digit of the number, and 1 gets carried over to
the next step. Second, we add 1, 1, and 9 to get 11. The 1 becomes the second digit, and the other 1 gets
carried over the final step. Third and finally, we add 1, 6 and 2 to get 9. So, our value becomes 912.
We can mimic this process recursively by adding node by node, carrying over any "excess" data to the next
node. Let's walk through this for the below linked list:
7 -> 1 -> 6
5 -> 9 -> 2
+
We do the following:
1. We add 7 and 5 first, getting a result of 12. 2 becomes the first node in our linked list, and we "carry" the
1 to the next sum.
List: 2 -> ?
2. We then add 1 and 9, as well as the "carry;' getting a result of 11. 1 becomes the second element of our
linked list, and we carry the 1 to the next sum.
List: 2 -> 1 ->?
3. Finally, we add 6, 2 and our"carrY:'to get 9. This becomes the final element of our linked list.
List: 2 -> 1 -> 9.
The code below implements this algorithm.

 */
public class Q2_5_SumList {

	public static void main(String[] args) {
		LinkedListNode l1 = new LinkedListNode(7);
		l1.appendToTail(1);
		l1.appendToTail(6);
		l1.printList();
		System.out.println("List 2: ");
		LinkedListNode l2 = new LinkedListNode(5);
		l2.appendToTail(9);
		l2.appendToTail(2);
		l2.printList();
		
		System.out.println("//--------Sum List-------------");
		LinkedListNode r = addlists(l1, l2, 0);
		r.printList();
	}
	
	
	static LinkedListNode addlists(LinkedListNode l1, LinkedListNode l2, int carry) {
		if (l1 == null && l2 == null && carry == 0) {
			return null;
		}

		int value = carry;
		if (l1 != null) {
			value += l1.data;
		}
		if (l2 != null) {
			value += l2.data;
		}

		int data = value % 10; /* Second digit of number */
		LinkedListNode result = new LinkedListNode(data);
		
		/* Recurse */
		if (l1 != null || l2 != null) {
			LinkedListNode more = addlists(
					l1 == null ? null : l1.next, 
					l2 == null ? null : l2.next,
					value >= 10 ? 1 : 0
					);

			result.next = more;
		}
		return result;
	}
	

}
