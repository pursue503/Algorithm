package programmers.level01;

import java.util.HashMap;
import java.util.Map;

public class Programmers142086 {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];

        Map<Character, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char target = s.charAt(i);
            if (indexMap.containsKey(target)) {
                int value = indexMap.get(target);
                answer[i] = i - value;
                indexMap.put(target, i);
                continue;
            }
            indexMap.put(target, i);
            answer[i] = -1;

        }

        return answer;
    }
}
