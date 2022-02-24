package leetcode;

public class LeetCode1528 {
    public String restoreString(String s, int[] indices) {
        StringBuilder builder = new StringBuilder();

        String[] answer = new String[indices.length];

        for (int i=0; i<indices.length; i++) {
            answer[indices[i]] = String.valueOf(s.charAt(i));
        }

        for (String str : answer) {
            builder.append(str);
        }

        return builder.toString();
    }

}
