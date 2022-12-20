package programmers.level0;

import java.util.Arrays;

public class Programmers120889 {
    public int solution(int[] sides) {
        Arrays.sort(sides);
        return sides[2] < sides[1] + sides[0] ? 1 : 2;
    }
}
