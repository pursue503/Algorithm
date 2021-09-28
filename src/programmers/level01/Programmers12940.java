package level01;

import java.util.Arrays;

public class Programmers12940 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(12,20)));
    }

    public static int[] solution(int n, int m) {

        int[] answer = new int[2];

        for(int i=2; i<=Math.max(n,m); i++) {

            if(n % i == 0 && m % i == 0 ) {
                answer[0] = i;
            }
        }
        if(answer[0] == 0 ) answer[0] = 1;

        answer[1] = n * m / answer[0];

        return answer;
    }

}
