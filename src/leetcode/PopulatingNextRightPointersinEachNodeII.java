package leetcode;

public class PopulatingNextRightPointersinEachNodeII {
	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) { val = x; }
	}
    public void connect(TreeLinkNode root) {
        if (root == null) {
			return;
		}
        TreeLinkNode curLinkNode = root;
        while (curLinkNode != null) {
			if (curLinkNode.left != null) {
				if (curLinkNode.right != null) {
					curLinkNode.left.next = curLinkNode.right;
				}
				else {
					TreeLinkNode temp = curLinkNode.next;
					while (temp != null) {
						if (temp.left != null) {
							curLinkNode.left.next = temp.left;
							break;
						}
						else if (temp.right != null) {
							curLinkNode.left.next = temp.right;
							break;
						}
						temp = temp.next;
					}
				}
			}
			if (curLinkNode.right != null) {
				TreeLinkNode temp = curLinkNode.next;
				while (temp != null) {
					if (temp.left != null) {
						curLinkNode.right.next = temp.left;
						break;
					}
					else if (temp.right != null) {
						curLinkNode.right.next = temp.right;
						break;
					}
					temp = temp.next;
				}
			}
			curLinkNode = curLinkNode.next;
		}
        curLinkNode = root;
        while (curLinkNode != null) {
			if (curLinkNode.left != null) {
				connect(curLinkNode.left);
				break;
			}
			else if (curLinkNode.right != null) {
				connect(curLinkNode.right);
				break;
			}
			curLinkNode = curLinkNode.next;
		}
    }
}
