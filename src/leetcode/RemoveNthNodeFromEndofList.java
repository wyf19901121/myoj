package leetcode;

public class RemoveNthNodeFromEndofList {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || n <= 0) {
			return head;
		}
		ListNode fast = head, slow = head;
		while (n > 0 && fast != null) {
			fast = fast.next;
			n--;
		}
		if (n > 0) {//List不够长
			return head;
		}
		if (fast == null && n == 0) {//头节点删除
			return head.next;
		}
		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
		return head;
	}
}
