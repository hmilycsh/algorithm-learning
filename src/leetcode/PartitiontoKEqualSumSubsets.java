package leetcode;

/**
 * 687. Partition to K Equal Sum Subsets.
 * 
 * @author zhaozp
 *
 */
public class PartitiontoKEqualSumSubsets {

	public static void main(String[] args) {

	}

	public boolean canPartitionKSubsets(int[] nums, int k) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		if (k < 0 || sum % k != 0)
			return false;

		boolean[] visited = new boolean[nums.length];
		return _helper(nums, visited, 0, k, 0, 0, sum / k);
	}

	public boolean _helper(int[] nums, boolean[] visited, int start, int k, int curSum, int curNum, int target) {
		if (k == 1)
			return true;
		if (curSum == target && curNum > 0) {
			return _helper(nums, visited, 0, k - 1, 0, 0, target);
		}

		for (int i = start; i < nums.length; i++) {
			if (visited[i]) {
				continue;
			}
			visited[i] = true;
			if (_helper(nums, visited, i + 1, k, curSum + nums[i], curNum++, target))
				return true;
			visited[i] = false;
		}
		return false;
	}
}
