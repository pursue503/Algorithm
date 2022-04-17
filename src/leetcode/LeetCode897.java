package leetcode;

import leetcode.node.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LeetCode897 {

    public static void main(String[] args) {
        System.out.println(new LeetCode897().increasingBST(
                new TreeNode(2, new TreeNode(1, null, null), new TreeNode(4, new TreeNode(3), null))
        ));
    }

    List<TreeNode> treeNodeList = new ArrayList<>();

    public TreeNode increasingBST(TreeNode root) {

        recursive(root);

        treeNodeList.sort(Comparator.comparingInt(o -> o.val));

        treeNodeList.forEach(treeNode -> System.out.println(treeNode.val));

        TreeNode treeNode = new TreeNode(treeNodeList.get(0).val);

        TreeNode result = treeNode;

        for (int i=1; i<treeNodeList.size(); i++) {
            TreeNode insertNode = new TreeNode(treeNodeList.get(i).val);
            treeNode.right =  insertNode;
            treeNode = insertNode;
        }

        return result;
    }


    private void recursive(TreeNode treeNode) {

        if (treeNode == null) {
            return;
        }

        treeNodeList.add(treeNode);

        recursive(treeNode.left);
        recursive(treeNode.right);
    }



}
