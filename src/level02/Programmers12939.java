package level02;

import java.util.Arrays;

/**
 *
 * 최대값과 최솟값
 *
 */

public class Programmers12939 {

    public String solution(String s) {
        int[] arr = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        return arr[0] + " " + arr[arr.length -1];
    }
}
