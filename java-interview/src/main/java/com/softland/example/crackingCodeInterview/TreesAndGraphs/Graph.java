package com.softland.example.crackingCodeInterview.TreesAndGraphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class Graph {

	private int VERTICES;
	private LinkedList<Integer>[] adj;
	
	Graph(int v) {
		VERTICES = v;
		adj = new LinkedList[v]; 
		for (int i=0; i<v; i++)  //init adjacent list
			adj[i] = new LinkedList<Integer>();
	}
	
	void addEdge(int s, int d) {
		adj[s].add(d);
	}
	
	void printGraph() {
		for(int i=0; i<VERTICES; i++) {
			System.out.println(String.format("%s : %s", i, adj[i]));
		}
	}
	
	/*
	 * -----------------------------------------------------------------
	 * 1. Find if there is a path between two vertices in a directed graph
	 * Given a Directed Graph and two vertices in it, check whether there is a path 
	 * from the first given vertex to second. For example, in the following graph, 
	 * there is a path from vertex 1 to 3. As another example, there is no path from 3 to 0.
	 * 
	 * SOLUTION:
	 * We can either use Breadth First Search (BFS) or Depth First Search (DFS) to find path 
	 * between two vertices. Take the first vertex as source in BFS (or DFS), follow the 
	 * standard BFS (or DFS). If we see the second vertex in our traversal, then return true. 
	 * Else return false.
	 * 
	 */
	
	// BFS traversal from a given source s
	// Time Complexity: O(V+E) where V is number of vertices in the graph and E is number of 
	// edges in the graph.
	boolean hasPath(int s, int d) {
		boolean[] visited = new boolean[VERTICES];
		Queue<Integer> q = new LinkedList<Integer>();
		LinkedList<Integer> child;
		
		if(s == d) return true;
		
		int n = s;
		visited[n] = true; // mark the current node as visited
		q.add(n);   // add current to queue
		
		while(!q.isEmpty()) {
			n = q.remove();  
			child = adj[n];  // get the adjacent nodes
			
			for(int c: child) {
				if (c == d) return true; //if child is the destination node
				if (c == s) return false; // source is the same that child (is a loop)
				
				// if the adjacent node is not visited yet, 
				// then set as visited and add to queue
				if (!visited[c]) { 
					visited[c] = true;
					q.add(c);
				}
			}
		}
		return false;
	}
	
	
	/*
	 * ----------------------------------------------------------------------
	 * 
	 * 
	 * 
	 */
	public void printAllPaths(int s, int d) {
		boolean[] visited = new boolean[VERTICES];
		LinkedList<Integer> path = new LinkedList<>();
		path.add(s); // add source to path
		printAllPaths(s, d, visited, path);
	}
	private void printAllPaths(int s, int d, boolean[] visited, LinkedList<Integer> path) {
		visited[s] = true;
		
		//System.out.println("---- path: " + path + ", visited: " + Arrays.asList(visited).stream().map(x -> {return String.valueOf(x);}).collect(Collectors.toList()));
		System.out.printf("\n---- path: " + path + ", visited: ");
		for (boolean v: visited) {
			System.out.printf(String.format("%s, ", v));
		}
		
		if (s == d) {
			System.out.println(path);
			visited[s] = false;
			return;
		}
		
		for (int i: adj[s]) {
			if (!visited[i]) {
				path.add(i);
				printAllPaths(i, d, visited, path);
				
				path.remove(i);
				//path.remove();
			}
		}
		visited[s] = false;
	}
	
	
	public static void main(String[] args) {
		Graph g = new Graph(4); 
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
  
        int s = 1; 
        int d = 3; 
        System.out.println(String.format("There is path from %s to %s ?  %s", s, d, g.hasPath(s, d)));
        
        s = 3; 
        d = 1;
        System.out.println(String.format("There is path from %s to %s ?  %s", s, d, g.hasPath(s, d)));
        
        //-------------------------------------
        // Create a sample graph 
        Graph g2 = new Graph(4); 
        g2.addEdge(0,1); 
        g2.addEdge(0,2); 
        g2.addEdge(0,3); 
        g2.addEdge(2,0); 
        g2.addEdge(2,1); 
        g2.addEdge(1,3); 
        g2.printGraph();
        
        int s2 = 2;  // arbitrary source 
        int d2 = 3;  // arbitrary destination 
      
        System.out.println("All different paths from "+s2+" to "+d2); 
        g2.printAllPaths(s2, d2); 
        
	}

}
