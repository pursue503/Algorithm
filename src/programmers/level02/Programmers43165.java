package programmers.level02;

public class Programmers43165 {
    public int solution(int[] numbers, int target) {
        Answer answer = new Answer(0);
        dfs(numbers, 0, target, 0 , answer);
        return answer.count;
    }

    private void dfs(int[] numbers, int depth, int target, int num, Answer answer) {
        // depth 가 array 의 마지막 index 를 지났다면 아래 조건 체크
        if (depth == numbers.length) {
            if (target == num) {
                answer.count++;
            }
        } else {
            // 경우의 수를 전부 구함 + -
            dfs(numbers, depth + 1 , target , num + numbers[depth], answer);
            dfs(numbers, depth + 1 , target , num - numbers[depth], answer);
        }
    }

}

class Answer {
    public int count;

    public Answer(int count) {
        this.count = count;
    }
}