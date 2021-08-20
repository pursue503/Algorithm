package level02;

/**
 *
 * 예상 대진표
 *
 */

public class Programmers12985 {

    public static void main(String[] args) {
        System.out.println(new Programmers12985().solution(8,4,5));
    }

    public int solution(int n, int a, int b) {
        int answer = 1;
        while ((a - b != 1 && a - b != -1) || Math.max(a,b) % 2 != 0) {

            a = (int) Math.ceil(((double) a / 2));
            b = (int) Math.ceil((double) b / 2);

            answer++;
        }

        return answer;
    }


}
