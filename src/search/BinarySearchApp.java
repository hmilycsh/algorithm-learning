package search;

/**
 * 二分查找 变形题
 */
public class BinarySearchApp {

	/**
	 * 变形一：查找第一个值等于给定值的元素
	 *
	 * @param a
	 *            可能存在重复的数据
	 * @param n
	 */
	public static int binarySearchForFirstEqual(int[] a, int n, int value) {
		int low = 0;
		int high = n - 1;
		while (low <= high) {

			// 1.不用(low+high)/2是因为low+high可能会很大产生溢出
			// 2.相比除2，用右移一位效率更高
			int mid = low + ((high - low) >> 1);
			if (a[mid] > value) {
				high = mid - 1;
			} else if (a[mid] < value) {
				low = mid + 1;
			} else {
				if ((mid == 0 || a[mid - 1] != value)) {
					return mid;
				} else {
					high = mid - 1;
				}
			}
		}

		return -1;
	}

	/**
	 * 变形二：查找最后一个值等于给定值的元素
	 *
	 * @param a
	 *            可能存在重复的数据
	 * @param n
	 */
	public static int binarySearchForLastEqual(int[] a, int n, int value) {
		int low = 0;
		int high = n - 1;
		while (low <= high) {
			int mid = low + ((high - low) >> 1);
			if (value > a[mid]) {
				low = mid + 1;
			} else if (value < a[mid]) {
				high = mid - 1;
			} else {
				if (mid == n - 1 || a[mid + 1] != value) {
					return mid;
				} else {
					low = mid + 1;
				}
			}

		}

		return -1;
	}

	/**
	 * 变形三：查找第一个值大于等于给定值的元素
	 *
	 * @param a
	 *            可能存在重复的数据
	 * @param n
	 */
	public static int binarySearchForFirstEqualOrGreater(int[] a, int n, int value) {
		int low = 0;
		int high = n - 1;
		while (low <= high) {

			// 1.不用(low+high)/2是因为low+high可能会很大产生溢出
			// 2.相比除2，用右移一位效率更高
			int mid = low + ((high - low) >> 1);
			if (a[mid] >= value) {
				if (mid == 0 || a[mid - 1] < value) {
					return mid;
				} else {
					high = mid - 1;
				}
			} else {
				low = mid + 1;
			}
		}

		return -1;
	}

	/**
	 * 变形四：查找最后一个值小于等于给定值的元素
	 *
	 * @param a
	 *            可能存在重复的数据
	 * @param n
	 */
	public static int binarySearchForFirstEqualOrSmaller(int[] a, int n, int value) {
		int low = 0;
		int high = n - 1;
		while (low <= high) {

			// 1.不用(low+high)/2是因为low+high可能会很大产生溢出
			// 2.相比除2，用右移一位效率更高
			int mid = low + ((high - low) >> 1);
			if (a[mid] <= value) {
				if (mid == 0 || a[mid + 1] > value) {
					return mid;
				} else {
					low = mid + 1;
				}
			} else {
				high = mid - 1;
			}
		}

		return -1;
	}

	public static void printAll(int[] a) {
		for (int v : a) {
			System.out.print(v + " ");
		}
		System.out.println();
		System.out.println("===============");
	}

	public static void main(String[] arg) {
		int[] a = { 1, 4, 7, 9, 9, 9, 21, 56, 98 };
		printAll(a);
		BinarySearchApp bs = new BinarySearchApp();
		System.out.println("result: " + bs.binarySearchForFirstEqual(a, a.length, 8));
		System.out.println("result: " + bs.binarySearchForLastEqual(a, a.length, 8));
		System.out.println("result: " + bs.binarySearchForFirstEqualOrGreater(a, a.length, 8));
		System.out.println("result: " + bs.binarySearchForFirstEqualOrSmaller(a, a.length, 8));

	}

}