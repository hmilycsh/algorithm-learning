package leetcode;

import java.util.ArrayList;
import java.util.List;

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

	public String largestNumber(int[] nums) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			list.add(String.valueOf(nums[i]));
		}

		list.sort((o1,o2)->{
			String s1=o1+o2;
			
			String s2=o2+o1;
			return s2.compareTo(s1);
			
		});
		if ("0".equals(list.get(0))) {
			return "0";
		}

		StringBuilder sb = new StringBuilder();
		for (String s : list) {
			sb.append(s);
		}
		return sb.toString();
	}
	
	public static void main(String[] arg){
		SortedArrayToBST bst = new SortedArrayToBST();
		int[] a={3,30,34,5,9};
		System.out.println(bst.largestNumber(a));
		
		
	}
}
