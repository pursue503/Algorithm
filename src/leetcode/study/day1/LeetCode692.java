package leetcode.study.day1;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode692 {
    public static void main(String[] args) {
        new LeetCode692().topKFrequent(new String[]{"i","love","leetcode","i","love","coding"}, 2);
    }
    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> map = new HashMap<>();

        for (String str : words) {
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
        }

        List<Map.Entry<String, Integer>> sorted = new ArrayList<>(map.entrySet());
        sorted.sort((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return o2.getValue().compareTo(o1.getValue());
        });

        List<String> answer = new ArrayList<>();

        for (int i=0; i<k; i++) {
            answer.add(sorted.get(i).getKey());
        }
        return answer;
    }
}
