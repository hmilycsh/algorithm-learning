package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LevelOrderBottom {

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		if (root == null){
			return null;
		}
		LinkedList<List<Integer>> result = new LinkedList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			int size = queue.size();
			List<Integer> list = new ArrayList<Integer>();
			for(int i=0;i<size;i++){
				TreeNode node = queue.poll();
				list.add(node.val);
				if(node.left !=null){
					queue.add(node.left);
				}
				if(node.right !=null){
					queue.add(node.right);
				}
			}
			result.addFirst(list);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
