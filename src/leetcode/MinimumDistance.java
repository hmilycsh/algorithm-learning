package leetcode;

/**
 * 783. Minimum Distance Between BST Nodes.
 * 
 * @author zhaozp
 *
 */
public class MinimumDistance {
	Integer res = Integer.MIN_VALUE;

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode a = new TreeNode(4);
		TreeNode b = new TreeNode(5);
		a.left = new TreeNode(4);
		a.right = new TreeNode(4);
		b.left=new TreeNode(5);

		root.left=a;
		root.right=b;
		MinimumDistance md = new MinimumDistance();
		System.out.println(md.minDiffInBST(root));
	}

	public int minDiffInBST(TreeNode root) {
		if(root ==null) return 0;
		_help(root,root.val);
		return res;
	}
	
	private int _help(TreeNode node, int val) {
		if (node == null)
			return 0;
		int left = _help(node.left, node.val);
		int right = _help(node.right, node.val);
		res = Math.max(res, left + right);
		if (val == node.val) {
			return Math.max(left, right)+1;
		}
		return 0;
	}

	
}
