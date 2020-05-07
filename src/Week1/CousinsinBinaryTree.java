/*
 * 993. Cousins in Binary Tree
 * 
 * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
 * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
 * We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
 * 
 * Return true if and only if the nodes corresponding to the values x and y are cousins.
 * 
 * 	Example 1:
 * 		Input: root = [1,2,3,4], x = 4, y = 3
 * 		Output: false
 * 
 * 	Example 2:
 * 		Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
 * 		Output: true
 * 
 * 	Example 3:
 * 		Input: root = [1,2,3,null,4], x = 2, y = 3
 * 		Output: false
 * 
 * 	Note:
 * 		The number of nodes in the tree will be between 2 and 100.
 * 		Each node has a unique integer value from 1 to 100.
 * 
 * 
 */


package Week1;

import java.util.*;

public class CousinsinBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	TreeNode root;

	public CousinsinBinaryTree(String s) {
		// TODO Auto-generated constructor stub
		s = s.substring(1, s.length() - 1);
		String[] element = s.split("[,]");
		root = constructBT(element);
	}

	public TreeNode constructBT(String[] s) {
		int indx = 0;
		TreeNode head = new TreeNode(Integer.parseInt(s[indx++]), null, null);
		Queue<TreeNode> q = new LinkedList<>();
		q.add(head);
		while (!q.isEmpty() && indx < s.length) {
			TreeNode temp = q.poll();
			if (!s[indx].equals("null")) {
				TreeNode leftNode = new TreeNode(Integer.parseInt(s[indx++]), null, null);
				temp.left = leftNode;
				q.add(leftNode);
			} else {
				indx++;
			}
			if (indx < s.length && (!s[indx].equals("null"))) {
				TreeNode rightNode = new TreeNode(Integer.parseInt(s[indx++]), null, null);
				temp.right = rightNode;
				q.add(rightNode);
			} else {
				indx++;
			}

		}
		return head;
	}

	public void display() {
		display(root);
	}

	private void display(TreeNode node) {
		// TODO Auto-generated method stub
		if (node == null) {
			return;
		}
		String str = "";
		if (node.left == null) {
			str += ".";
		} else {
			str += node.left.val + "";

		}
		str += "->" + node.val + "->";
		if (node.right == null) {
			str += ".";
		} else {
			str += node.right.val;
		}
		System.out.println(str);
		display(node.left);
		display(node.right);
	}

	public boolean isCousins(TreeNode root, int x, int y) {
		boolean[] isSiblingCheck = new boolean[1];
		int xDepth = depthOf(root, x, 0, isSiblingCheck, y);
		isSiblingCheck[0] = false;
		int yDepth = depthOf(root, y, 0, isSiblingCheck, x);
		if ((xDepth == yDepth) && (xDepth != -1) && (xDepth != -20)) {
			return true;
		} else {
			return false;
		}
	}

	public int depthOf(TreeNode root, int element, int depth, boolean[] check, int potentialThreat) {
		if (check[0]) {
			check[0] = false;
			if (root.val == potentialThreat) {
				return -20;
			} else {
				return depth;
			}
		}
		if (root == null) {
			return -1;
		}
		if (root.val == element) {
			check[0] = true;
			return depth;
		}
		int left = depthOf(root.left, element, depth + 1, check, potentialThreat);
		if (left != -1) {
			if (check[0]) {
				if ((root.right != null) && (depthOf(root.right, element, left, check, potentialThreat) != left)) {
					return -20;
				}
				check[0] = false;
			}
			return left;
		}
		int right = depthOf(root.right, element, depth + 1, check, potentialThreat);
		if (right != -1) {
			if (check[0]) {
				if ((root.left != null) && (depthOf(root.left, element, right, check, potentialThreat) != right)) {
					return -20;
				}
				check[0] = false;
			}
			return right;
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		int x = scn.nextInt();
		int y = scn.nextInt();
		CousinsinBinaryTree obj = new CousinsinBinaryTree(s);
		System.out.println(obj.isCousins(obj.root, x, y));
		scn.close();
	}

}
