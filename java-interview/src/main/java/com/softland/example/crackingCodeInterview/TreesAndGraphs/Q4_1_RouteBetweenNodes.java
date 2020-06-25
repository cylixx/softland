package com.softland.example.crackingCodeInterview.TreesAndGraphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * 
 * 4.1
Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a
route between two nodes.
 * 
 * SOLUTION
--------------------- - ------
This problem can be solved by just simple graph traversal, such as depth-first search or breadth-first search.
We start with one of the two nodes and, during traversal, check if the other node is found. We should mark
any node found in the course of the algorithm as "already visited" to avoid cycles and repetition of the
nodes.

 * 
 * It may be worth discussing with your interviewer the tradeoffs between breadth-first search and depth-first
search for this and other problems. For example, depth-first search is a bit simpler to implement since it can
be done with simple recursion. Breadth-first search can also be useful to find the shortest path, whereas
depth-first search may traverse one adjacent node very deeply before ever going onto the immediate
neighbors.
 */
public class Q4_1_RouteBetweenNodes {
	public Map<Integer, Node> nodes = new HashMap<Integer, Node>();
	
	enum State { Unvisited, Visited, Visiting; }
	
	static class Node {
		public int data;
		public List<Node> adjacent = new LinkedList<Node>();
		public State state;
		
		public Node(int value) {
			this.data = value;
		}
	}
	
	public Node getEdge(int value) {
		//if (!nodes.containsKey(value) ) return null;
		//else 
			return nodes.get(value);
	}
	
	public void addEdge(int source, int destination) {
		Node s = getEdge(source);
		Node d = getEdge(destination);
		if (s == null) s = new Node(source);
		if (d == null) d = new Node(destination);
		s.adjacent.add(d);
		nodes.put(source, s);
	}
	
	public boolean hasPathDFS(int source, int destination) {
		Node s = getEdge(source);
		Node d = getEdge(destination);
		Set<Integer> visit = new HashSet<Integer>();
		return hasPathDFS(s, d, visit);
	}
	
	// DFS - xxx no estoy seguro
	public boolean hasPathDFS(Node source, Node destination, Set<Integer> visit) {
		//Set<Integer> visit = new HashSet<Integer>();
		if (source == null) return false;
		visit.add(source.data);
		
		for (Node n: source.adjacent) {
			if (n.data == destination.data) return true;
			else {
				hasPathDFS(n, destination, visit);
			}
		}
		
		return false;
	}
	// BFS
	public boolean search(int source, int destination) {
		Node s = getEdge(source);
		Node d = getEdge(destination);
		return search(s, d);
	}
	public boolean search(Node start, Node end) {
		if (start == null || end == null) return false;
		if (start.data == end.data) return true;
		Queue<Node> q = new LinkedList<Node>();
		
		nodes.forEach((k, v) -> {
			v.state = State.Unvisited;
		});
		
		start.state = State.Visited;
		q.add(start);
		Node u;
		while(!q.isEmpty()) {
			u = q.remove();
			if (u != null) {
				for (Node v: u.adjacent) {
					if (v.state == State.Unvisited) {
						if (v.data == end.data) {
							return true;
						} else {
							v.state = State.Visiting;
							q.add(v);
						}
					}
				}
				u.state = State.Visited;
			}
		}
		return false;
	}
	
	
	public void print() {
		nodes.forEach((k, v) -> {
			System.out.printf(String.format("%d: ", v.data));
			System.out.printf(String.format("%s \n", v.adjacent.stream().map(n -> {
				return n.data;
			}).collect(Collectors.toList())));
		});
	}

	public static void main(String[] args) {
		Q4_1_RouteBetweenNodes g = new Q4_1_RouteBetweenNodes();
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(4, 3);
		g.addEdge(3, 2);
		g.addEdge(4, 5);
		g.addEdge(5, 3);
		g.print(); 

		System.out.println("Has path (1, 4) ? " +  g.hasPathDFS(2, 5));
		System.out.println("Has path (1, 4) ? " +  g.search(2, 5));
	}

}
