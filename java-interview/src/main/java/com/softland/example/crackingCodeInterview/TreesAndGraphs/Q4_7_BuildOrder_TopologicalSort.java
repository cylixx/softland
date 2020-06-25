package com.softland.example.crackingCodeInterview.TreesAndGraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
import java.util.stream.Collectors;

public class Q4_7_BuildOrder_TopologicalSort {

	/**
	 * 4.7 Build Order - solution 1
	 * You are given a list of projects and a list of dependencies 
	 * (which is a list of pairs of projects, where the 1st project is
	 * dependent on the 2nd project. All of a project's dependencies
	 * must be built before the project is. Find a build order that will allow
	 * the projects to be built.
	 * If there is no valid build order, return an error
	 * Example :
	 * 		INPUT
	 *			projects : a, b, c, d, e, f
	 * 			dependencies : (d,a), (b,f), (d,b), (a,f), (c,d)
	 *		OUTPUT : f, e, a b, d, c
	 */
	Project[] findBuildOrder(String[] projects, String[][] dependencies) {
		Graph graph = buildGraph(projects, dependencies);
		return orderProjects(graph.getNodes());
	}

	Graph buildGraph(String[] projects, String[][] dependencies) {
		Graph graph = new Graph();
		for (String project : projects) {
			graph.getOrCreateNode(project);
		}
		for (String[] dependency : dependencies) {
			graph.addEdge(dependency[0], dependency[1]);
		}
		return graph;
	}

	Project[] orderProjects(ArrayList<Project> projects) {
		Project[] order = new Project[projects.size()];
		/* Add "roots" to the build order first.*/
		int endOfList = addNonDependent(order, projects, 0);
		
		int toBeProcessed = 0;
		while(toBeProcessed < order.length) {
			Project current = order[toBeProcessed];

			if (current == null)	return null;		// circular dependency, no remaining projects w/ 0 dependencies

			ArrayList<Project> children = current.getChildren();		// remove myself as dependency
			for (Project child : children)
				child.decrementDependencies();

			endOfList = addNonDependent(order, children, endOfList);	// add children that have no one depending on them
			++toBeProcessed;
		}
		return order;
	}

	/* insert projects w/ 0 dependencies into the order array */
	int addNonDependent(Project[] order, ArrayList<Project> projects, int offset) {
		for(Project project : projects) {
			if (project.getNumberDependencies() == 0) {
				order[offset] = project; 
				++offset;
			}
		}
		return offset;
	}

	static class Graph {
		private ArrayList<Project> nodes = new ArrayList<Project>();
		private HashMap<String, Project> map = new HashMap<String, Project>();

		public Project getOrCreateNode(String name) {
			if(!map.containsKey(name)) {
				Project node = new Project(name);
				nodes.add(node);
				map.put(name, node);
			}
			return map.get(name);
		}

		public void addEdge(String startName, String endName) {
			Project start = getOrCreateNode(startName);
			Project end = getOrCreateNode(endName);
			start.addNeighbor(end);
		}

		public ArrayList<Project> getNodes() {	return nodes;	}
	}

	static class Project {
		public enum State {COMPLETE, PARTIAL, BLANK};  // for solution #2 DFS
		private State state = State.BLANK;               // for solution #2 DFS
		public State getState() {	return state;	}    // for solution #2 DFS
		public void setState(State st) {	state = st;		} // for solution #2 DFS
		
		private ArrayList<Project> children = new ArrayList<Project>();
		private HashMap<String, Project> map = new HashMap<String, Project>();
		private String name;
		private int dependencies = 0;

		public Project(String n) {	name = n;	}
		
		public void addNeighbor(Project node) {
			if(!map.containsKey(node.getName())) {
				children.add(node);
				map.put(node.getName(), node);
				node.incrementDependencies();
			}
		}

		public void incrementDependencies() {	dependencies++;	 }
		public void decrementDependencies() {	dependencies--;	 }
		
		public String getName() {	return name;	}
		public ArrayList<Project> getChildren() {	return children;	}
		public int getNumberDependencies() {	return dependencies;	}

