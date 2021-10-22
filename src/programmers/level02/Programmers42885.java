package programmers.level02;

import java.util.Arrays;

public class Programmers42885 {

    public static void main(String[] args) {
        System.out.println(new Programmers42885().solution(new int[]{70,50,80,50}, 100));
    }

    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        int minIndex = 0;

        for(int i=people.length -1; i>=minIndex; i--) {
            if(people[i] + people[minIndex] <= limit) {
                minIndex++;
                answer++;
            } else {
                answer++;
            }
        }
        return answer;
    }

}
