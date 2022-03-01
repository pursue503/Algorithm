package programmers.level01;

public class Programmers12921 {
    public int solution(int n) {
        int answer = 0;

        boolean[] booleans = new boolean[n + 1];

        for(int i=2; i<booleans.length; i++) { // 2부터 일단 전부 소수취급
            booleans[i] = true;
        }

        int sqrt = (int) Math.sqrt(n); // 제곱근

        for(int i=2; i<=sqrt; i++) {
            for(int j = i*i; j<booleans.length; j+=i) {
                booleans[j] = false;
            }
        }

        for(int i=2; i<booleans.length; i++) {
            if(booleans[i]) {
                answer++;
            }
        }

        return answer;
    }
}
