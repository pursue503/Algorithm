package level02;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 배달
 *
 */

public class Programmers12978 {

    public static void main(String[] args) {
        Programmers12978 programmers12978 = new Programmers12978();
        System.out.println(programmers12978.solution(5, new int[][]{
                {1, 2, 1},
                {2, 3, 3},
                {5, 2, 2},
                {1, 4, 2},
                {5, 3, 1},
                {5, 4, 2}
        }, 3));
    }


    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        boolean[] counts = new boolean[N + 1];
        int[] edge = new int[N + 1]; // 거리

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        counts[1] = true;

        while (!queue.isEmpty()) {

            int x = queue.poll(); // 노드뽑기

            for (int i = 0; i < road.length; i++) { // node 예시 노드,노드,거리
                if (road[i][0] == x) { //현재 노드와 같은지 검사
                    int node = road[i][1]; // 연결된 노드를  뽑음
                    int nodeEdge = road[i][2];
                    int length = edge[x] + nodeEdge; // 이전노드 + 현재 노드까지 거리
                    if (length <= edge[node] || edge[node] == 0) { // 0이거나 작을경우
                        edge[node] = length;
                        if(!counts[node] && edge[node] <= K) { // 카운트 된적이 없고 K 보다 같거나 작을때
                            counts[node] = true;
                        }
                        queue.add(node); //  작을경우 현재 노드를 다시 넣어서 재탐색 시작함
                    }


                } else if (road[i][1] == x) { //앞뒤로 검사해줌 , 위랑 반대로 뽑음
                    int node = road[i][0];
                    int nodeEdge = road[i][2];
                    int length = edge[x] + nodeEdge; // 이전노드 + 현재 노드까지 거리
                    if (length <= edge[node] || edge[node] == 0) {  // 0이거나 작을경우
                        edge[node] = length;
                        if(!counts[node] && edge[node] <= K) { // 카운트 된적이 없고 K 보다 같거나 작을때
                            counts[node] = true;
                        }
                        queue.add(node); //  작을경우 현재 노드를 다시 넣어서 재탐색 시작함
                    }
                }
            }

        }

        for(int i=1; i<counts.length; i++) {
            if(counts[i]) {
                answer++;
            }
        }

        return answer;
    }

}
