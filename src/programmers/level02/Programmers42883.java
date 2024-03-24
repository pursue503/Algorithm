package programmers.level02;

import java.util.Stack;

public class Programmers42883 {

    public static void main(String[] args) {
//        System.out.println(new Programmers42883().solution2("1924", 2));
//        System.out.println(new Programmers42883().solution2("1231234", 3));
        System.out.println(new Programmers42883().solution2("4177252841", 4));
    }

    /*
        4177252841

        채워야 하는 개수 - 선택된 개수 - 선택 해야 하는 수 (1 고정) -> 시작 인덱스 < 문자 수 - 앞공식
        (6 - 0 - 1) ->  0 < 5 -> 41772
        7선택 , 시작 인덱스 3
        (6 - 1- 1) -> 3 < 6 -> 725
        7선택, 시작 인덱스 4
        (6 - 2- 1) -> 4 < 7 -> 252
        5선택, 시작 인덱스 6
        (6 - 3 - 1) -> 6 < 8 -> 28
        8선택 시작 인덱스 8
        (6 - 4 - 1) -> 8 < 9 -> 4
        4선택 시작 인덱스 9
     */
    public String solution(String number, int k) {
        int[] numbers = number.chars()
                .map(Character::getNumericValue)
                .toArray();

        StringBuilder builder = new StringBuilder();


        int length = numbers.length - k;
        int startIndex = 0;
        while (builder.length() != length) {
            // 총 문자 수 - (채워야 하는 숫자 수 - 현재 넣은 숫자 수 - 이번에 선택될 숫자 카운트(고정1))
            int maxLength = numbers.length - (length - builder.length() - 1);
            int max = -1;
            for (int i = startIndex; i < maxLength; i++) {
                if (max < numbers[i]) {
                    max = numbers[i];
                    startIndex = i + 1;
                }
            }
            builder.append(max);
        }

        return builder.toString();
    }

    public String solution2(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }

        for (int i = 0; i < result.length; i++) {
            result[i] = stack.get(i);
        }

        return new String(result);
    }

}
