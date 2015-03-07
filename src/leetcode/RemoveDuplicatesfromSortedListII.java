package leetcode;

public class RemoveDuplicatesfromSortedListII {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            while (temp != null) {
                if (temp.val != cur.val) {
                    break;
                }
                temp = temp.next;
            }
            if (cur.next == temp) {
                pre = cur;
            }
            else {
                if (cur == head) {
                    head = temp;
                }
                else {
                    pre.next = temp;
                }
            }
            cur = temp;
        }
        return head;
    }
}
