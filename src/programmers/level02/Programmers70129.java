package programmers.level02;

import java.util.Arrays;

/**
 *
 * 이진 변환 반복하기
 *
 */

public class Programmers70129 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Programmers70129().solution("110010101001")));
    }

    public int[] solution(String s) {

        int[] answer = new int[2];

        int removeZeroCount = 0;
        int count = 0;

        String tempString = s;

        while (true) {

            String removeZeroString = deleteZero(tempString);

            removeZeroCount += tempString.length() - removeZeroString.length();


            count++;
            tempString = toBinary(removeZeroString.length());


            if(tempString.equals("1")) {
                break;
            }




        }

        answer[0] = count;
        answer[1] = removeZeroCount;

        return answer;
    }

    private String deleteZero(String num) {
        StringBuilder builder = new StringBuilder();
        for (char c : num.toCharArray()) if (c == 49) builder.append(Character.toChars(c));
        return builder.toString();
    }

    private String toBinary(int num) {
        return Integer.toBinaryString(num);
    }

}
