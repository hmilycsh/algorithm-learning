package linkedlist;

public class Node {

	/** 节点数据 */
	private int data;

	/** 指向下一节点引用 */
	private Node next;

	/**
	 * 构造1个节点
	 * 
	 * @param d
	 * @param n
	 */
	public Node(int d, Node n) {
		data = d;
		next = n;
	}

	public void setData(int data) {
		this.data = data;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getNext() {
		return next;
	}

	/**
	 * 返回节点数据
	 * 
	 * @return
	 */
	public int getData() {
		return data;
	}
}
