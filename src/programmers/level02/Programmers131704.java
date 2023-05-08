package programmers.level02;

import java.util.Stack;

public class Programmers131704 {
    public int solution(int[] order) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        int box = 0;
        int index = 0;
        while (box <= order.length) { // 꺼내온 박스 수가 주문 수보다 같거나 작을 때까지만
            box++;
            if (box == order[index]) {
                answer++;
                index++;
                continue;
            }
            while (!stack.isEmpty()) {
                if (order[index] == stack.peek()) {
                    answer++;
                    index++;
                    stack.pop();
                    continue;
                }
                break;
            }

            stack.push(box);
        }
        return answer;
    }
}
