package com.softland.example.algorithmsAndDataStructures;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MyGraphsTest {

	public static void main(String[] args) {

		//Node[] arr = new Node[6];
		Node[] arr = {
			new Node(0, new int[] {1,4,5}),	
			new Node(1, new int[] {4,3}),
			new Node(2, new int[] {1}),
			new Node(3, new int[] {2,4}),
			new Node(4, new int[] {}),
			new Node(5, new int[] {}),
		};
		
		
//		Node node1 = new Node(0);
//		node1
		
		
		
		
	}

	static class Node {
		//public String name;
		//public Node[] children;

		public int data;
		public boolean visited;
		public List<Node> adjacent;
		
		public Node(int data) {
			this.data = data;
		}
		public Node(int data, int[] adj) {
			adjacent = new LinkedList<Node>();
			for(int n : adj) {
				adjacent.add(new Node(n));
			}
			this.data = data;
		}
		@Override
		public String toString() {
			return String.format("Node [data=%s, visited=%s, adjacent=%s]", data, visited, adjacent);
		}
		
//		public List<Node> getAdjacent() {
//			if (adjacent == null) {
//				adjacent = new LinkedList<Node>();
//			}
//			return adjacent;
//		}
		
	}

	void search(Node root) {
		if (root == null)
			return;
		visit(root);
		root.visited = true;
		for (Node n : root.adjacent) {
			if (n.visited == false) {
				search(n);
			}
		}
	}

	static void visit(Node n) {
		System.out.println(n.toString());
	}

}
