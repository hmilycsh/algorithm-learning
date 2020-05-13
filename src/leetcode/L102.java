package leetcode;

import java.util.*;

public class L102 {


    Map<Integer, List<Integer>> levelMap = new HashMap<>();

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        dfs(root, 0);
        return new ArrayList<>(levelMap.values());
    }
    
    void dfs(TreeNode root, Integer level) {
        if (root == null) return;
        levelMap.putIfAbsent(level, new ArrayList<>());
        levelMap.get(level).add(root.val);
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.addFirst(node.left);
                if (node.right != null) queue.addFirst(node.right);
            }
            ans.add(level);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.stringToTreeNode("[3,9,20,null,null,15,7]");
        L102 l = new L102();
        List<List<Integer>> ans = l.levelOrder(root);
    }
}
