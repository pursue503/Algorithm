package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LeetCode136 {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map.entrySet()
                .stream().min(Comparator.comparingInt(Map.Entry::getValue))
                .orElseThrow()
                .getKey();
    }
}
