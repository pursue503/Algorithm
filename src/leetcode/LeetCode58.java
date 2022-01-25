package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/length-of-last-word/submissions/
 * Length of Last Word
 */

public class LeetCode58 {

    public static void main(String[] args) {
        System.out.println(new LeetCode58().lengthOfLastWord2("   fly me   to   the moon  "));
    }

    public int lengthOfLastWord(String s) {

        String trimString = s.trim();

        for (int i = trimString.length() - 1; i >= 0; i--) {

            if (' ' == trimString.charAt(i)) {
                return trimString.length() - (i + 1);
            }

        }
        return trimString.length();
    }

    public int lengthOfLastWord2(String s) {
        return Arrays.stream(s.trim().split(" "))
                .filter(str -> !str.trim().equals(""))
                .reduce((s1, s2) -> s2)
                .orElse("")
                .length();
    }

}
