package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_39 {

    public static void main(String[] args) {
        LeetCode_39 l = new LeetCode_39();
        int[] candidates = {2,3,6,7};
        System.out.println(l.combinationSum(candidates,7));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list,new ArrayList<>(),candidates,target,0);
        return list;
    }

    void backtrack(List<List<Integer>> list,List<Integer> tempList,int[] candidates,int target,int start){
        if(target == 0){
            list.add(new ArrayList<>(tempList));
        }else{
            for(int i = start;i<candidates.length && target >= candidates[i];i++){
                tempList.add(candidates[i]);
                backtrack(list,tempList,candidates,target-candidates[i],i);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
