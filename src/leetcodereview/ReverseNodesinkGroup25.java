/**
 * Created by wangyifan on 2018/2/13.
 */
public class ReverseNodesinkGroup25 {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    private void reverse(ListNode startNode, ListNode endNode) {
        ListNode pre = startNode, cur = startNode.next, next = null;
        startNode.next = endNode.next;
        while (cur != startNode.next) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        ListNode preHead = new ListNode(-1);
        preHead.next = head;

        ListNode start = head, end = head, pre = preHead;
        while (end != null) {
            for (int i = 0; i < k - 1 ; i++) {
                if (end == null) {
                    return preHead.next;
                }
                end = end.next;
            }
            if (end == null) {
                return preHead.next;
            }
            System.out.println(start.val + " " + end.val);
            reverse(start, end);
            pre.next = end;
            pre = start;
            start = start.next;
            end = start;
        }
        return preHead.next;
    }
}
