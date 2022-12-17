package programmers.level0;

import java.util.Arrays;

public class Programmers120585 {
    public int solution(int[] array, int height) {
        int answer = 0;
        for (int num : array) {
            if (num > height) {
                answer++;
            }
        }
        return answer;
    }

    // 소팅
    public int solution2(int[] array, int height) {
        Arrays.sort(array);
        for (int i=0; i<array.length; i++) {
            if (array[i] > height) {
                return array.length - i;
            }
        }
        return 0;
    }

    public int solution3(int[] array, int height) {
        return (int) Arrays.stream(array)
                .filter(it -> it > height)
                .count();
    }

}
