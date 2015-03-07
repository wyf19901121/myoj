package leetcode;

public class SortListQuick {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = null;
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        mid = slow.next;
        slow.next = null;
        return mergeList(sortList(head), sortList(mid));
    }
    public ListNode mergeList(ListNode a, ListNode b) {
        ListNode dummyHead = new ListNode(-1);
        ListNode curr = dummyHead;
        while(a!=null&&b!=null) {
            if(a.val<=b.val) {
                curr.next=a;a=a.next;
            } else {
                curr.next=b;b=b.next;
            }
            curr  = curr.next;
        }
        curr.next = a!=null?a:b;
        return dummyHead.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}