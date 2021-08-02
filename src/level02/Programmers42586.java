package level02;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 기능 개발
 *
 */
public class Programmers42586 {


    //큐사용 좀 느림..
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> integers = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int n = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
            queue.add(n);
        }

        while (!queue.isEmpty()) {

            int answer = 1;
            int x = queue.poll();

            while (!queue.isEmpty()) {
                if(queue.peek() <= x) {
                    answer++;
                    queue.poll();
                } else {
                    break;
                }
            }
            integers.add(answer);
        }


        int[] answer = new int[integers.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = integers.get(i);
        }

        return answer;
    }

    // 큐 안쓴 방식 기본 속도 0.02
    public int[] solution2(int[] progresses, int[] speeds) {
        int[] answer = new int[100];

        int x =  (99 - progresses[0]) / speeds[0] + 1;
        int count = 1;
        int index = 0;
        for (int i = 1; i < progresses.length; i++) {
            int n = (99 - progresses[i]) / speeds[i] + 1;
            if(n <= x) {
                count++;
            } else {
                answer[index] = count;
                count = 1;
                index++;
                x = n;
            }
        }
        answer[index] = count;
        int[] result = new int[index + 1];
        for(int i=0; i<result.length; i++) {
            result[i] = answer[i];
        }
        return result;
    }

}
