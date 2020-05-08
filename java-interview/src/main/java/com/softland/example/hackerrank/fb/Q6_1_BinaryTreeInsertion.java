package com.softland.example.hackerrank.fb;

/*
 * You are given a pointer to the root of a binary search tree and values to be inserted into the tree. Insert the values into their appropriate position in the binary search tree and return the root of the updated binary tree. You just have to complete the function.

Input Format

You are given a function,

Node * insert (Node * root ,int data) {

}

Constraints

    No. of nodes in the tree 

    500

Output Format

Return the root of the binary search tree after inserting the value into the tree.

Sample Input

        4
       / \
      2   7
     / \
    1   3

The value to be inserted is 6.

Sample Output

         4
       /   \
      2     7
     / \   /
    1   3 6


RESULT:
Input (stdin)
Download

    6

    4 2 3 1 7 6

Your Output (stdout)

    4 2 1 3 7 6 

Expected Output
Download

    4 2 1 3 7 6 


 */
public class Q6_1_BinaryTreeInsertion {
   
  	public static void preOrder( Node root ) {
      
    	if( root == null) return;
      
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
     
    }

 
	static Node insert(Node root,int data) {
        Node n = root;
		
        if (n == null) {
        	n = new Node(data);
        	return n;
        }
        
        Node parent;
        while(true) {
        	parent = n;
        	
			if (data <= n.data) {
				n = n.left;
				if ( n == null) { 
					parent.left = new Node(data);
					return root;
				}
				
			} else {
				n = n.right;
				if (n == null) {
					parent.right = new Node(data);
					return root;
				}
			}
        }
    }
	
	// Using recursion, best solution
	public static Node insert2(Node root, int data) {
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

	

	public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int t = scan.nextInt();
//        Node root = null;
//        while(t-- > 0) {
//            int data = scan.nextInt();
//            root = insert(root, data);
//        }
//        scan.close();
		
		
		int[] arr = new int[] {4, 2, 3, 1, 7, 6};
		Node root = null;
		for(int i: arr) {
			root = insert2(root, i);
		}
      	preOrder(root);
    }
	
}	

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
