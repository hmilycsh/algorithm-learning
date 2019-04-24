package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
    3
   / \
  9  20
    /  \
   15   7

 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class ConstructBinaryTree {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null || preorder.length != inorder.length) {
			return null;
		}

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return helper(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1, map);
	}

	public TreeNode helper(int[] inorder, int inStart, int inEnd, int[] preorder, int preStart, int preEnd,
			Map<Integer, Integer> map) {
		if (inStart > inEnd || preStart > preEnd) {
			return null;
		}

		TreeNode root = new TreeNode(preorder[preStart]);
		int ri = map.get(preorder[preStart]);
		TreeNode left = helper(inorder, inStart, ri - 1, preorder, preStart + 1, preStart + (ri - inStart),map);
		TreeNode right = helper(inorder, ri + 1, inEnd, preorder, preEnd - (inEnd - ri-1), preEnd,map);
		root.left = left;
		root.right = right;
		return root;
	}
}
