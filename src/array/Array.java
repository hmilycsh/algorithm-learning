package array;

public class Array {

	private static final int DEFAULT_SIZE = 6;

	/** 定义data保存数据 */
	private int[] data;

	/** 数组的长度 */
	private int size = 0;

	/** 数组中实际元素的个数 */
	private int count = 0;

	public Array(int capacity) {
		data = new int[capacity];
		size = capacity;
	}

	/**
	 * 查找是否存在某元素d，如果存在则返回下标index,不存在则返回-1
	 * 
	 * @param d
	 * @return
	 */
	public int find(int d) {
		for (int i = 0; i < count; i++) {
			if (d == data[i]) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 在指定下标处插入指定的元素
	 * 
	 * @param index
	 * @param d
	 * @return true表示插入成功,false表示插入失败
	 */
	public boolean insert(int index, int d) {
		if (index < 0 || index > count) {
			return false;
		}

		if (count == size) { // 队列满了则返回插入失败
			System.out.println("array is full.");
			return false;
		}

		for (int i = count; i > index; i--) {
			data[i] = data[i - 1];
		}
		data[index] = d;
		count++;
		return true;
	}

	/**
	 * 根据下标删除元素
	 * 
	 * @param index
	 * @return
	 */
	public boolean delete(int index) {
		if (index < 0 || index > count) {
			return false;
		}

		if (count == 0) {
			System.out.println("array is empty.");
			return false;
		}

		for (int i = index; i < count; i++) {
			data[i] = data[i + 1];
		}
		count--;
		return true;
	}

	/**
	 * 打印数组所有元素
	 * 
	 * @param a
	 * @param n
	 */
	public void printAll() {
		for (int i = 0; i < count; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
		System.out.println("=============");
	}

	public static void main(String[] arg) {
		Array a = new Array(DEFAULT_SIZE);

		a.insert(0, 93);
		a.insert(1, 38);
		a.insert(1, 26);
		a.insert(1, 55);
		a.insert(4, 68);

		a.printAll();
		System.out.println(a.find(68));
		System.out.println(a.delete(2));

		a.printAll();

	}
}
