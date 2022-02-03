package programmers.level02;

import java.util.Arrays;
import java.util.Comparator;

public class Programmers42747 {
    public static void main(String[] args) {
        System.out.println(new Programmers42747().solution(new int[]{3, 0, 6, 1, 5}));
        System.out.println(new Programmers42747().solution(new int[]{0, 0, 0, 0, 0})); // 0
        System.out.println(new Programmers42747().solution(new int[]{0, 0, 0, 0, 1})); // 1
        System.out.println(new Programmers42747().solution(new int[]{9, 9, 9, 12})); // 4
        System.out.println(new Programmers42747().solution(new int[]{9, 7, 6, 2, 1})); // 3
        System.out.println(new Programmers42747().solution(new int[]{10, 8, 5, 4, 3})); // 4
        System.out.println(new Programmers42747().solution(new int[]{25, 8, 5, 3, 3})); // 3
        System.out.println(new Programmers42747().solution(new int[]{5, 9, 2, 8, 7, 7, 3, 1})); // 5
        System.out.println(new Programmers42747().solution(new int[]{0, 0, 0, 1, 2, 4, 5, 5, 6, 77})); // 5
    }

    public int solution(int[] citations) {

        citations = Arrays.stream(citations)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::valueOf)
                .toArray();

        int answer = 0;

        for (int i = 0; i < citations.length; i++) {
            if (i + 1 <= citations[i]) {
                answer = i + 1;
            }
        }
        return answer;
    }
}
