package leetcode;

import leetcode.node.TreeNode;

public class LeetCode700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root.val == val) {
            return root;
        }

        if (root.right != null) {
            TreeNode treeNode = searchBST(root.right, val);
            if (treeNode != null) {
                return treeNode;
            }
        }

        if (root.left != null) {
            TreeNode treeNode = searchBST(root.left, val);
            if (treeNode != null) {
                return treeNode;
            }
        }
        return null;
    }
}
