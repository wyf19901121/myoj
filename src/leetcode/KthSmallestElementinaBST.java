package leetcode;

import java.util.Stack;

public class KthSmallestElementinaBST {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
    public int kthSmallest(TreeNode root, int k) {
    	if (root == null) {
			return 0;
		}
    	Stack<TreeNode> nodes = new Stack<TreeNode>();
    	TreeNode curNode = root;
    	while (curNode != null) {
			nodes.push(curNode);
			curNode = curNode.left;
		}
    	while (curNode != null || !nodes.isEmpty()) {
    		if (curNode == null) {
				curNode = nodes.pop();
				if (--k == 0) {
					return curNode.val;
				}
				curNode = curNode.right;
			}
    		else {
				nodes.push(curNode);
				curNode = curNode.left;
			}	
		}
    	return curNode.val;
    }
}
