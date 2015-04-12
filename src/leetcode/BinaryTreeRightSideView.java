package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class BinaryTreeRightSideView {
    public ArrayList<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> tempQueue = new LinkedList<>();
        tempQueue.offer(root);
        tempQueue.offer(null);
        int temp = 0;
        while (!tempQueue.isEmpty()) {
            TreeNode tempNode = tempQueue.poll();
            if (tempNode == null) {
                res.add(temp);
                if (!tempQueue.isEmpty()) {
                    tempQueue.offer(null);
                }
            }
            else {
                temp = tempNode.val;
                if (tempNode.left != null) {
                    tempQueue.offer(tempNode.left);
                }
                if (tempNode.right != null) {
                    tempQueue.offer(tempNode.right);
                }
            }
        }
        return res;
    }
}
