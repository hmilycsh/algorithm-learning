package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Populating Next Right Pointers in Each Node
 * 
 * @author zhaozp
 *
 */
public class PopulatingNextRightPointers {

	public TreeNode connect(TreeNode root) {
		if (root == null) {
			return null;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode prev = null;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (prev != null) {
					prev.next = node;
				}
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
				prev = node;
			}
		}
		return root;
	}
}
