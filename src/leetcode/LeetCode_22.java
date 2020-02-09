package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_22 {

    public static void main(String[] args) {
        LeetCode_22 l = new LeetCode_22();
        System.out.println(l.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list,"",0,0,n);
        return list;
    }

    void backtrack(List<String> list,String cur,int open,int close,int max){
        if(cur.length() == 2 * max){
            list.add(cur);
            return;
        }

        if(open < max){
            backtrack(list,cur+"(",open+1,close,max);
        }
        if(open > close){
            backtrack(list,cur+")",open,close+1,max);
        }
    }
}


