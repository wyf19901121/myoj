package leetcode;

public class BinaryTreeMaximumPathSum {
    public int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        travel(root);
        return ans;
    }
    public int travel(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftnum = travel(node.left);
        int rightnum = travel(node.right);
        
        int sum = node.val;
        sum += leftnum > 0 ? leftnum : 0;
        sum += rightnum > 0 ? rightnum : 0;
        ans = Math.max(sum, ans);
        sum = Math.max(leftnum, rightnum);
        return node.val + (sum > 0 ? sum : 0);
    }
}
