package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindShortestSubArray {

    public int findShortestSubArray(int[] nums) {
        Map<Integer,Integer> freqMap = new HashMap<>();

        int maxDegree = 0,maxVal = 0;
        for(int n:nums){
            freqMap.put(n,freqMap.getOrDefault(n,0)+1);
            if(freqMap.get(n) > maxDegree){
                maxDegree = freqMap.get(n);
                maxVal = n;
            }
        }

        int left = 0,right = 0;
        boolean isFirst= true;
        for(int i =0;i<nums.length;i++){
            if(maxVal == nums[i]){
                if(isFirst){
                    left = i;
                    right =i;
                    isFirst= false;
                }else{
                    right=i;
                }
            }
        }
        return right-left+1;
    }


    public static void main(String[] args) {
        FindShortestSubArray f = new FindShortestSubArray();
        Arrays.stream(new int[]{1,22,4}).sum();
        int ret =f.findShortestSubArray(new int[]{2,1,1,2,1,3,3,3,1,3,1,3,2});
        System.out.println(ret);
    }
}
