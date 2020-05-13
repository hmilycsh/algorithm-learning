package leetcode;

public class L1361 {

    int[] leftChild, rightChild;
    boolean[] visited;

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        // 统计每个结点的父亲数：1. 若父亲数大于1则为false  2.若父亲数等于0的不是1个则为false
        int[] indegreeCnt = new int[n];
        for (int i = 0; i < n; i++) {
            if ((leftChild[i] != -1 && ++indegreeCnt[leftChild[i]] > 1)
                    || (rightChild[i] != -1 && ++indegreeCnt[rightChild[i]] > 1)) {
                return false;
            }
        }
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (indegreeCnt[i] == 0) {
                //巧妙判断，第2次走到这里return false
                if (root != -1) {
                    return false;
                }
                root = i;
            }
        }

        // 上面的判断可以解决单个连通域的树判断、及部分多连通域情况
        // 例如下面的情况无法判断，需要再判断连通域的个数。从root一遍dfs之后，若存在结点未被访问说明多个连通域。
        // 1 <--- 0 <--->  2， 4 --->3
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        visited = new boolean[n];
        dfs(root);
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }

    private void dfs(int v) {
        if (v == -1) {
            return;
        }
        visited[v] = true;
        dfs(leftChild[v]);
        dfs(rightChild[v]);
    }
}
