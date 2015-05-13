package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergekSortedLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heapIntegers = new PriorityQueue<>(10, new Comparator<ListNode>() {
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                heapIntegers.offer(lists[i]);
            }
        }
        ListNode headListNode = new ListNode(-1);
        ListNode preListNode = headListNode;
        while (heapIntegers.size() != 0) {
            ListNode cur = heapIntegers.poll();
            preListNode.next = cur;
            preListNode = cur;
            if (cur.next != null) {
                heapIntegers.offer(cur.next);
            }
        }
        return headListNode.next;
    }
}
