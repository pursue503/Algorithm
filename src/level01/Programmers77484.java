package level01;

import java.util.Arrays;

/**
 *
 * 로또의 최고 순위와 최저 순위
 *
 */

public class Programmers77484 {

    public int[] solution(int[] lottos, int[] win_nums) {
        // lottos = 로또
        // win_nums = 당첨 번호

        int[] answer = new int[2];

        // 0 -> 랜덤

        int count = 0;

        //0
        int zero = 0;
        //정렬

        for(int i=0; i<lottos.length; i++) {
            for(int j=0; j< win_nums.length; j++) {
                if(lottos[i] == win_nums[j]) {
                    count++;
                }
            }

            if(lottos[i] == 0) {
                zero++;
            }
        }

        switch (count) {

            case 6:
                answer[0] = 1;
                break;
            case 5:
                answer[0] = 2;
                break;
            case 4:
                answer[0] = 3;
                break;
            case 3:
                answer[0] = 4;
                break;
            case 2:
                answer[0] = 5;
                break;
            default:
                answer[0] = 6;
                break;
        }

        switch (count + zero) {

            case 6:
                answer[1] = 1;
                break;
            case 5:
                answer[1] = 2;
                break;
            case 4:
                answer[1] = 3;
                break;
            case 3:
                answer[1] = 4;
                break;
            case 2:
                answer[1] = 5;
                break;
            default:
                answer[1] = 6;
                break;
        }
        Arrays.sort(answer);
        return answer;
    }

}
