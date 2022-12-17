package programmers.level0;

import java.util.Arrays;

public class Programmers120583 {
    public int solution(int[] array, int n) {
        return (int) Arrays.stream(array)
                .filter(it -> it == n)
                .count();
    }
}
