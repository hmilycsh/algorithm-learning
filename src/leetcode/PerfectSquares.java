package leetcode;

/**
 * 
 * 279.Perfect Squares. Given a positive integer n, find the least number of
 * perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * @author zhaozp
 *
 */
public class PerfectSquares {

	public int numSquares(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			int res = Integer.MAX_VALUE;
			int j = 1;
			while (j * j <= i) {
				res = Math.min(res, dp[i - j * j] + 1);
				j++;
			}
			dp[i] = res;
		}
		return dp[n];
	}

	public static void main(String[] arg) {
		PerfectSquares ps = new PerfectSquares();
		System.out.println(ps.numSquares(12));
	}

}
