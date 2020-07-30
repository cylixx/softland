package com.softland.example.crackingCodeInterview.TreesAndGraphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MyGraph {
	private Map<Integer, Node> nodeLookup = new HashMap<Integer, Node>();
	
	
	public static class  Node {
		private int id;
		List<Node> adjacent = new LinkedList<Node>();
		
		private Node(int id) {
			this.id = id;
		}

		@Override
		public String toString() {
			return String.format("Node [id=%s, adjacent=%s]", id, adjacent);
		}
		
	}
	
	private Node getNode(int source) {
		if (nodeLookup.containsKey(source)) return nodeLookup.get(source);
		return null;
	}
	
//	public void addNode(int id) {
//		  nodeLookup.put(id, new Node(id));
//	}
	
	public void addEdge(int source, int destination) {
		Node s = getNode(source);
		Node d = getNode(destination);
		if (s == null) s = new Node(source);
		if (d == null) d = new Node(destination);
		s.adjacent.add(d);
		nodeLookup.put(source, s);
	}
	
	public boolean hasPathDFS(int source, int destination) {
		Node s = getNode(source);
		Node d = getNode(destination);
		HashSet<Integer> visited = new HashSet<Integer>();
		return hasPathDFS(s, d, visited);
	}
	// tiene un error no funciona bien
	private boolean hasPathDFS(Node source, Node destination, HashSet<Integer> visited) {
		if(visited.contains(source.id)) {
			return false;
		}
		visited.add(source.id);
		if (source.id == destination.id) {
			return true;
		}
		for (Node child: source.adjacent) {
			if (hasPathDFS(child, destination, visited)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean hasPathBFS(int sourse, int destination) {
		return hasPathBFS(getNode(sourse), getNode(destination));
	}
	
	private boolean hasPathBFS(Node sourse, Node destination) {
		LinkedList<Node> nextToVisit = new LinkedList<Node>(); // define a QUEUE
		HashSet<Integer> visited = new HashSet<Integer>();
		nextToVisit.add(sourse);
		while(!nextToVisit.isEmpty()) {
			Node node = nextToVisit.remove();
			if (node ==  destination) {
				return true;
			}
			
			if (visited.contains(node.id)) {
				continue;
			}
			visited.add(node.id);
			for (Node child: node.adjacent) {
				nextToVisit.add(child);
			}
		}
		return false;
	}
	
	public void printGraph() {
		nodeLookup.forEach((k, v) -> {
			System.out.printf(String.format("Node[%s]: ", k) );
			//v.adjacent.forEach(x -> System.out.printf(String.format("%s, ", x.id) ));
			//System.out.println(""); 
			
			System.out.printf(String.format("%s",
			  v.adjacent.stream().map(x -> { return x.id; }).collect(Collectors.toList())
			));
			System.out.println(""); 
		});
	}

	public static void main(String[] args) {

		MyGraph graph = new MyGraph();
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 2);
		graph.addEdge(4, 3);
		System.out.println("--------- print graph--------");
		graph.printGraph();
		
		System.out.println("hasPathDFS (2, 3) ? " + graph.hasPathDFS(2, 3));
		System.out.println("hasPathBFS (1, 4) ? " + graph.hasPathBFS(1, 4));
		System.out.println("hasPathBFS (1, 3) ? " + graph.hasPathBFS(1, 3));
	}

}
