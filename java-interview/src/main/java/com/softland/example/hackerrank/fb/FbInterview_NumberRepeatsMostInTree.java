package com.softland.example.hackerrank.fb;

// Most frequently number in a Binary Tree

//        6
//     6    6
//   4  6    7
// 4        7 7
//
// output = 6  (apper 4 times)


/*
 * 
 * Reference:
 * https://www.geeksforgeeks.org/find-maximum-count-of-duplicate-nodes-in-a-binary-search-tree/
 * 
 * 
>> Find maximum count of duplicate nodes in a Binary Search Tree <<

Given a Binary Search Tree (BST) with duplicates, find the node (the most frequently occurred element) in the given BST. If the BST contains two or more such nodes, print any of them.

Note: We cannot use any extra space. (Assume that the implicit stack space incurred due to recursion does not count)

Assume a BST is defined as follows:


    The left subtree of a node contains only nodes with keys less than or equal to the node’s key.
    The right subtree of a node contains only nodes with keys greater than or equal to the node’s key.
    Both the left and right subtrees must also be binary search trees.

Examples:

Input :   Given BST is

                    6
                 /    \
                5       7
              /   \    /  \
             4     5  7    7
Output : 7 

Input :  Given BST is
 
                    10
                 /    \
                5       12
              /   \    /  \
             5     6  12    16
Output : 5 or 12 
We can print any of the two value 5 or 12.

Recommended: Please try your approach on {IDE} first, before moving on to the solution.

Approach:

To find the node, we need to find the Inorder Traversal of the BST because its Inorder Traversal will be in sorted order.

So, the idea is to do recursive Inorder traversal and keeping the track of the previous node. If the current node value is equal to the previous value we can increase the current count and if the current count becomes greater than the maximum count, replace the element.

Below is the implementation of the above approach:

 */

public class FbInterview_NumberRepeatsMostInTree {

	static class Node {
		int data;
		String name;
		Node left;
		Node right;

		public Node(int value) {
			this.data = value;
		}
		public Node(int value, String name) {
			this.data = value;
			this.name = name;
		}
	}
	
	static Node root;
	
//	static void insert(int value) {
//		if (root == null) {
//			root = new Node(value);
//		} else {
//			insert(new Node(value));
//		}
//	}
//	static void insert(Node node) {
//		if (root == null) {
//			root = node;
//			return;
//		}
//		
//		if (node.data <= root.data) {
//			if (root.left == null) root.left = node;
//			else insert(root.left);
//			
//		} else {
//			if (root.right == null) root.right = node;
//			else insert(root.right);
//		}
//		
//	}
	static void insert(int value) {
		if (root == null) {
			root = new Node(value);
			return;
		}

		Node n = root;
		while (n != null) {

			if (value < n.data) {
				if (n.left == null) {
					n.left = new Node(value, "Parent("+n.data+")-->left("+value+")"); 
					return;
				}
				n = n.left;
			} else {
				if (n.right == null) {
					n.right = new Node(value, "Parent("+n.data+")-->right("+value+")");
					return;
				}
				n = n.right;
			}
		}

	}
	
	
	static int node;
	static int maxCount = 0;
	static int curCount = 1;
	static Node previous;

	static void DFS(Node root) {
		if (root == null)  return;
		
		
		DFS(root.left);  // left node
		
		if (previous != null) {
			if (root.data == previous.data) {
				curCount++;
			} else {
				curCount = 1;
			}
		}
		
		
		if (curCount > maxCount) {
			maxCount = curCount;
			node = root.data;
		}

		previous = root;
		
		System.out.println(String.format("root=%s, previous=%s, nodeFound=%s, maxCount=%s, root.left=%s, root.right=%s", 
				root.data, previous!=null ? previous.data : null, node, maxCount, root.left!=null ? root.left.data : 0, root.right!=null ? root.right.data : 0));

		
		DFS(root.right); // right node
		
	}

	static int freqNumber(Node n) {
		DFS(n);
		return node;
	}

	public static void main(String[] args) {
		
//      6
//   6    6
// 4  6    7
//4       7 7
		insert(6);
		insert(6);
		insert(4);
		insert(4);
		insert(6);
		insert(6);
		insert(7);
		insert(7);
		insert(7);
		//insert(7);
		//insert(7);
		//DFS(root);
		int n = freqNumber(root);
		System.out.println(String.format("maxNode=%s, maxCounter=%s", node, maxCount));
		System.out.println("Most frequently number: " + n);

	}

}
