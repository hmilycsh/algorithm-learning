package leetcode;

import java.util.*;

public class FourSum {

    private static final String s = "afdasfdas";


    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }

        for(int x:set){
            for(int y:set){
                for(int z:set){
                    int threeSum = x + y + z;
                    if(set.contains(target-threeSum)){
                        List<Integer> subList = new ArrayList<>();
                        subList.add(x);
                        subList.add(y);
                        subList.add(z);
                        subList.add(target-threeSum);
                        res.add(subList);
                        set.remove(x);
                        set.remove(y);
                        set.remove(z);
                    }
                }
            }
        }
        return res;
    }

    public List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> list = new LinkedList<>();
        Arrays.sort(nums);
        for(int i = 0;i< nums.length - 3;i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1;j< nums.length - 2;j++){
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                int twoSumTarget = target - nums[i] - nums[j];
                //The following 3 lines of code to calculate the min and max of twoSum
                int minTwoSum = nums[j+1] + nums[j+2];
                int maxTwoSum = nums[nums.length - 1] + nums[nums.length - 2];
                if(twoSumTarget < minTwoSum || twoSumTarget > maxTwoSum) continue;
                for(int m = j+1,n= nums.length-1;m < n;){
                    int twoSum = nums[m] + nums[n];
                    if(twoSum < twoSumTarget){
                        while(m < n && nums[m] == nums[m+1]) m++;
                        m++;
                    }else if(twoSum > twoSumTarget){
                        while(m < n && nums[n] == nums[n-1]) n--;
                        n--;
                    }else{
                        List<Integer> tempList = new LinkedList<>(Arrays.asList(nums[i],nums[j],nums[m],nums[n]));
                        list.add(tempList);
                        while(m < n && nums[m] == nums[m+1]) m++;
                        m++;
                        while(m < n && nums[n] == nums[n-1]) n--;
                        n--;
                    }
                }
            }
        }
        return list;
    }


    public static void main(String[] args) {
        FourSum s = new FourSum();
        System.out.println(s.fourSum(new int[]{1, 0, -1, 0, -2, 2},0));
    }
}
