package leetcode;

public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || head.next == null || n == 0) {
            return head;
        }
        int count = 0;
        ListNode cur = head, pre = null;
        while (cur != null) {
            pre = cur;
            cur = cur.next;
            count++;
        }
        n %= count;
        cur = head;
        for (int i = 0; i < count - n - 1; i++) {
            cur = cur.next;
        }
        pre.next = head;
        head = cur.next;
        cur.next = null;
        return head;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
