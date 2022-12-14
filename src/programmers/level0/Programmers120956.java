package programmers.level0;

import java.util.List;

public class Programmers120956 {
    private final List<String> list = List.of("aya", "ye", "woo", "ma" );
    private final StringBuilder builder = new StringBuilder();

    public int solution(String[] babbling) {
        int answer = 0;
        for (String s : babbling) {
            builder.append(s);
            if (recursion(builder, 0, 0)) answer++;
            builder.setLength(0);
        }
        return answer;
    }

    private boolean recursion(StringBuilder target, int length, int index) {
        if (index == list.size()) {
            return length == target.length();
        }
        if (target.indexOf(list.get(index)) != -1) {
            length += list.get(index).length();
        }
        return recursion(target, length, index + 1);
    }
}
