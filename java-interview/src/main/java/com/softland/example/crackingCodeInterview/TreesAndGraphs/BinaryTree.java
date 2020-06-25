package com.softland.example.crackingCodeInterview.TreesAndGraphs;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Binary Search Tree
 * A binary search tree imposes the condition that, for each node, its left descendents are less than or
equal to the current node, which is less than the right descendents.
 * 
 * Complete Binary Trees
A complete binary tree is a binary tree in which every level of the tree is fully filled, except for perhaps the
last level. To the extent that the last level is filled, it is filled left to right.
 * 
 * Binary Tree Traversal
 * Prior to your interview, you should be comfortable implementing in-order, post-order, and pre-order
traversal. The most common of these is in-order traversal.
 * 
 * 
 * 
In-Order Traversal
In-order traversal means to "visit" (often, print) the left branch, then the current node, and finally, the right
branch.

void inOrderTraversal(TreeNode node) {
	if (node!= null) {
		inOrderTraversal(node.left);
		visit(node);
		inOrderTraversal(node.right);
	}
}


Pre-Order Traversal
Pre-order traversal visits the current node before its child nodes (hence the name "pre-order").

Post-Order Traversal
Post-order traversal visits the current node after its child nodes (hence the name "post-order").

Binary Heaps (Min-Heaps and Max-Heaps)
A min-heap is a complete binary tree (that is, totally filled other than the rightmost elements on the last
level) where each node is smaller than its children. The root, therefore, is the minimum element in the tree.
 * 
 * 
 */
public class BinaryTree {
	Node root;
	
	public void addNode(int key, String name) {
		
		if (root == null) root = new Node(key, name);
		else {
			Node node = root;
			Node parent;
			
			while(true) {
				parent = node;
				if(key < node.key) {
					node = node.left;
					if (node == null) {
						parent.left = new Node(key, name);
						return;
					}
				} else {
					node = node.right;
					if (node == null) {
						parent.right = new Node(key, name);
						return;
					}
				}
			} 
			
		}
	}
	
	//---------- DFS - Depth-First-Search --------------------------------
	
	// left, root, right
	public void inOrderTraverseTree(Node node) {
		if (node != null) {
			inOrderTraverseTree(node.left);
			System.out.println(node);
			inOrderTraverseTree(node.right);
		}
	}
	
	// root, left, right
	public void preOrderTraverseTree(Node node) {
		if (node != null) {
			System.out.println(node);
			preOrderTraverseTree(node.left);
			preOrderTraverseTree(node.right);
		}
	}
	
	// left, right, root
	public void postOrderTraverseTree(Node node) {
		if (node != null) {
			postOrderTraverseTree(node.left);
			postOrderTraverseTree(node.right);
			System.out.println(node);
		}
	}
	
	//---------- BFS (breadth-first search) --------------------------------
	/*
	 * BFS (breadth-first search)
	 * Pre-Order Traversal  - Root, Left, Right
	 */
	public void BFS_preOrderTraverseTree(Node node) {
		Queue<Node> q = new LinkedList<Node>(); 
		
		if (node != null) q.add(node);
		while(!q.isEmpty()) {
			node = q.remove();
			System.out.println(node);
			if (node.left != null) q.add(node.left);
			if (node.right != null) q.add(node.right);
		}
			
	}
	
	
	// find spesific node by key
	public Node findNode(int key) {
		Node node = root;
		
		if (node == null) return null;
		if (node.key == key) return node;
		
		while(node.key != key) {
			if (key < node.key) {
				node = node.left;
			} else {
				node = node.right;
			}
			
			if (node == null) return null;
		}
		
		return node;
	}
	
	
	public static void main(String[] args) {
		BinaryTree btree = new BinaryTree();
		btree.addNode(50, "Boss");
		btree.addNode(25, "Vice President");
		btree.addNode(15, "Office Manager");
		btree.addNode(30, "Secretary");
		btree.addNode(75, "Sales Manager");
		btree.addNode(80, "Salesman 1");
		
		System.out.println("-------------DFS - In Order traverse----------------");
		btree.inOrderTraverseTree(btree.root);
		
		System.out.println("-------------DFS -Pre Order traverse----------------");
		btree.preOrderTraverseTree(btree.root);
		
		System.out.println("-------------DFS -Post Order traverse----------------");
		btree.postOrderTraverseTree(btree.root);
		
		System.out.println("-------------BFS - Pre-Order Traversal----------------");
		btree.BFS_preOrderTraverseTree(btree.root);
		
		System.out.println("-------------Find node----------------");
		System.out.println("Find node 30: " + btree.findNode(50));
		
	}
	
}

class Node {
	int key;
	String name;
	
	Node left;
	Node right;
	
	Node(int key, String name) {
		this.key = key;
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("Node [key=%s, name=%s]", key, name);
	}
	
	
}