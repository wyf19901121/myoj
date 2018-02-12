
/**
 * Created by wangyifan on 2018/2/12.
 */
public class SwapNodesinPairs24 {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode pre = res, cur = head, next = null;
        while (cur != null && cur.next != null) {
            next = cur.next;
            pre.next = next;
            ListNode temp = next.next;
            next.next = cur;
            cur.next = temp;
            pre = cur;
            cur = temp;
        }
        return res.next;
    }
}
