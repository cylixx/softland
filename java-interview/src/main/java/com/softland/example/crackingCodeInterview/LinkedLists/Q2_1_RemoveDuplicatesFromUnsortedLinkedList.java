package com.softland.example.crackingCodeInterview.LinkedLists;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;


/*
 * 
 * 2.1
   Remove Dups! Write code to remove duplicates from an unsorted linked list.
   FOLLOW UP
   How would you solve this problem if a temporary buffer is not allowed?
 */
public class Q2_1_RemoveDuplicatesFromUnsortedLinkedList {
	
	
	public static void main(String[] args) {
		LinkedListNode list = new LinkedListNode(5);
		list.appendToTail(1);
		list.appendToTail(5);
		list.appendToTail(7);
		list.appendToTail(1);
		
		list.printList();
		System.out.println("//---------------------");
		deleteDups(list);
		//deleteDupsNoBuffer(list);
		list.printList();
	}
	
	// solution takes O(N) time, 
	// where N is the number of elements in the linked list.
	static void deleteDups(LinkedListNode n) {
		HashSet<Integer> set = new HashSet<Integer>(); //simple hash table to track duplicates
		LinkedListNode previous = null;
		
		while (n != null) {
			if (set.contains(n.data)) {
				previous.next = n.next;
			} else {
				set.add(n.data);
				previous = n;
			}
			n = n.next;
		}
	}
	
	// This code runs in O ( 1) space, but O ( N 2 ) time.
	// If we don't have a buffer, we can iterate with two pointers: 
	// current which iterates through the linked list,
	// and runner which checks all subsequent nodes for duplicates.
	static void deleteDupsNoBuffer(LinkedListNode head) {
		LinkedListNode current = head;
		while (current != null) {
			/* Remove all future nodes that have the same value */
			LinkedListNode runner = current;
			while (runner.next != null) {
				if (runner.next.data == current.data) {

					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		}

	}
	
}
