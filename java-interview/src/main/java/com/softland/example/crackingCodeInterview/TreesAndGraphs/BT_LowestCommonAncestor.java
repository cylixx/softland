package com.softland.example.crackingCodeInterview.TreesAndGraphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/*
 * https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
 * 
Lowest Common Ancestor in a Binary Tree | Set 1

Given a binary tree (not a binary search tree) and two values say n1 and n2, write a program to find the least common ancestor.

Following is definition of LCA from Wikipedia:
Let T be a rooted tree. The lowest common ancestor between two nodes n1 and n2 is defined as the lowest node in T that has both n1 and n2 as descendants (where we allow a node to be a descendant of itself).

The LCA of n1 and n2 in T is the shared ancestor of n1 and n2 that is located farthest from the root. Computation of lowest common ancestors may be useful, for instance, as part of a procedure for determining the distance between pairs of nodes in a tree: the distance from n1 to n2 can be computed as the distance from the root to n1, plus the distance from the root to n2, minus twice the distance from the root to their lowest common ancestor. (Source Wiki)

lca
Recommended: Please solve it on “PRACTICE” first, before moving on to the solution.


We have discussed an efficient solution to find LCA in Binary Search Tree. In Binary Search Tree, using BST properties, we can find LCA in O(h) time where h is height of tree. Such an implementation is not possible in Binary Tree as keys Binary Tree nodes don’t follow any order. Following are different approaches to find LCA in Binary Tree.

Method 1 (By Storing root to n1 and root to n2 paths):
Following is simple O(n) algorithm to find LCA of n1 and n2.
1) Find path from root to n1 and store it in a vector or array.
2) Find path from root to n2 and store it in another vector or array.
3) Traverse both paths till the values in arrays are same. Return the common element just before the mismatch.

Following is the implementation of above algorithm.

 */

/*

	           1
	         /   \  
            2     3
          /  \   /  \
         4    5 6    7
         
         
    LCA(4, 5) = 2
    LCA(4, 6) = 1
    LCA(3, 4) = 1
    LCA(2, 4) = 2
        
 
 */
public class BT_LowestCommonAncestor {
	static NodeB root; 
	private static LinkedList<Integer> path1 = new LinkedList<Integer>();
	private static LinkedList<Integer> path2 = new LinkedList<Integer>();

	
	
	//---------------------------[SOLUTION #1 - By Storing root to n1 and root to n2 paths]---------------------------------------------------
	/*
	 * Time Complexity: Time complexity of the above solution is O(n). 
	 * The tree is traversed twice, and then path arrays are compared.
	 */
	 private static int LCA(NodeB root, int n1, int n2) { 
		 
		 if (!findPath(root, n1, path1) && !findPath(root, n2, path2)) {
			 return -1;
		 }
		 
		 int i;
		 for(i = 0; i < path1.size() && i < path2.size(); i++) {
			 if (!path1.get(i).equals(path2.get(i))) break;
		 }
		 
		 return path1.get(i - 1);
	 }
	
	
	 private static boolean findPath(NodeB node, int value, LinkedList<Integer> path) {
		NodeB n = node;
		
		if (n == null) return false;
		path.add(n.data);
		
		if (n.data == value) return true;
		
		if (n.left != null && findPath(n.left, value, path)) return true;
		
		
		if (n.right != null && findPath(n.right, value, path)) return true;
		
		path.remove(path.size()-1);
		
		return false;
	}
	 
	//--------------------------------------[SOLUTION #2 - Using Single Traversal]---------------------------------------------------
	/*
	 * The method 1 finds LCA in O(n) time, but requires three tree traversals plus extra spaces for path arrays. 
	 * If we assume that the keys n1 and n2 are present in Binary Tree, we can find LCA using single traversal of 
	 * Binary Tree and without extra storage for path arrays.
The idea is to traverse the tree starting from root. If any of the given keys (n1 and n2) matches with root, 
then root is LCA (assuming that both keys are present). If root doesn’t match with any of the keys,
 we recur for left and right subtree. The node which has one key present in its left subtree and the other key 
 present in right subtree is the LCA. If both keys lie in left subtree, then left subtree has LCA also, 
 otherwise LCA lies in right subtree.
	 * 
	 * 
	 * Time Complexity: Time complexity of the above solution is O(n) as the method does a simple tree traversal in bottom up fashion.
Note that the above method assumes that keys are present in Binary Tree. If one key is present and other is absent, then it returns the present key as LCA (Ideally should have returned NULL).
We can extend this method to handle all cases by passing two boolean variables v1 and v2. v1 is set as true when n1 is present in tree and v2 is set as true if n2 is present in tree.
	 */
	 private static NodeB LCA2(NodeB root, int n1, int n2) { 
		 
		 if (root == null) return null;
		 
		 // If either n1 or n2 matches with root's key, report 
	     // the presence by returning root (Note that if a key is 
	     // ancestor of other, then the ancestor key becomes LCA 
		 if (root.data == n1 || root.data == n2) return root;
		 
		// Look for keys in left and right subtrees 
		 NodeB left = LCA2(root.left, n1, n2);
		 NodeB right = LCA2(root.right, n1, n2);
		 
		 // If both of the above calls return Non-NULL, then one key 
	     // is present in once subtree and other is present in other, 
	     // So this node is the LCA 
		 if (left != null && right != null) return root;
		 
		// Otherwise check if left subtree or right subtree is LCA 
		 return (left != null) ? left : right;
	 }
	 
