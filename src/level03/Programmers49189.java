package level03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 가장 먼 노드
 *
 */
public class Programmers49189 {

    public static void main(String[] args) {
        Programmers49189 programmers49189 = new Programmers49189();
        System.out.println(programmers49189.solution(6, new int[][]{
                {3, 6},
                {4, 3},
                {3, 2},
                {1, 3},
                {1, 2},
                {2, 4},
                {5, 2}
        }));

        System.out.println(programmers49189.solution2(6, new int[][]{
                {3, 6},
                {4, 3},
                {3, 2},
                {1, 3},
                {1, 2},
                {2, 4},
                {5, 2}
        }));


    }

    public int solution(int n, int[][] edge) {
        int answer = 0;

        boolean[] visited = new boolean[n + 1];
        int[] countArr = new int[n + 1];

        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        countArr[1] = 1;

        int max = 0;

        visited[1] = true; // 본인 방문처리

        while (!queue.isEmpty()) {

            int x = queue.poll();
            int nodeCount = countArr[x]; // 1 과 거리


            // max 치 확인
            if (nodeCount > max) {
                max = nodeCount;
                answer = 1; //초기화 최대값 변경으로
            } else if (nodeCount == max) {
                answer++;
            }

            for (int i = 0; i < edge.length; i++) {
                if (edge[i][0] == x) { //  노드값이 현재 노드와 같은지..
                    int node = edge[i][1];
                    if (!visited[node]) { //미방문
                        queue.add(node); // 값추가
                        countArr[node] = nodeCount + 1;
                        visited[node] = true; // 본인 방문처리
                    }
                } else if (edge[i][1] == x) {
                    int node = edge[i][0];
                    if (!visited[node]) { //미방문
                        queue.add(node); // 값추가
                        countArr[node] = nodeCount + 1;
                        visited[node] = true; // 본인 방문처리
                    }
                }
            }

        }
        return answer;
    }

    public int solution2(int n, int[][] edge) {
        int answer = 0;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(n);

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < edge.length; i++) {
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);

        }

        boolean[] visited = new boolean[n + 1];
        int[] countArr = new int[n + 1];


        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        countArr[1] = 1;

        int max = 0;

        visited[1] = true; // 본인 방문처리

        while (!queue.isEmpty()) {

            int x = queue.poll();
            int nodeCount = countArr[x]; // 1 과 거리


            // max 치 확인
            if (nodeCount > max) {
                max = nodeCount;
                answer = 1; //초기화 최대값 변경으로
            } else if (nodeCount == max) {
                answer++;
            }

            for (int i = 0; i < graph.get(x).size(); i++) {
                int node = graph.get(x).get(i);
                if (!visited[node]) {
                    queue.add(node);
                    countArr[node] = nodeCount + 1;
                    visited[node] = true;
                }
            }

        }
        return answer;
    }

}
