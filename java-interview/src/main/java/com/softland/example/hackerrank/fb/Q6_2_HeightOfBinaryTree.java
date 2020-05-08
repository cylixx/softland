package com.softland.example.hackerrank.fb;

/*
 * Tree: Height of a Binary Tree
 * 
 * The height of a binary tree is the number of edges between the tree's root and its furthest leaf. For example, the following binary tree is of height

:

image
Function Description

Complete the getHeight or height function in the editor. It must return the height of a binary tree as an integer.

getHeight or height has the following parameter(s):

    root: a reference to the root of a binary tree.

Note -The Height of binary tree with single node is taken as zero.

Input Format

The first line contains an integer
, the number of nodes in the tree.
Next line contains space separated integer where

th integer denotes node[i].data.

Note: Node values are inserted into a binary search tree before a reference to the tree's root node is passed to your function. In a binary search tree, all nodes on the left branch of a node are less than the node value. All values on the right branch are greater than the node value.

Constraints


Output Format

Your function should return a single integer denoting the height of the binary tree.

Sample Input

image

Sample Output

3

Explanation

The longest root-to-leaf path is shown below:

image

There are
nodes in this path that are connected by edges, meaning our binary tree's .


TEST:
Input (stdin)
    7

    3 5 2 1 4 6 7

Your Output (stdout)
    3

Expected Output
    3

 * 
 */
public class Q6_2_HeightOfBinaryTree {
	
	static class Node {
	    Node left;
	    Node right;
	    int data;
	    
	    Node(int data) {
	        this.data = data;
	        left = null;
	        right = null;
	    }
	}

	/*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static int height(Node root) {
      	return  maxDepth(root) - 1;
    }
    public static int maxDepth(Node root) {
          // Write your code here.
          if (root == null) return 0;
         
         int lMax = maxDepth(root.left);
         int rMax = maxDepth(root.right);

         if (lMax > rMax) {
             return lMax + 1;
         } else {
             return rMax + 1;
         }
    }


	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
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

//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int t = scan.nextInt();
//        Node root = null;
//        while(t-- > 0) {
//            int data = scan.nextInt();
//            root = insert(root, data);
//        }
//        scan.close();
//        int height = height(root);
//        System.out.println(height);
//    }	
	public static void main(String[] args) {
        
        int[] arr = new int[] {3, 5, 2, 1, 4, 6, 7};
        Node root = null;
        for(int i: arr) {
			root = insert(root, i);
		}
        int height = height(root);
        System.out.println("height: " + height);
    }	
}