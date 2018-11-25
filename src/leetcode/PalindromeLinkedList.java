package leetcode;

public class PalindromeLinkedList {

	public boolean isPalindrome(ListNode head) {
		// 找到中间节点
		ListNode fast = head, slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		// 奇数节点
		if (fast != null) {
			slow = slow.next;
		}

		// 反转后半段链表
		slow = reverse(slow);
		fast = head;

		// 判断两半段链表是否一致
		while (slow != null) {
			if (fast.val != slow.val) {
				return false;
			}
			slow = slow.next;
			fast = fast.next;
		}
		return true;
	}

	/**
	 * 反转单链表
	 * 
	 * @param head
	 * @return
	 */
	public ListNode reverse(ListNode head) {
		ListNode prev = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(1);
		
		PalindromeLinkedList pll = new PalindromeLinkedList();
		System.out.println(pll.isPalindrome(head));
	}

}
