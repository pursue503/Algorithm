package programmers.level0;

public class Programmers131705 {
    public int solution(int[] number) {
        int answer = 0;
        for (int i = 0; i < number.length - 2; i++) {
            for (int j = i + 1; j < number.length - 1; j++) {
                for (int k = j + 1; k < number.length; k++) {
                    if (i == j || i == k || j == k) {
                        continue;
                    }
                    int num = number[i] + number[j] + number[k];
                    if (num == 0) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}
