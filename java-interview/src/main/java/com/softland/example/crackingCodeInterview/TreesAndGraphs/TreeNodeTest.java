package com.softland.example.crackingCodeInterview.TreesAndGraphs;

public class TreeNodeTest {

	public static void main(String[] args) {
		
		TreeNode tn = new TreeNode(50);
		tn.insertInOrder(25);
		tn.insertInOrder(15);
		tn.insertInOrder(30);
		tn.insertInOrder(75);
		tn.insertInOrder(80);
		tn.insertInOrder(5);

		System.out.println("-------------In Order traverse----------------");
		tn.inOrderTraverseTree(tn);
		
		System.out.println("Tree size: " + tn.size());
		System.out.println("Find node 75: " + tn.find(75).data);
	}

}
