package sort;

import java.util.Random;

/**
 * 计数排序，只能处理正整数，如果不是正整数需要先变形转换 举例：排序500个学生的成绩(0..100)
 * 
 * @author zhaozp
 *
 */
public class CountingSort {

	private static final int DEFAULT_SIZE = 500;// 待排序数组大小

	/**
	 * 计数排序
	 * 
	 * @param a
	 * @param n
	 */
	public static void countingSort(int[] a, int n) {
		// 1.新建大小为max(a[i])的数组c[0...max],并初始化为0
		int max = a[0];
		for (int i = 1; i < n; i++) {
			if (max < a[i])
				max = a[i];
		}

		int[] c = new int[max + 1];
		for (int i = 0; i <= max; i++) {
			c[i] = 0;
		}

		// 2.统计待排序数组元素出现的次数
		for (int i = 0; i < n; i++) {
			c[a[i]]++;
		}

		// 3.依次累计，计算出数组元素的位置
		for (int i = 1; i <= max; i++) {
			c[i] = c[i] + c[i - 1];
		}

		// 【关键】4.排序并把排序后数组写进r数组
		int[] r = new int[n];
		for (int i = 0; i < n; i++) {
			int index = c[a[i]] - 1;
			r[index] = a[i];
			c[a[i]]--;
		}

		// 5.把r赋值给a
		for (int i = 0; i < n; i++) {
			a[i] = r[i];
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
			a[i] = r.nextInt(101);
		}
		printAll(a, a.length);
		// 排序
		countingSort(a, a.length);

		printAll(a, a.length);

	}

}
