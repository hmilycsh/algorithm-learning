package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 257. Binary Tree Paths Given a binary tree, return all root-to-leaf paths.
 * 
 * @author zhaozp
 *
 */
public class BinaryTreePath {

	/**
	 * DFS
	 * 
	 * @param root
	 * @return
	 */
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new ArrayList<>();
		Stack<TreeNode> nodeStack = new Stack<>();
		Stack<String> pathStack = new Stack<>();
		if (root == null) {
			return res;
		}

		nodeStack.add(root);
		pathStack.push(root.val + "");
		while (!nodeStack.isEmpty()) {
			TreeNode node = nodeStack.pop();
			String path = pathStack.pop();
			if (node.left == null && node.right == null) {
				res.add(path);
			}

			if (node.left != null) {
				nodeStack.push(node.left);
				pathStack.push(path + "->" + node.left.val);
			}

			if (node.right != null) {
				nodeStack.push(node.right);
				pathStack.push(path + "->" + node.right.val);
			}
		}
		return res;
	}

	
	public static void main(String[] args) {

	}

}
