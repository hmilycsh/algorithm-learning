package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        Subsets f = new Subsets();
        System.out.println(f.subsets(new int[]{1,2,3}));
    }


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list,new  ArrayList<>(),nums,0);
        return list;
    }

    public void backtrack(List<List<Integer>> list, List<Integer> tmpList,int[] nums,int start){
        list.add(new ArrayList<>(tmpList));
        for(int i = start;i<nums.length;i++){
            tmpList.add(nums[i]);
            backtrack(list,tmpList,nums,i+1);
            tmpList.remove(tmpList.size()-1);
        }
    }
}
