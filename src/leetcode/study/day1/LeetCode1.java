package leetcode.study.day1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * two sum
 * https://leetcode.com/problems/two-sum/
 */

public class LeetCode1 {

    public int[] twoSum2(int[] nums, int target) {

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{};
    }

//    public int[] twoSum(int[] nums, int target) {
//
//        int[] answer = new int[2];
//
//        Map<Integer, Integer> map = new HashMap<>();
//
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i], i);
//        }
//
//
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//
//            int findKey = target - entry.getKey();
//
//            if (map.containsKey(findKey)) {
//                answer[0] = entry.getValue();
//                answer[1] = map.get(findKey);
//
//                return answer;
//            }
//
//        }
//
//        return answer;
//    }

}
