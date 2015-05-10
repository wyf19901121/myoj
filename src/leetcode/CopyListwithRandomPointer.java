package leetcode;

import java.util.HashMap;

public class CopyListwithRandomPointer {
	class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) { this.label = x; }
	};
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
			return null;
		}
        RandomListNode rootListNode = new RandomListNode(head.label), curListNode = head, curNewNode = rootListNode;
        HashMap<RandomListNode, RandomListNode> hashListNode = new HashMap<RandomListNode, RandomListNode>();
        hashListNode.put(head, rootListNode);
        while (curListNode != null) {
			if (curListNode.next != null) {
				if (hashListNode.containsKey(curListNode.next)) {
					curNewNode.next = hashListNode.get(curListNode.next);
				}
				else {
					curNewNode.next = new RandomListNode(curListNode.next.label);
					hashListNode.put(curListNode.next, curNewNode.next);
				}
			}
			if (curListNode.random != null) {
				if (hashListNode.containsKey(curListNode.random)) {
					curNewNode.random = hashListNode.get(curListNode.random);
				}
				else {
					curNewNode.random = new RandomListNode(curListNode.random.label);
					hashListNode.put(curListNode.random, curNewNode.random);
				}
			}
			curListNode = curListNode.next;
			curNewNode = curNewNode.next;
		}
        return rootListNode;
    }
}
