package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergekSortedLists {
   private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode mergeKLists(ListNode[] lists) {
    	PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
    		public int compare(ListNode a, ListNode b) {
				return a.val - b.val;
			}
		});
    	ListNode tempHead = new ListNode(0);
    	for (int i = 0; i < lists.length; i++) {
    		if (lists[i] != null) {
    			minHeap.offer(lists[i]);
			}
		}
    	ListNode curNew = tempHead;
    	while (!minHeap.isEmpty()) {
			ListNode curMin = minHeap.poll();
			if (curMin.next != null) {
				minHeap.offer(curMin.next);
			}
			curNew.next = curMin;
			curNew = curNew.next;
		}
    	return tempHead.next;
    }
}
