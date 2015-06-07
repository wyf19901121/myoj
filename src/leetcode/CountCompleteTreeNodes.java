package leetcode;


public class CountCompleteTreeNodes {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = getLeft(root);
        int r = getRight(root);
        
        if (l == r) {
            return (2 << (l - 1)) - 1;
        }
        else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }

    public int getLeft(TreeNode root) {
        int count = 1;
        TreeNode tempNode = root;
        while (tempNode.left != null) {
            count++;
            tempNode = tempNode.left;
        }
        return count;
    }

    public int getRight(TreeNode root) {
        int count = 1;
        TreeNode tempNode = root;
        while (tempNode.right != null) {
            count++;
            tempNode = tempNode.right;
        }
        return count;
    }
}
