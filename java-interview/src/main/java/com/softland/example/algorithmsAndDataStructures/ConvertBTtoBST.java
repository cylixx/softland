/*
 * Program to convert Binary Tree to Binary Search Tree.
 * 
 * Explanation

In this program, we need to convert given binary tree to a corresponding binary search tree. A tree is said to be the binary tree 
if each of the nodes has at most two children. Whereas, the binary search tree is the special case of the binary tree in which all 
the nodes to the left of root node should be less than root node and nodes to the right should be greater than root node.

This problem can be resolved by converting given binary tree to its corresponding array representation. Sort the array. Calculate 
the middle node from array elements as it will become the root node of the corresponding binary search tree.


Algorithm

    1. Define Node class which has three attributes namely: data left and right. Here, left represents the left child of the node and 
       right represents the right child of the node.
    2. When a node is created, data will pass to data attribute of the node and both left and right will be set to null.
    3. Define another class which has two attribute root and treeArray.
        a. Root represents the root node of the tree and initializes it to null.
        b. treeArray will store the array representation of the binary tree.
    4. convertBTBST() will convert binary tree to the corresponding binary search tree:
        a. It will convert the binary tree to corresponding array by calling convertBTtoArray().
        b. Sort the resultant array from step 1 in ascending order.
        c. Convert the array to the binary search tree by calling createBST().
    5. calculateSize() will count the number of nodes present in the tree.
    6. convertBTtoArray() will convert binary tree to its array representation by traversing the tree and adding elements to treeArray.
    7. createBST() will create a corresponding binary search tree by selecting a middle node of sorted treeArray as it the root node. 
       treeArray will be divided into two parts i.e [0, mid-1] and [mid+1, end]. Recursively find middle node from each array to create 
       left subtree and right subtree respectively.
    8. Inorder() will display the nodes of the tree in inorder fashion, i.e., left child followed by root node followed by the right child.


 * 
 * 
 */
package com.softland.example.algorithmsAndDataStructures;

import java.util.Arrays;

public class ConvertBTtoBST {
	
	public Node root;
	int treeArray[];
	int index = 0;
	
	
	public static class Node {
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	
	public ConvertBTtoBST() {
		root = null;
	}
	
	
	// It will convert a binary tree to binary search tree 
	public Node convertBTtoBST(Node node) {
		int treeSize = calculateSize(node);
		treeArray =  new int[treeSize];
		
		convertBTtoArray(node);  //Converts binary tree to array  
		System.out.println("Converts binary tree to array: " + Arrays.toString(treeArray));
		Arrays.sort(treeArray);
		System.out.println("Sorted array: " + Arrays.toString(treeArray));
		
		Node d = createBST(0, treeArray.length-1);  //Converts array to binary search tree 
		
		return d;
	}
	
	//It will calculate size of tree
	public int calculateSize(Node node) { 
		int size = 0;
		
		if(node == null) return 0;
		else  size = calculateSize(node.left) + calculateSize(node.right) + 1;
		return size;
	}
	
	//It will convert the given binary tree to its corresponding array representation  
	public void convertBTtoArray(Node node) {
		if(root == null) {
			System.out.println("Tree is empty");
			return;
		} else {
			if(node.left != null) convertBTtoArray(node.left);
			
			treeArray[index] = node.data; //Adds nodes of binary tree to treeArray
			index++;
			if (node.right != null) convertBTtoArray(node.right);
		}
	}
	
	//It will convert array to binary search tree
	public Node createBST(int start, int end) {
		if(start > end) return null;
		
		//Variable will store middle element of array and make it root of binary search tree  
		int mid = (start + end) / 2;
		Node node = new Node(treeArray[mid]);
		
		node.left = createBST(start, mid - 1); //Construct left subtree  
		
		node.right = createBST(mid + 1, end);  //Construct right subtree  
		
		return node;
	}
	

	//inorder() will perform inorder traversal on binary search tree  
	//In-Order Traversal - Left, Root, Right
	public void inorderTraversal(Node node) {
		if(root == null) {
			System.out.println("Tree is empty");
			return;
		} else {
			if (node.left != null)  inorderTraversal(node.left);
			
			System.out.println(node.data + " ");
			
			if(node.right != null) inorderTraversal(node.right);
		}
		
	}
	

	public static void main(String[] args) {
		/*
		 *             
		 *        Binary Tree
		 *             1
		 *         2	    3   
		 * 	     4   5    6    7  
		 * 
		 * 
		 * 		Binary Seach Tree	
		 * 				4					
		 *          2        6
		 *       1    3    5    7       
		 * 
		 * 
		 */
		ConvertBTtoBST bt = new ConvertBTtoBST();  
        //Add nodes to the binary tree  
        bt.root = new Node(1);  
        bt.root.left = new Node(2);  
        bt.root.right = new Node(3);  
        bt.root.left.left = new Node(4);  
        bt.root.left.right = new Node(5);  
        bt.root.right.left = new Node(6);  
        bt.root.right.right = new Node(7);  
          
        //Display given binary tree  
        System.out.println("Inorder representation of binary tree: ");  
        bt.inorderTraversal(bt.root);  
          
        //Converts binary tree to corresponding binary search tree  
        Node bst = bt.convertBTtoBST(bt.root);  
          
        //Display corresponding binary search tree  
        System.out.println("\nInorder representation of resulting binary search tree: ");  
        bt.inorderTraversal(bst);  
	}

}
