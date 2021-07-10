package level01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 *
 * 체육복
 *
 */

public class Programmers42862 {

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        //일단 들을 수 있는 학생수 계산

        // 학생수 - 잃어버린 학생수
        answer = n - lost.length;

        //여유복이 있는 학생중에 도난당한 학생이라면 제거하고 결과값 추가
        //arraylist 로 변환
        ArrayList<Integer> lostList = Arrays.stream(lost).boxed().collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Integer> reserveList = Arrays.stream(reserve).boxed().collect(Collectors.toCollection(ArrayList::new));
        for (int i = 0; i < lostList.size(); i++) {
            for (int j = 0; j < reserveList.size(); j++) {
                if (lostList.get(i).equals(reserveList.get(j))) {
                    answer++;
                    lostList.remove(i);
                    reserveList.remove(j);
                    i--;
                    break;
                }
            }
        }
        for (int i = 0; i < lostList.size(); i++) {
            for (int j = 0; j < reserveList.size(); j++) {
                if (lostList.contains(reserveList.get(j) - 1)) {
                    answer++;
                    lostList.remove(i);
                    reserveList.remove(j);
                    i--;
                    break;
                } else if (lostList.contains(reserveList.get(j) + 1)) {
                    answer++;
                    lostList.remove(i);
                    reserveList.remove(j);
                    i--;
                    break;
                }
            }
        }


        return answer;
    }

}
