package sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 桶排序 举例：排序500个学生的成绩(0..100)
 * 
 * @author zhaozp
 *
 */
public class BucketSort {

	private static final int DEFAULT_SIZE = 500;// 待排序数组大小
	public static final int BUCKET_NUM = 101;// 创建101个桶,编号0...101

	/**
	 * 桶排序
	 * 
	 * @param a
	 * @param n
	 */
	public static void bucketSort(int[] a, int n) {
		// 1.创建101个桶,编号0...101
		List<ArrayList<Integer>> bucketList = new ArrayList<>(BUCKET_NUM);
		for (int i = 0; i <= BUCKET_NUM; i++) {
			ArrayList<Integer> bucket = new ArrayList<Integer>();
			bucketList.add(bucket);
		}

		// 2.待排序数据放进桶里
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> bucket = bucketList.get(a[i]);
			bucket.add(a[i]);
		}

		// 3.把排序后的数据输出到a数组
		int j = 0;
		for (int i = 0; i <= BUCKET_NUM; i++) {
			ArrayList<Integer> bucket = bucketList.get(i);
			for (Integer value : bucket) {
				a[j++] = value;
			}
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
		bucketSort(a, a.length);

		printAll(a, a.length);

	}

}
