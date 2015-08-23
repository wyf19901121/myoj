package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<String>();
        }
        
        List<String> result = new ArrayList<String>();
        StringBuffer path = new StringBuffer(10);
        getPath(root, path, result);
        return result;
    }
    
    public void getPath(TreeNode root, StringBuffer path, List<String> result) {
        int oldLen = path.length();
        if (root.left == null && root.right == null) {
            path.append(root.val);
            result.add(path.toString());
            path.delete(oldLen, path.length());
            return;
        }
        
        path.append(root.val + "->");
        if (root.left != null) {
            getPath(root.left, path, result);
        }

        if (root.right != null) {
            getPath(root.right, path, result);
        }
        path.delete(oldLen, path.length());
    }
}
