package com.softland.example.crackingCodeInterview.LinkedLists;

/**
 * 
 * 2.8
Loop Detection: Given a circular linked list, implement an algorithm that returns the node at the
beginning of the loop.
DEFINITION
Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so
as to make a loop in the linked list.
EXAMPLE
Input: A - > B - > C - > D - > E - > C [the same C as earlier]
Output: C
 *
 *
 *SOLUCION:
 *An easy way to detect if a linked list has a loop is through the FastRunner / SlowRunner approach.
FastRunner moves two steps at a time, while SlowRunner moves one step. Much like two cars racing
around a track at different steps, they must eventually meet.
 *
 */
public class Q2_8_LoopDetection {

	public static void main(String[] args) {
		LinkedListNode l1 = new LinkedListNode(0);
		l1.appendToTail(1);
		l1.appendToTail(2);
		l1.appendToTail(3);
		l1.appendToTail(4);
		l1.appendToTail(5);
		l1.appendToTail(6);
		l1.appendToTail(7);
		l1.appendToTail(8);
		l1.appendToTail(9);
		l1.appendToTail(10);
		l1.appendToTail(11);
		l1.printList();
		
		l1.getTail().next = l1.getNode(4); // we force it to collide in node 4
		LinkedListNode res = FindBeginning(l1);
		//res.printList();
		System.out.println("Node of collision: " + res.data);
	}
	
	/*
	 * Our algorithm is derived directly from parts 1, 2 and 3.
1. Create two pointers, FastPointer and SlowPointer.
2. Move FastPointer at a rate of 2 steps and SlowPointer at a rate of 1 step.
3. When they collide, move SlowPointer to LinkedListHead. Keep FastPointer where it is.
4. Move SlowPointer and FastPointer at a rate of one step. Return the new collision point.

	 */
	static LinkedListNode FindBeginning(LinkedListNode head) {
		System.out.println("Head start in " + head.data);
		LinkedListNode slow = head;
		LinkedListNode fast = head;
		
		/* Find meeting point. This will be LOOP_SIZE - k steps into the linked list. */
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {// Collision
				System.out.println("Collision in " + slow.data + " node");
				break;
			}
		}
		
		/* Error check - no meeting point, and therefore no loop */
		if (fast == null || fast.next == null) {
			return null;
		}
		
		/*
		 * Move slow to Head. Keep fast at Meeting Point. Each are k steps from the Loop
		 * Start. If they move at the same pace, they must meet at Loop Start .
		 */
		System.out.println("Head is in " + head.data + " before to move slow to head");
		slow = head;
		System.out.println("slow=" + slow.data + ", fast=" + fast.data);
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
			System.out.println("slow=" + slow.data + ", fast=" + fast.data);
		}
		
		/* Both now point to the start of the loop. */
		return fast;
	}
	
}
