package com.softland.example.crackingCodeInterview.LinkedLists;

/**
 * 
 * @author root
 * Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
 *
 */
public class Q2_2_ReturnKthToLast {

	public static void main(String[] args) {
		LinkedListNode list = new LinkedListNode(1);
		list.appendToTail(3);
		list.appendToTail(5);
		list.appendToTail(7);
		list.appendToTail(11);
		
		list.printList();
		System.out.println("//---------------------");
		//Node res = returnKthToLast(list, 5);
		//res.printList();
		printKthToLast(list, 3);
		LinkedListNode node = nthTolast(list, 3);
		node.printList();
	}
	

	// Mi solucion
	// regresa una LinkedList con los elementos del Kth al final
	// Nota: no regresa el primer elemento
//	static Node returnKthToLast(Node head, int kth) {
//		Node res = null;
//		Node n = head;
//		
//		if (n.data == kth) {
//			//res = head;
//			return head;
//		}
//		//if(n.next == null) return res;
//		
//		while(n.next != null) {
//			if (n.data == kth) {
//				res = n;
//				return res;
//			}
//			n = n.next;
//		}
//		
//		return null;
//	}
	
	/*
	 * Approach A: Don't Return the Element.
	 * One way to do this is to change the problem to simply printing the kth to last element. 
	 * Then, we can pass back the value of the counter simply through return values.
	 */
	static int printKthToLast(LinkedListNode head, int k) {
		if (head == null) {
			return 0;
		}
		int index = printKthToLast(head.next, k) + 1;
		if (index == k) {
			System.out.println(k + "th to last node is " + head.data);
		}
		return index;
	}
	
	/*
	 * Solution #3: Iterative
	 * We can use two pointers,
		pl and p2. We place them k nodes apart in the linked list by putting p2 at the beginning and moving pl
		k nodes into the list. Then, when we move them at the same pace, pl will hit the end of the linked list after
		LENGTH - k steps. At that point, p2 will be LENGTH - k nodes into the list, or k nodes from the end.
	 */
	static LinkedListNode nthTolast(LinkedListNode head, int k) {
		LinkedListNode p1 = head;
		LinkedListNode p2 = head;

		/* Move pl k nodes into the list. */
		for (int i = 0; i < k; i++) {
			if (p1 == null)   return null; // Out of bounds
			p1 = p1.next;
		}
		/*
		 * Move them at the same pace. When pl hits the end, p2 will be at the right
		 * element.
		 */
		while (p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;
	}

}
