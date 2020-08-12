package com.softland.example.hackerrank.fb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
20200810 - Karat Interview 

Suppose we have some input data describing a graph of relationships between parents and children 
over multiple generations. The data is formatted as a list of (parent, child) pairs, where each 
individual is assigned a unique integer identifier.

For example, in this diagram, 3 is a child of 1 and 2, and 5 is a child of 4:

1   2    4
 \ /   / | \
  3   5  8  9
   \ / \     \
    6   7    11


Sample input/output (pseudodata):

parentChildPairs = [
    (1, 3), (2, 3), (3, 6), (5, 6),
    (5, 7), (4, 5), (4, 8), (4, 9), (9, 11)
]


Write a function that takes this data as input and returns two collections: 
one containing all individuals with zero known parents, and one containing 
all individuals with exactly one known parent.


Output may be in any order:

findNodesWithZeroAndOneParents(parentChildPairs) => [
  [1, 2, 4],       // Individuals with zero parents
  [5, 7, 8, 9, 11] // Individuals with exactly one parent
]

n: number of pairs in the input

//-------------------------------
My Aproch
1: 3
2: 3
3: 6
4: 5, 8, 9
5: 6, 7
6
7
8
9: 11
11

*/
public class _Karat_graphRelationshipParentChildren {

	public static void main(String[] args) {

		int[][] parentChildPairs = new int[][] {
	        {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7},
	        {4, 5}, {4, 8}, {4, 9}, {9, 11}
	      };
	    
	     for (int i=0; i < parentChildPairs.length; i++) {
	    	 addEdge(parentChildPairs[i][0], parentChildPairs[i][1]);
		 }
	      //System.out.println(graph.toString());
	      printGraph();
	      
	      List<List<Integer>> res = findNodesWithZeroAndOneParents(parentChildPairs);
	      //System.out.println(graph.toString());
	      
	      System.out.println("//---------------[SOLUTION 1]----------------------------");
	      List<List<Integer>> res2 = findNodesWithZeroAndOneParents2(parentChildPairs);
	      System.out.println(res2.toString());
	}
	
	/*
	 * 20200811
	 * Solucion:
	 * Debemos contar los papas que tiene cada nodo, entonces usamos un mapa para almacenar como llave al hijo
	 * y contamos los papas y los ponemos como valor.
	 */
	static List<List<Integer>> findNodesWithZeroAndOneParents2(int[][] pc) {
		Map<Integer, Integer> mapChild = new HashMap<Integer, Integer>();
		List<List<Integer>> res =  new ArrayList<List<Integer>>();
		
		for (int i = 0; i < pc.length; i++) {
			mapChild.putIfAbsent(pc[i][0], 0); // si el nodo no existe creamos uno con valor 0
			mapChild.put(pc[i][1], mapChild.getOrDefault(pc[i][1], 0) + 1); // agregamos el nodo y le sumamos 1
		}
		System.out.println(mapChild.toString());
		
		List<Integer> zero = new ArrayList<>();
		List<Integer> one = new ArrayList<>();
		for(Map.Entry<Integer, Integer> child: mapChild.entrySet()) {
			if (child.getValue() == 0)
				zero.add(child.getKey()); 
			else if (child.getValue() == 1)
				one.add(child.getKey());
		}
		res.add(zero);
		res.add(one);
		
		return res;
	}
	
	//----------------------------------------------------------
	// SOLUTION #2 - Esta mal (Revisar)
	// crequ que esta aproximacion esta mal por que no queremos obtener el patn entre dos nodos
	// o la suma o algo por el estilo, solo queremos recorrer todos los nodos y contar sus papas.
	
	public static Map<Integer, Node> graph = new HashMap<>();
	
//	static List<List<Integer>> findNodesWithZeroAndOneParents(int[][] parentChildPairs) {
//		for (int i=0; i < parentChildPairs.length; i++) {
//			addEdge(parentChildPairs[i][0], parentChildPairs[i][1]);
//		}
//		findNodesWithZeroAndOneParents2(null);
//		
//		return null;
//	}
	
	static List<List<Integer>> findNodesWithZeroAndOneParents(int[][] parentChildPairs) {
	    List<List<Integer>> res =  new LinkedList<>();
	    LinkedList<Node> q = new LinkedList<Node>();
	    Set<Integer> visited = new HashSet<Integer>();
	    
	    HashMap<Integer, Integer> parentsPerChild = new HashMap<>();
	    
	    for(Integer curNode : graph.keySet()) { //Iterate over all nodes in graph
	    
		    q.add(graph.get(curNode));
		    
		    
		    while(!q.isEmpty()) {
		      Node node = q.remove();

		      
//		      if (visited.contains(node.id)) {
//		    	  continue;
//		      }
		      visited.add(node.id);
		      
		      for(Node child : node.adj) {
		    	  //child.parent.add(node.id); // Added its parent
		    	  parentsPerChild.put(child.id, parentsPerChild.getOrDefault(child.id, 0) + 1);
		    	  
		    	  if (!visited.contains(child.id)) {
		    		  q.add(child);
			      }
		    	  //q.add(child);
			  }
	
		    }
	      
	    }
	    
	    System.out.println(parentsPerChild.toString());
	    
	    List<Integer> zeroParent =  new LinkedList<>();
	    List<Integer> oneParent =  new LinkedList<>();
	    for (Integer n : parentsPerChild.keySet()) {
	    	if (parentsPerChild.get(n) == 0) {
	    		zeroParent.add(n);
	    		
	    	} else if (parentsPerChild.get(n) == 1)  {
	    		oneParent.add(n);
	    	}
	    }
	    
	    System.out.println("zero parents: " + zeroParent.toString());
	    System.out.println("one parent" + oneParent.toString());  
	    
	    return res;
	  }
	  
	  
	  
	  static class Node {
	    int id;
	    //Set<Integer> parent = new HashSet<>();
	    List<Node> adj = new LinkedList<>();
	    
	    Node (int data) {
	      this.id = data;
	    }
	    
	    @Override
		public String toString() {
			//return String.format("%s:%s", id, adj);
	    	//return String.format("%s", adj);
	    	StringBuffer sb = new StringBuffer();
	    	sb.append(id);
	    	sb.append(": [");
	    	for (Node n: adj) 
	    		sb.append(n.id + ", ");
	    	sb.append("]");
	    	return sb.toString();
		}
	  }
	  
	  static public Node getNode(int id) {
		  return graph.get(id);
	  }
    
	  static void addEdge(int parent, int child)  {
	      Node p = getNode(parent);
	      Node c = getNode(child);
	      if (p == null) p = new Node(parent);
	      if (c == null) { 
	    	  c = new Node(child);
	    	  graph.put(child, c);
	      }
	      p.adj.add(c);
	      graph.put(parent, p);
	  } 
	  
	  static void printGraph() {
		 
		  for (Node node : graph.values()) {
//			  System.out.printf("%s: ", node.id);
//			  for (Node s : node.adj) {
//				  System.out.printf("%s, ", s.id);
//			  }
//			  System.out.println("");
			  System.out.println(node.toString());
		  }
	  }

}
