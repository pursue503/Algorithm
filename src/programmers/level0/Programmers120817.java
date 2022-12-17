package programmers.level0;

import java.util.Arrays;

public class Programmers120817 {
    public double solution(int[] numbers) {
        int answer = 0;
        for (int num : numbers) {
            answer += num;
        }
        return (double) answer / numbers.length;
    }

    public double solution2(int[] numbers) {
        return Arrays.stream(numbers).average().orElse(-1);
    }

}
