package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Longest Substring Without Repeating Characters
 */

public class LeetCode3 {

    public static void main(String[] args) {
        System.out.println(new LeetCode3().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new LeetCode3().lengthOfLongestSubstring("bbbbbbbb"));
        System.out.println(new LeetCode3().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new LeetCode3().lengthOfLongestSubstring("dvdf"));
        System.out.println(new LeetCode3().lengthOfLongestSubstring("ohvhjdml"));
    }

    public int lengthOfLongestSubstring(String s) {

        Queue<Character> queue = new LinkedList<>();

        int answer = 0;

        for (char c : s.toCharArray()) {

            if (queue.contains(c)) {

                if (queue.size() > answer) {
                    answer = queue.size();
                }

                if (queue.peek() == c) {
                    queue.remove();
                } else {

                    while (!queue.isEmpty()) {
                        if (queue.peek() == c) {
                            queue.remove();
                            break;
                        }
                        queue.remove();
                    }

                }
            }

            queue.add(c);
        }
        return Math.max(answer, queue.size());
    }
}
