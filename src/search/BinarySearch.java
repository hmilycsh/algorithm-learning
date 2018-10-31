package search;

/**
 * 二分查找 1.只适合于线性表(数组),且要求有序
 * 2.数据量太大（考虑存储的连续性，可能没连续的大空间）、太小(eg小于10，直接循环比较也相差不大)不适合用
 * 3.比较操作比较耗时的话，还是推荐使用二分查找，可以减少比较次数
 */
public class BinarySearch {

	/**
	 * 二分查找(非递归模式)
	 *
	 * @param a
	 * @param n
	 */
	public static int binarySearch(int[] a, int n, int value) {
		int low = 0;
		int high = n - 1;
		while (low <= high) {

			// 1.不用(low+high)/2是因为low+high可能会很大产生溢出
			// 2.相比除2，用右移一位效率更高
			int mid = low + ((high - low) >> 1);
			if (value == a[mid]) {
				return mid;
			} else if (value > a[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	/**
	 * 二分查找(递归模式)
	 *
	 * @param a
	 * @param low
	 * @param high
	 * @param value
	 * @return
	 */
	public static int bSearch(int[] a, int low, int high, int value) {
		if (low > high)
			return -1;
		int mid = low + ((high - low) >> 1);
		if (value == a[mid]) {
			return mid;
		} else if (value > a[mid]) {
			return bSearch(a, mid + 1, high, value);
		} else {
			return bSearch(a, low, mid - 1, value);
		}
	}

	public static void printAll(int[] a) {
		for (int v : a) {
			System.out.print(v + " ");
		}
		System.out.println();
		System.out.println("===============");
	}

	public static void main(String[] arg) {
		int[] a = { 1, 4, 7, 8, 21, 56, 98 };
		printAll(a);
		BinarySearch bs = new BinarySearch();
		System.out.println("result: " + bs.binarySearch(a, a.length, 23));
		System.out.println("result: " + bs.bSearch(a, 0, a.length - 1, 23));

	}

}