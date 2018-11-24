package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {

	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode right = invertTree(root.right);
		TreeNode left = invertTree(root.left);
		root.left = right;
		root.right = left;
		return root;
	}

	/**
	 * BFS
	 * 
	 * @param root
	 * @return
	 */
	public TreeNode invertTreeByBFS(TreeNode root) {
		if (root == null) {
			return null;
		}
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.addLast(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.pollFirst();
			TreeNode left = node.left;
			TreeNode right = node.right;
			node.left = right;
			node.right = left;

			if (node.left != null) {
				queue.addLast(node.left);
			}
			if (node.right != null) {
				queue.addLast(node.right);
			}
		}
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
