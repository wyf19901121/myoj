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
        ListNode start = head, end = head, pre = null;
        while (end != null) {
            for (int i = 1; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                return head;
            }
            if (pre == null) {
                head = end;
            }
            else {
                pre.next = end;
            }
            pre = start;
            reverse(start, end);
            start = pre.next;
            end = pre.next;
        }
        return head;
    }
    public void reverse(ListNode head, ListNode tail) {
        ListNode mid = head.next;
        ListNode left = head;
        head.next = tail.next;
        while (mid != head.next && mid != null) {
            ListNode right = mid.next;
            mid.next = left;
            left = mid;
            mid = right;
        }
    }
}
