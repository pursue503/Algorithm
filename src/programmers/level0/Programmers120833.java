package programmers.level0;

import java.util.stream.LongStream;

public class Programmers120833 {
    public int[] solution(int[] numbers, int num1, int num2) {
        return LongStream.rangeClosed(num1, num2)
                .mapToInt(it -> numbers[(int) it])
                .toArray();
    }
}
