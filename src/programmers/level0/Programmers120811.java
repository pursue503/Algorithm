package programmers.level0;

import java.util.Arrays;

public class Programmers120811 {
    public int solution(int[] array) {
        Arrays.sort(array);
        return array[array.length / 2];
    }
}
