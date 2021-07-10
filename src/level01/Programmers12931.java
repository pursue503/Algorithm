package level01;

/**
 *
 * 자릿수 더하기
 *
 */

public class Programmers12931 {

    public int solution(int n) {
        String temp = n + "";
        String[] arr = temp.split("");

        int answer = 0;
        for(int i=0; i< arr.length; i++) {
            answer += Integer.parseInt(arr[i]);
        }


        return answer;
    }

}
