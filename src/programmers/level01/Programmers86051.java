package level01;

import java.util.Arrays;

/**
 *
 * 없는 숫자 더하기
 *
 */
public class Programmers86051 {

    public int solution(int[] numbers) {
        return 45 - Arrays.stream(numbers).sum();
    }

}
