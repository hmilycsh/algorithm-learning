package leetcode;

import java.util.Arrays;

/**
 思路:
 考虑题意: 必然存在一条分界线把 A 拆分成两半，存在两大类情况：
 长度为 L 的连续子数组在左边, 长度为 M 的连续子数组在右边
 或者反过来长度为 M 的连续子数组在左边, 长度为 L 的连续子数组在右边
 引入:
 dp[i][0]: 从 A[0]-A[i] 连续 L 长度子数组最大的元素和
 dp[i][1]: 从 A[0]-A[i] 连续 M 长度子数组最大的元素和
 dp[i][2]: 从 A[i]-A[A.size()-1] 连续 L 长度子数组最大的元素和
 dp[i][3]: 从 A[i]-A[A.size()-1] 连续 M 长度子数组最大的元素和
 某些超出范围的下标, 值设置为 0 (默认值)
 代码中首先用滑动窗口计算了dp, 然后将 dp 分成两组, 计算两大类情况下的结果，         取最大值返回即可
 */
public class MaxSumTwoNoOverlap {

    public static void main(String[] args) {
        MaxSumTwoNoOverlap m = new MaxSumTwoNoOverlap();
        int result = m.maxSumTwoNoOverlap(new int[]{0,6,5,2,2,5,1,9,4},1,2);
        System.out.println(result);
    }

    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int N = A.length;

        //前缀和
        int[] preSum = new int[A.length];
        preSum[0] = A[0];
        for(int i = 1;i<A.length;i++){
            preSum[i] = preSum[i-1] + A[i];
        }

        //后缀和
        int[] sufSum = new int[A.length];
        sufSum[N-1] = A[N-1];
        for(int i = N-2;i>=0;i--){
            sufSum[i] = sufSum[i+1] + A[i];
        }

        int[] preL = new int[A.length];
        preL[L-1] = preSum[L-1];
        for(int i=L;i<A.length;i++){
            preL[i] = Math.max(preL[i-1],preSum[i] - preSum[i - L]);
        }

        int[] preM = new int[A.length];
        preL[M-1] = preSum[M-1];
        for(int i=M;i<A.length;i++){
            preM[i] = Math.max(preM[i-1],preSum[i] - preSum[i - M]);
        }

        int[] sufL = new int[A.length];
        sufL[N - L] = sufSum[N - L];
        for (int i = N - L - 1; i >= 0; i--)
            sufL[i] = Math.max(sufL[i + 1], sufSum[i] - sufSum[i + L]);

        int[] sufM = new int[A.length];
        sufM[N - M] = sufSum[N - M];
        for (int i = N - M - 1; i >= 0; i--)
            sufM[i] = Math.max(sufM[i + 1], sufSum[i] - sufSum[i + M]);

        int ans = 0;
        for (int i = L - 1; i < N - M; i++)
            ans = Math.max(ans, preL[i] + sufM[i + 1]);

        for (int i = M - 1; i < N - L; i++)
            ans = Math.max(ans, preM[i] + sufL[i + 1]);

        return ans;

    }

}
