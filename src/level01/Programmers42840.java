package level01;

import java.util.Arrays;

/**
 * 모의고사
 */

public class Programmers42840 {

    public static void main(String[] args) {

        Programmers42840 programmers42840 = new Programmers42840();
//
//        programmers42840.solution(new int[]{1,3,2,4,2});

        System.out.println(Arrays.toString(programmers42840.solution(new int[]{1, 2, 3, 4, 5})));
    }

    public int[] solution(int[] answers) {

        int[] case1 = new int[]{1, 2, 3, 4, 5};
        int[] case2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] case3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] answer = new int[3];

        for (int i = 0; i <answers.length; i++) {
            if(case1[index(i, 1)] == answers[i]) {
                answer[0]++;
            }

            if(case2[index(i, 2)] == answers[i]) {
                answer[1]++;
            }

            if(case3[index(i, 3)] == answers[i]) {
                answer[2]++;
            }

        }

        int max = Arrays.stream(answer).max().getAsInt();


        int length = 0;
        for(int i=0; i<answer.length; i++) {
            if(answer[i] == max) {
                length++;
            } else {
                answer[i] = -1;
            }
        }

        int[] result = new int[length];

        int count = 0;
        for(int i=0; i<answer.length; i++) {
            if(answer[i] != -1) {
                result[count] = i + 1;
                count++;
            }
        }
        return result;
    }

    public int index(int idx , int num) {

        switch (num) {

            case 1 :
                if(idx >= 5) {
                    return idx % 5;
                }
            case 2:
                if(idx >= 8) {
                    return idx % 8;
                }
            case 3:
                if(idx >= 10) {
                    return idx % 10;
                }

        }
        return idx;
    }

}
