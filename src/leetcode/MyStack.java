package leetcode;

import java.util.LinkedList;

public class MyStack {

	private LinkedList<Integer> queue1 = new LinkedList<>();
	private LinkedList<Integer> queue2 = new LinkedList<>();
	private int top;

	/** Initialize your data structure here. */
	public MyStack() {

	}

	/** Push element x onto stack. */
	public void push(int x) {
		top = x;
		queue1.addLast(x);
	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		while (queue1.size() > 1) {
			top = queue1.getFirst();
			queue2.addLast(queue1.pollFirst());
		}
		int result = queue1.pollFirst();
		queue1 = queue2;
		queue2 = new LinkedList<>();
		return result;
	}

	/** Get the top element. */
	public int top() {
		return top;
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		return queue1.isEmpty() && queue2.isEmpty();
	}

	public static void main(String[] args) {
		MyStack stack = new MyStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.pop();
		System.out.println(stack.top());
	}

}
