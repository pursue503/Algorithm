package programmers.level0;

public class Programmers120871 {
    public int solution(int n) {
        int answer = 0;
        for (int i=1; i<=n; i++) {
            answer++;
            if (answer % 3 == 0) {
                answer++;
            }

            if (answer % 10 == 3 || answer % 100 == 3) {
                answer += 1;
                if (answer % 3 == 0) {
                    answer++;
                }
            }

            if (answer >= 30 && answer <=39) {
                answer = 40;
            }

            if (answer>= 130 && answer <= 139) {
                answer = 140;
            }

        }
        return answer;
    }
}
