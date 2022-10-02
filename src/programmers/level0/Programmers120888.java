package programmers.level0;

import java.util.stream.Collectors;

public class Programmers120888 {
    public static void main(String[] args) {
        System.out.println(new Programmers120888().solution("people"));
    }
    public String solution(String my_string) {
        return my_string.chars()
                .mapToObj(Character::toString)
                .distinct()
                .collect(Collectors.joining());
    }
}
