package level01;

import java.util.Arrays;

/**
 * 
 * 자연수 뒤집어 배열로 만들기
 * 
 */
public class Programmers12932 {

    public int[] solution(long n) {
        return Arrays.stream(new StringBuffer(String.valueOf(n)).reverse().toString().split("")).mapToInt(Integer::parseInt).toArray();
    }
    
}
