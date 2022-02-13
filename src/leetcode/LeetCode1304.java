package leetcode;

public class LeetCode1304 {
    public int[] sumZero(int n) {
        int[] answer = new int[n];

        int sum = 0;
        int count = 1;
        for (int i=0; i<answer.length - 1; i++) {
            answer[i] = count;
            sum += count;
            count++;
        }

        answer[answer.length - 1] = sum * -1;

        return answer;
    }
}
