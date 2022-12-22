package programmers.level0;


import java.util.stream.IntStream;

public class Programmers120813 {
    public int[] solution(int n) {
        int[] answer = new int[n % 2 == 0 ? n / 2 : n /2 + 1];
        int index = 0;
        for (int i=1; i<=n; i+=2) {
            answer[index++] = i;
        }
        return answer;
    }

    public int[] solution2(int n) {
        return IntStream.rangeClosed(0, n)
                .filter(it -> it % 2 == 1)
                .toArray();
    }
}
