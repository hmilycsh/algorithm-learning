package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BSTIterator {

	private List<Integer> list = new ArrayList<>();
	private int index = 0;

	public BSTIterator(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		while (!stack.isEmpty() || root != null) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			list.add(root.val);
			root = root.right;
		}
	}

	/** @return the next smallest number */
	public int next() {
		return list.get(index++);
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return index < list.size();
	}

	public static void main(String[] arg) {
		TreeNode root = new TreeNode(7);
		TreeNode n1 = new TreeNode(3);
		TreeNode n2 = new TreeNode(15);
		TreeNode n3 = new TreeNode(9);
		TreeNode n4 = new TreeNode(20);
		root.left = n1;
		root.right = n2;
		n2.left = n3;
		n2.right = n4;
		BSTIterator bsi = new BSTIterator(root);
		System.out.println(bsi.next());
		System.out.println(bsi.next());
		System.out.println(bsi.hasNext());
		System.out.println(bsi.next());
		System.out.println(bsi.hasNext());
		System.out.println(bsi.next());
		System.out.println(bsi.hasNext());
		System.out.println(bsi.next());
		System.out.println(bsi.hasNext());

	}
}
