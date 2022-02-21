package leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LeetCode268 {
    public int missingNumber(int[] nums) {

        Arrays.sort(nums);

        for (int i=0; i<nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }

    public int missingNumber2(int[] nums) {
        return IntStream.range(0, nums.length + 1).sum() - Arrays.stream(nums).sum();
    }
}
