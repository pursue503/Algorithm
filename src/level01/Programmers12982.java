package level01;

import java.util.Arrays;

/**
 * 예산
 */

public class Programmers12982 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,3,2,5,4},9));
        System.out.println(solution(new int[]{2,2,3,3},10));

    }

    public static int solution(int[] d, int budget) {
        Arrays.sort(d);
        for(int i=0; i<d.length; i++) {
            budget -= d[i];
            if(budget < 0) {
                return i;
            } else if(budget == 0) {
                return i + 1;
            }
        }
        return d.length;
    }


}
