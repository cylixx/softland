package com.softland.example.crackingCodeInterview.LinkedLists;

import java.util.Stack;

/*
 * 2.6
Palindrome: Implement a function to check if a linked list is a palindrome

Solution #1: Reverse and Compare
Our first solution is to reverse the linked list and compare the reversed list to the original list. If they're the
same, the lists are identical.
Note that when we compare the linked list to the reversed list, we only actually need to compare the first
half of the list. If the first half of the normal list matches the first half of the reversed list, then the second half
of the normal list must match the second half of the reversed list.
 * 
 */
public class Q2_6_Palindrome {

	public static void main(String[] args) {
		LinkedListNode l1 = new LinkedListNode(1);
		l1.appendToTail(2);
		l1.appendToTail(3);
		l1.appendToTail(2);
		l1.appendToTail(1);
		l1.printList();

		System.out.println("//--------Palindrome?-------------");
		System.out.println("Solution #1: Reverse and Compare - Palindrome?  " + isPalindrome(l1));
		System.out.println("Solution #2: Runner Technique - Palindrome?  " + isPalindrome_RunnerTechnique(l1));
		System.out.println("//--------Solution #3: Recursive-------------");
		System.out.println("Solution #3: " + isPalindrome3(l1));
		
	}

	/*
	 * Solution #1: Reverse and Compare Our first solution is to reverse the linked
	 * list and compare the reversed list to the original list. If they're the same,
	 * the lists are identical. Note that when we compare the linked list to the
	 * reversed list, we only actually need to compare the first half of the list.
	 * If the first half of the normal list matches the first half of the reversed
	 * list, then the second half of the normal list must match the second half of
	 * the reversed list.
	 * 
	 */
	static boolean isPalindrome(LinkedListNode head) {
		LinkedListNode reversed = reverseAndClone(head);
		System.out.println("reversed: ");
		reversed.printList(reversed);
		return isEqual(head, reversed);
	}

	static LinkedListNode reverseAndClone(LinkedListNode node) {
		LinkedListNode head = null;

		while (node != null) {
			LinkedListNode n = new LinkedListNode(node.data); // clone
			n.next = head;
			head = n;
			node = node.next;
		}
		return head;
	}

	static boolean isEqual(LinkedListNode one, LinkedListNode two) {
		while (one != null && two != null) {
			if (one.data != two.data) {
				return false;
			}
			one = one.next;
			two = two.next;
		}
		return one == null && two == null;
	}

	// ----------------- SOLUTION #2 - Iterative Approach (FastRunner / SlowRunner)
	// -------------------------------------
	/*
	 * R E C O M M E N D E D Solution #2: Iterative Approach (Runner Technique or
	 * FastRunner / SlowRunner Technique)
	 * 
	 * If we don't know the size of the linked list, we can iterate through the
	 * linked list, using the fast runner/ slow runner technique described in the
	 * beginning of the chapter. At each step in the loop, we push the data from the
	 * slow runner onto a stack. When the fast runner hits the end of the list, the
	 * slow runner will have reached the middle of the linked list. By this point,
	 * the stack will have all the elements from the front of the linked list, but
	 * in reverse order.
	 * 
	 * Now, we simply iterate through the rest of the linked list. At each
	 * iteration, we compare the node to the top of the stack. If we complete the
	 * iteration without finding a difference, then the linked list is a palindrome.
	 */
	static boolean isPalindrome_RunnerTechnique(LinkedListNode head) {
		LinkedListNode fast = head;
		LinkedListNode slow = head;
		Stack<Integer> stack = new Stack<Integer>();

		/*
		 * Push elements from first half of linked list onto stack. When fast runner
		 * (which is moving at 2x speed) reaches the end of the linked list, then we
		 * know we're at the middle
		 */
		while (fast != null && fast.next != null) {
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}

		/* Has odd number of elements, so skip the middle element */
		if (fast != null) {
			slow = slow.next;
		}

		while (slow != null) {
			int top = stack.pop().intValue();

			/* If values are different, then it's not a palindrome */
			if (top != slow.data) {
				return false;
			}
			slow = slow.next;
		}
		return true;
	}

	
	// ----------------- SOLUTION #3 - -------------------------------------
	

	static boolean isPalindrome3(LinkedListNode head) {
		int length = lengthOfList(head);
		Result p = isPalindromeRecurse(head, length);
		return p.result;
	}

	static Result isPalindromeRecurse(LinkedListNode head, int length) {
		System.out.println("lengthOfList = " + length);
		head.printList();
		
		if (head == null || length <= 0) { // Even number of nodes
			return new Result(head, true);
		
		} else if (length == 1) { // Odd number of nodes
			return new Result(head.next, true);
		}

		// * Recurse on sublist.
		Result res = isPalindromeRecurse(head.next, length - 2);

		/*
		 * If child calls are not a palindrome, pass back up a failure.
		 */
		if (!res.result || res.node == null) {
			return res;
		}

		/*
		 * Check if matches corresponding node on other side. 
		 */
		res.result = (head.data == res.node.data);
		
		//  Return corresponding node.
		res.node = res.node.next;
		
		return res;
	}
	
	static int lengthOfList(LinkedListNode n) {
		int size = 0;
		while (n != null) {
			size++;
			n = n.next;
		}
		return size;
	}

}

class Result {
	public Result(LinkedListNode head, boolean b) {
	}
	public LinkedListNode node;
	public boolean result;
}
