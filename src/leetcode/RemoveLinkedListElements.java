package leetcode;

public class RemoveLinkedListElements {
    public class ListNode {
            int val;
            ListNode next;
            ListNode(int x) { val = x; }
        }
    public ListNode removeElements(ListNode head, int val) {
        ListNode preListNode = null, curListNode = head;
        while (curListNode != null) {
            if (curListNode.val == val) {
                if (curListNode == head) {
                    head = curListNode.next;
                }
                else {
                    preListNode.next = curListNode.next;
                }
            }
            else {
                preListNode = curListNode;
            }
            curListNode = curListNode.next;
        }
        return head;
    }
}
