package leetcode;

import java.util.Arrays;

public class LeetCode1046 {
    public static void main(String[] args) {
        System.out.println(new LeetCode1046().lastStoneWeight(new int[]{7,6,7,6,9}));
    }
    public int lastStoneWeight(int[] stones) {

        int index = stones.length - 1;

        int count = stones.length - 1;

        while (count > 0) {
            count--;
            Arrays.sort(stones);

            int y = stones[index];
            int x = stones[index - 1];

            stones[index] = - 1;


            stones[index - 1] = Math.max(y, x) - Math.min(y, x);

        }

//        for (int num : stones) {
//            if (num != -1) return num;
//        }
//        return 0;
        return Arrays.stream(stones)
                .filter(num -> num != -1)
                .findFirst()
                .orElse(0);
    }
}
