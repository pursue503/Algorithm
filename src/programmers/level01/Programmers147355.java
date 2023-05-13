package programmers.level01;

public class Programmers147355 {
    public int solution(String t, String p) {
        int answer = 0;

        long target = toLong(p);

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < p.length(); i++) {
            builder.append(t.charAt(i));
        }

        for (int i = p.length(); i < t.length(); i++) {
            if (toLong(builder.toString()) <= target) {
                answer++;
            }
            builder.append(t.charAt(i));
            builder.deleteCharAt(0);
        }

        return toLong(builder.toString()) <= target ? answer + 1 : answer;
    }

    public long toLong(String value) {
        return Long.parseLong(value);
    }
}
