package level01;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * 문자열 내 마음대로 정렬하기
 *
 */

public class Programmers12915 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"sun","bed","car"},1)));
    }

    public static String[] solution(String[] strings, int n) {

        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                char s = o1.charAt(n);
                char m = o2.charAt(n);

                if(s > m) {
                    return 1; // 오름차순으로 바꾼다
                } else if (s == m) {
                    return o1.compareTo(o2); //사전순으로 바꾼다
                } else {
                    return -1; // 내림차순으로바꿈
                }

            }
        });
        return strings;
    }

}
