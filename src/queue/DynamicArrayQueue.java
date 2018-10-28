package queue;

import java.util.Random;

/**
 * 基于数组实现可以动态扩展的队列
 * 
 * @author zhaozp
 *
 */
public class DynamicArrayQueue {

	private static final int DEFAULT_SIZE = 6;

	/** 基于数组实现队列 */
	private String[] items;

	/** 队列的大小 */
	private int size = 0;

	/** 队头 */
	private int head;

	/** 队尾 */
	private int tail;

	public DynamicArrayQueue(int capacity) {
		this.items = new String[capacity];
		this.size = capacity;
		this.head = 0;
		this.tail = 0;
	}

	/**
	 * 入队
	 * 
	 * @param e
	 * @return
	 */
	public boolean enQueue(String e) {
		if (e == null)
			return false;
		if (tail == size) {
			// TODO 扩容
			int newsize = size * 2;
			String[] array = new String[newsize];
			int j = 0;
			for (int i = head; i < tail; i++, j++) {// 把旧队列的元素移动到新扩容的队列中，从队首开始
				array[j] = items[i];
			}
			items = array;
			head = 0;// 扩容后新的队首
			tail = j;
			size = newsize;

		}
		items[tail++] = e;
		return true;
	}

	/**
	 * 出队
	 * 
	 * @return
	 */
	public String deQueue() {
		if (head == tail)
			return null;
		return items[head++];
	}

	/**
	 * 打印整个队列
	 */
	public void printAll() {
		for (int i = head; i < tail; i++) {
			if (items[i] != null) {
				System.out.print(items[i] + " ");
			}
		}
		System.out.println();
		System.out.println("==================");
	}

	public static void main(String[] args) {
		Random r = new Random();
		DynamicArrayQueue queue = new DynamicArrayQueue(3);// 初始化10个大小
		for (int i = 0; i < DEFAULT_SIZE; i++) {
			String e = String.valueOf(r.nextInt(100));
			queue.enQueue(e);
		}
		queue.printAll();
		for (int i = 0; i < DEFAULT_SIZE; i++) {
			System.out.print(queue.deQueue() + " ");
		}
	}
}
