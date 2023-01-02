package programmers.level0;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Programmers120903 {
    public int solution(String[] s1, String[] s2) {
        Map<String, String> map = Arrays.stream(s1)
                .collect(Collectors.toMap(o1 -> o1, o2 -> o2));

        int answer = 0;
        for (String str : s2) {
            if (map.containsKey(str)) answer++;
        }
        return answer;
    }
}
