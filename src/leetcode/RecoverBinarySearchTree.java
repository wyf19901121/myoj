package leetcode;

public class RecoverBinarySearchTree {
    public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int x) { val = x; }
        }
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        findout(root);
        if (curNode != null) {
            int temp = preNode.val;
            preNode.val = curNode.val;
            curNode.val = temp;
        }
    }
    public void findout(TreeNode root) {
        if (root == null) {
            return;
        }
        findout(root.left);
        if (root.val < max) {
            if (curNode == null) {
                curNode = root;
                preNode = tempNode;
            }
            else {
                int temp = preNode.val;
                preNode.val = root.val;
                root.val = temp;
                curNode = null;
            }
        }
        tempNode = root;
        max = root.val;
        findout(root.right);
    }
    public TreeNode tempNode = null;
    public TreeNode preNode = null;
    public TreeNode curNode = null;
    public int max = Integer.MIN_VALUE;
}
