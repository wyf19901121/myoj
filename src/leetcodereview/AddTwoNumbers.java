/**
 * Created by wangyifan on 2017/12/25.
 */

package leetcodereview;
import java.util.*;

public class AddTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        int next = 0;
        ListNode l1Ptr = l1, l2Ptr = l2, headPtr = head;
        while (l1Ptr != null || l2Ptr != null || next != 0) {
            int num = (l1Ptr == null ? 0 : l1Ptr.val) + (l2Ptr == null ? 0 :l2Ptr.val) + next;
            headPtr.next = new ListNode(num%10);
            next = num / 10;
            l1Ptr = l1Ptr != null ? l1Ptr.next : l1Ptr;
            l2Ptr = l2Ptr != null ? l2Ptr.next : l2Ptr;
            headPtr = headPtr.next;
        }
        return head.next;
    }
}
