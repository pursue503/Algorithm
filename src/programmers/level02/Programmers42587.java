package programmers.level02;

import java.util.*;

public class Programmers42587 {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> numbers = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Process> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            numbers.add(priorities[i]);
            queue.add(new Process(priorities[i], i));
        }

        int answer = 0;
        while (!queue.isEmpty() && !numbers.isEmpty()) {
            int processingTarget = numbers.peek();
            Process process = queue.poll();


            if (processingTarget == process.priority) {
                answer++;
                numbers.poll();
                if (process.location == location) {
                    return answer;
                }
                continue;
            }


            queue.add(process);

        }

        return answer;
    }
}

class Process {
    int priority;
    int location;

    public Process(int priority, int location) {
        this.priority = priority;
        this.location = location;
    }

}