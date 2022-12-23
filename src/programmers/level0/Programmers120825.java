package programmers.level0;

import java.util.stream.Collectors;

public class Programmers120825 {
    public String solution(String my_string, int n) {
        return my_string.chars()
                .mapToObj(it -> Character.toString(it).repeat(n))
                .collect(Collectors.joining());
    }
}
