package sort;

import java.util.Random;

/**
 * 归并排序
 * 
 * @author zhaozp
 *
 */
public class MergeSort {

	private static final int DEFAULT_SIZE = 6;

	/**
	 * 归并排序
	 * 
	 * @param a
	 *            待排序数组
	 * @param n
	 *            数组长度
	 */
	public static void mergeSort(int[] a, int n) {
		doMergeSort(a, 0, n - 1);
	}

	/**
	 * 归并排序递归方法
	 * 
	 * @param a
	 * @param p
	 * @param r
	 */
	public static void doMergeSort(int[] a, int p, int r) {
		if (p >= r)
			return;
		int q = (p + r) / 2;// 取p到r的中间位置
		doMergeSort(a, p, q);
		doMergeSort(a, q + 1, r);

		// 将A[p...q]和A[q+1...r]合并为A[p...r]
		merge(a, p, q, r);
	}

	/**
	 * 合并a[p...q]和a[q+1...r]两个有序子数组
	 * 
	 * @param a
	 * @param p
	 * @param r
	 * @return
	 */
	public static void merge(int[] a, int p, int q, int r) {
		int i = p, j = q + 1, k = 0;
		int[] tmp = new int[r - p + 1];
		while (i <= q & j <= r) {
			if (a[i] <= a[j]) {
				tmp[k++] = a[i++];
			} else if (a[i] > a[j]) {
				tmp[k++] = a[j++];
			}
		}

		while (i <= q) { // a[p...q]还有剩余元素，直接赋值给tmp
			tmp[k++] = a[i++];
		}

		while (j <= r) { // a[q...r]还有剩余元素，直接赋值给tmp
			tmp[k++] = a[j++];
		}

		// 将tmp中的数组拷贝回a[p...r]
		for (i = 0; i < r - p + 1; i++) {
			a[p + i] = tmp[i];
		}

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
		mergeSort(a, a.length);

		printAll(a, a.length);

	}

}
