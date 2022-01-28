package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode169 {


    public static void main(String[] args) {
        System.out.println(new LeetCode169().majorityElement(new int[]{2,2,1,1,1,2,2}));
        System.out.println(new LeetCode169().majorityElement2(new int[]{2,2,1,1,1,2,2}));
    }

    // 기본
    public int majorityElement(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (Integer num : nums) {
            map.put(num, map.getOrDefault(num, 0) +1 );
        }

        List<Map.Entry<Integer, Integer>> sorted = new ArrayList<>(map.entrySet());

        sorted.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        return sorted.get(0).getKey();

//        return map.entrySet()
//                .stream()
//                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
//                .findFirst()
//                .orElse(null)
//                .getKey();

    }

    // 스트림
    public int majorityElement2(int[] nums) {
        return Objects.requireNonNull(Arrays.stream(nums)
                        .boxed()
                        .collect(Collectors.toList())
                        .stream()
                        .collect(Collectors.groupingBy(o -> o))
                        .entrySet()
                        .stream().min((o1, o2) -> o2.getValue().size() - o1.getValue().size())
                        .orElse(null))
                .getKey();
    }

}
