package com.softland.example.crackingCodeInterview.TreesAndGraphs;

/*
 * Implement a Binary Search Tree (Recursive way)
 * - insert in order
 * - Print nodes - DFS in order Traversal
 * - contains value (in order traverse)
 */
public class MyTree {
	int data;
	MyTree left, right;
	
	MyTree(int data) {
		this.data = data;
	}
	
	public void insert(int value) {
		
		if(value <= data) {
			if (left == null) left = new MyTree(value);
			else {
				left.insert(value);
			}
		} else {
			if (right == null) right = new MyTree(value);
			else {
				right.insert(value);
			}
		}
		
	}
	
	public void printInOrderTraversal() {
		
		if (left != null)	left.printInOrderTraversal();
		System.out.println(data);
		if (right != null)	right.printInOrderTraversal();
	}
	
	public boolean contains(int value) {
		if (value == data) return true;
		else if (value < data) {
			if (left == null) return false;
			else {
				return left.contains(value);
			}
		} else {
			if (right == null) return false;
			else {
				return right.contains(value);
			}
		}
	}
	
	
	public static void main(String[] args) {
		MyTree t = new  MyTree(5);
		t.insert(8);
		t.insert(20);
		t.insert(10);
		t.insert(15);
		t.insert(1);
		
		t.printInOrderTraversal();
		
		System.out.println("Contains 10? " + t.contains(10));
		
	}

}
