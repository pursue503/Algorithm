package programmers.level0;

public class Programmers120831 {
    public int solution(int n) {
        int answer = 0;
        for (int i=2; i<=n; i+=2) {
            answer += i;
        }
        return answer;
    }
}
