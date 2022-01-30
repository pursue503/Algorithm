package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 *
 * 1636. Sort Array by Increasing Frequency
 * https://leetcode.com/problems/sort-array-by-increasing-frequency/
 *
 */

public class LeetCode1636 {
    public int[] frequencySort(int[] nums) {

        int[] answer = new int[nums.length];

        Map<Integer, Integer> map = new HashMap<>();

        for (Integer num : nums) {
            map.put(num, map.getOrDefault(num, 0) +1 );
        }

        List<Map.Entry<Integer, Integer>> sorted = new ArrayList<>(map.entrySet());

        sorted.sort((o1, o2) -> {
            if (Objects.equals(o1.getValue(), o2.getValue())) {
                return o2.getKey() - o1.getKey();
            }

            return o1.getValue() - o2.getValue();
        });

        int index = 0;

        for (Map.Entry<Integer, Integer> entry : sorted) {
            index += entry.getValue();

            for (int i = index - entry.getValue(); i < index; i++) {
                answer[i] = entry.getKey();
            }

        }

        return answer;
    }

    // stream
    public int[] frequencySort2(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(o -> o))
                .entrySet()
                .stream()
                .sorted((o1, o2) -> {
                    if (o1.getValue().size() == o2.getValue().size()) {
                        return o2.getKey() - o1.getKey();
                    }

                    return o1.getValue().size() - o2.getValue().size();
                })
                .flatMap(entry -> entry.getValue().stream())
                .mapToInt(Integer::valueOf)
                .toArray();
    }

}
