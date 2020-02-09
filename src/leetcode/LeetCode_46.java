package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_46 {

    public static void main(String[] args) {
        LeetCode_46 l = new LeetCode_46();
        System.out.println(l.permute(new int[]{1,2,3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res,new ArrayList<>(),nums);
        return res;
    }

    void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums){
        if(tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        }else{
            for(int i = 0; i < nums.length;i++){
                if(!tempList.contains(nums[i])) {
                    tempList.add(nums[i]);
                    backtrack(list, tempList, nums);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }
}
