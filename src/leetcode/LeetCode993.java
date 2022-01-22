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
    
    // 하나의 메소드로
    public boolean isCousins2(TreeNode root, int x, int y) {
        int[] answer = new int[4];
        
        int count = 0;
        
        if (root.val == x) {
            answer[0] = 0;
            answer[1] = 0;
            count ++;
        }
        
        if (root.val == y) {
            answer[2] = 0;
            answer[3] = 0;
            count ++;
        }
        
        if (count == 2) return answer[0] != answer[2] && answer[1] == answer[3];

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        Map<Integer, Integer> map = new HashMap<>();

        map.put(root.val, 0);

        while (!queue.isEmpty()) {

            TreeNode treeNode = queue.poll();

            if (treeNode.right != null) {
                map.put(treeNode.right.val, map.get(treeNode.val) + 1);
                queue.add(treeNode.right);
                if (treeNode.right.val == x) {
                    answer[0] = treeNode.val;
                    answer[1] = map.get(treeNode.right.val);
                }
                if (treeNode.right.val == y) {
                    answer[2] = treeNode.val;
                    answer[3] = map.get(treeNode.right.val);
                }
            }

            if (treeNode.left != null) {
                map.put(treeNode.left.val, map.get(treeNode.val) + 1);
                queue.add(treeNode.left);
                if (treeNode.left.val == x) {
                    answer[0] = treeNode.val;
                    answer[1] = map.get(treeNode.left.val);
                }
                if (treeNode.left.val == y) {
                    answer[2] = treeNode.val;
                    answer[3] = map.get(treeNode.left.val);
                }
            }

        }
        return answer[0] != answer[2] && answer[1] == answer[3];
    }
    
}
