package com.softland.example.crackingCodeInterview.LinkedLists;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

import com.softland.example.crackingCodeInterview.LinkedLists._ReverseLinkedList.SinglyLinkedListNode;

/*
 * 
 * Merge two sorted linked lists
 * 
 * You’re given the pointer to the head nodes of two sorted linked lists. The data in both lists will be sorted in ascending order. Change the next pointers to obtain a single, merged linked list which also has data in ascending order. Either head pointer given may be null meaning that the corresponding list is empty.

Input Format

You have to complete the SinglyLinkedListNode MergeLists(SinglyLinkedListNode headA, SinglyLinkedListNode headB) method which takes two arguments - the heads of the two sorted linked lists to merge. You should NOT read any input from stdin/console.

The input is handled by the code in the editor and the format is as follows:

The first line contains an integer

, denoting the number of test cases.
The format for each test case is as follows:

The first line contains an integer
, denoting the length of the first linked list.
The next lines contain an integer each, denoting the elements of the linked list.
The next line contains an integer , denoting the length of the second linked list.
The next

lines contain an integer each, denoting the elements of the second linked list.

Constraints

, where is the

    element of the list.

Output Format

Change the next pointer of individual nodes so that nodes from both lists are merged into a single list. Then return the head of this merged list. Do NOT print anything to stdout/console.

The output is handled by the editor and the format is as follows:

For each test case, print in a new line, the linked list after merging them separated by spaces.

Sample Input

1
3
1
2
3
2
3
4

Sample Output

1 2 3 3 4 

Explanation

The first linked list is: 1 -> 2 -> 3 -> NULL

The second linked list is: 3 -> 4 -> NULL

Hence, the merged linked list is: 1 -> 2 -> 3 -> 3 -> 4 -> NULL
 * 
 * -------------------------------
 * Reference:
 * https://www.programcreek.com/2012/12/leetcode-merge-two-sorted-lists-java/
 * 
 */
public class _MergeTwoSortedLinkedLists {

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

    // Complete the mergeLists function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    /*
     * SOLUTION:
     * The key to solve the problem is defining a fake head. Then compare the first elements from each list. 
     * Add the smaller one to the merged list. Finally, when one of them is empty, simply append it to the 
     * merged list, since it is already sorted.
     * 
     */
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        if (head1 == null) return head2;
        if (head2 == null) return head1;
       
        SinglyLinkedListNode head = new SinglyLinkedListNode(0);
        SinglyLinkedListNode h = head;
        SinglyLinkedListNode l1 = head1;
        SinglyLinkedListNode l2 = head2;

        while(l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                h.next = l1;
                l1 = l1.next;

            } else {
                h.next = l2;
                l2 = l2.next;
            } 
            h = h.next;
        }

        if (l1 != null) {
            h.next = l1;
        } 
        if (l2 != null) {
            h.next = l2;
        }

       return head.next;
    }
    
    
    static void print(SinglyLinkedListNode head) {
    	while(head != null) {
    		System.out.printf(String.format("%s ", head.data));
    		head = head.next;
    	}
    	System.out.println("");
    }
    
    public static void main(String[] args) throws IOException {
    	SinglyLinkedList sl1 = new SinglyLinkedList();
    	sl1.insertNode(1);
    	sl1.insertNode(2);
    	sl1.insertNode(3);
    	
    	SinglyLinkedList sl2 = new SinglyLinkedList();
    	sl2.insertNode(3);
    	sl2.insertNode(4);
    	
    	SinglyLinkedListNode llist3 = mergeLists(sl1.head, sl2.head);
    	
    	System.out.println("List 1: ");
    	print(sl1.head);
    	System.out.println("List 2: ");
    	print(sl2.head);
    	
    	System.out.println("Merge list: ");
    	print(llist3);
    	
    	
    }


//    private static final Scanner scanner = new Scanner(System.in);
//
//    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int tests = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int testsItr = 0; testsItr < tests; testsItr++) {
//            SinglyLinkedList llist1 = new SinglyLinkedList();
//
//            int llist1Count = scanner.nextInt();
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//            for (int i = 0; i < llist1Count; i++) {
//                int llist1Item = scanner.nextInt();
//                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//                llist1.insertNode(llist1Item);
//            }
//          
//          	SinglyLinkedList llist2 = new SinglyLinkedList();
//
//            int llist2Count = scanner.nextInt();
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//            for (int i = 0; i < llist2Count; i++) {
//                int llist2Item = scanner.nextInt();
//                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//                llist2.insertNode(llist2Item);
//            }
//
//            SinglyLinkedListNode llist3 = mergeLists(llist1.head, llist2.head);
//
//            printSinglyLinkedList(llist3, " ", bufferedWriter);
//            bufferedWriter.newLine();
//        }
//
//        bufferedWriter.close();
//
//        scanner.close();
//    }
}
