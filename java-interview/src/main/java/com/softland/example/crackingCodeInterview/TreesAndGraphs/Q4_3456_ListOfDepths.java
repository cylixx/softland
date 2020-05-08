package com.softland.example.crackingCodeInterview.TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;

/*
 * 4.3  List of Depths:   (Nodes by level)
 * Given a binary tree, design an algorithm which creates a linked list of all the nodes
at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).

SOLUTION
Though we might think at first glance that this problem requires a level-by-level traversal, this isn't actually
necessary. We can traverse the graph any way that we'd like, provided we know which level we're on as we
do so.
We can implement a simple modification of the pre-order traversal algorithm, where we pass in level +
1 to the next recursive call. The code below provides an implementation using depth-first search.

Both solutions run in O ( N)

 */
public class Q4_3456_ListOfDepths {

	public TreeNode root;
	public int size;  // NO necessary only for problem Q4_5_Validate BST

	private class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode parent;  // NO necessary only for the problem of Successor Q4_6

		public TreeNode(int data) {
			this.data = data;
			size++;
		}

		@Override
		public String toString() {
			return String.format("N(%s) -> P(%s)", data, parent!=null && parent.data > 0 ? parent.data : -1);
		}
		
	}
	// add node to the tree
	public void addNode(int key) {
		
		if (root == null) root = new TreeNode(key);
		else {
			TreeNode node = root;
			TreeNode parent;
			
			while(true) {
				parent = node;
				if(key < node.data) {
					node = node.left;
					if (node == null) {
						parent.left = new TreeNode(key);
						parent.left.parent = parent;  // NO necessary only for the problem of Successor Q4_6
						return;
					}
				} else {
					node = node.right;
					if (node == null) {
						parent.right = new TreeNode(key);
						parent.right.parent = parent;  // NO necessary only for the problem of Successor Q4_6
						return;
					}
				}
			} 
			
		}
	}
	// left, root, right
		public void inOrderTraverseTree(TreeNode node) {
			if (node != null) {
				inOrderTraverseTree(node.left);
				System.out.println(node);
				inOrderTraverseTree(node.right);
			}
		}
	
		
	/*------SOLUTION #1 DFS-----------------------------
	 * 
	 * We can implement a simple modification of the pre-order traversal algorithm, where we pass in level +1 
	 * to the next recursive call. The code below provides an implementation using depth-first search.
	 */
	void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
		if (root == null)  return; // base case

		LinkedList<TreeNode> list = null;
		if (lists.size() == level) {  // Level not contained in list
			list = new LinkedList<TreeNode>();
			/*
			 * Levels are always traversed in order. So, if this is the first time we've
			 * visited level i, we must have seen levels 0 through i - 1. We can therefore
			 * safely add the level at the end.
			 */
			lists.add(list);
		} else {
			list = lists.get(level);
		}
		list.add(root);
		createLevelLinkedList(root.left, lists, level + 1);
		createLevelLinkedList(root.right, lists, level + 1);
	}

	ArrayList<LinkedList<TreeNode>> createLevelLinkedListDFS(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
		createLevelLinkedList(root, lists, 0);
		return lists;
	}

	/*
	 * ------SOLUTION #2 BFS--------------------------------------------------
	 * Alternatively, we can also implement a modification of breadth-first search. With this implementation, we
want to iterate through the root first, then level 2, then level 3, and so on.
With each level i, we will have already fully visited all nodes on level i. - 1. This means that to get which
nodes are on level i, we can simply look at all children of the nodes of level i - 1.
	 */
	ArrayList<LinkedList<TreeNode>> createLevelLinkedListBFS(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		
		/* "Visit" the root */
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		if (root != null) {
			current.add(root);
		}
		
		while (current.size() > 0) {
			result.add(current); // Add previous level
			LinkedList<TreeNode> parents = current; // Go to next level
			current = new LinkedList<TreeNode>();
			for (TreeNode parent : parents) {
				/* Visit the children */
				if (parent.left != null) {
					current.add(parent.left);
				}
				if (parent.right != null) {
					current.add(parent.right);
				}
			}
		}
		return result;
	}
	
	
	/*
	 * Q4_4_Check Balanced
	 * --------------------------------------------------------
	 * Check Balanced: Implement a function to check if a binary tree is balanced. For the purposes of
		this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any
		node never differ by more than one.
		
		SOLUTION:
		balanced means: that for each node,
		the two subtrees differ in height by no more than one. We can implement a solution based on this defini­
		tion. We can simply recurse through the entire tree, and for each node, compute the heights of each subtree.
	 */
	
	/* SOLUTIOn #1 
	 * Although this works. it's not very efficient. On each node. we recurse through its entire subtree. This means
that getHeight is called repeatedly on the same nodes. The algorithm isO(N log N) since each node is
"touched" once per node above it.
	 */
	int getHeight(TreeNode root) {
		if (root == null)  return -1; // Base case
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}

	boolean isBalanced(TreeNode root) {
		if (root == null) return true;// Base case
		
		int heightDiff = getHeight(root.left) - getHeight(root.right);
		if (Math.abs(heightDiff) > 1) {
			return false;
		} else {  // Recurse
			return isBalanced(root.left) && isBalanced(root.right);
		}
	}
	
	/*
	 * SOLUTION #2 - Recommended
	 * This code runs in O(N) time and O(H) space, where H is the height of the tree.
	 */
	int checkHeight(TreeNode root) {
		if (root == null)  return -1;
		
		int leftHeight = checkHeight(root.left);
		if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; // Pass error up
		
		int rightHeight = checkHeight(root.right);
		if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; // Pass error up
		
		int heightDiff = leftHeight - rightHeight;
		if (Math.abs(heightDiff) > 1) {
			return Integer.MIN_VALUE; // Found error -> pass it back
		} else {
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}
	boolean isBalanced2(TreeNode root) {
		return checkHeight(root) != Integer.MIN_VALUE;
	}
	
	
	//----------------------------------------------------------------------------
	/*
	 * Q4_5_Validate BST
	 * ---------------------------------------------------------------------------
Validate BST: Implement a function to check if a binary tree is a binary search tree.
pg 710
SOLUTION
We can implement this solution in two different ways. The first leverages the in-order traversal, and the
second builds off the property that left <= c urrent < right.
	 */
	
	/*
	 * Solution #1: In-Order Traversal
Our first thought might be to do an in-order traversal, copy the elements to an array, and then check to see
if the array is sorted. This solution takes up a bit of extra memory, but it works-mostly.
	 */
	int index = 0;
	void copyBST(TreeNode root, int[] array) {
		if (root == null) return;
		copyBST(root.left, array);
		array[index] = root.data;
		index++;
		copyBST(root.right, array);
	}
	
	boolean checkBST(TreeNode root) {
		int[] array = new int[this.size];
		copyBST(root, array);
		for (int i=1; i<array.length; i++) {
			if (array[i] <= array[i-1]) return false;
		}
		return true;
	}
			
	/*
	 * SOLUTION #2
	 * When we examine the Solution #1, we find that the array is not actually necessary. We never use it other than
to compare an element to the previous element. So why not just track the last element we saw and compare
it as we go?
	 */
	Integer lastPrinted = null;
	boolean checkBST2(TreeNode n) {
		if (n == null) return true;
		
		// check / recurse left
		if (!checkBST2(n.left)) return false;
		
		// check current
		if (this.lastPrinted != null && n.data <= this.lastPrinted) {
			return false;
		}https://accounts.google.com/ServiceLogin?hl=en&passive=true&continue=https://translate.google.com/
		lastPrinted = n.data;
		
		// check / recurse right
		if (!checkBST2(n.right)) return false;
		
		return true;  // All good!
	}
	
	/*
	 * SOLUTION #3:  : The Min / Max Solution
	 * In the second solution, we leverage the definition of the binary search tree.
	 * More precisely, the condition is that a// left nodes must be less than or equal to the current node, which
must be less than all the right nodes.
Using this thought, we can approach the problem by passing down the min and max values. As we iterate
through the tree, we verify against progressively narrower ranges.
The time complexity for this solution is O(N), where N is the number of nodes in the tree.
	 * 
In the second solution, we leverage the definition of the binary search tree.

	 * 
	 */
	boolean checkBST3(TreeNode n) {
		return checkBST3(n, null, null);
	}
	
	boolean checkBST3(TreeNode n, Integer min, Integer max) {
		if (n == null) 	return true;
		
		if ((min != null && n.data <= min) || (max != null && n.data > max)) {
			return false;
		}
		
		if (!checkBST3(n.left, min, n.data) || !checkBST3(n.right, n.data, max)) {
			return false;
		}
		return true;
	}
	
	
	/*----------------------------------------------------------------------------
	 * Q4_6_Successor
	 * ---------------------------------------------------------------------------
	 * 4.6
Successor: Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a
binary search tree. You may assume that each node has a link to its parent.
	 * 
	 * SOLUTION
	 * Let's suppose we have a hypothetical node. We know that the order goes left subtree, then current side,
then right subtree. So, the next node we visit should be on the right side.
But which node on the right subtree? It should be the first node we'd visit if we were doing an in-order
traversal of that subtree. This means that it should be the leftmost node on the right subtree. Easy enough!
But what if the node doesn't have a right subtree? This is where it gets a bit trickier.
If a node n doesn't have a right subtree, then we are done traversing n's subtree. We need to pick up where
we left off with n's parent, which we'll call q.
If n was to the left of q, then the next node we should traverse should be q (again, since left - > current
-> right).
If n were to the right of q, then we have fully traversed q's subtree as well. We need to traverse upwards from
q until we find a node x that we have not fully traversed. How do we know that we have not fully traversed
a node x? We know we have hit this case when we move from a left node to its parent. The left node is fully
traversed, but its parent is not.

	 * 
	 */
	TreeNode inorderSuccessor(TreeNode n) {
		if (n == null) return null;
		
		// Found right children -> return leftmost node of right subtree
		if (n.right != null) {
			return leftMostChild(n.right);
		} else {
			TreeNode q = n;
			TreeNode x = q.parent;
			// Go up until we're on left instead of right
			while(x != null && x.left != q) {
				q = x;
				x = x.parent;
			}
			return x;
		}
	}
	
	TreeNode leftMostChild(TreeNode n) {
		if (n == null) return null;
		
		while(n.left != null) {
			n = n.left;
		}
		return n;
	}
	
	
		
	/*
	 * Example BST:
	 * 
	 *               (50)
	 *              /    \ 
	 *          (25)      (75)
	 *         /    \      /
	 *       (15)   (30) (80)
	 */
	public static void main(String[] args) {
		Q4_3456_ListOfDepths btree = new Q4_3456_ListOfDepths();
		btree.addNode(50);
		btree.addNode(25);
		btree.addNode(15);
		btree.addNode(30);
		btree.addNode(75);
		btree.addNode(80);
		
		System.out.println("-------------DFS - In Order traverse----------------");
		btree.inOrderTraverseTree(btree.root);
		
		System.out.println("-------------SOLUTION #1 DFS----------------");
		ArrayList<LinkedList<TreeNode>> list = btree.createLevelLinkedListDFS(btree.root);
		System.out.println(list.toString());
		
		System.out.println("\n-------------SOLUTION #2 BFS----------------");
		ArrayList<LinkedList<TreeNode>> list2 = btree.createLevelLinkedListBFS(btree.root);
		System.out.println(list2.toString());
		
		System.out.println("\n-------------Get Nodes on level 2----------------");
		System.out.println(list2.get(2));
		
		System.out.println("\n-------------Q4_4_Check Balanced - ----------------");
		System.out.println("SOLUTION #1:  Is binary tree balanced? " + btree.isBalanced(btree.root));
		System.out.println("SOLUTION #2:  Is binary tree balanced? " + btree.isBalanced2(btree.root));
		
		System.out.println("\n---Q4_5_Validate BST ---------------------------------------");
		System.out.println("Total Nodes: " + btree.size);
		System.out.println("SOLUTION #1: In-Order Traversal -- Is BST? " + btree.checkBST(btree.root));
		System.out.println("SOLUTION #2:  Is BST? " + btree.checkBST2(btree.root));
		System.out.println("SOLUTION #3:  Is BST? " + btree.checkBST3(btree.root));
		
		System.out.println("\n---Q4_6_Successor ----------------");
		System.out.println("Find the next successor: " + btree.inorderSuccessor(btree.root));
	}

}
