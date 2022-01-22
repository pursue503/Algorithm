package leetcode;

import leetcode.node.TreeNode;

/**
 * Insert into a Binary Search Tree
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/
 */
public class LeetCode701 {

    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null) {
            return new TreeNode(val);
        }

        if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        }

        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        }

        return root;
    }

}

