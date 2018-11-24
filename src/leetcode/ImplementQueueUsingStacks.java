package leetcode;

import java.util.Stack;

public class ImplementQueueUsingStacks {

	private Stack<Integer> stack1 = new Stack<>();
	private Stack<Integer> stack2 = new Stack<>();
	private int front;

	/** Initialize your data structure here. */
	public ImplementQueueUsingStacks() {

	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		if (stack1.isEmpty()) {
			front = x;
		}
		stack1.push(x);
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
	}

	/** Get the front element. */
	public int peek() {
		if (!stack2.isEmpty()) {
			return stack2.peek();
		}
		return front;

	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return stack1.isEmpty() && stack2.isEmpty();
	}

	public static void main(String[] args) {
		ImplementQueueUsingStacks stack = new ImplementQueueUsingStacks();
		stack.push(1);
		stack.push(2);
		stack.peek();
		stack.push(3);
		System.out.println(stack.peek());
	}

}
