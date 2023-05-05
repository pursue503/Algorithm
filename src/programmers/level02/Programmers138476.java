package programmers.level02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Programmers138476 {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> sorts = new ArrayList<>(map.entrySet());

        sorts.sort(Map.Entry.comparingByValue((o1, o2) ->  o2 - o1));

        for (Map.Entry<Integer, Integer> entry : sorts) {
            answer++;
            k -= entry.getValue();
            if (k <= 0) {
                break;
            }
        }
        return answer;
    }
}