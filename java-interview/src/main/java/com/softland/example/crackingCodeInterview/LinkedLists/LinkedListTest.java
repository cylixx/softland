package com.softland.example.crackingCodeInterview.LinkedLists;

public class LinkedListTest {

	public static void main(String[] args) {
		LinkedListNode list = new LinkedListNode(5);
		list.appendToTail(1);
		list.appendToTail(9);
		list.appendToTail(7);
		list.appendToTail(2);
		list.printList();
		
		System.out.println("//---------------------");
		//list.deleteNode(list, 9);
		//list.deleteNode(list, 2);
		LinkedListNode list2 = list.deleteNode(list, 5);
		list2.deleteNode(list, 2);
		list2.deleteNode(list, 9);
		list2.printList();
		

	}

}
