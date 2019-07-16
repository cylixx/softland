package com.softland.example.algorithmsAndDataStructures;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class MyGraphsTest2 {
	 
	//static Map<Integer, Node> graph = new HashMap<Integer, Node>();
	public static Map<Integer, Node> graph;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		graph = new HashMap<Integer, Node>();

		addEdge(1, 2);
		addEdge(1, 6);
		addEdge(1, 3);
		addEdge(1, 4);
		
		addEdge(2, 1);
		addEdge(2, 3);
		
		addEdge(3, 1);
		addEdge(3, 2);
		addEdge(3, 6);
		
		addEdge(4, 1);
		addEdge(4, 6);
		
		addEdge(5, 6);
		
		addEdge(6, 1);
		addEdge(6, 3);
		addEdge(6, 4);
		addEdge(6, 5);
		addEdge(6, 8);
		
		addEdge(7, 8);
		
		addEdge(8, 6);
		addEdge(8, 7);
		
		System.out.println("Input: " + graph.toString());
		
		System.out.println("It has path graph BFS? " + hashPathBFS(1, 8));
	}

	public static class Node {
		private int id;
		//List<Node> adjacent = new LinkedList<Node>();
		List<Node> adjacent;
		
		public Node(int id) {
			this.id=id;
		}
		public List<Node> getAdjacent() {
			if(this.adjacent == null)  adjacent = new LinkedList<Node>();
			return this.adjacent;
		}

		@Override
		public String toString() {
			//return String.format("Node [id=%s, adjacent=%s]", id, adjacent);
			return String.format("%s=%s ", id, adjacent);
//			return String.format("%s ", adjacent);
		}
	}
	
	static public Node getNode(int id) {
		return graph.get(id);
	}
	
	static private void addEdge(int source, int destination) {
		Node s = getNode(source);
		if (s == null) s = new Node(source); 
			
		Node d = getNode(destination);
		if (d == null) d = new Node(destination);
		
		//s.adjacent.add(d);
		s.getAdjacent().add(d);
		graph.put(source, s);
	}
	
	static public boolean hashPathBFS(int source, int destination) {
		//return PathBFS(getNode(source), getNode(destination));
		return PathBFS(graph.get(source), graph.get(destination));
	}
	
	static private boolean PathBFS(Node source, Node destination) {
		//List<Node> nextToVisit = new LinkedList<Node>();  //QUEUE
		Queue<Node> nextToVisit = new LinkedList<Node>();  //FIFO
		Set<Integer> visited = new HashSet<Integer>();
		
		nextToVisit.add(source);
		while(!nextToVisit.isEmpty()) {
			Node node = nextToVisit.remove();
			System.out.println(node.id + "  Adjacent=" + node.getAdjacent().toString());
			//if(node.id == destination.id) {
			if(node == destination) {
				return true;
			}
			
			if (visited.contains(node.id)) {
				continue;
			}
			visited.add(node.id);
			
			for (Node child : node.getAdjacent()) {
				nextToVisit.add(child);
			}
		}
		
		return false;
	}
	
	
}
