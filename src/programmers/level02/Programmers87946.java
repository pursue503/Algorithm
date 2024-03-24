package programmers.level02;

import java.util.HashMap;
import java.util.Map;

public class Programmers87946 {
    public static void main(String[] args) {
        System.out.println(new Programmers87946().solution(80, new int[][]{
                {80, 20},
                {50, 40},
                {30, 10}
        }));
    }

    int answer = 0;

    public int solution(int k, int[][] dungeons) {
        dfs(k, dungeons, new HashMap<>());
        return answer;
    }

    public void dfs(int k, int[][] dungeons, Map<Integer, Boolean> visited) {

        if (visited.size() == dungeons.length) {
            int count = 0;
            for (boolean flag : visited.values()) {
                if (flag) {
                    count++;
                }
            }
            if (answer < count) {
                answer = count;
            }
            return;
        }

        for (int i = 0; i < dungeons.length; i++) {
            if (visited.containsKey(i)) {
                continue;
            }

            int minimumFatigue = dungeons[i][0];
            int useFatigue = dungeons[i][1];

            Map<Integer, Boolean> copy = new HashMap<>(Map.copyOf(visited));
            if (k >= minimumFatigue) {
                copy.put(i, true);
                dfs(k - useFatigue, dungeons, copy);
            } else {
                copy.put(i, false);
                dfs(k, dungeons, copy);
            }
        }
    }

}
