package leetcode;

/**
 *
 * Remove Duplicates from Sorted Array II
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 *
 */

public class LeetCode80 {

    public int removeDuplicates(int[] nums) {

        int index = 0;

        int lastValue = nums[0];

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (lastValue != nums[i]) {
                lastValue = nums[i];
                count = 1;
                nums[index] = lastValue;
                index++;
                continue;
            }
            count++;
            if (count <= 2) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
