package linkedlist;

public class SimpleLinkedList {

	private Node head = new Node(-1, null);

	/**
	 * 根据值查找节点
	 * 
	 * @param value
	 * @return
	 */
	public Node find(int value) {
		Node p = head;
		while (p != null && p.getData() != value) {
			p = p.getNext();
		}
		return p;
	}

	/**
	 * 向链表的末尾插入节点，最后节点next指向null
	 * 
	 * @param value
	 * @return
	 */
	public void insertAfter(int value) {
		Node p = head;
		while (p.getNext() != null) {
			p = p.getNext();
		}
		// 创建新的尾节点
		Node n = new Node(value, null);
		p.setNext(n);
	}

	/**
	 * 删除指定值得节点，删除成功则返回true,失败返回false
	 * 
	 * @param value
	 * @return
	 */
	public void delete(int value) {
		if (head == null)
			return;
		Node p = head;
		Node q = null;// 指向p的上一节点
		while (p != null && p.getData() != value) {
			q = p;
			p = p.getNext();
		}

		if (p == null) { // 没有找到value
			return;
		}

		if (q == null) { // 首节点==value
			head = head.getNext();
		} else { // 中间节点 or尾节点处理方式一样
			q.setNext(q.getNext().getNext());
		}

	}

	/**
	 * 打印所有节点的数据
	 */
	public void printAll() {
		Node p = head;
		while (p != null) {
			System.out.print(p.getData() + " ");
			p = p.getNext();
		}
		System.out.println();
		System.out.println("======");
	}

	public static void main(String[] arg) {
		SimpleLinkedList list = new SimpleLinkedList();
		list.insertAfter(93);
		list.insertAfter(36);
		list.insertAfter(45);
		list.insertAfter(28);
		list.insertAfter(37);

		list.printAll();

		Node n = list.find(28);
		if (n == null) {
			System.out.println("not found the value.");
		} else {
			System.out.println("found the value:" + n.getData());
		}
		System.out.println("======");

		list.delete(45);
		list.printAll();

	}
}
