package level02;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 *
 * 다리를 지나는 트럭
 *
 */
public class Programmers42583 {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < truck_weights.length; i++) {
            queue.add(truck_weights[i]);
        }
        Queue<Integer> integerQueue = new LinkedList<>();
        int num = 0;
        int index = 0;
        while (!queue.isEmpty() || !integerQueue.isEmpty()) {
            if (!integerQueue.isEmpty()) {
                int t = integerQueue.peek();
                if (t == answer) {
                    num -= truck_weights[index];
                    index++;
                    integerQueue.poll();
                }
            }

            if (!queue.isEmpty()) {
                int x = queue.peek();
                if (num + x <= weight) {
                    num += queue.poll();
                    integerQueue.add(answer + bridge_length);
                }
            }
            answer++;
        }

        return answer;
    }

}
