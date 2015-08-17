package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorofaBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        List<TreeNode> pathp = new ArrayList<TreeNode>();
        pathp.add(root);
        getPath(root, p, pathp);
        List<TreeNode> pathq = new ArrayList<TreeNode>();
        pathq.add(root);
        getPath(root, q, pathq);

        return getCommon(pathp, pathq);
    }
    private boolean getPath(TreeNode curNode, TreeNode destNode, List<TreeNode> path) {
        if (curNode == destNode) {
            return true;
        }
        
        if (curNode.left != null) {
            path.add(curNode.left);
            boolean found = getPath(curNode.left, destNode, path);
            if (found) {
                return true;
            }
        }
        
        if (curNode.right != null) {
            path.add(curNode.right);
            boolean found = getPath(curNode.right, destNode, path);
            if (found) {
                return true;
            }
        }
        path.remove(path.size() - 1);
        return false;
    }
    
    private TreeNode getCommon(List<TreeNode> list1, List<TreeNode> list2) {
        TreeNode lastAncesor = null;
        for (int i = 0; i < list1.size() && i < list2.size(); i++) {
            if (list1.get(i) == list2.get(i)) {
                lastAncesor = list1.get(i);
            }
        }
        return lastAncesor;
    }
}
