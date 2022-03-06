package leetcode;

import java.util.Arrays;

public class LeetCode1550 {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (count == 3) return true;
            if (arr[i] % 2 == 1) {
                count++;
            } else {
                count = 0;
            }
        }
        return count == 3;
    }

    public boolean threeConsecutiveOdds2(int[] arr) {

        return Arrays.stream(arr)
                .mapToObj(num -> num % 2)
                .reduce((acc, num) -> {
                    if (acc >= 3) return acc;
                    if (num == 1) {
                        return acc + 1;
                    } else {
                        return 0;
                    }
                })
                .get() >= 3;
    }

}
