package sort;

import java.util.Random;

/**
 * 快速排序
 * 
 * @author zhaozp
 *
 */
public class QuickSort {

	private static final int DEFAULT_SIZE = 6;

	/**
	 * 快速排序
	 * 
	 * @param a
	 *            待排序数组
	 * @param n
	 *            数组长度
	 */
	public static void quickSort(int[] a, int n) {
		doQuickSort(a, 0, n - 1);
	}

	/**
	 * 快排递归方法
	 * 
	 * @param a
	 * @param p
	 * @param r
	 */
	public static void doQuickSort(int[] a, int p, int r) {
		if (p >= r)
			return;
		int q = partition(a, p, r);// 排好了a[q]位置
		doQuickSort(a, p, q - 1);
		doQuickSort(a, q + 1, r);
	}

	/**
	 * 找到分区点正确的位置i
	 * 
	 * @param a
	 * @param p
	 * @param r
	 * @return
	 */
	public static int partition(int[] a, int p, int r) {
		int pivot = a[r];// 取最后一个作为分区元素
		int i = p;
		for (int j = p; j < r; j++) {
			if (a[j] < pivot) {
				int tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
				i++;
			}
		}
		// i的位置就是pivot正确的位置
		int tmp = a[i];
		a[i] = a[r];
		a[r] = tmp;
		return i;
	}

	/**
	 * 打印数组所有元素
	 * 
	 * @param a
	 * @param n
	 */
	public static void printAll(int[] a, int n) {
		for (int i = 0; i < n; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		System.out.println("=============");
	}

	public static void main(String[] arg) {
		Random r = new Random();
		int[] a = new int[DEFAULT_SIZE];
		for (int i = 0; i < DEFAULT_SIZE; i++) {
			a[i] = r.nextInt(100);
		}
		printAll(a, a.length);
		// 排序
		quickSort(a, a.length);

		printAll(a, a.length);

	}

}
