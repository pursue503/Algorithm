package leetcode;

/**
 * Palindrome Number
 */

public class LeetCode9 {

    public boolean isPalindrome(int x) {
        return String.valueOf(x).equals(new StringBuilder(String.valueOf(x)).reverse().toString());
    }

}
