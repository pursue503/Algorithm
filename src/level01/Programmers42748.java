package level01;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * K 번째 수
 *
 */

public class Programmers42748 {

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++) {
            int[] tempArr = new int[commands[i].length];
            for(int j=0; j<commands[i].length; j++) {
                tempArr[j] = commands[i][j];
            }

            ArrayList<Integer> truncList = new ArrayList<>();

            for(int t=tempArr[0] -1; t<=tempArr[1]-1; t++) {
                truncList.add(array[t]);
            }

            Collections.sort(truncList);
            answer[i] = truncList.get(tempArr[2] -1);
        }


        return answer;
    }

}