		@Override
		public String toString() {
			return String.format("[name=%s]", name);
		}
	}
	
	
	
	//---------------------------------------------------------------------------
	// SOLUTION #2 solution DFS - topological sort
/*
 * lienarly ordering the vertices in a graph such that for every edge (a,b)
 * a appears before b in the linear order
 * You are given a list of projects and a list of dependencies 
 * (which is a list of pairs of projects, where the 1st project is
 * dependent on the 2nd project. All of a project's dependencies
 * must be built before the project is. Find a build order that will allow
 * the projects to be built.
 * If there is no valid build order, return an error
 * 
 */
	/**
	 *
	 * O(P + D) time
	 *    f
	 *  / | \		d
	 * c  |  b 	    |
	 *  \ | /|\		g	
	 *    a  | h
	 *    |  /
	 *    | /
	 *    e
	 * Pick arbitrary node
	 * 
	 * DFS(b)
	 * 	DFS(h)
	 *		build order = ..., h
	 *	DFS(a)
	 *		DFS(e)
	 *			build order = ..., e, h
	 *		build order = ..., a, e, h
	 *	DFS(e) -> return
	 *	build order = ..., b, a, e, h
	 *
	 * DFS(b)
	 *	DFS(g)
	 * 		build order = ..., g, b, a, e, h
	 * 	build order = ..., d, g, b, a, e, h
	 * DFS(f)
	 * 	DFS(c)
	 *		build order = ..., c, d, g, b, a, e, h
	 *	build order = f, c, d, g, b, a, e, h
	 *
	 */
	Stack<Project> findBuildOrder2(String[] projects, String[][] dependencies) {
		Graph graph = buildGraph(projects, dependencies);
		return orderProjectsDFS(graph.getNodes());
	}
	
	Stack<Project> orderProjectsDFS(ArrayList<Project> projects) {
		Stack<Project> stack = new Stack<Project>();
		for (Project project : projects)
			if (project.getState() == Project.State.BLANK)
				if (!doDFS(project, stack))
					return null;
		return stack;
	}

	boolean doDFS(Project project, Stack<Project> stack) {
		if (project.getState() == Project.State.PARTIAL)	return false;	// cycle

		if (project.getState() == Project.State.BLANK) {
			project.setState(Project.State.PARTIAL);
			ArrayList<Project> children = project.getChildren();
			for (Project child : children)
				if (!doDFS(child, stack))
					return false;

			project.setState(Project.State.COMPLETE);
			stack.push(project);
		}
		return true;
	}
	
	
	
