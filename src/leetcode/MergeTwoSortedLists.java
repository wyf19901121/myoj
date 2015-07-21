package leetcode;

public class MergeTwoSortedLists {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
			return l2;
		}
        if (l2 == null) {
			return l1;
		}
        ListNode orginList = null, newList = null, newhead = null;
        orginList = l1.val <= l2.val ? l1 : l2;
        newList = l1.val <= l2.val ? l2 : l1;
        newhead = orginList;
        while (orginList != null && newList != null) {
        	if (newList.val < orginList.val) {
				ListNode newNext = newList.next;
				newList.next = orginList;
				newList = newNext;
				if (newNext == null) {
					return newhead;
				}
			}
        	else {
        		if (orginList.next == null) {
					orginList.next = newList;
					return newhead;
				}
				orginList = orginList.next;
			}
		}
        return newhead;
    }
}
