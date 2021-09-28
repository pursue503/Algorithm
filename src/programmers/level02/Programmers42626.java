package level02;

import java.util.PriorityQueue;

/**
 * 더 맵게
 */

public class Programmers42626 {

    public static void main(String[] args) {
        Programmers42626 programmers42626 = new Programmers42626();
        System.out.println(programmers42626.solution(new int[]{1,2}, 7));
    }

    public int solution(int[] scoville, int K) {

        int answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (Integer integer : scoville) {
            queue.add(integer);
        }

        while (true) {
            if(queue.size() == 1 && queue.peek() < K) {
                return -1;
            }
            if (queue.peek() >= K) {
                return answer;
            }

            int n = queue.poll() + (queue.poll() * 2);
            queue.add(n);
            answer++;

        }

    }

}
