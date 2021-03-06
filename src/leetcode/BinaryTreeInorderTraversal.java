package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * leetcode 94
 * 
 * @author zhaozp
 *
 */
public class BinaryTreeInorderTraversal {

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {
				cur = stack.pop();
				list.add(cur.val);
				cur = cur.right;
			}
		}
		return list;
	}

	public List<Integer> preorderTraversal(TreeNode root){
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while(cur!=null || !stack.isEmpty()){
			if(cur!=null){
				list.add(cur.val);
				cur = cur.left;
			}else{
				cur = stack.pop();
				cur=cur.right;
			}
		}
		return list;
		
	}
	
	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root,list);
        return list;   
    }
    
    private void helper(TreeNode root,List<Integer> list){
        if(root!=null){
            helper(root.left,list);
            helper(root.right,list);
            list.add(root.val);
        }
    }
}
