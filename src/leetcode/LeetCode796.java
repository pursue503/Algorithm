package leetcode;

public class LeetCode796 {
    public boolean rotateString(String s, String goal) {

        if (s.equals(goal)) return true;

        StringBuilder builder = new StringBuilder(s);

        for (int i=0; i<s.length() - 1; i++) {
            builder.append(builder.charAt(0));
            builder.deleteCharAt(0);

            if (builder.toString().equals(goal)) return true;

        }

        return false;
    }
}
