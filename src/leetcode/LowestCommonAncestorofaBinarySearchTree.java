package leetcode;

public class LowestCommonAncestorofaBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        TreeNode curNode = root;
        int max = Math.max(p.val, q.val);
        int min = Math.min(p.val, q.val);
        while (curNode != null) {
            if (curNode.val > max) {
                curNode = curNode.left;
            }
            else if (curNode.val < min) {
                curNode = curNode.right;
            }
            else {
                return curNode;
            }
        }
        return null;
    }
}
