package level02;

import java.util.Arrays;

/**
 *
 * 최솟값 만들기
 *
 */

public class Programmers12941 {

    public int solution(int[] A, int[] B) {
        int answer = 0;


        int index = 0;
        int reversIndex = A.length -1;

        Arrays.sort(A);
        Arrays.sort(B);

        while (index < A.length) {
            answer += (A[index] * B[reversIndex]);
            index++;
            reversIndex--;
        }

        return answer;
    }

}
