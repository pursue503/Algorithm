package programmers.level02;

import java.util.HashMap;
import java.util.Map;

public class Programmers12981 {
    public int[] solution(int n, String[] words) {

        Map<String, Integer> map = new HashMap<>();

        String lastWord = String.valueOf(words[0].charAt(words[0].length() -1));

        for (int i=0; i<words.length; i++) {

            int turn = (i + 1) % n == 0 ? (i + 1) / n : ((i + 1) / n) + 1;
            if (i != 0 && !lastWord.equals(String.valueOf(words[i].charAt(0)))) {
                return new int[]{(i % n) + 1, turn};
            }

            if (map.containsKey(words[i])) {
                return new int[]{(i % n) + 1, turn};
            } else {
                map.put(words[i], i / n);
            }
            lastWord = String.valueOf(words[i].charAt(words[i].length() -1));
        }

        return new int[]{0,0};
    }
}
