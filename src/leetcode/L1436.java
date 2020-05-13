package leetcode;

import sun.rmi.server.InactiveGroupException;

import java.util.*;

public class L1436 {

    int res = 0, N = 0;
    List<Boolean> hasApple;
    boolean[] visited;

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        N = n;
        this.hasApple = hasApple;
        visited = new boolean[N];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] e : edges) {
            if (map.get(e[0]) == null) {
                List<Integer> list = new ArrayList<>();
                list.add(e[1]);
                map.put(e[0], list);
            } else {
                List<Integer> list = map.get(e[0]);
                list.add(e[1]);
            }
        }
        dfs(0, map);
        return res * 2;
    }

    void dfs(int n, Map<Integer, List<Integer>> edgeMap) {
        if (visited[n]) return;
        List<Integer> edges = edgeMap.get(n);
        if (edges == null) return;
        ;
        visited[n] = true;
        if (hasApple.get(edges.get(0))) res += 2;
        if (hasApple.get(edges.get(1))) res += 2;
        dfs(edges.get(0), edgeMap);
        dfs(edges.get(1), edgeMap);
    }


    public int countTriplets(int[] arr) {
        int count = 0;
        int a=arr[0];
        for(int i = 1;i < arr.length;i++){
            a ^= arr[i];
            if(a == 0) count++;
        }
        return count;
    }


    public static void main(String[] args) {
        L1436 l = new L1436();
//        int[][] edges = {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
//        List<Boolean> apples = Arrays.asList(false, false, true, false, true, true, false);
//        System.out.println(l.minTime(7, edges, apples));
        System.out.println(l.countTriplets(new int[]{2,3,1,6,7}));

    }
}
