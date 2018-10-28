package sort;

import java.util.Random;

/**
 * 冒泡排序、选择排序、插入排序
 * 
 * @author zhaozp
 *
 */
public class SimpleSort {

	private static final int DEFAULT_SIZE = 6;
	
	/**
	 * 冒泡排序
	 * @param a
	 * @param n
	 */
	public static void bubbleSort(int[] a, int n) {
		if (n <= 1) return;
		for (int i = 0; i < n; i++) {
			boolean flag = false;
			for (int j = 0; j < n - i - 1; j++) { 
				if(a[j] >a[j+1]){ //交换相邻的2个元素
					int tmp = a[j+1];
					a[j+1] = a[j];
					a[j] =tmp;
					flag = true;
				}
				if(!flag) return; //没有数据交换就提前退出循环
			}
		}
	}
	
	
	/**
	 * 选择排序
	 * 
	 * @param a
	 * @param n
	 */
	public static void selectionSort(int[] a, int n) {
		if (n <= 1)
			return;
		for (int i = 0; i < n; i++) {
			int minIndex = i;//找最小值
			for (int j = i + 1; j < n; j++) {
				if (a[j] < a[minIndex]) {
					int tmp = a[j];
					a[j] = a[minIndex];
					a[minIndex] = tmp;
				}
			}
		}
	}
	
	/**
	 * 插入排序
	 * @param a
	 * @param n
	 */
	public static void insertionSort(int[] a, int n) {
		if (n <= 1)
			return;
		for (int i = 1; i < n; i++) {
			int tmp = a[i];
			int j = i - 1;
			for (; j >= 0; j--) {
				if (tmp < a[j]) {
					a[j + 1] = a[j];
				} else {
					break;
				}
			}
			a[j + 1] = tmp;
		}
	}
	
	
	/**
	 * 打印数组所有元素
	 * @param a
	 * @param n
	 */
	public static void printAll(int[] a,int n){
		for(int i=0;i<n;i++){
			System.out.print(a[i]+" ");
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
		printAll(a,a.length);
		//排序
		//bubbleSort(a,a.length);
		//selectionSort(a,a.length);
		insertionSort(a,a.length);
		
		printAll(a,a.length);
		
	}

}
