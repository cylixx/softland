/*
 * Dado el arbol binario lo recorre de dos formas DFS y BFS
 * 
 * Input:
 * 
 *              A
 *           /    \
 *          B      E
 *         / \    / \
 *        C   D  F   G    
 *                    \
 *                    H
 *                    
 * Binary Tree Traversal
 * 	  In-Order Traversal   - Left, Root, Right                
 *    Pre-Order Traversal  - Root, Left, Right    
 *    Post-Order Traversal - Left, Right, Root
 * 
 * 
 * Hay dos formas de recorrer un Tree:
 * 	 BFS - Breadth-first search
 * 	 DFS - Depth-First-Search
 * 
 * 
 * Ejemplo de problemas:
 * 
 * 4.3 
 * List of Depths: Given a binary tree, design an algorithm which creates a linked list of all the nodes
   at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
 * 
 * 
 */
package com.softland.example.algorithmsAndDataStructures;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SeachInTree {

	public static void main(String[] args) {
		Node tree = initTree();

		System.out.println("BFS (breadth-first search) - Pre-Order Traversal  - Root, Left, Right");
		BFS_pre_order_traversal(tree);
		
		System.out.println("DFS traversal");
		DFS_traversal(tree);
		
		System.out.println("Tree to list: " + BFS_TreeToList(tree).toString());
		
		System.out.println("Is balanced? " + isBalanced(tree));
		
		System.out.println("is a binary search tree (BST) ? " + checkBST(tree));
	}
	
	private static class Node {
		Node left;
		Node right;
		String data;
		
		public Node(String data) {
			this.data = data;
		}

		public Node(String data, Node left, Node right) {
			super();
			this.left = left;
			this.right = right;
			this.data = data;
		}
	}
	
	private static Node initTree() {
		Node root = new Node("A",
				new Node("B", new Node("C"), new Node("D")),
				new Node("E", new Node("F"), new Node("G", new Node("H"), null)) );
				//new Node("E", new Node("F"), new Node("G", null, new Node("H", null, new Node("I")))) );
		return root;
	}
	
	/*
	 * BFS (breadth-first search)
	 * Pre-Order Traversal  - Root, Left, Right
	 */
	static void BFS_pre_order_traversal(Node node) {
		Queue<Node> q = new LinkedList<Node>();  //FIFO
		
		if(node != null)  q.add(node);
		while(!q.isEmpty()) {
			node = q.remove();
			System.out.println(node.data + " ");
			
			if (node.left != null)  q.add(node.left);
			
			if (node.right != null) q.add(node.right);
		}
	}
	
	/*
	 * DFS - Depth-First-Search
	 * preOrderTraverseTree = Root, left, right
	 */
	static void DFS_traversal(Node node) {
		if (node == null) return;
		
		System.out.println(node.data + " ");
		DFS_traversal(node.left);
		DFS_traversal(node.right);
	}
	
	//-----------------------------------OTHERS functions--------------------------------------------------------------
	/*
	 *XXX Esta mal porque debe ser una lista por cada nivel del arbol
	 * 4.3
	 * List of Depths: Given a binary tree, design an algorithm which creates a linked list of all the nodes
	   at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
	 */
	// Convierte tree in a LinkedList
	static List<String> BFS_TreeToList(Node node) {
		List<String> list = new LinkedList<String>();
		Queue<Node> q = new LinkedList<Node>();  //FIFO
		
		q.add(node);
		while(!q.isEmpty()) {
			node = q.remove();
			
			list.add(node.data);
			//System.out.println(node.data + " ");
			
			if (node.left != null)  q.add(node.left);
			
			if (node.right != null) q.add(node.right);
		}
		
		return list;
	}
	
	/*
	 * ------------------------------------------------------
	 * 4.4
	 * Check Balanced: Implement a function to check if a binary tree is balanced. For the purposes of
	   this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any
	   node never differ by more than one.
	 * 
	 * 
	 * This code runs in O(N) time and O(H) space, where H is the height of the tree.
	 * 
	 */
	static int checkHeight(Node root) {
		if (root == null) return -1;
		
		int leftHeight = checkHeight(root.left);
		if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; // Pass error up

		int rightHeight = checkHeight(root.right);
		if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; // Pass error up
		
		int heightDiff = leftHeight - rightHeight;
		if (Math.abs(heightDiff) > 1) {
			return Integer.MIN_VALUE; // Found error -> pass it back
		} else {
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}
	static boolean isBalanced(Node root) {
		return checkHeight(root) != Integer.MIN_VALUE;
	}
	
	
	/*
	 * --------------------------------------------------------------
	 * 4.5
	   Validate BST: Implement a function to check if a binary tree is a binary search tree.
	 * 
	 */
	
	static Integer last_printed = null;

	static boolean checkBST(Node n) {
		if (n == null) return true;

		// Check I recurse left
		if (!checkBST(n.left)) return false;

		// Check current
		//if (last_printed != null && n.data <= last_printed) {
		char c = n.data.charAt(0);  //solo si son cadenas
		int intData = Character.getNumericValue(c);   //solo si son cadenas
		
		if (last_printed != null && intData <= last_printed) {
			return false;
		}
		//last_printed = n.data;
		last_printed = Character.getNumericValue(n.data.charAt(0));

		// Check / recurse right
		if (!checkBST(n.right)) return false;
		return true;// All good!
	}
	
	
	

}
