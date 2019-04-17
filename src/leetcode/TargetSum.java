package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target,
 * S. Now you have 2 symbols + and -. For each integer, you should choose one
 * from + and - as its new symbol. Find out how many ways to assign symbols to
 * make sum of integers equal to target S.
 * 
 * @author zhaozp
 *
 */
public class TargetSum {
	public int findTargetSumWays(int[] nums, int S) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		return helper(nums, 0, 0, S, new HashMap<String, Integer>());
	}

	private int helper(int[] nums, int i, int sum, int s, Map<String, Integer> map) {
		String key = i + "_" + sum;
		if (map.containsKey(key)) {
			return map.get(key);
		}

		if (i == nums.length) {
			if (sum == s) {
				return 1;
			} else {
				return 0;
			}
		}

		int curNum = nums[i];
		int add = helper(nums, i + 1, sum - curNum, s, map);
		int minus = helper(nums, i + 1, sum + curNum, s, map);
		map.put(key, add + minus);
		return add + minus;
	}
}
