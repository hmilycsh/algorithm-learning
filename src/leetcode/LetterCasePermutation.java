package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {


    public static void main(String[] args) {
        LetterCasePermutation l = new LetterCasePermutation();
        System.out.println(l.letterCasePermutation("a1b2"));
    }

    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        backtrack(res,0,S.toCharArray());
        return res;
    }

    public void backtrack(List<String> res,int i,char[] S){
        if(i == S.length){
            res.add(new String(S));
        }else{
            if(Character.isLetter(S[i])){
                S[i] = Character.toLowerCase(S[i]);
                backtrack(res,i+1,S);
                S[i] = Character.toUpperCase(S[i]);
                backtrack(res,i+1,S);
            }else {
                backtrack(res, i + 1, S);
            }
        }
    }
}
