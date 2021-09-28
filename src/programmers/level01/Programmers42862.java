package level01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 *
 * 체육복
 *
 */

public class Programmers42862 {

    public static void main(String[] args) {
        Programmers42862 programmers42862 = new Programmers42862();
//        System.out.println(programmers42862.solution2(5,new int[]{2,4}, new int[]{3}));
//        System.out.println(programmers42862.solution2(5,new int[]{2, 3, 4}, new int[]{1, 2, 3}));
        System.out.println(programmers42862.solution2(5,new int[]{2, 3, 4}, new int[]{3 , 4 , 5}));
//        System.out.println(programmers42862.solution2(5,new int[]{3, 4}, new int[]{4,5}));
    }

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

    public int solution2(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        ArrayList<Integer> lostList = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<lost.length; i++) {
            lostList.add(lost[i]);
        }

        for(int i=0; i<reserve.length; i++) {
            int num = lostList.indexOf(reserve[i]);
            if(num != -1) {
                lostList.remove(num);
                answer++;
                continue;
            }
            queue.add(reserve[i]);
        }

        while (!queue.isEmpty()) {
            int x = queue.poll();

            int rm = lostList.indexOf(x - 1);

            if(rm != -1) {
                lostList.remove(rm);
                answer++;
                continue;
            }

            int rm2 = lostList.indexOf(x + 1);
            if(rm2 != -1) {
                lostList.remove(rm2);
                answer++;
            }

        }
        return answer;
    }

}
