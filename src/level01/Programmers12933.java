package level01;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * 정수 내림차순으로 배치하기
 *
 */
public class Programmers12933 {

    public long solution(long n) {
        StringBuilder builder = new StringBuilder();
        Arrays.stream(String.valueOf(n).split("")).sorted(Comparator.reverseOrder()).mapToInt(Integer::parseInt).forEach(builder::append);
        return Long.parseLong(builder.toString());
    }

}
