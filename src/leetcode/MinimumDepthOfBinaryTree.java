package leetcode;

import java.util.LinkedList;
import java.util.Stack;

import javafx.util.Pair;

public class MinimumDepthOfBinaryTree {

	/**
	 * DFS 求解
	 * 
	 * @param root
	 * @return
	 */
	public int minDepthByDFS(TreeNode root) {
		Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
		if (root == null) {
			return 0;
		} else {
			stack.push(new Pair<>(root, 1));
		}

		int min_depth = Integer.MAX_VALUE;
		while (!stack.isEmpty()) {
			Pair<TreeNode, Integer> pair = stack.pop();
			TreeNode node = pair.getKey();
			int current_depth = pair.getValue();
			if (node.left == null && node.right == null) {
				min_depth = Math.min(current_depth, min_depth);
			}

			if (node.left != null) {
				stack.push(new Pair<TreeNode, Integer>(node.left, current_depth + 1));
			}
			if (node.right != null) {
				stack.push(new Pair<TreeNode, Integer>(node.right, current_depth + 1));
			}
		}

		return min_depth;

	}

	/**
	 * BFS 求解
	 * 
	 * @param root
	 * @return
	 */
	public int minDepthByBFS(TreeNode root) {
		LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();
		if (root == null) {
			return 0;
		} else {
			queue.add(new Pair<>(root, 1));
		}

		int min_depth = Integer.MAX_VALUE;
		while (!queue.isEmpty()) {
			Pair<TreeNode, Integer> pair = queue.poll();
			TreeNode node = pair.getKey();
			int current_depth = pair.getValue();
			if (node.left == null && node.right == null) {
				min_depth = Math.min(current_depth, min_depth);
				break;
			}

			if (node.left != null) {
				queue.add(new Pair<TreeNode, Integer>(node.left, current_depth + 1));
			}
			if (node.right != null) {
				queue.add(new Pair<TreeNode, Integer>(node.right, current_depth + 1));
			}
		}

		return min_depth;

	}

}
