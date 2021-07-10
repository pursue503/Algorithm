package level01;

import java.util.Arrays;
import java.util.Collections;

/**
 *
 * 문자열 내림차순으로 배치하기
 *
 */

public class Programmers12917 {

    public String solution(String s) {
        String answer = "";

        String[] arr = s.split("");

        Arrays.sort(arr, Collections.reverseOrder());

        for(String a : arr) {
            answer += a;
        }

        return answer;
    }

}
