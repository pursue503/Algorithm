package leetcode;

public class LeetCode1816 {

    public String truncateSentence(String s, int k) {
        String[] arr = s.split(" ");

        StringBuilder builder = new StringBuilder();
        for (int i=0; i<Math.min(s.length(), k); i++) {
            builder.append(arr[i]).append(" ");
        }
        return builder.toString().trim();
    }
}
