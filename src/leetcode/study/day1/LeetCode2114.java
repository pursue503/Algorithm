package leetcode.study.day1;

import java.util.Arrays;

/**
 *
 * Maximum Number of Words Found in Sentences
 *
 */

public class LeetCode2114 {

    public int mostWordsFound(String[] sentences) {

        int answer = 0;

        for (String str : sentences) {
            int count = 0;
            for (char c : str.toCharArray()) {
                if (c == ' ') {
                    count++;
                }
            }
            if (count > answer) {
                answer = count;
            }
        }
        return answer + 1;
    }

    public int mostWordsFound2(String[] sentences) {
        return Arrays.stream(sentences).map(str -> str.chars().filter(c -> c == ' ').count() + 1).mapToInt(Math::toIntExact).max().orElse(0) + 1;
    }

}