	//--------------------------------------[FIX SOLUTION #2 - Using Single Traversal]----------------------------------
	     // Root of the Binary Tree 
	     static boolean v1 = false, v2 = false; 
	   
	     // This function returns pointer to LCA of two given 
	     // values n1 and n2. 
	     // v1 is set as true by this function if n1 is found 
	     // v2 is set as true by this function if n2 is found 
	     static NodeB findLCAUtil(NodeB node, int n1, int n2) 
	     { 
	         // Base case 
	         if (node == null) 
	             return null; 
	           
	         //Store result in temp, in case of key match so that we can search for other key also. 
	         NodeB temp=null; 
	   
	         // If either n1 or n2 matches with root's key, report the presence 
	         // by setting v1 or v2 as true and return root (Note that if a key 
	         // is ancestor of other, then the ancestor key becomes LCA) 
	         if (node.data == n1) 
	         { 
	             v1 = true; 
	             temp = node; 
	         } 
	         if (node.data == n2) 
	         { 
	             v2 = true; 
	             temp = node; 
	         } 
	   
	         // Look for keys in left and right subtrees 
	         NodeB left_lca = findLCAUtil(node.left, n1, n2); 
	         NodeB right_lca = findLCAUtil(node.right, n1, n2); 
	   
	         if (temp != null) 
	             return temp; 
	   
	         // If both of the above calls return Non-NULL, then one key 
	         // is present in once subtree and other is present in other, 
	         // So this node is the LCA 
	         if (left_lca != null && right_lca != null) 
	             return node; 
	   
	         // Otherwise check if left subtree or right subtree is LCA 
	         return (left_lca != null) ? left_lca : right_lca; 
	     } 
	   
	     // Finds lca of n1 and n2 under the subtree rooted with 'node' 
	     static NodeB findLCA(int n1, int n2) 
	     { 
	         // Initialize n1 and n2 as not visited 
	         v1 = false; 
	         v2 = false; 
	   
	         // Find lca of n1 and n2 using the technique discussed above 
	         NodeB lca = findLCAUtil(root, n1, n2); 
	   
	         // Return LCA only if both n1 and n2 are present in tree 
	         if (v1 && v2) 
	             return lca; 
	   
	         // Else return NULL 
	         return null; 
	     } 
	     
	     
	     
	     public static void main(String[] args) {
	 		// TODO Auto-generated method stub
	 		
	 		BT_LowestCommonAncestor tree = new BT_LowestCommonAncestor(); 
	 	        tree.root = new NodeB(1); 
	 	        tree.root.left = new NodeB(2); 
	 	        tree.root.right = new NodeB(3); 
	 	        tree.root.left.left = new NodeB(4); 
	 	        tree.root.left.right = new NodeB(5); 
	 	        tree.root.right.left = new NodeB(6); 
	 	        tree.root.right.right = new NodeB(7); 
	 	        
	 	        List<int[]> nodes =  
	 	        		Arrays.asList(
	 	        				new int[]{4, 5},
	 	        				new int[]{4, 6},
	 	        				new int[]{3, 4},
	 	        				new int[]{2, 4}
	 	        		);
	 	        		
	     		for (int[] n: nodes ) {
	     			 path1.clear();
	     			 path2.clear();
	     			 
	     			int v1 = n[0];
	     			int v2 = n[1];
	     	        System.out.println(String.format("Is have path to %s: %s, path: %s", v1, findPath(tree.root, v1, path1), path1.toString()));
	     	        System.out.println(String.format("Is have path to %s: %s, path: %s", v2, findPath(tree.root, v2, path2), path2.toString()));
	     	        System.out.println(String.format("LCA(%s, %s) = %s", v1, v2, LCA(tree.root, v1, v2)));
	     		}
	 	        
	     	System.out.println("--------------------[SOLUTION #2 - Using Single Traversal]-------------------------");
	     	for (int[] n: nodes ) {
	    			 path1.clear();
	    			 path2.clear();
	    			 
	    			int v1 = n[0];
	    			int v2 = n[1];
	    			NodeB lca = LCA2(tree.root, v1, v2);
	    	        System.out.println(String.format("LCA(%s, %s) = %s", v1, v2, lca != null? lca.data : -1));
	    		}
	 	        
	     	System.out.println("--------------------[FIX SOLUTION #2 - Using Single Traversal]-------------------------");
	     	for (int[] n: nodes ) {
    			 path1.clear();
    			 path2.clear();
    			 
    			int v1 = n[0];
    			int v2 = n[1];
    			NodeB lca = findLCA(n[0], n[1]); 
    	        System.out.println(String.format("LCA(%s, %s) = %s", v1, v2, lca != null? lca.data : -1));
    		}
	     		
	 	}
	 
	
}

class NodeB {
	int data;
    NodeB left;
    NodeB right;
    
    NodeB(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
