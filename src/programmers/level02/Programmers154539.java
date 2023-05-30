package programmers.level02;

import java.util.Stack;

public class Programmers154539 {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        // numbers 의 index 를 저장할 스택
        Stack<Integer> indexStack = new Stack<>();

        indexStack.push(0);

        for (int i = 1; i < numbers.length; i++) {
            // stack 이 비어 있지 않고
            // stack index 를 순차 적으로 꺼내서 현재 numbers[i] 보다 작다면 가장 가까운 큰수 여서 추가 해줌
            while (!indexStack.isEmpty() && numbers[indexStack.peek()] < numbers[i]) {
                // 현재 스택에 들어가 있는 numbers index 에 해당 하는 값을 numbers[i] 값으로 넣음 ( 가장 가까운 큰수 )
                answer[indexStack.pop()] = numbers[i];
            }
            indexStack.push(i);
        }

        // 지금 까지 존재 하는 애들은 뒤에 큰수가 없는 애들 전부 -1
        while (!indexStack.isEmpty()) {
            answer[indexStack.pop()] = -1;
        }

        return answer;
    }
}
