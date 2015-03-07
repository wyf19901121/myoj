package leetcode;

public class SwapNodesinPairs {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null, cur = head, post = null;
        head = head.next;
        do {
            post = cur.next;
            cur.next = post.next;
            post.next = cur;
            if (pre != null) {
                pre.next = post;
            }
            pre = cur;
            cur = cur.next;
        } while (cur != null && cur.next != null);
        return head;
    }
}
