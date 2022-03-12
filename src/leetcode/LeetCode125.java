package leetcode;

public class LeetCode125 {
    public boolean isPalindrome(String s) {

        StringBuilder builder = new StringBuilder();

        for (char c : s.toLowerCase().toCharArray()) {
            if (c >= 97 && c <= 122 || c >= 48 && c <= 57) {
                builder.append(c);
            }
        }

        StringBuilder reverse = new StringBuilder(builder.toString());

        reverse.reverse();

        return builder.toString().equals(reverse.toString());
    }
}
