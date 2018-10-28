package stack;

import java.util.Random;

/**
 * 基于数组实现可以动态扩展的栈
 * 
 * @author zhaozp
 *
 */
public class DynamicArrayStack {

	private static final int DEFAULT_SIZE = 6;

	/** 数组实现栈 */
	private String[] items;
	/** 栈的大小 */
	private int size = 0;
	/** 栈顶指针 */
	private int head = 0;

	public DynamicArrayStack(int capacity) {
		this.items = new String[capacity];
		this.size = capacity;
	}

	/**
	 * 入栈元素e
	 * 
	 * @param e
	 * @return
	 */
	public boolean push(String e) {
		if (e == null) {
			return false;
		}

		// 栈满扩容
		if (head == size) {
			int newsize = size * 2;// 扩容为原来的2倍
			String[] array = new String[newsize];
			for (int i = 0; i < size; i++) {
				array[i] = items[i];// 搬运数组
			}
			items = array;
			size = newsize;
		}
		items[head++] = e;
		return true;
	}

	/**
	 * 出栈
	 * 
	 * @return
	 */
	public String pop() {
		if (head == 0) { // 栈为空
			return null;
		} else {
			return items[--head];
		}
	}

	/**
	 * 打印整个栈
	 */
	public void printAll() {
		for (String e : items) {
			if (e != null) {
				System.out.print(e + " ");
			}
		}
		System.out.println();
		System.out.println("==================");
	}

	public static void main(String[] args) {
		Random r = new Random();
		DynamicArrayStack stack = new DynamicArrayStack(3);// 初始化10个大小
		for (int i = 0; i < DEFAULT_SIZE; i++) {
			String e = String.valueOf(r.nextInt(100));
			stack.push(e);
		}
		stack.printAll();
		for (int i = 0; i < DEFAULT_SIZE; i++) {
			System.out.print(stack.pop() + " ");
		}
	}
}
