package com.softland.example.crackingCodeInterview.TreesAndGraphs;


import java.util.*;
import java.io.*;

/*
 * 
 * Binary Search Tree : Lowest Common Ancestor
 * 
 * You are given pointer to the root of the binary search tree and two values and . You need to return the lowest common ancestor (LCA) of and

in the binary search tree.

image
In the diagram above, the lowest common ancestor of the nodes
and is the node . Node is the lowest node which has nodes and

as descendants.

Function Description

Complete the function lca in the editor below. It should return a pointer to the lowest common ancestor node of the two values given.

lca has the following parameters:
- root: a pointer to the root node of a binary search tree
- v1: a node.data value
- v2: a node.data value

Input Format

The first line contains an integer,
, the number of nodes in the tree.
The second line contains space-separated integers representing values.
The third line contains two space-separated integers, and

.

To use the test data, you will have to create the binary search tree yourself. Here on the platform, the tree will be created for you.

Constraints




The tree will contain nodes with data equal to and

.

Output Format

Return the a pointer to the node that is the lowest common ancestor of
and

.

Sample Input

6
4 2 3 1 7 6
1 7

image

and

.

Sample Output

[reference to node 4]

Explanation

LCA of
and is , the root in this case.
Return a pointer to the node.
 * 
 * 
 */

/*
 * https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
 * 
 * Approach: For Binary search tree, while traversing the tree from top to bottom the first node which lies in between the two numbers n1 and n2 is the LCA of the nodes, 
 * i.e. the first node n with the lowest depth which lies in between n1 and n2 (n1<=n<=n2) n1 < n2. 
 * So just recursively traverse the BST in, if node's value is greater than both n1 and n2 then our LCA lies in the left side of the node, 
 * if it's is smaller than both n1 and n2, then LCA lies on the right side. Otherwise, the root is LCA (assuming that both n1 and n2 are present in BST).

Algorithm:

    Create a recursive function that takes a node and the two values n1 and n2.
    If the value of the current node is less than both n1 and n2, then LCA lies in the right subtree. Call the recursive function for thr right subtree.
    If the value of the current node is greater than both n1 and n2, then LCA lies in the left subtree. Call the recursive function for thr left subtree.
    If both the above cases are false then return the current node as LCA.

 * 
 */
public class BST_LowestCommonAncestor {

	public static NodeA insert(NodeA root, int data) {
        if(root == null) {
            return new NodeA(data);
        } else {
            NodeA cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }
	
	/*
    class NodeA 
    	int data;
    	NodeA left;
    	NodeA right;
	*/
	/*
	 Binary Search Tree
	 
	    4
	  /   \
	2      7
   / \    /
  1	  3  6
	    
	 
	 */
	/*
	 *---------------------[Solution #1 - Recursively]----------------------------------
	 * Complexity Analysis:

    Time Complexity: O(h).
    The time Complexity of the above solution is O(h), where h is the height of the tree.
    Space Complexity: O(1).
    If recursive stack space is ignored, the space complexity of the above solution is constant.

	 */
	public static NodeA lca(NodeA root, int v1, int v2) {
      	// Write your code here.
        NodeA n = root;
        if (n == null) return null;
        if (v1 == v2) return null;        
        
		if (n.data>v1 && n.data>v2) {
	        return lca(n.left, v1, v2);
	    } 
        if (n.data<v1 && n.data<v2) {
            return lca(n.right, v1, v2);
        }
        
        return n;
    }
	
	/*
	 * ---------------------[Solution #2 - Iterative]----------------------------------
	 * Iterative Implementation: The above solution uses recursion. The recursive solution requires 
	 * extra space in the form of the function call stack. So an iterative solution can be implemented 
	 * which does not occupy space in the form of the function call stack.
	 * Complexity Analysis:

    Time Complexity: O(h).
    The Time Complexity of the above solution is O(h), where h is the height of the tree.
    Space Complexity: O(1).
    The space complexity of the above solution is constant.

	 */
	public static NodeA lca2(NodeA root, int v1, int v2) {
		
		NodeA n = root;
		if (n == null) return null;
		if (v1 == v2) return null;
		
		while(n != null) {
			
			
			if (n.data>v1 && n.data>v2) {
				n = n.left;
				
			} else  if (n.data<v1 && n.data<v2) {
				n = n.right;
				
			} else {
				break;  // or return n;
			}
		}
		
		return n;
	}
	
	
	
	public static void main(String[] args) {
		NodeA root = null;
		//4 2 3 1 7 6
		root = insert(root, 4);
		root = insert(root, 2);
		root = insert(root, 3);
		root = insert(root, 1);
		root = insert(root, 7);
		root = insert(root, 6);
		
		List<int[]> nodes =  
		Arrays.asList(
				new int[]{1, 7},
				new int[]{1, 3},
				new int[]{3, 6},
				new int[]{6, 7}
		);
		
		
		for (int[] n: nodes ) {
			int v1 = n[0];
			int v2 = n[1];
			NodeA ans = lca(root, v1, v2);
	        System.out.println(String.format("LCA(%s, %s) = %s", v1, v2, ans.data));
		}
		
		// solution #2
		System.out.println("//------------------[Solution #2. Iterative]---------------------------------");
		for (int[] n: nodes ) {
			int v1 = n[0];
			int v2 = n[1];
			NodeA ans = lca2(root, v1, v2);
	        System.out.println(String.format("LCA(%s, %s) = %s", v1, v2, ans.data));
		}
	}

	/*
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        NodeA root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
      	int v1 = scan.nextInt();
      	int v2 = scan.nextInt();
        scan.close();
        NodeA ans = lca(root,v1,v2);
        System.out.println(ans.data);
    }	
    */
}

class NodeA {
	int data;
    NodeA left;
    NodeA right;
    
    NodeA(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

