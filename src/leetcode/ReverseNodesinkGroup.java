package leetcode;

public class ReverseNodesinkGroup {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
    	if (head == null || head.next == null || k <= 1) {
			return head;
		}
    	ListNode tempHead = new ListNode(0);
    	tempHead.next = head;
    	ListNode pre = tempHead, next = pre.next;
    	while (next != null) {
			for (int i = 0; i < k - 1 && next != null; i++) {
				next = next.next;
			}
			if (next == null) {
				return tempHead.next;
			}
			ListNode cur = pre.next;
			pre.next = reverse(cur, next);
			pre = cur;
			next = pre.next;		
		}
    	return tempHead.next;
    }
    private ListNode reverse(ListNode head, ListNode tail) {
		if (head == null || tail == null) {
			return head;
		}
		ListNode pre = null, cur = head;
		while (cur != null) {
			ListNode fast = cur.next;
			cur.next = pre;
			if (cur == tail) {
				head.next = fast;
				return tail;
			}
			pre = cur;
			cur = fast;
		}
		return tail;
	}
}
