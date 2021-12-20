package leetcode.study.day1;

public class LeetCode151 {

    public static void main(String[] args) {
        System.out.println(new LeetCode151().reverseWords("the sky is blue"));
    }

    public String reverseWords(String s) {

        StringBuilder builder = new StringBuilder();

        String[] arr = s.trim().split(" ");

        for (int i = arr.length - 1; i >= 0; i--) {

            String str = arr[i].trim();

            if (!str.equals("")) {
                builder.append(" ").append(arr[i]);
            }
        }

        return builder.toString().trim();
    }

}
