package leetcode;

/**
 *
 *
 * https://leetcode.com/problems/length-of-last-word/submissions/
 * Length of Last Word
 */

public class LeetCode58 {

    public int lengthOfLastWord(String s) {

        String trimString = s.trim();

        for (int i=trimString.length() - 1; i>=0; i--) {

            if (' ' == trimString.charAt(i)) {
                return trimString.length() - (i + 1);
            }

        }
        return trimString.length();
    }

}
