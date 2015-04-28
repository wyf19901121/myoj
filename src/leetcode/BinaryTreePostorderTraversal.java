package leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
    public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int x) { val = x; }
        }
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> resArrayList = new ArrayList<>();
        if (root == null) {
            return resArrayList;
        }
        Stack<TreeNode> tempNodes = new Stack<>();
        tempNodes.push(root);
        TreeNode curNode;
        TreeNode preNode = null;
        while (!tempNodes.empty()) {
            curNode = tempNodes.peek();
            if (curNode.left == null && curNode.right == null
                || preNode != null && (preNode == curNode.left || preNode ==curNode.right)) {
                resArrayList.add(curNode.val);
                preNode = curNode;
                tempNodes.pop();
            }
            else {
                if (curNode.right != null) {
                    tempNodes.push(curNode.right);
                }
                if (curNode.left != null) {
                    tempNodes.push(curNode.left);
                }
            }
        }
        return resArrayList;
    }
}
