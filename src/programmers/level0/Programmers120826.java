package programmers.level0;

public class Programmers120826 {
    public String solution(String my_string, String letter) {
        StringBuilder builder = new StringBuilder();
        char target = letter.charAt(0);
        for (char c : my_string.toCharArray()) {
            if (c != target) {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
