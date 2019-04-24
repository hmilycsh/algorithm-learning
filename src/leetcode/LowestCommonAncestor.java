package leetcode;

/**
 * Lowest Common Ancestor of a Binary Tree
 * 
 * @author zhaozp
 *
 */
public class LowestCommonAncestor {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || p == root || q == root) {
			return root;
		}

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		return left != null && right != null ? root : left == null ? right : left;
	}

}
