package leetcode;

public class LeetCode_526 {

    public static void main(String[] args) {
        LeetCode_526 l = new LeetCode_526();
        System.out.println(l.countArrangement(3));
    }

    int count= 0;
    public int countArrangement(int N) {
        boolean[] visited = new boolean[N+1];
        backtrack(N,1,visited);
        return count;
    }

    void backtrack(int N,int pos,boolean[] visited){
        if(pos > N){
            count++;
        }

        for(int i = 1;i<=N;i++){
            if(!visited[i] && (pos % i==0 || i % pos == 0)){
                visited[i] = true;
                backtrack(N,pos+1,visited);
                visited[i] = false;
            }
        }
    }
}
