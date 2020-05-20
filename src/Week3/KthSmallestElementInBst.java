/*
 * 230. Kth Smallest Element in a BST
 * 
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * 
 * Note:
 * You may assume k is always valid, 1 <= k <= BST's total elements.
 * 
 * Example 1:
 * 
 * 		Input: root = [3,1,4,null,2], k = 1
 * 		   3
 * 		  / \
 * 		 1   4
 * 		  \
 * 		   2
 * 		Output: 1
 * 
 * 	Example 2:
 * 
 * 		Input: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 *  	Output: 3
 * 
 * 
 */

package Week3;

import java.util.*;

public class KthSmallestElementInBst {
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

	TreeNode root = null;

	public void construct(String str) {
		StringTokenizer st = new StringTokenizer(str, "[\\[\\],]");
		Queue<TreeNode> q = new LinkedList<>();
		TreeNode node = new TreeNode(Integer.parseInt(st.nextToken()), null, null);
		root = node;
		q.add(node);
		while (!q.isEmpty()) {
			TreeNode temp = q.poll();
			if (st.hasMoreTokens()) {
				String s1 = st.nextToken();
				if (!s1.equals("null")) {
					temp.left = new TreeNode(Integer.parseInt(s1), null, null);
					q.add(temp.left);
				}
			}
			if (st.hasMoreTokens()) {
				String s2 = st.nextToken();
				if (!s2.equals("null")) {
					temp.right = new TreeNode(Integer.parseInt(s2), null, null);
					q.add(temp.right);
				}
			}
		}
	}

	public static int kthSmallest(TreeNode root, int k) {
		int[] kArr = new int[1];
		kArr[0] = k - 1;
		return KthSmallestHelper(root, kArr);

	}

	public static int KthSmallestHelper(TreeNode node, int[] kArr) {
		if (node.left == null && node.right == null) {
			kArr[0] = kArr[0] - 1;
			return node.val;
		}

		int leftAns = 0;
		if (node.left != null) {
			leftAns = KthSmallestHelper(node.left, kArr);
		}

		if (kArr[0] < 0) {

			return leftAns;
		}

		if (kArr[0] == 0) {
			kArr[0] = kArr[0] - 1;
			return node.val;
		}

		int rightAns = 0;
		kArr[0] = kArr[0] - 1;

		if (node.right != null) {
			rightAns = KthSmallestHelper(node.right, kArr);
		}
		return rightAns;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		int k = scn.nextInt();
		KthSmallestElementInBst obj = new KthSmallestElementInBst();
		obj.construct(str);
		System.out.println(kthSmallest(obj.root, k));
		scn.close();
	}

}
