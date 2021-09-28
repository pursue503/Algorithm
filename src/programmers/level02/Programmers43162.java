package level02;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * 카카오 블라인드 테스트 [3차] 압축
 *
 */

public class Programmers43162 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Programmers43162().solution("TOBEORNOTTOBEORTOBEORNOT")));
        System.out.println(Arrays.toString(new Programmers43162().solution("KAKAO")));
        System.out.println(Arrays.toString(new Programmers43162().solution("ABABABABABABABAB")));
    }

    public int[] solution(String msg) {
        String[] arr = msg.split("");
        ArrayList<String> list = setUp();
        ArrayList<Integer> answerList = new ArrayList<>();

        outer : for(int i=0; i< arr.length; i++) {
            StringBuilder builder = new StringBuilder(arr[i]);
            String temp = "";
            for(int j=i+1; j<arr.length; j++) {
                temp = builder.toString();
                builder.append(arr[j]);

                if(!list.contains(builder.toString())) {
                    list.add(builder.toString());
                    answerList.add(list.indexOf(temp) + 1);
                    i = j - 1;
                    continue outer;
                } else if(j == arr.length -1 && list.contains(builder.toString())) {
                    answerList.add(list.indexOf(builder.toString()) + 1);
                    i = j - 1;
                    break outer;
                }
            }

            if((i == arr.length -2 && builder.length() == 2) || i == arr.length -1 ) {
                answerList.add(list.indexOf(builder.toString()) + 1);
                break;
            }
        }

        int[] answer = new int[answerList.size()];
        for(int i=0; i<answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    private ArrayList<String> setUp() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 65; i <= 90; i++) {
            char c = (char) i;
            list.add(String.valueOf(c));
        }
        return list;
    }



}
