package leetcode;

public class SortedArrayToBST {
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}

		return getTreeNode(nums, 0, nums.length - 1);
	}

	public TreeNode getTreeNode(int[] nums, int left, int right) {
		if (left > right)
			return null;
		int mid = left + (right - left) / 2;
		TreeNode node = new TreeNode(nums[mid]);
		node.left = getTreeNode(nums, left, mid - 1);
		node.right = getTreeNode(nums, mid + 1, right);
		return node;
	}
}
