/**
 * Created by wangyifan on 2018/2/7.
 */
public class MergeTwoSortedLists21 {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode cur = preHead;
        ListNode cur1 = l1;
        ListNode cur2 = l2;

        while (cur1 != null || cur2 != null) {
            if (cur1 == null) {
                cur.next = cur2;
                break;
            }
            else if (cur2 == null) {
                cur.next = cur1;
                break;
            }
            else {
                ListNode temp = null;
                if (cur1.val <= cur2.val) {
                    temp = cur1;
                    cur1 = cur1.next;
                }
                else {
                    temp = cur2;
                    cur2 = cur2.next;
                }
                cur.next = temp;
                cur = temp;
            }
        }
        return preHead.next;
    }
}
