package leetcode;

/**
 * 4. Median of Two Sorted Arrays.
 * 
 * @author zhaozp
 *
 */
public class MedianSortedArray {

	public static void main(String[] args) {
		int[] nums1 = { 1, 3 };
		int[] nums2 = { 2 };
		MedianSortedArray msa = new MedianSortedArray();
		System.out.println(msa.findMedianSortedArrays(nums1, nums2));
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length, n = nums2.length;
		int l = m + n;
		int[] nums = new int[l];
		int i = 0, j = 0, k = 0;
		while (i < m && j < n) {
			if (nums1[i] < nums2[j]) {
				nums[k++] = nums1[i++];
			} else {
				nums[k++] = nums2[j++];
			}
		}

		while (i < m) {
			nums[k++] = nums1[i++];
		}

		while (j < n) {
			nums[k++] = nums2[j++];
		}

		if (l == 1)
			return nums[0];
		if (l % 2 == 0) {
			return Double.valueOf((nums[l / 2] + nums[(l - 1) / 2])) / 2;
		} else {
			return nums[l / 2];
		}
	}
}
