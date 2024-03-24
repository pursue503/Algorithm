package programmers.level02;

import java.util.HashSet;
import java.util.Set;

public class Programmers42839 {

    public static void main(String[] args) {

//        System.out.println(new Programmers42839().solution("17"));
//        System.out.println(new Programmers42839().solution("123"));
        System.out.println(new Programmers42839().solution("011"));
    }

    Set<Integer> set = new HashSet<>();
    int max = -1;

    public int solution(String numbers) {
        int[] arr = numbers.chars()
                .map(it -> it - '0')
                .toArray();
        int[] output = new int[arr.length];
        boolean[] visited = new boolean[arr.length];
        for (int i = 0; i < numbers.length(); i++) {
            permutation(arr, output, visited, 0, numbers.length(), i + 1);
        }

        int answer = 0;

        boolean[] flag = new boolean[max + 1];

        for (int i=2; i <= Math.sqrt(max); i++) {
            for (int j = i * i; j<flag.length; j +=i) {
                flag[j] = true;
            }
        }

        for (int num : set) {
            if (!flag[num] && num != 1 && num != 0) {
                answer++;
            }
        }

        return answer;
    }

    public void permutation(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            add(output, r);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                permutation(arr, output, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }

    }

    private void add(int[] output, int r) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < r; i++) {
            builder.append(output[i]);
        }
        int num = Integer.parseInt(builder.toString());
        set.add(num);

        max = Math.max(max, num);
    }


}
