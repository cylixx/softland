package com.softland.example.crackingCodeInterview.LinkedLists;

/**
 * 
 * Delete Middle Node: Implement an algorithm to delete a node in the middle (i.e., any node but
the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
that node.
2.3
EXAMPLE
lnput:the node c from the linked list a->b->c->d->e->f
Result: nothing is returned, but the new linked list looks like a ->b->d- >e- >f
 *
 */
public class Q2_3_DeleteMiddleNode {

	public static void main(String[] args) {
		LinkedListNode list = new LinkedListNode(1);
		list.appendToTail(2);
		list.appendToTail(3);
		list.appendToTail(4);
		list.appendToTail(5);
		list.appendToTail(6);
		
		list.printList();
		System.out.println("//--------Delete node-------------");
		int data = 3;
		LinkedListNode n = list.getNode(data);
		//n.printList();
		boolean f = deleteNode(n);
		System.out.println("Node "+data+" deleted: "+f); 
		list.printList();
	}
	
	static boolean deleteNode(LinkedListNode n) {
		
		if(n== null || n.next == null ) {
			return false;  //failure
		}
		
		LinkedListNode next = n.next;
		n.data = next.data;
		n.next = next.next;
		return true;
	}

}
