package leetcode;

public class LeetCode2396 {
    public boolean isStrictlyPalindromic(int n) {
        for (int i=2; i<=n-2; i++) {
            String t = Integer.toString(n, i);
            StringBuilder builder = new StringBuilder(t);

            if (!t.equals(builder.reverse().toString())) {
                return false;
            }

        }
        return true;
    }

    public boolean isStrictlyPalindromic2(int n) {
        return false;
    }
}
