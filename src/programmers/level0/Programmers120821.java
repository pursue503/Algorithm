package programmers.level0;

import java.util.stream.LongStream;

public class Programmers120821 {
    public int[] solution(int[] num_list) {
        return LongStream.rangeClosed(1, num_list.length)
                .mapToInt(i -> num_list[(int) (num_list.length - i)])
                .toArray();
    }
}
