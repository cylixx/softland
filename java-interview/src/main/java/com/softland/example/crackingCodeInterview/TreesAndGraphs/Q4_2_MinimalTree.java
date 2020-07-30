/*
 * 4.2
	Minimal Tree:  (It will convert array to binary tree search)
	Given a sorted (increasing order) array with unique integer elements, write an algorithm 
	to create a binary search tree with minimal height.
	Hints: #79, #73, #7 76
 */
package com.softland.example.crackingCodeInterview.TreesAndGraphs;

public class Q4_2_MinimalTree {

	public static void main(String[] args) {
		int arr[] =  new int[]{1, 2, 3, 4, 5, 6, 7, 8};
		
		Q4_2_MinimalTree tree = new Q4_2_MinimalTree();
		Node node = tree.createBST(arr, 0, arr.length-1);
		tree.inOrderTraversal(node);
		
	}
	
	public Node root;
	//public int arr[];
	
	private class Node {
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	/*
	 * It will convert array to binary tree search
	 */
	public Node createBST(int arr[], int start, int end) {
		if(end < start)  return null; 
		
		int middle = (start + end) / 2;
		Node node = new Node(arr[middle]);
		
		node.left = createBST(arr, start, middle-1);  
		
		node.right = createBST(arr, middle+1, end);
		
		//root = node;
		return node; 
	}
	
	/*
	 * will perform inorder traversal on binary search tree 
	 * In-Order Traversal - Left, Root, Right
	 * 
     * 		Binary Seach Tree	
	 * 				4					
	 *          2        6
	 *       1    3    5    7      
	 */
	public void inOrderTraversal(Node node) {
		//if (root == null) {
		if (node == null) {
			System.out.println("Tree is empty");
			return;
		} else {
		
			if (node.left != null) inOrderTraversal(node.left);
			
			System.out.printf(node.data + " ");
			
			if (node.right != null) inOrderTraversal(node.right);
		}
	}
	

}
