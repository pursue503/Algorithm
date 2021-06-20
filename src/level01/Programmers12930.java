package level01;

import java.util.Arrays;

/**
 *
 * 이상한 문자 만들기
 *
 */

public class Programmers12930 {

    public static void main(String[] args) {
        System.out.println(solution("try hello world strys        "));
    }

    public static String solution(String s) {

        String answer = "";

        String[] arr = s.split(" ", -1);

        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i].length(); j++) {
                String a = String.valueOf(arr[i].charAt(j));
                if(j == 0 || j % 2 == 0) {
                    answer += a.toUpperCase();
                } else {
                    answer += a.toLowerCase();
                }
            }
            if(i != arr.length -1) answer += " ";
        }
        return answer;
    }

}
