package leetcode;

public class AddTwoNumbers {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode longList = null;
		ListNode shortList = null;
		ListNode cur1 = l1, cur2 = l2;
		while (true) {
			if (cur1 == null) {
				longList = l2;
				shortList = l1;
				break;
			}
			if (cur2 == null) {
				longList = l1;
				shortList = l2;
				break;
			}
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		ListNode curLong = longList, curShort = shortList, preLong = null;
		int carry = 0;
		while (curShort != null) {
			int newCarry = (curLong.val + curShort.val + carry) / 10;
			curLong.val = (curLong.val + curShort.val + carry) % 10;
			carry = newCarry;
			preLong = curLong;
			curLong = curLong.next;
			curShort = curShort.next;
		}
		while (carry == 1) {
			if (curLong == null) {
				preLong.next = new ListNode(1);
				return longList;
			}
			int newCarry = (curLong.val + carry) / 10;
			curLong.val = (curLong.val + carry) % 10;
			carry = newCarry;
			preLong = curLong;
			curLong = curLong.next;
		}
		return longList;
	}
}
