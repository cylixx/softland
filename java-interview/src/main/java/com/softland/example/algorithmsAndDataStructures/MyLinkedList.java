package com.softland.example.algorithmsAndDataStructures;

public class MyLinkedList {

	public static void main(String[] args) {
		
		Node n =  new Node(2);
		n.appendToTail(3);
		n.appendToTail(12);
		n.appendToTail(10);
		
		System.out.println("Add Output: ");
		System.out.println(n.toString());
		
		System.out.println("Remove output: ");
		//n.delete(n, 2);
		//n.delete(n, 12);
//		n.delete(12);
//		n.delete(10);
		//n.delete(2);
		
		//Node n2 = n.delete(n, 2);
		//Node n2 = n.delete(n, 2).delete(n, 12);
		//n2.delete(n, 12);
		n.delete(n, 2);
		n.delete(n, 12);
		n.delete(n, 10);
		System.out.println(n.toString());
		
	}
	
	
	static class Node {
		Node next = null;
		int data;
		
		
		public Node(int d) {
			this.data = d;
		}
		
		void appendToTail(int d) {
			Node end = new Node(d);
			Node curr = this;
			while(curr.next != null) {
				curr = curr.next;
			}
			curr.next = end;
		}
		
		
		Node delete(Node head, int d) {
			Node n = head;
			
			if (n.data == d) {
				return n.next;   //moved head
			}
			
			while(n.next != null) {
				if(n.next.data == d) {
					n.next = n.next.next;
					return head;     //head didn't change
				}
				n = n.next;
			}
			return head;
		}
//		void delete(int d) {
//			Node n = this;
//			
//			if (n.data == d) {
//				n = n.next;   //moved head
//				return;
//			}
//			
//			while(n.next != null) {
//				if(n.next.data == d) {
//					n.next = n.next.next;
//					return;
//				}
//				n = n.next;
//			}
//		}
		

		@Override
		public String toString() {
			//return String.format("Node [next=%s, data=%s]", next, data);
			StringBuilder s = new StringBuilder();
			s.append("[");
			Node n = this;
			while(n.next != null) {
				s.append(n.data + ", ");
				n = n.next;
			}
			s.append(n.data + "]");
			return s.toString();
		}
		
	}

}
