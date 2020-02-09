package leetcode;

import java.util.Arrays;

public class LeetCode_1079 {
    int count;

    public static void main(String[] args) {
        LeetCode_1079 l = new LeetCode_1079();
        int result = l.numTilePossibilities("AAB");
        System.out.println(result);
    }

    public int numTilePossibilities(String tiles) {
        count = 0;
        char[] chars = tiles.toCharArray();
        Arrays.sort(chars);
        boolean[] visited = new boolean[chars.length];
        dfs(chars,0,visited);
        return count;
    }

    void dfs(char[] chars,int length,boolean[] visited){
        if(length == chars.length) return;
        for(int i = 0;i<chars.length;i++){
            if(visited[i]) continue;
            if(i-1>=0 && chars[i] == chars[i-1] && !visited[i-1]){
                continue;
            }
            count++;
            visited[i] = true;
            dfs(chars,length+1,visited);
            visited[i] = false;
        }
    }
}
