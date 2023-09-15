package programmers.level02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 *
 * Level2 카펫
 *
 */

public class Programmers42842 {

    /*
        1. 가로 >= 세로
        2. 테두리만 갈색

     */
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int max = brown + yellow;

        for (int i = 3;  i<= max; i++) { // yellow 가 존재하려면 최소3 이상
            if (max % i == 0) { // 약수 구하기
                int num = max / i; // 가로 -> 세로가 더 작아야해서 아래부터 탐색
                if ((num - 2) * (i - 2) == yellow) { // 테두리만 갈색 갈색을 빼고 나머지 범위가 yellow 로 차있어야함 (위아래 양옆이라 -2 )
                    answer[0] = num;
                    answer[1] = i;
                    break;
                }
            }
        }
        return answer;
    }

}
