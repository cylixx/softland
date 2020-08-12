package com.softland.example.crackingCodeInterview.LinkedLists;

public class LinkedListNode {
	LinkedListNode next = null;
	int data;
	
//	public LinkedListNode() {  //este no va, porque si no, agrega un 0 al inicio de la lista
//		super();
//	}
	
	public LinkedListNode(int d) {
		this.data = d;
	}

	void appendToTail(int d) {
		LinkedListNode n = this;
		LinkedListNode end = new LinkedListNode(d);
		
		while(n.next != null) {
			n = n.next;
		}
		n.next = end;
	}

	LinkedListNode deleteNode(LinkedListNode head, int d) {
		LinkedListNode n = head;
		
		if (n.data == d) {
			return  head.next;  // moved head
		}
		
		while(n.next != null) {
			if(n.next.data == d) {
				n.next = n.next.next;
				return head; /// head didn't change
			}
			n = n.next;
		}
		return head;
	}
	
	LinkedListNode getNode(int data) {
		LinkedListNode n = this;
		
		if (n.data == data) return n;
		
		while(n.next != null) {
			if (n.data == data) {
				return n;
			}
			n = n.next;
		}
		
		return null;
	}
	
	
	LinkedListNode getTail() {
		LinkedListNode n = this;
		
		while(n != null) {
			if (n.next == null) return n;
			n = n.next;
		}
		return null;
	}
	
	//void printList(Node head) {
	//	Node n = head;
//	void printList() {
//		LinkedListNode n = this;
//		
//		if (n.next == null) {
//			System.out.println(n.data);
//			return;
//		}
//		
//		while(n.next != null) {
//			System.out.println(n.next.data);
//			n = n.next;
//		}
//	}
	void printList() {
		LinkedListNode n = this;
		
		System.out.print("[");
		while(n != null) {
			//System.out.print(String.format("%s  ", n.data));
			System.out.printf("%s  ", n.data);
			n = n.next;
		}
		System.out.print("] \n");
	}
	
	void printList(LinkedListNode node) {
		System.out.print("[");
		while(node != null) {
			//System.out.print(String.format("%s  ", node.data));
			System.out.printf("%s  ", node.data);
		    node = node.next;
		}
		System.out.print("] \n");
	}
	
}
