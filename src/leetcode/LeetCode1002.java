package leetcode;

import java.util.*;

public class LeetCode1002 {
    public List<String> commonChars(String[] words) {
        String str = Arrays.stream(words).min((o1, o2) -> o2.length() - o1.length()).orElse("");

        List<String> answer = new ArrayList<>();

        for (String s : str.split("")) {
            boolean flag = true;
            for (String word : words) {
                if (!word.contains(s)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                for (int i=0; i<words.length; i++) {
                    StringBuilder builder = new StringBuilder(words[i]);
                    builder.deleteCharAt(builder.indexOf(s));
                    words[i] = builder.toString();
                }
                answer.add(s);
            }
        }
        return answer;
    }
}
