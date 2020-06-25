package com.softland.example.crackingCodeInterview.LinkedLists;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class _ReverseLinkedList {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    // Complete the reverse function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    // Solution # 1 - Reverse using a Stack
    // Mi solution implementing a Stack to put the value of the list in reverse order
    // then remove the head of stack and point to the next head in the stack and so on.
    // 
    static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
        LinkedList<SinglyLinkedListNode> st = new LinkedList<SinglyLinkedListNode>();

        if (head == null) return null;
        SinglyLinkedListNode n = head;

        while(n != null) {
            st.push(n);
            n = n.next;
        }
        n = st.pop();
        head = n;
        while(!st.isEmpty()) {
            SinglyLinkedListNode r = st.pop();
            n.next = r;
            n = r;
        }
        n.next = null;
        return head;
    }
    
 // Solution # 2 - Reversing but without use any structure data, only variables
    static SinglyLinkedListNode reverse2(SinglyLinkedListNode head) {
    	
    	
    	return null;
    }
    

    static void print(SinglyLinkedListNode head) {
    	while(head != null) {
    		System.out.printf(String.format("%s ", head.data));
    		head = head.next;
    	}
    	System.out.println("");
    }
    
    public static void main(String[] args) throws IOException {
    	SinglyLinkedList list = new SinglyLinkedList();
    	list.insertNode(1);
    	list.insertNode(2);
    	list.insertNode(3);
    	list.insertNode(4);
    	list.insertNode(5);
    	System.out.println("List: ");
    	print(list.head);
    	
    	System.out.println("Reverse List: ");
    	SinglyLinkedListNode r = reverse(list.head);
    	print(r);
    	
    }
    
//    private static final Scanner scanner = new Scanner(System.in);

//    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int tests = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int testsItr = 0; testsItr < tests; testsItr++) {
//            SinglyLinkedList llist = new SinglyLinkedList();
//
//            int llistCount = scanner.nextInt();
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//            for (int i = 0; i < llistCount; i++) {
//                int llistItem = scanner.nextInt();
//                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//                llist.insertNode(llistItem);
//            }
//
//            SinglyLinkedListNode llist1 = reverse(llist.head);
//
//            printSinglyLinkedList(llist1, " ", bufferedWriter);
//            bufferedWriter.newLine();
//        }
//
//        bufferedWriter.close();
//
//        scanner.close();
//    }
}
