package leetcode;

import java.util.Arrays;

public class LeetCode_1052 {

    /**
     * [1,0,1,2,1,1,7,5]
     * [0,1,0,1,0,1,0,1]
     * 3
     * @param args
     */
    public static void main(String[] args) {
        LeetCode_1052 l = new LeetCode_1052();
        int result = l.maxSatisfied(new int[]{1,0,1,2,1,1,7,5},new int[]{0,1,0,1,0,1,0,1},3);
        System.out.println(result);
    }

    /**
     * Time Limited
     * @param customers
     * @param grumpy
     * @param X
     * @return
     */
    public int maxSatisfied1(int[] customers, int[] grumpy, int X) {
        int res = 0;
        for(int i=0;i<=grumpy.length-X;i++){
            int[] cur = Arrays.copyOf(grumpy,grumpy.length);
            for(int j = 0;j<X;j++){
                cur[i+j] = 0;
            }

            int count = 0;
            for(int k = 0;k<customers.length;k++){
                if(cur[k] == 0){
                    count += customers[k];
                }
            }
            res = Math.max(res,count);
        }
        return res;
    }


    public int maxSatisfied(int[] customers, int[] grumpy, int X){
        int satisfied = 0,winSatisfied = 0;
        for(int i = 0,win = 0; i< grumpy.length;i++){
            if(grumpy[i] == 0){
                satisfied += customers[i];
            }else{
                win += customers[i];
            }

            if(i >= X){
                win -= grumpy[i-X] * customers[i-X];
            }
            winSatisfied = Math.max(winSatisfied,win);
        }
        return satisfied+winSatisfied;
    }
}
