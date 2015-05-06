package leetcode;

public class ReverseLinkedList {
    public class ListNode {
            int val;
            ListNode next;
            ListNode(int x) { val = x; }
    }
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode preListNode = null, curListNode = head;
        while (curListNode != null) {
            ListNode tempListNode = curListNode.next;
            curListNode.next = preListNode;
            preListNode = curListNode;
            curListNode = tempListNode;
        }
        return preListNode;
    }
}