	/**
	 * O(P+D) time (P - projects, D - dependencies)
	 * Nodes with no incoming edges can be built immediately
	 *
	 *    f
	 *  / | \		d
	 * c  |  b 	    |
	 *  \ | /|		g	
	 *    a  |
	 *    |  /
	 *    | /
	 *    e
	 *
	 * 1. Add the nodes with no incoming edges. 
	 *	  If the set of projects can b ebuilt, there must be some "first" project,
	 *	  and that project can't have any dependencies. If a project has no dependencies
	 * 	  (incoming edges), then we can't break anything by building it first
	 *
	 * 2. We removed all outgoing edges from these roots. Once those root projects were built
	 *	  it doesn't matter if another project depends on them.
	 *
	 * 3. We found nodes that now have no incoming edges. Using the same logic from steps 1 and 2
	 *	  It's okay to build these, find nodes with no dependencies, add them to build order
	 * 	  remove their outgoing edges, and repeat
	 *
	 * 4. What if there are nodes remaining, but all have dependencies (incoming edges)? 
	 *	  This means there's no way to build the system. We should return an error
	 * 
	 *  
	 * 1. Build a graph where each project is a node and its outgoing edges 
	 * represent the projects that depend on it. That is, if A has an edge to B
	 * (A->B), it means B has a dependency on A and therefore A must be built before B.
	 * Each node also tracks the # of incoming edges
	 * 
	 * 2. Initialize a buildOrder array. Once we determine a project's build order, we add it to the array.
	 * We also continue to iterate through the array, using a toBeProcessed pointer to 
	 * point to the next node to be fully processed.
	 * 
	 * 3. Find all the nodes with 0 incoming edges and add them to a buildOrder array. 
	 * Set a toBeProcessed pointer to the beginning of the array.
	 * 
	 * Repeat until toBeProcessed is at the end of the buildOrder
	 * 
	 * 1. Read node toBeProcessed.
	 *  >> If node == null, then all remaining nodes have a dependency and we have detected a cycle
	 * 2. For each child of node:
	 *  >> decrement child.dependencies (# of incoming edges)
	 *  >> if child.dependencies is 0, add child to end of buildOrder
	 *
	 */
	public static void main(String[] args) {
		Q4_7_BuildOrder_TopologicalSort example = new Q4_7_BuildOrder_TopologicalSort();
		
//		INPUT
//		 *			projects : a, b, c, d, e, f
//		 * 			dependencies : (d,a), (b,f), (d,b), (a,f), (c,d)
//		 *		OUTPUT : f, e, a b, d, c
		
//		String[] projects = new String[] {"a", "b", "c", "d", "e","f"};
//		String[][] dependencies = new String[][] {
//			{"a", "d"},
//			{"f", "b"},
//			{"b", "d"},
//			{"f", "a"},
//			{"d", "c"}
//		 };
		
		
//		build order: f, d, c, b, g, a, e
//		 *
//		 *    f
//		 *  / | \		d
//		 * c  |  b 	    |
//		 *  \ | /|		g	
//		 *    a  |
//		 *    |  /
//		 *    | /
//		 *    e
		String[] projects = new String[] {"a", "b", "c", "d", "e","f","g"};
		String[][] dependencies = new String[][] {
			{"f", "c"},   // c: f   'c' depende de 'f' ('c' enpieza despues de que termina 'f')
			{"f", "b"},   // b: f   f --> b  'b' depende de 'f'
			{"f", "a"},   // a: f   f --> a
			{"c", "a"},   // a: c   c --> a
			{"b", "a"},   // a: b
			{"a", "e"},   // e: a
			{"b", "e"},   // e: b
			{"d", "g"}    // g: d
		 };
		 System.out.println("--------SOLUTION #1 -------------------------------");
		 System.out.println("Projects: " + Arrays.asList(projects) );
		Project[] p = example.findBuildOrder(projects, dependencies);
		System.out.println("Build order: " + 
				Arrays.asList(p).stream().map(x -> x.name).collect(Collectors.toList())
				);
		 
		/*
		 *    f
		 *   /  \
		 *  a    b
		 *   \  /
		 *    d
		 *    |      e
		 *    c
		 *    
		 *  Adjacent list:
		 *  a: f         =>  f -> a
		 *  b: f             f -> b
		 *  c: d
		 *  d: a, b
		 *  e:
		 *  f:  
		 * 
		 */
		String[] projects2 = new String[] {"a", "b", "c", "d", "e", "f"};
		String[][] dependencies2 = new String[][] {
			{"f", "a"},
			{"f", "b"},
			{"a", "d"},
			{"b", "d"},
			{"d", "c"}
		};
		System.out.println("\nProjects: " + Arrays.asList(projects2) );
		Project[] p2 = example.findBuildOrder(projects2, dependencies2);
		System.out.println("Build order: " + 
				Arrays.asList(p2).stream().map(x -> x.name).collect(Collectors.toList())
				);
		
		
		System.out.println("\n--------SOLUTION #2 solution DFS - topological sort-------------------------------");
		 System.out.println("Projects: " + Arrays.asList(projects) );
		Stack<Project> stack = example.findBuildOrder2(projects, dependencies);
		System.out.println("Build order: " + 
				stack.stream().map(x -> x.name).collect(Collectors.toList())
				);
		
		
		System.out.println("\nProjects: " + Arrays.asList(projects2) );
		stack = example.findBuildOrder2(projects2, dependencies2);
		System.out.println("Build order: " + 
				stack.stream().map(x -> x.name).collect(Collectors.toList())
				);
		
	}

}
