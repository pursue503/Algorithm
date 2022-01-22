package leetcode;

import leetcode.node.TreeNode;

import java.util.*;

public class LeetCode993 {

    public static void main(String[] args) {
//        System.out.println(new LeetCode993().isCousins(
//                new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3))
//                ,4 , 3
//        ));
        System.out.println(new LeetCode993().isCousins(
                new TreeNode(
                        1,
                        new TreeNode(
                                2,
                                new TreeNode(3, null, null),
                                new TreeNode(4, new TreeNode(5) , null)
                        ),
                        null
                )
                ,2 , 4
        ));
    }

    public boolean isCousins(TreeNode root, int x, int y) {

        int[] xNodeAnswer = search(root, x);
        int[] yNodeAnswer = search(root, y);

        System.out.println(Arrays.toString(xNodeAnswer));
        System.out.println(Arrays.toString(yNodeAnswer));
        return xNodeAnswer[0] != yNodeAnswer[0] && xNodeAnswer[1] == yNodeAnswer[1];
    }

    private int[] search(TreeNode node, int target) {


        if (node.val == target) {
            return new int[]{0, 0};
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(node);

        Map<Integer, Integer> map = new HashMap<>();

        map.put(node.val, 0);

        while (!queue.isEmpty()) {

            TreeNode treeNode = queue.poll();

            if (treeNode.right != null) {
                map.put(treeNode.right.val, map.get(treeNode.val) + 1);
                queue.add(treeNode.right);
                if (treeNode.right.val == target) {
                    return new int[]{treeNode.val, map.get(treeNode.right.val)};
                }
            }

            if (treeNode.left != null) {
                map.put(treeNode.left.val, map.get(treeNode.val) + 1);
                queue.add(treeNode.left);
                if (treeNode.left.val == target) {
                    return new int[]{treeNode.val, map.get(treeNode.left.val)};
                }
            }

        }
        return null;
    }
}
