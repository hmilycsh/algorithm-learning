package leetcode;

import java.util.ArrayList;
import java.util.List;

public class L94 {

    //递归
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root,res);
        return res;
    }

    void helper(TreeNode root,List<Integer> res){
        if (root == null) return;
        helper(root.left,res);
        res.add(root.val);
        helper(root.right,res);
    }
}
