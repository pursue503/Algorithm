package programmers.level0;

import java.util.HashMap;
import java.util.Map;

public class Programmers120876 {
    public static void main(String[] args) {
//        System.out.println(new Programmers120876().solution(new int[][]{
//                {0,1},
//                {2,5},
//                {3,9}
//        }));

//        System.out.println(new Programmers120876().solution(new int[][]{
//                {1, -1},
//                {1, 3},
//                {9 , 3}
//        }));

        System.out.println(new Programmers120876().solution(new int[][]{
                {0, 5},
                {3, 9},
                {1 , 10}
        }));
    }
    public int solution(int[][] lines) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<lines.length; i++) {
            int min = Math.min(lines[i][0], lines[i][1]);
            int max = Math.max(lines[i][0], lines[i][1]);

            for (int j=min; j<max; j++) {
                map.put(j, map.getOrDefault(j, 0) + 1);
            }
        }

        int answer = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 2) {
                answer++;
            }
        }

        return answer;
    }


}
