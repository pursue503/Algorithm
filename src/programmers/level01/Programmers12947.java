package level01;


/**
 * 하샤드의 수
 * <p>
 * x 라는 수를 x 의 자릿수의 합으로 x가 나누어지는 수
 * <p>
 * ex) 18 의 자릿수의 합은 1 + 8 = 9
 * <p>
 * 18 / 9 == 2 떨어진다.
 */

public class Programmers12947 {

    public static void main(String[] args) {
        System.out.println(solution(11));
    }

    public static boolean solution(int x) {

        // x 를 문자화 시킵니다.
        String numStr = String.valueOf(x);

        int sum = 0;
        for (int i = 0; i < numStr.length(); i++) {
            sum += Integer.parseInt(String.valueOf(numStr.charAt(i)));
        }
        return x % sum == 0; // 나머지가 0이면 나누어짐
    }

}
