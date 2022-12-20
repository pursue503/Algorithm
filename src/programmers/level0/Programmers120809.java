package programmers.level0;

import java.util.Arrays;

public class Programmers120809 {
    public int[] solution(String[] strlist) {
        return Arrays.stream(strlist)
                .mapToInt(String::length)
                .toArray();
    }
}
