package leetcode;

public class IntersectionOfTwoLinkedLists {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		int lenA = this.findListNodeLength(headA);
		int lenB = this.findListNodeLength(headB);

		ListNode ha = headA, hb = headB;
		int differ = lenA - lenB;
		if (differ > 0) {
			while (ha != null && differ != 0) {
				differ--;
				ha = ha.next;
			}
		} else {
			while (hb != null && differ != 0) {
				differ++;
				hb = hb.next;
			}
		}

		while (ha != null && hb != null) {
			if (ha == hb) {
				return ha;
			}
			ha = ha.next;
			hb = hb.next;
		}

		return null;
	}

	/**
	 * return the length of list
	 * 
	 * @param head
	 * @return
	 */
	private int findListNodeLength(ListNode head) {
		if (head == null) {
			return 0;
		}
		int len = 0;
		ListNode h = head;
		while (h != null) {
			len++;
			h = h.next;
		}
		return len;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
