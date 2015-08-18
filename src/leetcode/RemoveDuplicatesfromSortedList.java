package leetcode;

public class RemoveDuplicatesfromSortedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curNode = head;
        while (curNode != null) {
            ListNode nextDifNode = curNode.next;
            while (nextDifNode != null && nextDifNode.val == curNode.val) {
                nextDifNode = nextDifNode.next;
            }
            curNode.next = nextDifNode;
            curNode = nextDifNode;
        }
        return head;
    }
}
