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
	
	
//	public static void main(String[] args) {
//		//List<String> list = Arrays.asList("HE", "BA", "RI", "HE", "OL", "BA" ); 
//		List<String> list = new LinkedList<String>(Arrays.asList("D", "A", "J", "D", "B", "A" ));
//		System.out.println("Data: " + list.toString());
//		
//		List<Character> res = removeDuplicates(list);
//		System.out.println("Remove duplicates: " + res.toString());
//	}
//	
//	static List<Character> removeDuplicates(List<String> list) {
//		//String[] arr = list.toArray(new String[0]); 
//		
//		int index = 0;
//		char[] data = new char[list.size()];
//		for(String s: list) {
//			data[index] = s.charAt(0);
//			index++;
//		}
//		
//		
//		int[] d = new int[256];
//		List<Character> res = new LinkedList<Character>();
//		
//		for(int i=0; i<data.length; i++) {
//			int c = data[i];
//			System.out.println("c="+c +", 256 % c =" + 256%c);
//			
//			
//			if (d[c] <= 0) {
//				d[c] = d[c] + 1;
//				res.add(data[i]);
//			} else {
//				
//			}
//		}
//		System.out.println("dictionary: " + Arrays.toString(d));
//		return res;
//	}
	
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
