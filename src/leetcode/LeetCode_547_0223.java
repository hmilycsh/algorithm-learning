package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_547_0223 {

    //DFS 朋友圈问题
    public int findCircleNum(int[][] M) {
        boolean[] visited = new boolean[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

    void dfs(int[][] M, boolean[] visited, int i) {
        for (int j = 0; j < M[0].length; j++) {
            if (M[i][j] == 0 || visited[j]) continue;
            visited[i] = true;
            dfs(M, visited, j);
        }
    }


    //BFS 朋友圈问题
    public int findCircleNum2(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                queue.add(i);
                while (!queue.isEmpty()) {
                    int s = queue.remove();
                    visited[s] = 1;
                    for (int j = 0; j < M.length; j++) {
                        if (M[s][j] == 1 && visited[j] == 0)
                            queue.add(j);
                    }
                }
                count++;
            }
        }
        return count;
    }
}