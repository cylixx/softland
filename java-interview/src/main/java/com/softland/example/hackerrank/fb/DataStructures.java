package com.softland.example.hackerrank.fb;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class DataStructures {
  public static void main(String[] args) {
    
   // Node n = new Node(1);
    System.out.println("---------------------Linked List-------------------------");
    insert(2);
    insert(4);
    insert(6);
    insert(8);
    printNode();
    
    System.out.println("---------------------Binary Tree Search - DFS-------------------------");
    insertTree(7);
    insertTree(3);
    insertTree(8);
    insertTree(9);
    insertTree(4);
    insertTree(1);
    inOrderTraversal(tree);
    
    System.out.println("---------------------Binary Tree Search - BFS-------------------------");
    BFS(tree);
    
    System.out.println("---------------------Graph - BFS-------------------------");
    addEdge(0, 1); 
    addEdge(0, 2); 
    addEdge(1, 2); 
    addEdge(2, 0); 
    addEdge(2, 3); 
    addEdge(3, 3);  
    
    NodeGraph ng = getNode(1);
    graphBFS(ng);
  }
  
//------------------[Tree]----------------------------
  
  static class Tree {
      public int data;
      public Tree left;
      public Tree right;
    
    public Tree(){
    }
    
    public Tree(int value) {
      this.data = value;
    }
  }
  
  static Tree tree;
  
  static void insertTree(int value){
    if (tree == null) {
      tree = new Tree(value);
      return;
    }
    
    Tree n = tree;
    while(n != null) {

        if (value < n.data) {
          if (n.left == null) {
            n.left = new Tree(value);
            return;
          }
          n = n.left;
        } else {
            if (n.right == null) {
              n.right = new Tree(value);
              return;
            }
          n = n.right;
        }
    }
    
  }
  
  static void inOrderTraversal(Tree root) {
    if (root == null) return;
    
    inOrderTraversal(root.left);
    System.out.println(root.data);
    inOrderTraversal(root.right);
  }
  
  static void BFS(Tree root) {
      LinkedList<Tree> stack = new LinkedList<Tree>();
      
      Tree n = root;
      if (n != null)  stack.add(n);
    
    while(!stack.isEmpty()) {
      Tree s = stack.poll();
      
      if (s.left != null) stack.add(s.left);
      System.out.println(s.data);
      if (s.right != null) stack.add(s.right);
      
    }
  }
  
  
  
//   ------------------[Array List]----------------------------
  
  static class Node {
    public int data;
    public Node next;
    
    public Node(int value) {
      this.data = value;
      this.next = null;
    }
  }
  
  static Node root;
  
  static void insert(int data) {
    if (root == null) { 
      root = new Node(data);
      return;
    }
    
    Node n = root;
    while(n != null) {
      if (n.next == null){
        n.next = new Node(data);
        return;
      }
      n = n.next;
    }
  }
  
  static void printNode(){
    Node n = root;
    while(n != null) {
      System.out.println(n.data);
      n = n.next;
    }
  }
  
  
//------------------[Grapth]----------------------------  
  static Map<Integer, NodeGraph> nodes = new HashMap<Integer, NodeGraph>();
  
  static class NodeGraph {
	  int data;
	  List<NodeGraph> adj;
	  
	  public NodeGraph(int value) {
		  this.data = value;
		  this.adj = new LinkedList<NodeGraph>();
	  }
  }
  
  static void addEdge(int source, int destination) {
	  NodeGraph s = getNode(source);
	  NodeGraph d = getNode(destination);
	  s.adj.add(d);
	  nodes.put(source, s);
  }
  
  static NodeGraph getNode(int value) {
	  if (!nodes.containsKey(value)) return new NodeGraph(value);
	  return nodes.get(value);
  }
  
  static void graphBFS(NodeGraph root) {
	  LinkedList<NodeGraph> q = new LinkedList<NodeGraph>();
	  Set<Integer> visited = new HashSet<Integer>();
	  
	  q.add(root);
	  while(!q.isEmpty()) {
		  NodeGraph n = q.poll();
		  System.out.println(n.data); 
		  
		  for(NodeGraph a: n.adj) {
			  if (!visited.contains(a.data)) {
				  visited.add(a.data);
				  q.add(a);
			  }
		  }
	  }
	  
	  
  }
  
  
}
