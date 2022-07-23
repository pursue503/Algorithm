package leetcode;

public class LeetCode35 {
    // TODO 추후 O (log n) 으로 풀이 2진탐색
    public int searchInsert(int[] nums, int target) {
        for (int i=0; i<nums.length; i++) if (nums[i] >= target) return i;
        return nums.length;
    }
}
