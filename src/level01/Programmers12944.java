package level01;

import java.util.Arrays;


/**
 *
 * 평균 구하기
 *
 */
public class Programmers12944 {

    public double solution(int[] arr) {
        return Arrays.stream(arr).average().orElse(0.0);
    }

}
