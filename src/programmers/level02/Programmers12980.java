package programmers.level02;

public class Programmers12980 {
    public int solution(int n) {
        int answer = 0;

        while (n != 0) {
            if (n == 2 || n == 1) {
                answer++;
                break;
            }

            if (n % 2 == 0) {
                n = n / 2;
            } else {
                answer++;
                n--;
            }
        }
        return answer;
    }
}
